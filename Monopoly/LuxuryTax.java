// Aakash Shetty
// Period 3

public class LuxuryTax extends SquareType {
	int price;
	public LuxuryTax(int b, String a) {
		price = b;
	}
	public LuxuryTax() {
	}
	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return "Luxury Tax";
	}
}