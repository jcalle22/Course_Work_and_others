// Assignment: Assignment 8, ReviewRatingComparator.java
// Description: Checks which aspect of a restaurant object comes first using the Comparator interface
import java.util.*;
public class ReviewRatingComparator implements Comparator<Restaurant> {
	public int compare(Restaurant rest1, Restaurant rest2) {
		int result = 0;
		if (rest1.getStars() - rest2.getStars() != 0) {
			if (rest1.getStars() - rest2.getStars() > 0) {
				result = 1;
				return result;
			}
			else {
				result = -1;
				return result;
			}
			
		}//End of second if
		
		//Checking which name is lexically first
		int count = 1;
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
