/*
 *		Name: Xu, Roberto
 *		Project: #3
 *		Due: 11/30/2012
 *		Course: CS-141-01-f12
 *		Description: CargoShip that extends Ship. It adds Ton and 
 *			appropriate accessor and mutator methods. Overwrites
 *			the toString method.
 */

public class CargoShip extends Ship {
	private int maxTon;
	
	public CargoShip(){
		super();
		maxTon = 0;
	}
	
	public CargoShip(String shipName, String shipYear, int shipTon){
		super(shipName, shipYear);
		maxTon = shipTon;
	}
	
	public void setTon(int shipTon){
		maxTon = shipTon;
	}
	
	public int getTon(){
		return maxTon;
	}
	
	public String toString(){
		
		
		return String.format("%-20s Cargo:%d", this.getName(), maxTon);
	}
	
}
