// Assignment: Assignment 8, ReviewCuisineComparator.java
// Description: Finds priority of how to sort the different restaurant objects
import java.util.*;

public class ReviewCuisineComparator implements Comparator<Restaurant> {
	public int compare(Restaurant rest1, Restaurant rest2) {
		int result = 0;
		
		//Checking which cuisine name is lexically first
		int count = 1;
		if (!(rest1.getCuisine().getName()).equals(rest2.getCuisine().getName())) {
			while (count != 0 ) {	
				for (int i = 0; i < (rest1.getCuisine().getName()).length(); i++) {
					if ((int)(rest1.getCuisine().getName().charAt(i)) > (int)(rest2.getCuisine().getName().charAt(i))) {
						result = 1;
						count = 0;
						return result;
					}//End of first if
					else if ((int)(rest1.getCuisine().getName().charAt(i)) < (int)(rest2.getCuisine().getName().charAt(i))) {
						result = -1;
						count = 0;
						return result;
					}//End of second if
				}//End of for
			}//End of while loop
		}//End of outer if that checks if the names are equal
		
		if (rest1.getPriceRange() != rest2.getPriceRange()) {
			if (rest1.getPriceRange() < rest2.getPriceRange()) {
				result = -1;
				return result;
			}
			else if (rest1.getPriceRange() > rest2.getPriceRange() ){
				result = 1;
				return result;
			}
			
		}//End of second if
		
		//Checks which restaurantName is lexically first
		if (!(rest1.getRestaurantName()).equals(rest2.getRestaurantName())) {
			while (count != 0 ) {	
				for (int i = 0; i < rest1.getRestaurantName().length(); i++) {
					if ((int)(rest1.getRestaurantName().charAt(i)) > (int)(rest2.getRestaurantName().charAt(i))) {
						result = 1;
						count = 0;
						return result;
					}//End of first if
					else if ((int)(rest1.getRestaurantName().charAt(i)) < (int)(rest2.getRestaurantName().charAt(i))) {
						result = -1;
						count = 0;
						return result;
					}//End of second if
				}//End of for
			}//End of while loop
		}//End of outer if that checks if the names are equal
		
		//Checks which location is lexically first
		if (!(rest1.getLocation()).equals(rest2.getLocation())) {
			while (count != 0 ) {	
				for (int i = 0; i < rest1.getLocation().length(); i++) {
					if ((int)(rest1.getLocation().charAt(i)) > (int)(rest2.getLocation().charAt(i))) {
						result = 1;
						count = 0;
						return result;
					}//End of first if
					else if ((int)(rest1.getLocation().charAt(i)) < (int)(rest2.getLocation().charAt(i))) {
						result = -1;
						count = 0;
						return result;
					}//End of second if
				}//End of for
			}//End of while loop
		}//End of outer if that checks if the names are equal
		
		//Checks which review is lexically first
				if (!(rest1.getReview()).equals(rest2.getReview())) {
					while (count != 0 ) {	
						for (int i = 0; i < rest1.getReview().length(); i++) {
							if ((int)(rest1.getReview().charAt(i)) > (int)(rest2.getReview().charAt(i))) {
								result = 1;
								count = 0;
								return result;
							}//End of first if
							else if ((int)(rest1.getReview().charAt(i)) < (int)(rest2.getReview().charAt(i))) {
								result = -1;
								count = 0;
								return result;
							}//End of second if
						}//End of for
					}//End of while loop
				}//End of outer if that checks if the names are equal
				
		//If result = 1, restaurant1
		//If result = -1, restaurant2
		//If result = 0, they are equal
		return result;
	}
}


