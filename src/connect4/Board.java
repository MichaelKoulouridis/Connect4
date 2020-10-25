// Koulouridis Mixalis 3120082
package connect4;

import java.util.ArrayList;

public class Board
{
	public static final int X = 1;
	public static final int O = -1;
	public static final int EMPTY = 0;
	private int [][] gameboard ;
	private Move lastMove;
	
	private int lastLetterPlayed;
	
	public Board()
	{
		lastMove = new Move();
		lastLetterPlayed = O;
		gameboard = new int[6][7];
		for (int i = 5; i>=0; i--)
		{
			for(int j = 0; j<7; j++)
			{
				gameboard[i][j]= EMPTY;
			}
		}
		
	}
	
	public Board(Board board) 
	{
		lastMove = board.lastMove;
		lastLetterPlayed = board.lastLetterPlayed;
		gameboard = new int[6][7];
		for(int j=0; j<7; j++)
		{
			for(int i=5; i>=0; i--)
			{
				gameboard[i][j] = board.gameboard[i][j];
			}
		}
		
	}
	
	public int getLastLetterPlayed()
	{
		return lastLetterPlayed;
	}
	
	
	public Move getLastMove()
	{
		return lastMove;
	}
	
	public void setLastMove(Move lastMove)
	{
		this.lastMove.setRow(lastMove.getRow());
		this.lastMove.setCol(lastMove.getCol());
		this.lastMove.setValue(lastMove.getValue());
	}

	public void makeMove(int row ,int col,int letter)
	{

		lastMove = new Move(row, col);
		gameboard[row][col]=letter;
		lastLetterPlayed = letter;
	}
	
	// Β�?ισκει για δεδομενη στηλη ποια σει�?α εχει ελευθε�?η θεση 
	public int getRowforCol(int col){
		int aux = -10;
		for(int i=0; i<6; i++)
		{
			if(gameboard[i][col]==EMPTY){
				aux = i;
			}
		}
		return aux;
	}
	
	// Παι�?νει ως arguments μια στηλη και ενα συμβολο και τοποθετει στον πινακα το συμβολο αυτο
	public void makeMove(int col, int letter) {
		
		lastMove = new Move(getRowforCol(col), col);
		gameboard[getRowforCol(col)][col] = letter;
		lastLetterPlayed = letter;
	}
	// ελεγχει αν μια κινηση ειναι εγκυρη 
	public boolean isValidMove(int col) {
		int row = getRowforCol(col);
		
		if ((row <0) || (col <0) || (row > 5) || (col > 6)) {
			return false;
		}
		if(gameboard[row][col] != EMPTY) {
			return false;
		}
		return true;
	}
	
	// δημιου�?γει τα παιδια-καταστασεις
	public ArrayList<Board> getChildren(int letter) {
		
		ArrayList<Board> children = new ArrayList<Board>();
		
		for(int col=0; col<7; col++) {
			
			if(isValidMove(col)) {
				
				Board child = new Board(this);
				child.makeMove(col, letter);
				children.add(child);
			}
		}
		return children;
	}
	
	

