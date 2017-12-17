package codetest;
import java.util.*;

public class EventDatabase 
{
	private final Map<Integer, Event> events = new HashMap<Integer, Event>();
	
	public Map<Integer, Event> getAllEvents() {return this.events;}
	
	
	public List<Event> findClosestEvents(Location location)
	{
		List<Event> foundEvents = new ArrayList<Event>();
		
		for(int x = Location.MIN_LOCATION_SIZE; x <= Location.MAX_LOCATION_SIZE; x++)
		{
			for(int y = Location.MIN_LOCATION_SIZE; y <= Location.MAX_LOCATION_SIZE; y++)
			{
				
			}
		}
		
		
		return foundEvents;
	}
	
	public Event getEventAtLocation(Location loc)
	{		
		return events.containsKey(loc.hashCode()) ? events.get(loc.hashCode()) : null;
	}
	
	public void addEvent(Location loc, Event evt)
	{
		events.put(loc.hashCode(), evt);
	}

}
