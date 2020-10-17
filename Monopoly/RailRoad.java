// Aakash Shetty
// Period 3
public class RailRoad extends SquareType {
	int price;
	String name;
	
	public RailRoad(String name) {
		this.price = 200;
		this.name = name;
	}
	
	public String getName() {
		return "RR " + name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getMortgage() {
		return price/2;
	}
}
