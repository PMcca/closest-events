package codetest;
import java.util.*;

public class EventDatabase 
{
	private final Map<Integer, Event> events = new HashMap<Integer, Event>();
	
	
	public List<Event> findClosestEvents(Location location)
	{
		List<Event> closestEvents = new ArrayList<Event>();
		List<FoundEvent> foundEvents = new ArrayList<FoundEvent>();
		
		//Iterate over grid, add any locations to foundEvents.
		for(int x = Location.MIN_LOCATION_SIZE; x <= Location.MAX_LOCATION_SIZE; x++){
			for(int y = Location.MIN_LOCATION_SIZE; y <= Location.MAX_LOCATION_SIZE; y++){
				
				if(!eventExistsAtLocation(new Location(x,y)))
					continue;
				
				Location location2 = new Location(x, y);
				int distance = location.getDistance(location2);
				
				foundEvents.add(new FoundEvent(getEventAtLocation(location2), distance));				
			}
		}
		
		//Sort by distance in ascending order
		Collections.sort(foundEvents, new Comparator<FoundEvent>()
		{
			public int compare(FoundEvent obj1, FoundEvent obj2)
			{
				if(obj1.getDistance() < obj2.getDistance())
					return -1;
				if(obj1.getDistance() > obj2.getDistance())
					return 1;
				return 0;
			}
		});
		
		//Load k amount of events into closestEvents. 
		for(int i = 0; i < Main.MAX_OUTPUT_COUNT; i++)
			closestEvents.add(foundEvents.get(i).getEvent());
		
		return closestEvents;
	}
	
	public Event getEventAtLocation(Location loc)
	{		
		return events.containsKey(loc.hashCode()) ? events.get(loc.hashCode()) : null;
	}
	
	private boolean eventExistsAtLocation(Location loc)
	{
		return events.containsKey(loc.hashCode());
	}
	
	public void addEvent(Location loc, Event evt)
	{
		events.put(loc.hashCode(), evt);
	}
	
	public Map<Integer, Event> getAllEvents() {return this.events;}
	
	//Nested class for dealing with events and distances
	private class FoundEvent
	{
		private Event event;
		private int distance;
		
		FoundEvent(Event evt, int dist) {event = evt; distance = dist;}
		
		public Event getEvent() {return this.event;}
		public int getDistance() {return this.distance;}
	}
}
