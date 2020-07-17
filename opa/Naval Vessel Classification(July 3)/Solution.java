import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		NavalVessel[] nvs=new NavalVessel[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<nvs.length;i++)
		{
			int vesselId=sc.nextInt();sc.nextLine();
			String vesselName=sc.nextLine();
			int noOfVoyagesPlanned=sc.nextInt();sc.nextLine();
			int noOfVoyagesCompleted=sc.nextInt();sc.nextLine();
			String purpose=sc.nextLine();
			nvs[i]=new NavalVessel(vesselId,vesselName,noOfVoyagesPlanned,noOfVoyagesCompleted,purpose);
		}
		int percentage=sc.nextInt();sc.nextLine();
		String otherPurpose=sc.nextLine();
		int output1=findAvgVoyagesByPct(nvs,percentage);
		if(output1==0)
			System.out.println("There are no voyages completed with this percentage");
		else
			System.out.println(output1);
		NavalVessel nv=findVesselByGrade(nvs,otherPurpose);
		if(nv==null)
			System.out.println("No Naval Vessel is available with the specified purpose");
		else
			System.out.println(nv.getVesselName()+"%"+nv.getClassification());
	}
	
	public static int findAvgVoyagesByPct(NavalVessel[] nvs,int percentage)
	{
		int avg=0,count=0;
		for(int i=0;i<nvs.length;i++)
		{
			int percent =((nvs[i].getNoOfVoyagesCompleted()*100)/nvs[i].getNoOfVoyagesPlanned());
			if(percent>=percentage)
			{
				avg += nvs[i].getNoOfVoyagesCompleted();
				count++;
			}
		}
		return avg/count;
	}
  
	public static NavalVessel findVesselByGrade(NavalVessel[] nvs,String purpose)
	{
		NavalVessel nv=null;
		for(int i=0;i<nvs.length;i++)
		{
			if(nvs[i].getPurpose().equalsIgnoreCase(purpose))
			{
				int percentage=(nvs[i].getNoOfVoyagesCompleted()*100/nvs[i].getNoOfVoyagesPlanned());
				if(percentage==100)
					nvs[i].setClassification("Star");
				else if(percentage<=99 && percentage>=80)
					nvs[i].setClassification("Leader");
				else if(percentage<=79 && percentage>=55)
					nvs[i].setClassification("Inspirer");
				else
					nvs[i].setClassification("Striver");
				nv=nvs[i];
			}
		}
		return nv;
	}

}
class NavalVessel
{
	private int vesselId;
	private String vesselName;
	private int noOfVoyagesPlanned;
	private int noOfVoyagesCompleted;
	private String purpose;
	private String classification;
	public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted,
			String purpose) {
		super();
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.noOfVoyagesPlanned = noOfVoyagesPlanned;
		this.noOfVoyagesCompleted = noOfVoyagesCompleted;
		this.purpose = purpose;
	}
	public int getVesselId() {
		return vesselId;
	}
	public void setVesselId(int vesselId) {
		this.vesselId = vesselId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public int getNoOfVoyagesPlanned() {
		return noOfVoyagesPlanned;
	}
	public void setNoOfVoyagesPlanned(int noOfVoyagesPlanned) {
		this.noOfVoyagesPlanned = noOfVoyagesPlanned;
	}
	public int getNoOfVoyagesCompleted() {
		return noOfVoyagesCompleted;
	}
	public void setNoOfVoyagesCompleted(int noOfVoyagesCompleted) {
		this.noOfVoyagesCompleted = noOfVoyagesCompleted;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
}
