package codetest;
import java.util.*;

public class Event 
{
	private final int eventID;
	private Location location;
	
	List<Ticket> tickets;
	
	public Event(int id, Location loc, List<Ticket> ticks)
	{
		eventID = id;
		location = loc;
		tickets = ticks;
	}
	
	public Ticket getCheapestTicket()
	{
		Ticket tick = null;
		
		for(Ticket t : tickets) {
			if(tick == null || t.getPrice() < tick.getPrice())
				tick = t;
		}
		
		return tick;
	}
	
	public int getID() {return this.eventID;}
	
	public Location getLocation() {return this.location;}
	
	public List<Ticket> getTickets(){return this.tickets;}
}
