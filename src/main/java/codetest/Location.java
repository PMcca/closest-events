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
		if(px < MIN_LOCATION_SIZE)
			x = MIN_LOCATION_SIZE;
		else if(px > MAX_LOCATION_SIZE)
			x = MAX_LOCATION_SIZE;
		else
			this.x = px;
		
		if(py < MIN_LOCATION_SIZE)
			y = MIN_LOCATION_SIZE;
		else if(py > MAX_LOCATION_SIZE)
			y = MAX_LOCATION_SIZE;
		else
			this.y = py;
	}
	
	public int getDistance(Location l)
	{
		return (Math.abs(this.x - l.x) + Math.abs(this.y - l.y));
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.x, this.y);
	}
	
	public static Location parseLocation(String input)
	{
		String coordinates [] = input.split(",");
		if(coordinates.length != 2)
			throw new IllegalArgumentException("Error! Could not parse location.");
		
		return new Location (Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
	}
	
	@Override
	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}
