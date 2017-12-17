package codetest;

import static java.lang.System.out;
import java.util.*;

public class Main 
{
	public static final int TEST_DATA_COUNT = 30;
	public static final int MAX_OUTPUT_COUNT = 5;
	
	public static void main(String args[])
	{
		EventDatabase database = new EventDatabase();
		
		out.println("Generating " + TEST_DATA_COUNT + " events...");
		DataGen.genTestdata(TEST_DATA_COUNT, database);
		
		Scanner scn = new Scanner(System.in);
		String input;
		
		//out.println("Enter a pair of the coordinates of the form x,y");
		
		List<Event> closestEvents = database.findClosestEvents(new Location(4,2));
		
		out.println("The " + MAX_OUTPUT_COUNT + " closest events to (4,2) are:");
		for(Event evt : closestEvents)
			out.println("Event: " + evt.getID() + ". Location: " + evt.getLocation() + ". Distance: " + new Location(4,2).getDistance((evt.getLocation())));
		
	}
}
