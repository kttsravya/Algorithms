package Outco_Recursion2;

import java.util.ArrayList;

/*
*  Problem: Lattice Paths
*
*  Prompt:  Count the number of unique paths to travel from the top left
*           corder to the bottom right corner of a lattice of N x N squares.
*
*           When moving through the lattice, one can only travel to the adjacent
*           corner on the right or down.
*
*  Input:   An integer N representing the size of the lattice
*  Output:  An integer representing the number of unique number of paths
*
*  Example: input: 2
*
*           (2 x 2 lattice of squares)
*            __ __
*           |__|__|
*           |__|__|
*
*           output: 6 (number of unique paths from top left corner to bottom right) */

public class LatticePaths {
	public static void main(String[] args) {
		int N = 3;
		findNumOfUniquePaths(N);
	}

	private static void findNumOfUniquePaths(int n) {
		int i = 0;
		int j = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0,0);
		latticePaths(i, j, list, n);
		System.out.println(list.get(0));
		
	}

	private static void latticePaths(int i, int j, ArrayList<Integer> count, int n) {

		    if(i > n || j > n){
		    	return;
		    }
			if (i == n  && j == n ) {
				System.out.println("reached end point");
				count.add(0,count.get(0)+1);
				
			}
			latticePaths(i + 1, j, count, n);
			latticePaths(i, j + 1, count, n);
		
	}
}
