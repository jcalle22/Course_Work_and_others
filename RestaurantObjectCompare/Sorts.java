// Assignment: Assignment 8, Sorts.java
// Description: Sorts an array list of restaurant objects
import java.util.*;
public class Sorts {

	public static void sort(ArrayList<Restaurant> reviewList, Comparator<Restaurant> xComparator) {
	      int min;
	      for (int i = 0; i <= reviewList.size()-1; i++)
	      {
	         min = i;
	         for (int j = i + 1; j < reviewList.size(); j++)
	            //if (reviewList.get(j).compareTo(reviewList.get(min)) < 0)
	        	if (xComparator.compare(reviewList.get(j), reviewList.get(min)) == -1)
	               min = j;
	         Collections.swap(reviewList, min, i);
	      }
	}
	
}

