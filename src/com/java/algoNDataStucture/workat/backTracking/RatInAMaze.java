package com.java.algoNDataStucture.workat;

import java.util.Scanner;

public class RatInAMaze {

	public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in)) {
			RatInAMaze ratInAMaze = new RatInAMaze();
			int TCs = sc.nextInt();
			for(int i = 0; i < TCs; i++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				int[][] maze = new int[n][m];
				for(int iRow = 0; iRow < n; iRow++) {
					for(int iCol = 0; iCol < m; iCol++) {
						maze[iRow][iCol] = sc.nextInt();
					}
				}
				System.out.println(ratInAMaze.canGetCheese(maze));
			}
		}

	}

	boolean canGetCheese(int[][] maze) {
	    // add your logic here
		int pathLength = 1;
		int n = maze.length;
		int m = maze[0].length;
		int[][] route = new int[n*m][2];
		route[0][0] = 0;
		route[0][1] = 0;
		for(int i = 0; i < pathLength; i++) {
			if((route[i][0]+1 < n) && (maze[route[i][0]+1][route[i][1]] == 1)) {
				maze[route[i][0]+1][route[i][1]] = 0;
				route[pathLength][0] = route[i][0]+1;
				route[pathLength++][1] = route[i][1];
			}
			if((route[i][1]+1 < m) && (maze[route[i][0]][route[i][1] +1] == 1)) {
				maze[route[i][0]][route[i][1] +1] = 0;
				route[pathLength][0] = route[i][0];
				route[pathLength++][1] = route[i][1] + 1;
			}
			if((route[pathLength-1][0] == n-1) && (route[pathLength-1][1] == m-1)) {
				return true;
			}
		}
		return false;
	}
}
