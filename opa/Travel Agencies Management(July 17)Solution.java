import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        TravelAgencies[] ta=new TravelAgencies[4];
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<ta.length;i++)
        {
            int regNo=sc.nextInt();sc.nextLine();
            String agencyName=sc.nextLine();
            String packageType=sc.nextLine();
            int price=sc.nextInt();sc.nextLine();
            boolean flightFacility=sc.nextBoolean();sc.nextLine();
            ta[i]=new TravelAgencies(regNo,agencyName,packageType,price,flightFacility);
        }
        int newId=sc.nextInt();sc.nextLine();
        String newPackType=sc.nextLine();
        int output1=findAgencyWithHighestPackagePrice(ta);
        if(output1!=0)
            System.out.println(output1);
        TravelAgencies output2=agencyDetailsForGivenIdAndType(ta,newId,newPackType);
        if(output2!=null)
            System.out.println(output2.getAgencyName()+":"+output2.getPrice());
    }
    
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] ta)
    {   	
    	int highPrice=ta[0].getPrice();
    	for(int i=1;i<ta.length;i++)
    	{
    		if(ta[i].getPrice()>highPrice)
    			highPrice=ta[i].getPrice();
    	}
    	return highPrice;
    }
    
    public static TravelAgencies agencyDetailsForGivenIdAndType(TravelAgencies[] ta,int regNo,String packageType)
    {
        TravelAgencies ta2=null;
        for(int i=0;i<ta.length;i++)
        {
            if(ta[i].isFlightFacility()==true && ta[i].getRegNo()==regNo && ta[i].getPackageType().equalsIgnoreCase(packageType))
            {
                ta2=ta[i];
            }
        }
        return ta2;
    }
}

class TravelAgencies
{
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        super();
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
    public int getRegNo() {
        return regNo;
    }
    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    public String getAgencyName() {
        return agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }
    public String getPackageType() {
        return packageType;
    }
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean isFlightFacility() {
        return flightFacility;
    }
    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }    
}
