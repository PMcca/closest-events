package codetest;

public class Ticket 
{
	private final float price;
	
	public Ticket(float p) {this.price = p;}
	
	public float getPrice() {return (float) Math.round(this.price*100f)/100f;} //Round to 2DP
}