	public int evaluate() {

		int Xlines = 0;
		int Olines = 0;
		
		
			
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == X && gameboard[row][col + 1] == X && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == 0) {
						Xlines = Xlines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == X && gameboard[row][col + 2] == X && gameboard[row][col + 3] == 0) {
						Xlines = Xlines+ 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == X && gameboard[row][col + 3] == X) {
						Xlines = Xlines+ 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == X && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == X && gameboard[row][col + 3] == 0) {
						Xlines = Xlines+ 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == X && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == X) {
						Xlines = Xlines+ 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == X && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == X) {
						Xlines = Xlines+ 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == O && gameboard[row][col + 1] == O && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == 0) {
						Olines = Olines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == O && gameboard[row][col + 2] == O && gameboard[row][col + 3] == 0) {
						Olines = Olines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == O && gameboard[row][col + 3] == O) {
						Olines = Olines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == O && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == O && gameboard[row][col + 3] == 0) {
						Olines = Olines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == 0 && gameboard[row][col + 1] == O && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == O) {
						Olines = Olines + 250;
					}
				}
			}
			
			for(int col = 0;col <= 3;col++) {
				for(int row = 0;row < 6;row++) {
					if(gameboard[row][col] == O && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == O) {
						Olines = Olines + 250;
					}
				}
			}
			
			
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == X && gameboard[row][col + 1] == X && gameboard[row][col + 2] == X && gameboard[row][col + 3] == 0) {
							Xlines = Xlines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == 0 && gameboard[row][col + 1] == X && gameboard[row][col + 2] == X && gameboard[row][col + 3] == X) {
							Xlines = Xlines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == X && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == X && gameboard[row][col + 3] == X) {
							Xlines = Xlines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == X && gameboard[row][col + 1] == X && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == X) {
							Xlines = Xlines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == O && gameboard[row][col + 1] == O && gameboard[row][col + 2] == O && gameboard[row][col + 3] == 0) {
							Olines = Olines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == 0 && gameboard[row][col + 1] == O && gameboard[row][col + 2] == O && gameboard[row][col + 3] == O) {
							Olines = Olines + 1000;
						}
					}
				}
				
	
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == O && gameboard[row][col + 1] == 0 && gameboard[row][col + 2] == O && gameboard[row][col + 3] == O) {
							Olines = Olines + 1000;
						}
					}
				}
				
				for(int col = 0;col <= 3;col++) {
					for(int row = 0;row < 6;row++) {
						if(gameboard[row][col] == O && gameboard[row][col + 1] == O && gameboard[row][col + 2] == 0 && gameboard[row][col + 3] == O) {
							Olines = Olines + 1000;
						}
					}
				}

				for (int col=0; col<=3; col++){
					for(int row=0;row<6;row++){
						if(gameboard[row][col]==X && gameboard[row][col+1]==X && gameboard[row][col + 2]==X && gameboard[row][col+ 3]== X){
							Xlines = Xlines + 4000;
						}
					}
				}
				
				for (int col=0; col<=3; col++){
					for(int row=0;row<6;row++){
						if(gameboard[row][col]==O && gameboard[row][col+1]==O && gameboard[row][col + 2]==O && gameboard[row][col+ 3]== O){
							Olines = Olines + 4000;
						}
					}
				}
				
				for(int col = 0;col<=6; col++){
					for(int row=5; row>=3; row--){
						if(gameboard[row][col]==X && gameboard[row-1][col]==X && gameboard[row-2][col]==0 && gameboard[row-3][col]==0)
						{
							Xlines = Xlines+ 250;
						}
					}
				}

				
				for(int col = 0;col<=6; col++){
					for(int row=5; row>=3; row--){
						if(gameboard[row][col]==O && gameboard[row-1][col]==O && gameboard[row-2][col]==0 && gameboard[row-3][col]==0)
						{
							Olines = Olines + 250;
						}
					}
				}
			
				
			
			
				
				
				for(int col = 0;col<=6; col++){
					for(int row=5; row>=3; row--){
						if(gameboard[row][col]==X && gameboard[row-1][col]==X && gameboard[row-2][col]==X && gameboard[row-3][col]==0)
						{
							Xlines = Xlines + 1000;
						}
					}
				}
				
				for(int col = 0;col<=6; col++){
					for(int row=5; row>=3; row--){
						if(gameboard[row][col]==O && gameboard[row-1][col]==O && gameboard[row-2][col]==O && gameboard[row-3][col]==0)
						{
							Olines = Olines + 1000;
						}
					}
				}
				
				
				
				for(int row =5; row>=3; row--){
					for(int col = 0; col<=6; col++){
						if(gameboard[row][col]==X && gameboard[row-1][col]==X && gameboard[row-2][col]==X && gameboard[row-3][col]==X)
						{
							Xlines = Xlines + 4000;
						}
					}
				}
				
				for(int row =5; row>=3; row--){
					for(int col = 0; col<=6; col++){
						if(gameboard[row][col]==O && gameboard[row-1][col]==O && gameboard[row-2][col]==O && gameboard[row-3][col]==O)
						{
							Olines = Olines + 4000;
						}
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Xlines = Xlines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] ==X && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Xlines = Xlines+ 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Xlines = Xlines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines+ 250;
				            } 
				        }
				}
				

				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 250;
				            } 
				        }
				}
				
				
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Olines = Olines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] ==0 && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] == 0) 
				            {
				            	Xlines = Xlines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == 0 && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == 0 && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] ==X) 
				            {
				            	Xlines = Xlines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == 0 && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines + 1000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == X && gameboard[r + 1][c + 1] == X && gameboard[r + 2][c + 2] == X && gameboard[r + 3][c + 3] == X) 
				            {
				            	Xlines = Xlines+ 4000;
				            } 
				        }
				}
		
				for(int r = 0;r <= 2;r++) 
				{
				        for(int c = 0;c < 4;c++) 
				        {
				            if(gameboard[r][c] == O && gameboard[r + 1][c + 1] == O && gameboard[r + 2][c + 2] == O && gameboard[r + 3][c + 3] == O) 
				            {
				            	Olines = Olines + 4000;
				            } 
				        }
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == 0) 
						{
							Xlines = Xlines+ 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == 0) 
						{
							Xlines = Xlines+ 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines+ 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == 0) 
						{
							Xlines = Xlines+ 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines+ 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == 0) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == 0) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == 0) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] ==0 && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 250;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == 0) 
						{
							Xlines = Xlines+ 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] ==0  && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines+ 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == 0) 
						{
							Olines = Olines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == 0 && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == 0 && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == 0 && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 1000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == O && gameboard[r + 1][c - 1] == O && gameboard[r + 2][c - 2] == O && gameboard[r + 3][c - 3] == O) 
						{
							Olines = Olines + 4000;
			            }
					}
				}
				
				for(int r = 0;r <= 2;r++) 
				{
					for(int c = 6;c >= 3;c--) 
					{
						if(gameboard[r][c] == X && gameboard[r + 1][c - 1] == X && gameboard[r + 2][c - 2] == X && gameboard[r + 3][c - 3] == X) 
						{
							Xlines = Xlines + 4000;
			            }
					}
				}
				
				
				
	   return Xlines-Olines;
	}
	
	
	// ελεγχος τε�?ματικης καταστασης
	public boolean isTerminal() 
	{
		
			//ελεγχος 4αδας ο�?ιζοντια
			for (int i=5; i>=0; i--) {
				for (int j=0; j<4; j++) {
					if (gameboard[i][j] == gameboard[i][j+1] && gameboard[i][j] == gameboard[i][j+2] && gameboard[i][j] == gameboard[i][j+3] && gameboard[i][j] != EMPTY) {
							
							return true;
					}
				}
			}

			//ελεγχος 4αδας καθετα
			for (int j=0;j<7; j++) {
				for (int i=5; i>=3; i--) {
					if (gameboard[i][j] == gameboard[i-1][j] && gameboard[i][j] == gameboard[i-2][j] && gameboard[i][j] == gameboard[i-3][j]
							&& gameboard[i][j] != EMPTY) {
			
						return true;
					}
				}
			}

			//ελεγχος 4αδας απο πανω α�?ιστε�?α π�?ος κατω δεξια
			for (int i=0; i<3; i++) {
				for (int j=0; j<4; j++) {
					if (gameboard[i][j] == gameboard[i+1][j+1] && gameboard[i][j] == gameboard[i+2][j+2] && gameboard[i][j] == gameboard[i+3][j+3] 
							&& gameboard[i][j] != EMPTY) {
						
						return true;
					}
				}
			}

			//ελεγος 4αδας απο κατω α�?ιστε�?α π�?ος πανω δεξια
			for (int i=5; i>=3; i--) {
				for (int j=0; j<4; j++) {
					 
						if (gameboard[i][j] == gameboard[i-1][j+1] && gameboard[i][j] == gameboard[i-2][j+2] && gameboard[i][j] == gameboard[i-3][j+3] 
								&& gameboard[i][j] != EMPTY) {
				
							return true;
						}
					
				}
			}


			return false;

}
	// τυπωνει το ταμπλο
    public void print()
	{
		
		for(int row=0; row<6; row++)
		{
			System.out.print("* ");
			for(int col=0; col<7; col++)
			{
				switch (gameboard[row][col])
				{
					case X:
						System.out.print("X ");
						break;
					case O:
						System.out.print("O ");
						break;
					case EMPTY:
						System.out.print("- ");
						break;
					default:
						break;
				}
			}
			System.out.println("*");
		}
		
	}
}