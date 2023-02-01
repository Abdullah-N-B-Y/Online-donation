package com.example.controller;

import model.DatabaseConnection;
import model.Donor;
import model.Operations;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet1 extends HttpServlet
{
    Donor donor = new Donor();//Declare obj of donor to set donor data

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        RequestDispatcher RD;//declare request dispatcher to dispatch between pages
        HttpSession session = request.getSession();//declare a session to put donor obj and can use it in jsp
        String date = Operations.getCurrentDate().toString();

        donor.setDonateDate(date);//set donate date, we can do this step in any location in code

        String sharedButton = request.getParameter("sharedButtonName");//make all buttons name are same to direct all request to main servlet
        String arr[] = null;//get all radio buttons in different pages in this arr in different locations

        if (sharedButton.equals("Next"))//here we started out from the first page with value of the "sharedButton" is "Next"
        {
            arr = request.getParameterValues("radioName");//get the radio buttons value from first page, and it will always be single value
            if (arr == null)//check if user don't click on any radio buttons and if it is re-open the same page
            {
                RD = request.getRequestDispatcher("index.jsp");//dispatching the same page
                RD.forward(request, response);//forwarding page
            }
            if (arr[0].equals("food"))//this mean that the donor choose donating food
            {
                donor.setDenotType("Food donate");//set donate type of the donor by "Food donate"
                RD = request.getRequestDispatcher("src/main/webapp/JSP/FoodDonateJSP.jsp");//dispatching to food donate jsp
                RD.forward(request, response);//forwarding page
            }
            else if (arr[0].equals("household"))//this mean that the donor didn't choose donate bt food but he choosed donates household
            {
                donor.setDenotType("Household donate");//set donate type of the donor by "Household donate"
                RD = request.getRequestDispatcher("JSP/HouseholdDonateJSP.jsp");//dispatching to household donate jsp but it is empty approximately
                RD.forward(request, response);//forwarding page
            }
            else//this mean that the donor didn't chose donate bt food or donate household but he choose donates money
            {
                donor.setDenotType("Money donate");//set donate type of the donor by "Money donate"
                RD = request.getRequestDispatcher("JSP/MoneyDonateJSP.jsp");//dispatching to Money donate jsp but it is empty approximately
                RD.forward(request, response);//forwarding page
            }
        }
        else if(sharedButton.equals("Open donation center"))
        {
            RD = request.getRequestDispatcher("JSP/CenterOfficers.jsp");//dispatching to center officer jsp but it is empty approximately
            RD.forward(request, response);//forwarding page
        }

        else if (sharedButton.equals(" Next "))//here we started out from the second page with value of the "sharedButton" is " Next "
        {
            arr = request.getParameterValues("radioName");//get the radio buttons value from second page, and it will always be single value
            if (arr == null)//check if user don't click on any radio buttons and if it is re-open the same page
            {
                RD = request.getRequestDispatcher("JSP/FoodDonateJSP.jsp");//dispatching the same page
                RD.forward(request, response);//forwarding page
            }
            if (arr[0].equals("package"))//this mean that the donor choose packages food to donate by
            {
                RD = request.getRequestDispatcher("JSP/PackageNumberJSP.jsp");//dispatching to package Number jsp
                RD.forward(request, response);//forwarding page
            }
            else//this mean that the donor choose individual selection
            {
                RD = request.getRequestDispatcher("JSP/IndividualSelectionJSP.jsp");//dispatching to individual selection jsp
                RD.forward(request, response);//forwarding page
            }
        }
        else if (sharedButton.equals("  Next  "))//here we started out from the third page with value of the "sharedButton" is "  Next  "
        {
            donor.setTotalSumToPay(0);//we do this to re-set price that the donor have to pay because that maybe the donor back and re-next then if we don't do this the sum will be incorrect
            String packageNumberArray[] = request.getParameterValues("packageNumberRadioName");//get/handle the package's number that the donor choose (#1, #2, #3)

            if (packageNumberArray == null)//check if user don't click on any radio buttons and if it is re-open the same page
            {
                RD = request.getRequestDispatcher("JSP/PackageNumberJSP.jsp");//dispatching the same page
                RD.forward(request, response);//forwarding page
            }
            donor.selectPackage(Integer.parseInt(packageNumberArray[0]));//set package number to put items in HashSet for "this user" and calculate the total sum
            RD = request.getRequestDispatcher("JSP/CityOrVillage.jsp");//dispatching the same page
            RD.forward(request, response);//forwarding page
        }
        else if (sharedButton.equals("Donate"))//here we started out from the fourth page with value of the "sharedButton" is "Donate"
        {
            arr = request.getParameterValues("radioName");//get the radio buttons value from second page, and it will always be single value
            if (arr == null)//check if user don't click on any radio buttons and if it is re-open the same page
            {
                RD = request.getRequestDispatcher("JSP/ContinuousDonationJSP.jsp");//dispatching the same page
                RD.forward(request, response);//forwarding page
            }
            donor.setSameDonees(arr[0]);
            Operations.insert(donor.getDonateTo(),donor.getDenotType(), donor.getLocation(), donor.getTotalSum(), donor.getDonateDate(), donor.getRepeatingDonate(), donor.getSameDonees());//insert data into database
            session.setAttribute("donor", donor);//add donor obj to session scope

            RD = request.getRequestDispatcher("JSP/FinalJSP.jsp");//dispatching to Final jsp
            RD.forward(request, response);//forwarding page
        }
        else if (sharedButton.equals("Back to main"))//here we started out from the final page with value of the "sharedButton" is "Back to main"
        {
            RD = request.getRequestDispatcher("index.jsp");//re-back to the first page
            RD.forward(request, response);//forwarding page
        }
        else if (sharedButton.equals("Add"))//here we started out from the final page with value of the "sharedButton" is "Back to main"
        {
            String itemNumber = request.getParameter("itemNumber");
            String itemQuantity = request.getParameter("itemQuantity");
            if (itemNumber.isEmpty() || itemQuantity.isEmpty()) {
                RD = request.getRequestDispatcher("JSP/IndividualSelectionJSP.jsp");//re-back to the same page
                RD.forward(request, response);//forwarding page
            }
            if (Integer.parseInt(itemNumber) < 1 || Integer.parseInt(itemNumber) > 10 || Integer.parseInt(itemQuantity) <= 0) {
                RD = request.getRequestDispatcher("JSP/IndividualSelectionJSP.jsp");//re-back to the same page
                RD.forward(request, response);//forwarding page
            }
            else
            {
                donor.setItemsAsSingle(Integer.parseInt(itemNumber), Integer.parseInt(itemQuantity));

                RD = request.getRequestDispatcher("JSP/IndividualSelectionJSP.jsp");//re-back to the same page
                RD.forward(request, response);//forwarding page
            }
        }
        else if (sharedButton.equals("save and continue"))//here we started out from the final page with value of the "sharedButton" is "Back to main"
        {
            String amountStr = request.getParameter("amount");
            if(amountStr == null || amountStr.isEmpty())
            {
                RD = request.getRequestDispatcher("JSP/MoneyDonateJSP.jsp");//dispatching to Money donate jsp but it is empty approximately
                RD.forward(request, response);//forwarding page
            }
            double amount = Double.parseDouble(request.getParameter("amount"));
            if(amount <= 0)
            {
                RD = request.getRequestDispatcher("JSP/MoneyDonateJSP.jsp");//dispatching to Money donate jsp but it is empty approximately
                RD.forward(request, response);//forwarding page
            }
            donor.setTotalSumToPay(amount);
            RD = request.getRequestDispatcher("JSP/CityOrVillage.jsp");//re-back to the same page
            RD.forward(request, response);//forwarding page
        }
        else if(sharedButton.equals("   Next   "))
        {
            String donateTo[] = request.getParameterValues("typeDoneesRadioName");//get/handle the type of donees that the donor want to donate to
            String locationDonees[] = request.getParameterValues("locationName");//get the location of the donees(city, viliage)
            String repetingDonate[] = request.getParameterValues("wayDoneesRadioName");////get/handle the way (one time, monthly, every four months, annual)

            if (locationDonees == null || donateTo == null || repetingDonate == null)//check if user don't click on any radio buttons and if it is re-open the same page
            {
                RD = request.getRequestDispatcher("JSP/CityOrVillage.jsp");//dispatching the same page
                RD.forward(request, response);//forwarding page
            }

            if(locationDonees[0].equals("Village"))
            {
                donor.totalSumIncrement();
            }
            if(repetingDonate[0].equals("One Time"))
            {
                donor.setLocation(locationDonees[0]);
                donor.setDonateTo(donateTo[0]);//set type of donees to donate to him
                donor.setRepeatingDonate(repetingDonate[0]);
                session.setAttribute("donor", donor);//add donor obj to session scope
                donor.setSameDonees("Just one time donate");
                Donor.Add(donor);
                Operations.insert(donor.getDenotType(), donor.getDonateTo(), donor.getDonateDate(), donor.getTotalSum(), donor.getLocation(), donor.getRepeatingDonate(), donor.getSameDonees());//insert data into database
                RD = request.getRequestDispatcher("JSP/FinalJSP.jsp");//dispatching to Final jsp
                RD.forward(request, response);//forwarding page
            }
            else if (!repetingDonate[0].equals("One Time"))//this mean that the donor choose donate more than one time
            {
                donor.setLocation(locationDonees[0]);
                donor.setDonateTo(donateTo[0]);//set type of donees to donate to him
                donor.setRepeatingDonate(repetingDonate[0]);
                Donor.Add(donor);
                RD = request.getRequestDispatcher("JSP/ContinuousDonationJSP.jsp");//dispatching to Continuous Donation jsp
                RD.forward(request, response);//forwarding page
            }
        }
        else if(sharedButton.equals("Open center"))
        {
            RD = request.getRequestDispatcher("JSP/CenterOfficers.jsp");//dispatching to Continuous Donation jsp
            RD.forward(request, response);//forwarding page
        }
        else if(sharedButton.equals("Receipt"))
        {
            Operations.update(donor.getDonateTo(), (int)donor.getTotalSum(), donor.getLocation(), donor.getDenotType());
            donor = new Donor();
            RD = request.getRequestDispatcher("index.jsp");//re-back to the first page
            RD.forward(request, response);//forwarding page
        }
        else if (sharedButton.equals("next"))//here we started out from the final page with value of the "sharedButton" is "Back to main"
        {
            if(donor.getTotalSum() <= 0)
            {
                RD = request.getRequestDispatcher("JSP/IndividualSelectionJSP.jsp");//dispatching to individual selection jsp
                RD.forward(request, response);//forwarding page
            }
            RD = request.getRequestDispatcher("JSP/CityOrVillage.jsp");//dispatching City page
            RD.forward(request, response);//forwarding page
        }
    }
}

