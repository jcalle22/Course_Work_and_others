import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//Assignment: Assignment 11, MazeSolver.java
//Description: Contains the code that creates the stack and for the DFS

public class MazeSolver {
	private Stack<Node> stack;
	private char[][] maze;
	private int eggFound;
	private int mHeight;
	private int mWidth;

	

	// ************************************************************************************
	// ************** Utility method to read maze from user input *************************
	// ************************************************************************************
	public void readMaze() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Height of the maze: ");
			String line = reader.readLine();
			mHeight = Integer.parseInt(line);

			System.out.println("Width of the maze: ");
			line = reader.readLine();
			mWidth = Integer.parseInt(line);
			maze = new char[mHeight][mWidth];
		
			for (int i = 0; i < mHeight; i++) {
				line = reader.readLine();
				for (int j = 0; j < mWidth; j++) {
					maze[i][j] = line.charAt(j);
				}
			}
				
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MazeSolver() {
		stack = new Stack<Node>();
		eggFound = 0;
		
	}//End of MazeSolver constructor
	//If this does not work then get rid of stackSearch
	public void depthFirstSearch() {
		//While the size of the stack is greater than zero and the amount of accessible routes does not equal zero
		Node theMan = new Node(0,0);
		stack.push(theMan);
		while (stack.size() > 0) {
			Node mazeSpot = stack.pop();
			//Checking if the node is an egg
			//Make sure to change the first one to the Y coordinate if it doesn't work
			
			if (maze[mazeSpot.getY()][mazeSpot.getX()] == 'E') {
				eggFound++;
			}
			
			maze[mazeSpot.getY()][mazeSpot.getX()] = 'x';
			//UNCOMMENT IF THE MAZE IS STILL ALL X
			//maze[mazeSpot.getY()][mazeSpot.getX()] = 'x';
			
			//Getting and checking south spot
			if (mazeSpot.getY() + 1 < mHeight) {
				if ((maze[mazeSpot.getY() + 1][mazeSpot.getX()] != 'x') && (maze[mazeSpot.getY() + 1][mazeSpot.getX()] != '#')) {
					Node mazeSpotSouth = new Node(mazeSpot.getX(), mazeSpot.getY() + 1);
					//maze[mazeSpot.getY() + 1][mazeSpot.getX()] = 'x';
					stack.push(mazeSpotSouth);
				}//End of inner if to check if its a wall or an already visited spot	
			}//End of outer if checking if it is in the maze
			//Getting and checking east spot
			if (mazeSpot.getX() + 1 < mWidth) {
				if ((maze[mazeSpot.getY()][mazeSpot.getX() + 1] != 'x') && (maze[mazeSpot.getY()][mazeSpot.getX() + 1] != '#')) {
					Node mazeSpotEast = new Node(mazeSpot.getX() + 1, mazeSpot.getY());
					//maze[mazeSpot.getY()][mazeSpot.getX() + 1] = 'x';
					stack.push(mazeSpotEast);
				}//End of inner if to check if its a wall or an already visited spot
			}//End of outer if checking if it is in the maze
			//Getting and checking north spot
			if (mazeSpot.getY() - 1 >= 0) {
				if ((maze[mazeSpot.getY() - 1][mazeSpot.getX()] != 'x') && (maze[mazeSpot.getY() - 1][mazeSpot.getX()] != '#')) {
					Node mazeSpotNorth = new Node(mazeSpot.getX(), mazeSpot.getY() - 1);
					//maze[mazeSpot.getY() - 1][mazeSpot.getX()] = 'x';
					stack.push(mazeSpotNorth);
				}//End of inner if to check if its a wall or an already visited spot
			}//End of outer if checking if it is in the maze
			//Getting and checking west spot
			if (mazeSpot.getX() - 1 >= 0) {
				if ((maze[mazeSpot.getY()][mazeSpot.getX() - 1] != 'x') && (maze[mazeSpot.getY()][mazeSpot.getX() - 1] != '#')) {
					Node mazeSpotWest = new Node(mazeSpot.getX() - 1, mazeSpot.getY());
					//maze[mazeSpot.getY()][mazeSpot.getX() - 1] = 'x';
					stack.push(mazeSpotWest);
				}//End of inner if to check if its a wall or an already visited spot
			}//End of outer if checking if it is in the maze
		}//End of while
	}//End of depthFirstSearch
	
	//Returns the number of eggs found
	public int getEggFound() {
		return eggFound;
	}//End of getEggFound
	
	public void printMaze() {
		for (int i = 0; i < mHeight; i++) {
			for (int j = 0; j < mWidth; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
		
	}//End of printMaze
	
}
