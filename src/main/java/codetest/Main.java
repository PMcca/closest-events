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
		
		out.printf("Generating %d events...\n", TEST_DATA_COUNT);
		DataGen.genTestdata(TEST_DATA_COUNT, database);
		
		out.println("Enter a pair of coordinates of the form x,y");
		
		Scanner scn = new Scanner(System.in);
		while(scn.hasNext())
		{
			String input = scn.nextLine();
			Location inputLocation;
			
			if(input.equalsIgnoreCase("exit"))
				System.exit(0);
			
			try 
			{
				inputLocation = Location.parseLocation(input);
			}
			
			catch (IllegalArgumentException e)
			{
				out.printf("Error! Could not parse \"%s\"\n", input);
				continue;
			}
			
			List<Event> closestEvents = database.findClosestEvents(inputLocation);
			
			out.printf("The %d closest events to %s are:\n", MAX_OUTPUT_COUNT, inputLocation.toString());
			for(Event evt : closestEvents) {
				out.printf("Event: %d, Location: %s, Distance: %d\n", evt.getID(), evt.getLocation(), inputLocation.getDistance(evt.getLocation()));
				out.printf("Cheapest Ticket: $%.2f\n\n", evt.getCheapestTicket().getPrice());
			}
		}
	}
}
