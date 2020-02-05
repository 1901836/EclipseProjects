import java.util.Random;

public class Board {

	private int[][] board; // holds state of game
	private Random rnd = new Random(0); // setup random # generator
	private int tilesOccupied = 16;
	private int emptySpaces = 0;
	boolean empty;

	/* default constructor for board */
	// constructors must match exactly the name
	// of the class.
	public Board() {

		// instantiate the board
		board = new int[4][4];
	 populateOne();
		slideLeft();
		slideRight();
	}

	/*
	 * return a String representation of the 2D array board
	 * 
	 * each row should be in its own line
	 * 
	 * Example:
	 * 
	 * { {1, 2, 3}, {4, 5, 6}} -> 1 2 3
	 * 
	 * 4 5 6
	 */

	// overriding a method is when a "child" class
	// implements the exact same method that its parent class has
	public String toString() {

		/*
		 * Use the String formatter to pad the numbers with leading 0s so that
		 * the print out does not become jagged An example is shown below.
		 * String str = String.format("%04d", 9); // 0009 int x = 30;
		 * System.out.println(String.format("%04d",x));
		 */

		// \n is to add a new character

		String str = "";
		// set up loops to visit every spot possible
		for (int r = 0; r < board.length; r++) {
			str = "";
			for (int c = 0; c < board[0].length; c++) {
				str += String.format("%04d", board[r][c]) + " "; // adding a 3
																	// zeros to
																	// a number
																	// to have 4
																	// digits
			}
			System.out.print(str);
			System.out.println();
			// make a matrix of 0 that's the objective5w

		}

		return str;
	}

	/*
	 * set one of the empty spaces (at random)
	 * 
	 * to a 2 or 4 (90/10 chance). an empty spot is defined to be a 0 element
	 * 
	 * Must use the Random class object rnd.
	 * 
	 * Example Use of rnd object.
	 * 
	 * int randomNum = rnd.nextInt(10); //returns a number in range [0 10) (not
	 * inclusive on the 10)
	 */

	public void populateOne() {

		// find an empty space on the board and randomly populate either a 2
		// or
		// 4 at
		// flipping a coin example
		// if(rnd.nextInt(10)<5){
		// System.out.println("hi);
		// that location

		//
		// int a = (int)(Math.random()*)

		if (tilesOccupied==16){
			return;
	} else { 
		int r = rnd.nextInt(4);
		int c = rnd.nextInt(4);
		
		while(empty==false){
			 r = rnd.nextInt(4);
			c = rnd.nextInt(4);
				if(board[r][c]==0){
					empty = true;
				}
		}
	
	if(empty == true){
		int s = rnd.nextInt(11);
		if(s<9){
			board[r][c] = 2;
		}else{
			board[r][c]=4;
		}
		tilesOccupied++;
	}
		
	}
		
		
	}

	/*
	 * 
	 * Given an array of integers, slide all non-zero elements to the right.
	 * 
	 * zero elements are considered open spots.
	 * 
	 * example:
	 * 
	 * [0 2 0 2]->[0 0 2 2]
	 * 
	 * [2 0 0 2]->[0 0 2 2]
	 * 
	 * [4 0 0 0]->[0 0 0 4]
	 */

	public void slideRight(int[] row) {
		// HELPER METHOD for the the next one without the param

		/*
		 * 
		 * Move the numbers as far to the right as they can go
		 * 
		 * aka the numbers are trying to move to the right-most
		 * 
		 * empty spaces. This method must utilize the slideRight(int[] row)
		 * method
		 * 
		 * must utilize the helper method above for full credit.
		 * 
		 * param: a valid row of 2048 where 0s are "empty" spots
		 * 
		 * effect: row is modified so all numbers are to the right side
		 * 
		 * return: none
		 */

		for (int i = 0; i < row.length; i++) {
			if (row[i] != 0) {
				for (int j = i + 1; j < row.length; j++) {
					if (row[j] == 0) {
						int temp = row[i]; // swapping it and assigning it a
											// temp value so that when
											// overwritten the value doesn't
											// disappear
						row[i] = row[j];
						row[j] = temp;
						break;
					}

				}
			}
		}

	}

	public void slideRight() {

		// go through 2D array, move all digits as far right as possible

		// you should not overwriting values

		for (int r = 0; r < board.length; r++) { // make sure every tile was hit
			for (int c = 0; c < board[0].length; c++) {
				for (int i = 0; i < board.length; i++) { // call slideRight on
															// specific elements
															// of the board
					slideRight(board[i]);
				}

			}
		}

	}

	/**
	 * Given an array of integers, slide all non-zero elements to the left.
	 * 
	 * zero elements are considered open spots.
	 * 
	 * example:
	 * 
	 * [0 2 0 2] -> [2 2 0 0]
	 * 
	 * [2 0 0 2] -> [2 2 0 0]
	 */

