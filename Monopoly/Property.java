//Aakash Shetty
//Period 3
public class Property extends SquareType{
	int price;
	boolean hotel;
	int house;
	boolean monopoly;
	int rent;
	
	public Property(String n, int p) {
		setName(n);
		setTileType("land");
		setOwner(0);
		
		price = p;
		hotel = false;
		house = 0;
		monopoly = false;
	}	
	public void buildHotel() {
		if(house == 4) {
			hotel = true;
			house = 0;
		}
	}
	public void buildHouse() {
		if(!hotel) {
			house++;
		}
	}
	public void setMonopoly() {
		monopoly = true;
	}
	public boolean getHotel() {
		return hotel;
	}
	public int getHouses() {
		return house;
	}
	public boolean getMonopoly() {
		return monopoly;
	}
	
	public int getMortgage() {
		return price/2;
	}
	
	public String toString() {
		return getName();
	}
	public int getRent() {
		rent = price / 5;
		return rent;
	}
}

