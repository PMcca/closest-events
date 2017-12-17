package codetest;
import java.util.*;

public class DataGen implements Comparator<Float> 
{
	
	private static final float MAX_TICKET_PRICE = 100f;
	
	public static void genTestdata(int TEST_COUNT, EventDatabase database)
	{
		Random rng = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < TEST_COUNT; i++)
		{
			//Generate tickets
			int ticketCount = rng.nextInt(10);
			List<Ticket> tickets = new ArrayList<Ticket>(ticketCount);
			for(int j = 0; j < ticketCount; j++)
				tickets.add(new Ticket(rng.nextFloat() * MAX_TICKET_PRICE));
			
			//Generate locations
			Location tempLocation = null;
			while(tempLocation == null)
			{
				int x = rng.nextInt(Location.MAX_LOCATION_SIZE+1);
				if(rng.nextBoolean())
					x = -x;
				
				int y = rng.nextInt(Location.MAX_LOCATION_SIZE+1);
				if(rng.nextBoolean())
					y = -y;
				
				tempLocation = new Location(x, y);;
			
				Event tempEvent = database.getEventAtLocation(tempLocation);
				if(tempEvent != null)
				{
					tempLocation = null;
				}
			}
			
			database.addEvent(tempLocation, new Event(i+1, tempLocation, tickets));
		}
	}
	
	public int compare(Float obj1, Float obj2)
	{
		if(obj1 < obj2)
			return -1;
		if (obj1 > obj2)
			return 1;
		return 0;
	}
}
