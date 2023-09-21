import java.util.ArrayList;
import java.util.List;


public class Graph 
{
	public String[] vertices;
	public int[][] edge;
	
	//O(1)
	public int getDistance(int vertices1, int vertices2)
	{
		return edge[vertices1][vertices2];
	}
	//O(n)
	public List<Integer> getNeighbors(int vertice) 
	{
		List<Integer> neighbors = new ArrayList<Integer>();
		for(int i = 0; i < edge.length; i++)
		{
			if(edge[vertice][i] > 0)
				neighbors.add(i);
		}
		return neighbors;
	}
	//O(n)
	public void display()
	{
		for(int i = 0; i < edge.length; i++)
		{
			for(int j = 0; j < edge.length; j++)
			{
				
					System.out.print("\t" + edge[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Graph thisGraph = new Graph();
		
		thisGraph.edge = new int[15][15];
		thisGraph.edge[0][1] = 14;
		thisGraph.edge[0][11] = 14;
		thisGraph.edge[0][12] = 9;
		
		thisGraph.edge[1][0] = 14;
		thisGraph.edge[1][11] = 9;
		thisGraph.edge[1][10] = 17;
		thisGraph.edge[1][2] = 9;
		
		thisGraph.edge[2][1] = 9;
		thisGraph.edge[2][10] = 13;
		thisGraph.edge[2][9] = 20;
		thisGraph.edge[2][3] = 5;
		
		thisGraph.edge[3][2] = 5;
		thisGraph.edge[3][9] = 19;
		thisGraph.edge[3][4] = 17;
		
		thisGraph.edge[4][3] = 17;
		thisGraph.edge[4][9] = 4;
		thisGraph.edge[4][5] = 16;
		
		thisGraph.edge[5][4] = 16;
		thisGraph.edge[5][9] = 12;
		thisGraph.edge[5][7] = 9;
		thisGraph.edge[5][6] = 8;
		
		thisGraph.edge[6][5] = 8;
		thisGraph.edge[6][7] = 6;
		
		thisGraph.edge[7][6] = 6;
		thisGraph.edge[7][5] = 9;
		thisGraph.edge[7][9] = 12;
		thisGraph.edge[7][8] = 7;
		thisGraph.edge[7][14] = 10;
		thisGraph.edge[7][13] = 23;
		
		thisGraph.edge[8][7] = 7;
		thisGraph.edge[8][9] = 13;
		thisGraph.edge[8][10] = 5;
		thisGraph.edge[8][14] = 6;
		
		thisGraph.edge[9][2] = 20;
		thisGraph.edge[9][3] = 19;
		thisGraph.edge[9][4] = 4;
		thisGraph.edge[9][5] = 12;
		thisGraph.edge[9][7] = 12;
		thisGraph.edge[9][8] = 13;
		thisGraph.edge[9][10] = 7;

		thisGraph.edge[10][1] = 17;
		thisGraph.edge[10][2] = 13;
		thisGraph.edge[10][9] = 7;
		thisGraph.edge[10][8] = 5;
		thisGraph.edge[10][14] = 8;
		thisGraph.edge[10][11] = 18;
		
		thisGraph.edge[11][0] = 14;
		thisGraph.edge[11][1] = 9;
		thisGraph.edge[11][10] = 18;
		thisGraph.edge[11][14] = 9;
		thisGraph.edge[11][12] = 15;

		thisGraph.edge[12][0] = 9;
		thisGraph.edge[12][11] = 15;
		thisGraph.edge[12][14] = 15;
		thisGraph.edge[12][13] = 11;

		thisGraph.edge[13][12] = 11;
		thisGraph.edge[13][14] = 18;
		thisGraph.edge[13][7] = 23;

		thisGraph.edge[14][12] = 15;
		thisGraph.edge[14][11] = 9;
		thisGraph.edge[14][10] = 8;
		thisGraph.edge[14][8] = 6;
		thisGraph.edge[14][7] = 10;
		thisGraph.edge[14][13] = 18;

		thisGraph.vertices = new String[15];
		thisGraph.vertices[0] = "Mohave";
		thisGraph.vertices[1] = "Coconino";
		thisGraph.vertices[2] = "Navajo";
		thisGraph.vertices[3] = "Apache";
		thisGraph.vertices[4] = "Greenlee";
		thisGraph.vertices[5] = "Cochise";
		thisGraph.vertices[6] = "Santa Cruz";
		thisGraph.vertices[7] = "Pima";
		thisGraph.vertices[8] = "Pinal";
		thisGraph.vertices[9] = "Graham";
		thisGraph.vertices[10] = "Gila";
		thisGraph.vertices[11] = "Yavapai";
		thisGraph.vertices[12] = "La Paz";
		thisGraph.vertices[13] = "Yuma";
		thisGraph.vertices[14] = "Maricopa";
		
		thisGraph.display();
		
		System.out.println("Distance between 4 and 5 is " + thisGraph.getDistance(4, 5));
		System.out.println("Distance between 9 and 4 is " + thisGraph.getDistance(9, 4));
		System.out.println("Distance between 6 and 9 is " + thisGraph.getDistance(6, 9));

		System.out.print("Neighbors of Pinal: ");
		for(int i = 0; i < thisGraph.getNeighbors(8).size(); i++)
		{
			System.out.print(thisGraph.vertices[i] + " ");
		}
	}

}
