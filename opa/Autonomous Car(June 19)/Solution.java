import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		AutonomousCar[] car=new AutonomousCar[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<car.length;i++)
		{
			int carId=sc.nextInt();sc.nextLine();
			String brand=sc.nextLine();
			int noOfTestsConducted=sc.nextInt();sc.nextLine();
			int noOfTestsPassed=sc.nextInt();sc.nextLine();
			String environment=sc.nextLine();
			car[i]=new AutonomousCar(carId,brand,noOfTestsConducted,noOfTestsPassed,environment);
		}
		String env=sc.nextLine();
		String brand=sc.nextLine();
		int output1=findTestPassedByEnv(car,env);
		if(output1>0)
			System.out.println(output1);
		else
			System.out.println("There are no tests passed in this particular environment");
		
		AutonomousCar output2=updateCarGrade(car,brand);
		if(output2==null)
			System.out.println("No Car is available with the specified brand");
		else
			System.out.println(output2.getBrand()+"::"+output2.getGrade());
	}
	
	public static int findTestPassedByEnv(AutonomousCar[] car,String environment)
	{
		int sum=0;
		for(int i=0;i<car.length;i++)
		{
			if(car[i].getEnvironment().equalsIgnoreCase(environment))
			{
				sum+=car[i].getNoOfTestsPassed();
			}
		}
		return sum;
	}
  
	public static AutonomousCar updateCarGrade(AutonomousCar[] car,String brand)
	{
		AutonomousCar car1=null;
		for(int i=0;i<car.length;i++)
		{
			if(car[i].getBrand().equalsIgnoreCase(brand))
			{
				int rating=(car[i].getNoOfTestsPassed()*100/car[i].getNoOfTestsConducted());
				if(rating>=80)
					car[i].setGrade("A1");
				else
					car[i].setGrade("B2");
				car1=car[i];
			}
		}
		return car1;
	}
}

class AutonomousCar
{
	private int carId;
	private String brand;
	private int noOfTestsConducted;
	private int noOfTestsPassed;
	private String environment;
	private String grade;
	public AutonomousCar(int carId, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment) {
		super();
		this.carId = carId;
		this.brand = brand;
		this.noOfTestsConducted = noOfTestsConducted;
		this.noOfTestsPassed = noOfTestsPassed;
		this.environment = environment;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getNoOfTestsConducted() {
		return noOfTestsConducted;
	}
	public void setNoOfTestsConducted(int noOfTestsConducted) {
		this.noOfTestsConducted = noOfTestsConducted;
	}
	public int getNoOfTestsPassed() {
		return noOfTestsPassed;
	}
	public void setNoOfTestsPassed(int noOfTestsPassed) {
		this.noOfTestsPassed = noOfTestsPassed;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
