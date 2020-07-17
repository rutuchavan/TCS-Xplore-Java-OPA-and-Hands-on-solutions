import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Movie[] mv=new Movie[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<mv.length;i++)
		{
			int movieId=sc.nextInt();sc.nextLine();
			String director=sc.nextLine();
			int rating=sc.nextInt();sc.nextLine();
			int budget=sc.nextInt();sc.nextLine();
			mv[i]=new Movie(movieId,director,rating,budget);
		}
		String dir=sc.nextLine();
		int rating=sc.nextInt();sc.nextLine();
		int budget=sc.nextInt();sc.nextLine();
		int output1=findAvgBudgetByDirector(mv,dir);
		if(output1>0)
			System.out.println(output1);
		else
			System.out.println("Sorry – No movie is available with the specified rating and budget requirement");
		Movie output2=getMovieByRatingBudget(mv,rating,budget);
		if(output2==null)
			System.out.println("Sorry -No movie is available with the specified rating and budget requirement");
		else
			System.out.println(output2.getMovieId());
	}
  
	public static int findAvgBudgetByDirector(Movie[] mv,String director)
	{
		int sum=0,count=0;
		for(int i=0;i<mv.length;i++)
		{
			if(mv[i].getDirector().equalsIgnoreCase(director))
			{
				sum+=mv[i].getBudget();
				count++;
			}
		}
		return sum/count;
	}
  
	public static Movie getMovieByRatingBudget(Movie[] mv,int rating,int budget)
	{
		Movie mov1=null;
		for(int i=0;i<mv.length;i++)
		{
			if(mv[i].getRating()==rating && mv[i].getBudget()==budget)
			{
				if((mv[i].getBudget()%mv[i].getRating())==0)
					mov1=mv[i];
			}
		}
		return mov1;
	}
}

class Movie
{
	private int movieId;
	private String director;
	private int rating;
	private int budget;
	public Movie(int movieId, String director, int rating, int budget) {
		super();
		this.movieId = movieId;
		this.director = director;
		this.rating = rating;
		this.budget = budget;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
}
