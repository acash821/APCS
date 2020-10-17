// Aakash Shetty
// Period 3

import java.util.ArrayList;

public abstract class SquareType{
	  //Can be made by person creating one class for properties, jail block, etc...
	  
	  private String name; //Name of the tile
	  private String tileType; //Utility / Taxes / Land / RailRoad / Jail / Go / Chance / Go To Jail / Free Parking
	  private int owner; //To determine who owns it. 0 for neutral, 1 for player 1, ... etc.
	  //Standard setters and getters
	  private boolean isPlayer1OnSquare = false;
	  private boolean isPlayer2OnSquare = false;
	  
	  public String getName(){
	    return name;
	  }
	  public void setName(String name){
	    this.name=name;
	  }
	  public String getTileType(){
	    return tileType;
	  }
	  public void setTileType(String tileType){
	    this.tileType=tileType;
	  }
	  public int getOwner(){
	    return owner;
	  }
	  public void setOwner(int owner){
	    this.owner=owner;
	  }
	  
	  public void setPlayer1(boolean b) {
		  isPlayer1OnSquare = b;
	  }
	  
	  public void setPlayer2(boolean b) {
		  isPlayer2OnSquare = b;
	  }
	  
	  public String getPlayer1() {
		  if(isPlayer1OnSquare) {
			  return "*";
		  } else {
			  return " ";
		  }
	  }
	  
	  public String getPlayer2() {
		  if(isPlayer2OnSquare) {
			  return "&";
		  } else {
			  return " ";
		  }
	  }
}

