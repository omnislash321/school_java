//-----------------------------------------------------------------------------
// Name: Roberto Hong Xu Kuang
// Class: CS 241
// Project: Shopping Cart
// Date: 10/13/2014
//-----------------------------------------------------------------------------
// ShoppingMain Class - Contains two Java TreeMaps. One TreeMap maps items 
// to prices, while another maps people to their carts, which are ArrayLists.
// There are several methods used for adding, deleting, viewing, and checking
// out a cart.
// Uses command-line arguments to specify files, assuming first is items.
//-----------------------------------------------------------------------------
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.ArrayList;

public class ShoppingMain {
	//Two private static TreeMaps using java.util.TreeMap.
	private static MyTreeMap<String,Integer> itemMap = new MyTreeMap<String,Integer>();
	//The second Treemap maps an ArrayList to a String.
	private static MyTreeMap<String,ArrayList<String>> cartMap = new MyTreeMap<String,ArrayList<String>>();
	
	public static void main(String[] args) throws FileNotFoundException {
		//Ensures that there are 2 arguments for the files.
		if(args.length > 1){
			//Assumes that items is the first file.
			File itemsFile = new File(args[0]);
			File ordersFiles = new File(args[1]);
			
			//Scanner objects created for both the files.
			Scanner items = new Scanner(itemsFile);
			Scanner orders = new Scanner(ordersFiles);
			
			//Begin mapping prices to items.
			while(items.hasNext()){
				//Assumes that names go first.
				String name = items.next();
				//Turns a string into an int, and removes any dollar signs.
				int price = Integer.parseInt(items.next().replace("$",""));
				
				itemMap.put(name,price);
			}
			
			//Begin orders processing.
			while(orders.hasNext()){
				
				//First, the action and the owner are initialized.
				String action = orders.next();
				String owner = orders.next();
				
				//If the owner is not in the TreeMap, then they will be added.
				if(!cartMap.containsKey(owner))
					addUser(owner);
				
				//A switch for all the different actions.
				switch(action){
					case "add":
						//Add will need an item to be passed through as an argument.
						String addItem = orders.next();
						cartAdd(owner,addItem);
						break;
					case "delete":
						//Delete will need an item to be passed through asn argument.
						String delItem = orders.next();
						cartDel(owner,delItem);
						break;
					case "cart":
						showCart(owner);
						break;
					case "checkout":
						checkCart(owner);
						break;
				}
			}
			
			//Closes the scanners.
			items.close();
			orders.close();
		}
	}
	
//-----------------------------------------------------------------------------
// void addUser with parameter String owner
// Using the cartMap Treemap, it maps an ArrayList object to a new user, "owner"
//-----------------------------------------------------------------------------
	public static void addUser(String owner){
		ArrayList<String> userCart = new ArrayList<String>();
		cartMap.put(owner, userCart);
	}
	
//-----------------------------------------------------------------------------
// void cartAdd with parameter String owner, String addItem
// Adds an item to the ArrayList of cart for the owner in the TreeMap.
//-----------------------------------------------------------------------------	
	public static void cartAdd(String owner, String addItem){
		//Checks if the item is valid.
		if(itemMap.containsKey(addItem)){
			//Prevents multiple of the same items.
			if(!cartMap.get(owner).contains(addItem)){
				cartMap.get(owner).add(addItem);
				System.out.println(addItem + " added to " + owner +"'s cart");
			}else
				System.out.println(owner + " already has " + addItem);
		}else
			System.out.println(addItem + " not found in items list");
	}
	
//-----------------------------------------------------------------------------
// void cartDel with parameter String owner, String delItem
// Deletes an item from the ArrayList cart.
//-----------------------------------------------------------------------------	
	public static void cartDel(String owner, String delItem){
		//Checks to mke sure the item is in the cart first.
		if(cartMap.get(owner).contains(delItem)){
			cartMap.get(owner).remove(delItem);
			System.out.println(delItem + " removed from " + owner +"'s cart");
		}else
			System.out.println(delItem + " not in  " + owner + "'s cart");
	}
	
//-----------------------------------------------------------------------------
// void showCart with parameter String owner
// Will display the contents of a cart by the given owner in a nice format.
//-----------------------------------------------------------------------------	
	public static void showCart(String owner){
		ArrayList<String> cart = cartMap.get(owner);
		if(!cart.isEmpty()){
			//Header
			System.out.println("View " + owner + "'s cart");
			System.out.println("--------------------");
			System.out.printf("%-14s%-6s%n", "Item","Price");
			System.out.println("--------------------");
			//For Loop to traverse the ArrayList.
			for(int loop = 0; loop < cart.size(); loop++){
				String item = cart.get(loop);
				int price = itemMap.get(item);
				//Using printf to format the names and prices nicely.
				System.out.printf("%-14s$%-5s%n", item,price);
			}
			System.out.println("--------------------");
		}else
			System.out.println(owner + " has no items in cart");
	}
//-----------------------------------------------------------------------------	
// void checkCart with parameter String owner
// Gets the total prices of the cart.
//-----------------------------------------------------------------------------	
	public static void checkCart(String owner){
		ArrayList<String> cart = cartMap.get(owner);
		if(!cart.isEmpty()){
			//Initializes the total with 0;
			int total = 0;
			//Traverses the ArrayList cart
			for(int loop = 0; loop < cart.size(); loop++){
				String item = cart.get(loop);
				//Searches for the item in the itemMap, and then adds the price.
				total += itemMap.get(item);
			}
			System.out.println(owner + " has checked out. Total = $"+total);
			//Uncomment in order to reset the cart of a user.
			//addUser(owner);
		}else
			System.out.println(owner + " has no items in cart");
	}
}