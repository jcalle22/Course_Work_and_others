//Assignment: Assignment 11, Assignment11.java
//Description: Driver class for MazeSolver.java and Node.java

public class Assignment11 {

	public static void main(String[] args) {
		MazeSolver mazeSolver = new MazeSolver();
		mazeSolver.readMaze();

		System.out.println("Original maze: ");
		mazeSolver.printMaze();
		System.out.println();
		mazeSolver.depthFirstSearch();

		System.out.println("Maze after Easter Bunny traverse: \n");
		mazeSolver.printMaze();
		System.out.println();
		if (mazeSolver.getEggFound() == 0)
			System.out.println("The Bunny was unable to recover the eggs, Easter is cancelled!");
		else
			System.out.println("The Easter Bunny found " + mazeSolver.getEggFound() + " egg(s)!");
	}
}
