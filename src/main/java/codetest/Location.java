package codetest;
import java.util.*;

public class Location 
{
	public static final int MAX_LOCATION_SIZE = 10;
	public static final int MIN_LOCATION_SIZE = -10;
	
	private int x;
	private int y;
	
	public Location(int px, int py) 
	{
			this.x = px;
			this.y = py;
	}
	
	public int getDistance(Location l)
	{
		return (Math.abs(this.x - l.x) + Math.abs(this.y - l.y)); //Mahnattan distance for this object and l
	}
	
	@Override
	public int hashCode() //Return a unique hashcode based on a location.
	{
		return Objects.hash(this.x, this.y);
	}
	
	public static Location parseLocation(String input)
	{
		String coordinates [] = input.split(",");
		if(coordinates.length != 2) //Ensure only two numbers are inputted.
			throw new IllegalArgumentException("Incorrect input format.");
		
		int x = Integer.parseInt(coordinates[0]);
		int y = Integer.parseInt(coordinates[1]);
		
		if((x < MIN_LOCATION_SIZE) || (y < MIN_LOCATION_SIZE) || (x > MAX_LOCATION_SIZE) || (y > MAX_LOCATION_SIZE)) //Ensure coordinates are within range.
			throw new IllegalArgumentException ("Coordinate(s) out of range."); 
		
		return new Location (x, y);
	}
	
	@Override
	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}
