//Aakash Shetty
//Period 3
import java.util.ArrayList;

public class Player implements Pieces {
	private String name;
	private ArrayList<Property> ownership = new ArrayList<Property>();
	private ArrayList<RailRoad> rrowner = new ArrayList<RailRoad>();
	private int position;
	private int cash;
	private boolean inJail;
	private boolean utility;
	
	public Player(String n) {
		name = n;
		position = 0;
		inJail = false;
		cash = 1500;
	}
	public void addProperty(Property p) {
		ownership.add(p);
		cash = cash - p.price;
	}
	
	public void addRailRoad(RailRoad r) {
		rrowner.add(r);
		cash = cash - r.price;
	}
	
	public Property[] getProperties() {
		Property[] ps = new Property[ownership.size()];
		int i = 0;
		for(Property p : ownership) {
			ps[i] = p;
			i++;
		}
		return ps;
	}
	
	public RailRoad[] getRailRoads() {
		RailRoad[] rs = new RailRoad[rrowner.size()];
		int i = 0;
		for(RailRoad r : rrowner) {
			rs[i] = r;
			i++;
		}
		return rs;
	}
	
	public Property getProperty(int i) {
		return ownership.get(i);
	}
	
	public void removeProperty(int i) {
		ownership.remove(i);
	}
	
	public RailRoad getRailRoad(int i) {
		return rrowner.get(i);
	}
	
	public void removeRailRoad(int i) {
		rrowner.remove(i);
	}
	
	public int getNumber() {
		return ownership.size();
	}
	public String getName() {
		return name;
	}
	public void setOwner(String human) {
		name = human;
	}
	public void addPosition(int a) {
		position = position + a;
		if(position >= 28) {
			cash = cash + 200;
		}
		position = position % 28;
	}
	public void addMoney(int a) {
		cash = cash + a;
	}
	public int getMoney() {
		return cash;
	}
	public int getPosition() {
		return position;
	}
	public void setJail(boolean a) {
		inJail = a;
	}
	public boolean isInJail() {
		return inJail;
	}
	public void Pay(int a) {
		cash = cash - a;
	}
	public void setPosition(int a) {
		position = position + a;
		position = position % 28;
	}
	public void setUtility(boolean a) {
		utility = a;
	}
	public boolean getUtility() {
		return utility;
	}
	public void sendPosition(int a) {
		position = a;
	}
}

