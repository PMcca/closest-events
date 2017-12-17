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
		return (Math.abs(this.x - l.x) + Math.abs(this.y - l.y));
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(this.x, this.y);
	}
	
	@Override
	public String toString()
	{
		return "("+this.x+","+this.y+")";
	}
	
	public int getX() {return this.x;}
	public int getY() {return this.y;}
}
