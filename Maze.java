package maze;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze {

	//variables
	private static char[][] maze;
	private static int startX;
	private static int startY;
	private static int goalX;
	private static int goalY;
	
	//constructor
	public Maze(char[][] maze, int startX, int startY, int goalX, int goalY){
		Maze.maze = maze;
		Maze.startX = startX;
		Maze.startY = startY;
		Maze.goalX = goalX;
		Maze.goalY = goalY;
	}	
	
	
	
	//public method
	/*public static void placePlus(){
		maze[currX][currY] = '+';
	}
	
	public static void placeMinus(){
		maze[currX][currY] = '-';
	}*/

	
	public boolean Find_Path(char[][] maze, int startX, int startY){
		
		//if open
		if (maze[startX][startY] != '0'){
			return false;
		}
		//if outside
		if (startX < 0 || startY < 0 || startX > 80 || startY > 80){
			return false;
		}
		//if goal
		if (startX == Maze.goalX && startY == Maze.goalY){
			return true;
		}
	

		maze[startX][startY] = '+';
		
		//check south
		if (Find_Path(maze, startX, startY + 1)){
			return true;
		}

		//check north
		if (Find_Path(maze, startX, startY - 1)){
			return true;
		}

		//check east
		if (Find_Path(maze, startX + 1, startY)){
			return true;
		}
		//check west
		if (Find_Path(maze, startX - 1, startY)){
			return true;
		}
			
		maze[startX][startY] = '-';
		return false;
		
		
	}

	
	public static void main(String[] args) throws IOException{
		
		Scanner sp = new Scanner(System.in);
		System.out.println("Please input the start point: x,y");
		String start = sp.nextLine();
		String[] splitsp = start.split(",");
		int startX = Integer.parseInt(splitsp[0]);
		int startY = Integer.parseInt(splitsp[1]);
		
		System.out.println("Please input the goal: x,y");
		String goal = sp.nextLine();
		String[] splitgoal = goal.split(",");
		int goalX = Integer.parseInt(splitgoal[0]);
		int goalY = Integer.parseInt(splitgoal[1]);
		sp.close();
		
			BufferedReader reader = new BufferedReader(new FileReader("./maze.txt"));
			String readline;
			//char[][] maze_original;
			ArrayList<String> myList = new ArrayList<String>();
			while((readline = reader.readLine()) != null){
				myList.add(readline);
				//maze_original[line] = readline.toCharArray();
				//System.out.println(maze);
			}
			reader.close();
			//System.out.println(myList);
			char[][] maze_original = new char[81][81];
			
			for(int i=0;i<myList.size();i++){
				String[] row_elements = myList.get(i).split(" ");
				for(int k=0;k<81;k++){
					maze_original[i][k] = row_elements[k].charAt(0);
					//System.out.println(row_elements[k].charAt(0));
				}
				//maze_original[i] = myList.get(i).toCharArray();
				//System.out.println(myList.get(i).toCharArray());
			}
			
			//System.out.println("MAZZZZZZZZZZZ \n");
			//System.out.println(maze_original[0]);

			Maze result = new Maze(maze_original, startX, startY, goalX, goalY);
			//System.out.println(result.Find_Path(maze, startX, startY));
			if(result.Find_Path(maze_original, startX, startY)){
				//System.out.println(maze);
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
	}
	}

