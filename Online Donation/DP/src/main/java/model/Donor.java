package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Donor
{
    private String denoteType;
    private String donateDate;
    private double totalSumToPay;
    private String donateTo;
    private String location;
    private String repeatingDonate;
    private String sameDonees;
    private static ArrayList<Donor> donors = new ArrayList<>();;
    private HashMap<String,Integer> items;

    public Donor()
    {
        totalSumToPay = 0;
        items = new HashMap<>();
    }

    public static void Add(Donor donor)
    {
        donors.add(donor);
    }
    public static int getSize()
    {
        return donors.size();
    }
    public static Donor getDonor(int index)
    {
        return donors.get(index);
    }

    public void selectPackage(int numOfPackage)
    {
        switch(numOfPackage)
        {
            case 1:totalSumToPay+=10;//3.25+1.75+3.50+1.50
                    items.put("rice",1);items.put("canned corn",1);items.put("sugar",1);items.put("canned beans",1);break;
            case 2:totalSumToPay+=20;//4.00+1.00+1.00+3.50+3.25+1.75+5.00+1.50
                    items.put("dried fruit",1);items.put("Yogurt",1);items.put("tomato sauce",1);
                    items.put("sugar",1);items.put("rice",1);items.put("canned corn",1);
                    items.put("canned fish",10);items.put("canned beans",1);break;
            case 3:totalSumToPay+=30;//4.00+(1.00*2)+(1.00*2)+(3.50*2)+(3.25*2)+1.75+5.00+1.50
                    items.put("dried fruit",1);items.put("Yogurt",2);items.put("tomato sauce",2);
                    items.put("sugar",2);items.put("rice",1);items.put("canned corn",1);
                    items.put("canned fish",10);items.put("canned beans",2);items.put("Peanut Butter",1);
                    items.put("dried beans",2);break;
        }
    }
    public void setItemsAsSingle(int itemNumber, int itemQuantity)
    {
        switch(itemNumber)
        {
            case 1:totalSumToPay+=3.25;items.put("rice",itemQuantity);break;//rice
            case 2:totalSumToPay+=3.50;items.put("sugar",itemQuantity);break;//sugar
            case 3:totalSumToPay+=1.25;items.put("dried beans",itemQuantity);break;//dried beans
            case 4:totalSumToPay+=1.50;items.put("canned beans",itemQuantity);break;//canned beans
            case 5:totalSumToPay+=1.75;items.put("canned corn",itemQuantity);break;//canned corn
            case 6:totalSumToPay+=4.00;items.put("dried fruit",itemQuantity);break;//dried fruit
            case 7:totalSumToPay+=0.50;items.put("canned fish",itemQuantity);break;//canned fish
            case 8:totalSumToPay+=1.00;items.put("Yogurt",itemQuantity);break;//Yogurt
            case 9:totalSumToPay+=1.00;items.put("tomato sauce",itemQuantity);break;//tomato sauce
            case 10:totalSumToPay+=2.00;items.put("Peanut Butter",itemQuantity);break;//Peanut Butter
        }
    }
    public void setTotalSumToPay(double totalSumToPay)
    {
        this.totalSumToPay = totalSumToPay;
    }
    public double getTotalSum(){return totalSumToPay;}

    public void setDenotType(String denoteType)
    {
        this.denoteType = denoteType;
    }
    public String getDenotType()
    {
        return denoteType;
    }
    public void setDonateDate(String denoteDate)
    {
        this.donateDate = denoteDate;
    }
    public String getDonateDate()
    {
        return donateDate;
    }
    public void setDonateTo(String donateTo){this.donateTo = donateTo;}
    public String getDonateTo(){return donateTo;}
    public void totalSumIncrement()
    {
        totalSumToPay++;
    }
    public void setLocation(String location)
    {
        this.location = location;
    }
    public String getLocation()
    {
        return location;
    }
    public void setRepeatingDonate(String repeatingDonate)
    {
        this.repeatingDonate = repeatingDonate;
    }
    public String getRepeatingDonate()
    {
        return repeatingDonate;
    }
    public void setSameDonees(String sameDonees)
    {
        this.sameDonees = sameDonees;
    }
    public String getSameDonees()
    {
        return sameDonees;
    }

    @Override
    public String toString() {
        return "Donor{" +
                "denoteType='" + denoteType + '\'' +
                ", donateDate=" + donateDate +
                ", totalSumToPay=" + totalSumToPay +
                ", donateTo='" + donateTo + '\'' +
                ", location='" + location + '\'' +
                ", repeatingDonate='" + repeatingDonate + '\'' +
                ", sameDonees='" + sameDonees + '\'' +
                '}';
    }
}
