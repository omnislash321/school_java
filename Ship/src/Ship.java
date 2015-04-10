/*
 *		Name: Xu, Roberto
 *		Project: #3
 *		Due: 11/30/2012
 *		Course: CS-141-01-f12
 *		Description: The superclass of CruiseShip and
 *			CargoShip. Has accessor and mutator methods, and has a toString method.
 */

public class Ship {

	private String name;
	private String year;
	
	public Ship(){
		name = "Ship";
		year = "2012";
	}
	
	public Ship( String shipName, String shipYear){
		name = shipName;
		year = shipYear;
	}
	
	public void setName(String shipName){
		name = shipName;
	}
	
	public void setYear(String shipYear){
		year = shipYear;
	}
	
	public String getName(){
		return name;
	}
	
	public String getYear(){
		return year;
	}
	
	public String toString(){
		return String.format("%-20s", this.getName());
	}
	
}