	public void slideLeft(int[] arr) {

		// find the first open left-most spot (a zero element)
		// then find the first non-zero element and swap

		for (int i = 0; i < arr.length; i++) {
			// check if spot is open
			if (arr[i] == 0) {
				// open! find the next non-zero element
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[j] != 0) {
						// checking to see if it is non-zero
						// swap element j and i!
						// have to store the element you're gonna swap first
						int temp = arr[i]; // have to do this line of code to
											// not lose i when overriding it
						arr[i] = arr[j];
						arr[j] = temp;
						break;
					}
				}

			}
		}

	}

	/*
	 * Slide all the numbers to the left so that
	 * 
	 * all of the empty spaces are on the right side
	 */

	public void slideLeft() {
		// grabbing a row from a 2D array
		// if it's called arr then arr[i] grabs ONE row!

		// visit every row in the 2D array
		// call the slideLeft method that takes in one argument

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				for (int i = 0; i < board.length; i++) {
					slideLeft(board[i]); // calling slideLeft on every element
											// of the board, that's why all 3
											// for loops were needed

				}
			}
		}
	}

	/**
	 * Given a 2D array and a column number, return a 1D array representing the
	 * elements in the given column number.
	 */

	public int[] getCol(int[][] data, int c) {
		int[] col = new int[4];
		for (int r = 0; r < data.length; r++) {
			col[r] = data[r][c];

		}
		return col;
	}

	/**
	 * Given an array of integers, slide all non-zero elements to the top.
	 * 
	 * zero elements are considered open spots.
	 */

	public void slideUp(int[] arr) {

		slideLeft(arr);

	}

	/*
	 * 
	 * Slide all elements in the board towards the top.
	 * 
	 * You must use slideUp and getCol for full credit.
	 */

	public void slideUp() {

		// visit every column index
		// grab each column as an array using getCOl keep track of it in a 1d
		// array
		// variable/reference
		// have slideLEft perform manipulation on the array
		// copy over the 1D array representation of the column
		// into a 2D array

		for (int c = 0; c < board.length; c++) {
			int[] arr = getCol(board, c);
			slideUp(arr);

			for (int row = 0, i = 0; row < board.length; row++, i++) {
				board[row][c] = arr[i];
			}

		}

	}

	public void slideDown(int[] arr) {
		slideRight(arr);

		//
	}

	/*
	 * slide all the numbers down so that any
	 * 
	 * empty space is at the top
	 * 
	 * You must use slideDown and getCol for full credit.
	 */

	public void slideDown() {
		for (int c = 0; c < board.length; c++) {
			int[] arr = getCol(board, c);
			slideDown(arr);

			for (int row = 0, i = 0; row < board.length; row++, i++) {
				board[row][c] = arr[i];
			}

		}
	}

	/*
	 * Given the 2D array, board, combineRight will take adjacent numbers that
	 * are the same and combine them (add them).
	 * 
	 * After adding them together, one of the numbers is zeroed out. For
	 * example, if row 0 contained [0 0 4 4],
	 * 
	 * a call to combineRight will produce [0 0 0 8]. If row 1 contained [2 2 2
	 * 2], a call to combineRight will
	 * 
	 * produce [0 4 0 4].
	 * 
	 * Notice that the left element is zeroed out.
	 */
	// change back to private
public void combineRight() {
		// do not combine zero tiles

		for (int r = 0; r < board.length; r++) {

			for (int c = board[0].length-1; c > 0; c--) {
				if (board[r][c] != 0 && board[r][c] == board[r][c - 1]) {
					board[r][c] = board[r][c] + board[r][c - 1];
					board[r][c - 1] = 0;
					tilesOccupied--;

				}

			}
		}

	}

	/*
	 * same behavior as combineRight but the right element is zeroed out when
	 * two elements are combined
	 */

	public void combineLeft() { // don't combine tiles
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board.length - 1; c++) {
				if (board[r][c + 1] != 0 && board[r][c + 1] == board[r][c]) {
					board[r][c] = board[r][c] + board[r][c + 1];
					board[r][c + 1] = 0;
					tilesOccupied--;

				}
			}
		}

	}

	/*
	 * same behavior as combineRight but the bottom element is zeroed out when
	 * two elements are combined
	 */

public void combineUp() {
		for (int r = 0; r < board.length - 1; r++) {
			for (int c = 0; c < board.length; c++) {
				if (board[r][c] != 0 && board[r][c] == board[r + 1][c]) {
					board[r][c] = board[r][c] + board[r + 1][c];
					board[r + 1][c] = 0;
					tilesOccupied--;
				}
			}
		}

	}

	/*
	 * same behavior as combineRight but the top element is zeroed out when two
	 * elements are combined
	 */
	// make this private again
	public void combineDown() {
		for (int r = 0; r < board.length - 1; r++) {
			for (int c = 0; c < board.length; c++) {
				if (board[r + 1][c] != 0 && board[r + 1][c] == board[r][c]) {
					board[r + 1][c] = board[r + 1][c] + board[r][c];
					board[r][c] = 0;
					tilesOccupied--;

				}
			}
		}

	}

	// reminder these are the methods that will ultimately invoke a series of
	// methods
	// the combine and slide methods should not worry about each other's methods
	public void left() {
		// numbers slide to the left
		// combine
		// slide(populate)
		// same thing for up, right, and down
		slideLeft();
		combineLeft();
		slideLeft();

	}

	public void right() {
		slideRight();
		combineRight();
		slideRight();

	}

	public void up() {
		slideUp();
		combineUp();
		slideUp();

	}

	public void down() {
		slideDown();
		combineDown();
		slideDown();

	}

	public boolean gameOver() {
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	// populate with a given 2d array
	public void populate(int[][] arr) {
		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[r].length; c++) {
				board[r][c] = arr[r][c];
			}
		}
	}

}
		                   
		        