/*
 *		Name: Xu, Roberto
 *		Project: #3
 *		Due: 11/30/2012
 *		Course: CS-141-01-f12
 *		Description: CruiseShip that extends Ship. It adds maxPass
 *			and has the appropriate accessor and mutator methods.
 *			Also overwrites the toString method.
 */

public class CruiseShip extends Ship {
	private int maxPass;
	
	public CruiseShip(){
		super();
		maxPass = 0;
	}
	
	public CruiseShip(String shipName, String shipYear, int shipPass){
		super(shipName, shipYear);
		maxPass = shipPass;
	}
	
	public void setPass(int shipPass){
		maxPass = shipPass;
	}
	
	public int getPass(){
		return maxPass;
	}
	
	public String toString(){
		return String.format("%-20s Cruise:%d", this.getName(), maxPass);
	}
}
