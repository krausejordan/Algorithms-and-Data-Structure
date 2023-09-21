import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver 
{
	//O(1)
	public static void depthFirst(MazeCell[][] cells, MazeCell start, MazeCell end) 
	{
		//Create instance of and set variables
		MyStack <MazeCell> stack = new MyStack<MazeCell>();
		int row = start.getRow();
		int col = start.getCol();
		stack.push(cells[row][col]);
		
		//Until we reach the end...
		while(cells[row][col] != cells[end.getRow()][end.getCol()])
		{
			//Check right
			if(cells[row][col].getCol() < 5 && cells[row][col+1].getCol() != -1 && cells[row][col+1].unVisited())
			{
				//increment col, mark visited, push to stack
				col++;
				cells[row][col].visit();
				stack.push(cells[row][col]);
			}
			//Check left
			else if(cells[row][col].getCol() > 0 && cells[row][col-1].getCol() != -1 && cells[row][col-1].unVisited())
			{
				//decrement col, mark visited, push to stack
				col--;
				cells[row][col].visit();
				stack.push(cells[row][col]);
			}
			//Check up
			else if(cells[row][col].getRow() > 0 && cells[row-1][col].getRow() != -1 && cells[row-1][col].unVisited())
			{
				//decrement row, mark visited, push to stack
				row--;
				cells[row][col].visit();	
				stack.push(cells[row][col]);				
			}
			//Check down
			else if(cells[row][col].getRow() < 3 && cells[row+1][col].getRow() != -1 && cells[row+1][col].unVisited())
			{
				//increment row, mark visited, push to stack
				row++;
				cells[row][col].visit();
				stack.push(cells[row][col]);
			}
			//Dead end
			else
			{
				//delete top, set row and col
				stack.pop();
				row = stack.top().getRow();
				col = stack.top().getCol();
			}
		}
		if(stack.empty())
		{
			System.out.println("The stack is empty. A solution was not found.");
		}
		else
		{
			//print path
			int stackSize = stack.size();
			System.out.println("A solution was found!");
			for(int i = 0; i < stackSize; i++)
			{
				System.out.println("ROW: " + stack.top().getRow() + "\tCOL: " + stack.top().getCol());
				stack.pop();
			}
		}
	} 
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		//create the Maze from the file
		Scanner fin = new Scanner(new File("Maze.in"));  
		
		//read in the rows and columns
		int rows = fin.nextInt();
		int cols = fin.nextInt();
		
		//create the maze
		int [][] grid = new int[rows][cols];
		
		//read in the data from the file to populate
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				grid[i][j] = fin.nextInt();
			}
		}
		
		//look at it
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				if (grid[i][j] == 3)
					System.out.print("S ");
				else if (grid[i][j] == 4)
					System.out.print("E ");
				else
					System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		//make a 2-d array of cells
		MazeCell[][] cells = new MazeCell[rows][cols];
		
		//populate with Maze Cell obj - default obj for walls
		MazeCell start = new MazeCell();
		MazeCell end = new MazeCell();
		
		//iterate over the grid, make cells and set coordinates
		for (int i = 0; i < rows; i++) 
		{
			for (int j = 0; j < cols; j++) 
			{
				//make a new cell
				cells[i][j] = new MazeCell();
				//if it isn't a wall, set the coordinates
				if (grid[i][j] != 0) 
				{
					cells[i][j].setCoordinates(i, j);
					//look for the start and end cells
					if (grid[i][j] == 3)
						start = cells[i][j];
					if (grid[i][j] == 4)
						end = cells[i][j];
				}
			}
		}
		//testing
		System.out.println("start:" + start + " end:" + end);
		
		
		//complete the maze
		depthFirst(cells, start, end);
	}
	
}
