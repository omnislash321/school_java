/*
 *		Name: Xu, Roberto
 *		Project: #2
 *		Due: 11/2/2012
 *		Course: CS-141-01-f12
 *		Description: This is a TicTacToe game that will allow up to two players.
 *			The first optional command line parameter can select the size of the board,
 *			other wise it will be set to a default of 3x3. "computer" can also be used
 *			in place of a player. The 2nd command line argument is also the seed.
 *			The game goes on until all spots are filled, or until either players get a
 *			 "x"-in-a-row, i.e., a board of 5x5 requires 5 in a row.
 */

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	private static String[][] board;
	private static String pOne, pTwo;
	private static int playerTurn = 1;
	private static Random ran;
	private static boolean hasSeed;
	private static long seed;
	
	public TicTacToe(){
		this(3);
	}
	
	public TicTacToe(int size){
		if (size <= 6 && size >= 3)
			board = new String[size][size];
		else 
			board = new String[3][3];
	}
	
	public void setBoard(){
		int count = 1;
		
		for (int x = 0; x < board.length; x++){
			for (int y = 0; y < board[x].length; y++){
				board[x][y] = "" + count;
				count ++;
			}
		}
	}
	
	public void showBoard(){
		
		// This is to format the board to make it look nicely.
		String temp = "";
		int num = board.length*board.length;
		int width = 1;
		
		do{
			num = num/10;
			width ++;
		}while (num != 0);
		
		//This will be the width of room needed in order for things to be formatted nicely.
		temp = "%" + width +"s";

		//I use format and then temp, which is the width, to define how much space to give.
		for (int x = 0; x < board.length; x++){
			for (int y = 0; y < board[x].length; y++){
				System.out.format(temp, board[x][y]);
			}
			System.out.println("");
		}
	}
	
	public boolean canMove(int pos){
		int x = (pos/board.length);
		int y = (pos%board.length);
		
		//This is in order to subtract 1 to the y values, 
		// Or, i.e., a 3x3, if pos is 3, x = 1, y = 0.
		// But if we put this in the array, it is wrong.
		// So we have to subtract 1 to x, and set y to length-1.
		if (y == 0){	
			y = board.length -1;
			x --;
		}
		else
			y --;
		
		if (board[x][y] != "X" && board[x][y] != "O"){
			return true;
		}
		
		return false;
	}
	
	public void move(String player, int pos){
		int x = (pos/board.length);
		int y = (pos%board.length);
		
		if (y == 0){	
			y = board.length -1;
			x --;
		}
		else
			y --;
		
		playerTurn ++;
		
		board[x][y] = player;
	}
	
	public void compMove(String player, boolean hasSeed){
		if (hasSeed)
			ran = new Random(seed);
		else
			ran = new Random();
		
		int pos = ran.nextInt(board.length * board.length) +1;
		
		while (!canMove(pos)){
			pos = ran.nextInt(board.length * board.length) +1;
		}
		System.out.println("computer moves to: " + pos);
		this.move(player, pos);	
	}
	
	//Returns the winner, player 1 or 2, or no winner, 0.
	public static int winner(){
		int temp = 0;
		int win = 1;
		int size = board.length;
		
		//These 4 for-loops check the 4 ways of winning.
		//Getting them in a row, column, and the two diagonals.
		for (int x = 0; x < size; x++){
			String first = board[x][0];
			win = 1;
			for (int y = 0; y < size; y++){	
				if (!board[x][y].equals(first)){
					win = 0;
				}
			}
			
			if (win == 1){
				if (first == "X")	
					temp = 1;
				else if (first == "O")	
					temp = 2;
				return temp;
			}
		}
		
		for (int y = 0; y < size; y++){
			String first = board[0][y];
			win = 1;
			for (int x = 0; x < size; x++){	
				if (!board[x][y].equals(first)){
					win = 0;
				}
			}
			
			if (win == 1){
				if (first == "X")	
					temp = 1;
				else if (first == "O")	
					temp = 2;
				return temp;
			}
		}
		
		for (int x = 0; x < 1; x++){
			String first = board[x][0];
			win = 1;
			for (int y = 0; y < size; y++){	
				if (!board[y][y].equals(first)){
					win = 0;
				}
			}
			
			if (win == 1){
				if (first == "X")	
					temp = 1;
				else if (first == "O")	
					temp = 2;
				return temp;
			}
		}
		
		for (int x = size-1; x > size-2; x--){
			String first = board[x][0];
			win = 1;
			for (int y = 0; y < size; y++){
				if (!board[size-1-y][y].equals(first)){
					win = 0;
				}
			}
			
			if (win == 1){
				if (first == "X")	
					temp = 1;
				else if (first == "O")	
					temp = 2;
				return temp;
			}
		}
		return temp;
	}
	
	public static boolean gameOver(){
		
		if (winner() > 0)
			return true;

		boolean result = true;
		
		for (int x = 0; x < board.length; x++){
			for (int y = 0; y < board[x].length; y++){
				if (board[x][y] != "X" && board[x][y] != "O")
					result = false;
			}
		}
		return result;
	}
	
	
	public static void main(String[] args){
		String piece = "X";
		System.out.println("\nWelcome to jTic-Tac-Toe version 0.1");
		System.out.println("Copyright (C) Roberto Xu 2012. All rights reserved.\n");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter first username: ");
		pOne = sc.nextLine();
		System.out.print("Enter second username: ");
		pTwo = sc.nextLine();
		System.out.println("");
		
		TicTacToe game;

		if (args.length != 0){
			int size = Integer.parseInt(args[0]);
			game = new TicTacToe(size);
			
			if (args.length == 2){
				seed = Long.parseLong(args[1]);
				hasSeed = true;
			}
				
		}
		else
			game = new TicTacToe();
		
		game.setBoard();
		game.showBoard();
		
		do{
			if (playerTurn % 2 == 1){
				piece = "X";
				if (pOne.equals("computer"))
						game.compMove(piece, hasSeed);
				else{
					System.out.print(pOne + ", enter your move: ");
					int pos = sc.nextInt();
					
					if (game.canMove(pos))
						game.move(piece, pos);
					else{
						System.out.println("Taken");
						playerTurn = 1;
					}
				}
				
			}
			else if (playerTurn % 2 == 0){
				piece = "O";
				if (pTwo.equals("computer"))
					game.compMove(piece, hasSeed);
				else{
					System.out.print(pTwo + ", enter your move: ");
					int pos = sc.nextInt();

					if (game.canMove(pos))
						game.move(piece, pos);
					else{
						System.out.println("Taken");
						playerTurn = 2;
					}
				}
				
			}
			game.showBoard();
			
		}while (!gameOver());
		
		System.out.print("Great Game! ");
		if (winner() == 0)
			System.out.println("It's a tie!");
		else{
			if (winner() == 1)
				System.out.print(pOne + " is the winner!");
			else if (winner() == 2)
				System.out.print(pTwo + " is the winner!");
		}
	}
}
