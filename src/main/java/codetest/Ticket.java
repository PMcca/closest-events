package codetest;

/**
 * A single ticket with a price. 
 * A ticket is associated with a single event. 
*/

public class Ticket 
{
	private final float price;
	
	public Ticket(float p) {this.price = (float) Math.round(p*100f)/100f;} //Round to 2DP
	
	public float getPrice() {return this.price;} 
}
