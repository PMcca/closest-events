//package codetest;

public class Ticket 
{
	private final float price;
	
	public Ticket(float p) {this.price = (float) Math.round(p*100f)/100f;} //Round to 2DP
	
	public float getPrice() {return this.price;} 
}
