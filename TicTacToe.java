import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	private static char table[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	private static boolean computerMove = true;
	private static boolean endOfGame = false;

	public static void printBoard() {
		System.out.println();
		System.out.println();
		System.out.println("    0 1 2");
		System.out.println("0  |" + table[0][0] + "|" + table[0][1] + "|" + table[0][2] + "|");
		System.out.println("1  |" + table[1][0] + "|" + table[1][1] + "|" + table[1][2] + "|");
		System.out.println("2  |" + table[2][0] + "|" + table[2][1] + "|" + table[2][2] + "|");
	}

	//Computer's move
	public static void computerMove() {
		if(endOfGame)
		{
			return;
		}
		//Computer wants to win,so that at first it looks for the way to win if it's possible
		//2 'X' in the same row
		for (int i = 0; i < 3; i++) {
			if (table[i][0] == 'X' && table[i][1] == 'X' && table[i][2] == ' ') {
				table[i][2] = 'X';
			}
			if (table[i][0] == 'X' && table[i][2] == 'X' && table[i][1] == ' ') {
				table[i][1] = 'X';
			}
			if (table[i][1] == 'X' && table[i][2] == 'X' && table[i][0] == ' ') {
				table[i][0] = 'X';
			}
		}
		//2 'X' in the same col
		for (int i = 0; i < 3; i++) {
			if (table[0][i] == 'X' && table[1][i] == 'X' && table[2][i] == ' ') {
				table[2][i] = 'X';
			}
			if (table[0][i] == 'X' && table[2][i] == 'X' && table[1][i] == ' ') {
				table[1][i] = 'X';
			}
			if (table[1][i] == 'X' && table[2][i] == 'X' && table[0][i] == ' ') {
				table[0][i] = 'X';
			}
		}
		//the possibilities of win when 2 'X' are diagonally to each others
		if (table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == ' ') {
			table[2][2] = 'X';
		}

		if (table[0][0] == 'X' && table[2][2] == 'X' && table[1][1] == ' ') {
			table[1][1] = 'X';
		}

		if (table[1][1] == 'X' && table[2][2] == 'X' && table[0][0] == ' ') {
			table[0][0] = 'X';
		}
		//Computer must block user
		for (int i = 0; i < 3; i++) {
			if (table[i][0] == 'O' && table[i][1] == 'O' && table[i][2] == ' ') {
				table[i][2] = 'X';
			}
			if (table[i][0] == 'O' && table[i][2] == 'O' && table[i][1] == ' ') {
				table[i][1] = 'X';
			}
			if (table[i][1] == 'O' && table[i][2] == 'O' && table[i][0] == ' ') {
				table[i][0] = 'X';
			}
		}
		//User has 2 'O' in two cols
		for (int i = 0; i < 3; i++) {
			if (table[0][i] == 'O' && table[1][i] == 'O' && table[2][i] == ' ') {
				table[2][i] = 'X';
			}
			if (table[0][i] == 'O' && table[2][i] == 'O' && table[1][i] == ' ') {
				table[1][i] = 'X';
			}
			if (table[1][i] == 'O' && table[2][i] == 'O' && table[0][i] == ' ') {
				table[0][i] = 'X';
			}
		}
		//2 'O' diagonally to each other 
		if (table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == ' ') {
			table[2][2] = 'X';
		}

		if (table[0][0] == 'O' && table[2][2] == 'O' && table[1][1] == ' ') {
			table[1][1] = 'X';
		}

		if (table[1][1] == 'O' && table[2][2] == 'O' && table[0][0] == ' ') {
			table[0][0] = 'X';
		}
		// random step
		boolean done = false;
		Random r = new Random();
		int a, b;
		while (!done) {
			a = r.nextInt(3);
			b = r.nextInt(3);
			if (table[a][b] == ' ') {
				table[a][b] = 'X';
				done = true;
			}
		}
		computerMove = false;
		
	}
	
	public static void userMove()
	{
		if(endOfGame)
		{
			return;
		}
		computerMove = false;
		boolean correctRow = false;
		boolean correctCol = false;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Give me number of row (0,1 lub 2 -> another option is INCORRECT!!) ");
		int myrow = keyboard.nextInt();
		if( myrow == 0 || myrow == 1 || myrow == 2)
		{
			correctRow = true;
		}
		while(!correctRow)
		{
			System.out.println("The row is incorrect");
			myrow = keyboard.nextInt();
			if( myrow <3 && myrow >= 0)
			{
				correctRow = true;
			}
		}
		int mycol = keyboard.nextInt();
		if( mycol == 0 || mycol == 1 || mycol == 2)
		{
			correctCol = true;
		}
		System.out.println("Give me a number of col (0,1 lub 2 -> another option is INCORRECT )");
		while(!correctCol)
		{
			System.out.println("The col is incorrect");
			mycol = keyboard.nextInt();
			if( mycol <3 && mycol >= 0)
			{
				correctCol = true;
			}
		}
		boolean correct = false;
		while(!correct){
		if(table[myrow][mycol] != ' ')
		{
			System.out.println("this space is not empty! ");
			System.out.println("Give me row ");
			myrow = keyboard.nextInt();
			System.out.println("Give me col ");
			mycol = keyboard.nextInt();
			while(mycol <0 || mycol >3)
			{
				System.out.println("You're stupid, give me correct col!! ");
				mycol = keyboard.nextInt();
			}
			while(myrow <0 || myrow >3)
			{
				System.out.println("You're stupid, give me correct row!! ");
				myrow = keyboard.nextInt();
			}
		}
		else
		{
			correct = true;
		}
	}
		table[myrow][mycol] = 'O';
		computerMove = true;
	}
	//koniec gry
	public static boolean endGame()
	{
		if((table[0][0] == 'X' && table[0][1] == 'X' && table[0][2] == 'X') || (table[1][0] == 'X' && table[1][1] == 'X' && table[1][2] == 'X') ||
			(table[2][0] == 'X' && table[2][1] == 'X' && table[2][2] == 'X') || (table[0][0] == 'X' && table[1][0] == 'X' && table[2][0] == 'X')
			|| (table[1][0] == 'X' && table[1][1] == 'X' && table[1][2] == 'X') || (table[2][0] == 'X' && table[2][1] == 'X' && table[2][2] == 'X')
			|| (table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X') || (table[0][2] == 'X' && table[1][1] == 'X' && table[2][0] == 'X'))
		{
			System.out.println("Sorry, computer was better, computer has won.");
			return true;
		}
		if((table[0][0] == 'O' && table[0][1] == 'O' && table[0][2] == 'O') || (table[1][0] == 'O' && table[1][1] == 'O' && table[1][2] == 'O') ||
				(table[2][0] == 'O' && table[2][1] == 'O' && table[2][2] == 'O') || (table[0][0] == 'O' && table[1][0] == 'O' && table[2][0] == 'O')
				|| (table[1][0] == 'O' && table[1][1] == 'O' && table[1][2] == 'O') || (table[2][0] == 'O' && table[2][1] == 'O' && table[2][2] == 'O')
				|| (table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O') || (table[0][2] == 'O' && table[1][1] == 'O' && table[2][0] == 'O'))
			{
				System.out.println("You are the best! Congratulations! You've won!");
				return true;
			}
		boolean draw = true;
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if(table[i][j] == ' ')
				{
					draw = false;
				}
			}
		}
		if(draw)
		{
			System.out.println("DRAW!");
			return true;
		}
		return false;
	}

	public static void main(String [] args)
	{
		System.out.print("Let's start a Tic Tac Toe game! "+"\n" + "Here's an empty board: ");
		printBoard();
		//if the game is going ...
		while(!endOfGame)
		{
			endOfGame = endGame();
			//ruch kompa
			if(computerMove)
			{
				computerMove(); 
				endOfGame = endGame();
				if(endOfGame)
				{
					printBoard();
					endGame();
					return;
				}
			}
			//ruch usera
			else
			{
				userMove();
				endOfGame = endGame();
				if(endOfGame)
				{
					printBoard();
					endGame();
					return;
				}
			}
			
			printBoard();
			endGame();
		}
		
	}
}
