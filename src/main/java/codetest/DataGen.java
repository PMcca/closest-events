package codetest;
import java.util.*;

public class DataGen
{
	
	private static final float MAX_TICKET_PRICE = 100f;
	
	public static void genTestdata(int TEST_COUNT, EventDatabase database)
	{
		Random rng = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < TEST_COUNT; i++)
		{
			//Generate randomly priced tickets
			int ticketCount = rng.nextInt(10) + 1; //Between 1 and 11
			List<Ticket> tickets = new ArrayList<Ticket>(ticketCount);
			for(int j = 0; j < ticketCount; j++)
				tickets.add(new Ticket(rng.nextFloat() * MAX_TICKET_PRICE));
			
			//Generate random locations
			Location tempLocation = null;
			while(tempLocation == null)
			{
				int x = rng.nextInt(Location.MAX_LOCATION_SIZE+1);
				if(rng.nextBoolean())
					x = -x;
				
				int y = rng.nextInt(Location.MAX_LOCATION_SIZE+1);
				if(rng.nextBoolean())
					y = -y;
				
				tempLocation = new Location(x, y);
				
				Event tempEvent = database.getEventAtLocation(tempLocation); //If an event already exists at tempLocation, continue while loop.
				if(tempEvent != null)
				{
					tempLocation = null;
				}
			}
			
			database.addEvent(tempLocation, new Event(i+1, tempLocation, tickets));
		}
	}
}
