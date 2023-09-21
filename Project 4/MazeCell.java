public class MazeCell 
{
		//Declare variables
		private int row, col;
		private int direction;
		boolean visited;
		
		//O(1)
		// set row and col with r and c
		public MazeCell(int r, int c) 
		{
			row = r;
			col = c;
			direction = 0;
			visited = false;
		}
		//O(1)
		// no-arg constructor
		public MazeCell()
		{
			row = col = -1;
			direction = 0;
			visited = false;
		}
		//O(1)
		// copy constructor
		public MazeCell(MazeCell rhs)
		{
			this.row = rhs.row;
			this.col = rhs.col;
			this.direction = rhs.direction;
			this.visited = rhs.visited;
		}
		//O(1)
		//returns direction
		public int getDirection() 
		{
			return direction;
		}
		//O(1)
		// update direction. if direction is 4, mark cell as visited
		public void advanceDirection()
		{
			direction++;
			if (direction == 4)
			{
				visited = true;
			}
		}
		//O(1)
		// change row and col to r and c
		public void setCoordinates(int r, int c) 
		{
			row = r;
			col = c;
		}
		//O(1)
		//return row
		public int getRow() 
		{
			return row;
		}
		//O(1)
		//reeturn col
		public int getCol() 
		{
			return col;
		}
		//O(1)
		//compares data
		@Override
		public boolean equals(Object obj) 
		{
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			MazeCell other = (MazeCell) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		//O(1)
		// set visited status to true
		public void visit() 
		{
			visited = true;
			
		}
		//O(1)
		// reset visited status
		public void reset() 
		{
			visited = false;
		}
		//O(1)
		// return true if this cell is unvisited
		public boolean unVisited()
		{
			return !visited;
		}
		//O(1)
		//format printing
		public String toString() 
		{
			return "(" + row + "," + col + ")";
		}
}