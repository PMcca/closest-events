//package codetest;
import java.util.*;

/**
Holds and manipulates events in various data structures to return.
*/

public class EventDatabase 
{
	private final Map<Integer, Event> events = new HashMap<Integer, Event>();
	
	//Return a list of OUTPUT_COUNT closest events relative to location.
	public List<Event> findClosestEvents(Location location, final int OUTPUT_COUNT)
	{
		List<Event> closestEvents = new ArrayList<Event>();
		List<FoundEvent> foundEvents = new ArrayList<FoundEvent>();
		
		//Add all events to foundEvents
		for(Event evt : events.values())
		{
				foundEvents.add(new FoundEvent(evt, location.getDistance(evt.getLocation())));
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
		for(int i = 0; i < OUTPUT_COUNT; i++)
			closestEvents.add(foundEvents.get(i).getEvent());
	
		return closestEvents;
	}
	
	//Return the event held in the events hashmap given by loc, or null if no event found.
	public Event getEventAtLocation(Location loc)
	{		
		return events.containsKey(loc.hashCode()) ? events.get(loc.hashCode()) : null;
	}
	
	//Adds an Event evt to the hash given by loc.
	public void addEvent(Location loc, Event evt)
	{
		events.put(loc.hashCode(), evt);
	}
	
	
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
