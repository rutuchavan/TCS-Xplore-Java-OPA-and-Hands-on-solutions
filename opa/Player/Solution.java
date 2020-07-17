import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Player[] player=new Player[4];
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<player.length;i++)
		{
			int playerId=sc.nextInt();sc.nextLine();
			String skill=sc.nextLine();
			String level=sc.nextLine();
			int points=sc.nextInt();sc.nextLine();
			player[i]=new Player(playerId,skill,level,points);
		}
		String requiredSkill=sc.nextLine();
		String requiredLevel=sc.nextLine();
		int output1=findPointsForGivenSkill(player,requiredSkill);
		if(output1==0)
			System.out.println("The given Skill is not available");
		else
			System.out.println(output1);
		Player output2=getPlayerBasedOnLevel(player,requiredSkill,requiredLevel);
		if(output2==null)
			System.out.println("No player is available with specified level, skill and eligibility points");
		else
			System.out.println(output2.getPlayerId());
	}
	
	public static int findPointsForGivenSkill(Player[] player,String skill)
	{
		int sum=0;
		for(int i=0;i<player.length;i++)
		{
			if(player[i].getSkill().equalsIgnoreCase(skill))
			{
				sum+=player[i].getPoints();
			}
		}
		return sum;
	}
	public static Player getPlayerBasedOnLevel(Player[] player,String skill,String level)
	{
		Player player2=null;
		for(int i=0;i<player.length;i++)
		{
			if(player[i].getSkill().equalsIgnoreCase(skill) && player[i].getLevel().equalsIgnoreCase(level) && player[i].getPoints()>=20)
			{
				player2=player[i];
				break;
			}
		}
		return player2;
	}
}

class Player
{
	private int playerId;
	private String skill;
	private String level;
	private int points;
	public Player(int playerId, String skill, String level, int points) {
		super();
		this.playerId = playerId;
		this.skill = skill;
		this.level = level;
		this.points = points;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}	
}
