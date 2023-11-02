// Assignment: Assignment 8, ReviewManager.java
// Description: Contains the methods for the ReviewManager class

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L;

    ArrayList<Restaurant> reviewList;

     public ReviewManager() {
        reviewList = new ArrayList<>();
    }

    /**
     * Add a Restaurant object to the reviewList and return true if such an object
     * is added successfully. Otherwise, return false. Two restaurants are
     * considered duplicated if they have exactly the same restaurant name and
     * cuisine name.
     * 
     * @param  restaurantName the name of the restaurant
     * @param  stars the number of stars for the restaurant
     * @param  review   the restaurant review
     * @param  priceRange    the integer price range
     * @param  cuisineName  the Cuisine's name
     * @param  location   the restaurant location (street address)
     * @param  signatureDish  most famous dish
     * @return            true if the operation is successful; false otherwise
     */
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }
    
    public int restaurantExists(String restaurantName, String location) {
    	for (int i = 0; i < reviewList.size(); i++) {
    		if ((reviewList.get(i)).getRestaurantName().equals(restaurantName) && reviewList.get(i).getLocation().equals(location)) {
    			return i;
    		}//End of if statement
    	}//End of for loop
    	//If it cannot find restaurant object
    	return -1;
    }//End of restaurantExists
    
    //I dont know why this needs an array
    public ArrayList<Integer> cuisineExists(String cuisine) {
    	ArrayList<Integer> cuisineList = new ArrayList<Integer>();
    	for (int i = 0; i < reviewList.size(); i++) {
    		if ((reviewList.get(i)).getCuisine().getName().equals(cuisine)) {
    			Integer index  = new Integer(i);
    			cuisineList.add(index);
    		}//End of if statement
    	}//End of for loop
    	//If it cannot find cuisine name
    	if (cuisineList.size() == 0) {
    		Integer notFound = new Integer(-1);
    		cuisineList.add(notFound);
    		return cuisineList;
    	}
    	return cuisineList;
    }//End of cuisineExists
    
    public Restaurant getRestaurant(int restaurantIndex) {
    	return reviewList.get(restaurantIndex);
    }//End of getRestaurant
    
    public boolean removeReview(String restaurantName, String location) {
    	if (restaurantExists(restaurantName, location) != -1) {
    		reviewList.remove(restaurantExists(restaurantName, location));
    		return true;
    	}
    	else
    		return false;
    }//End of removeReview
    
    public void sortByRating() {
    	Sorts.sort(reviewList, new ReviewRatingComparator());
    }//End of sortByRating
    
    public void sortByCuisine() {
    	Sorts.sort(reviewList, new ReviewCuisineComparator());
    }//End of sortByCuisine
    
    public String listReviews() {
    	String string = "";
    	for (int i = 0; i < reviewList.size(); i++) {
    		string += reviewList.get(i).toString();
    	}//End of for loop
    	return string;
    }//End of listReviews
    
    public void closeReviewManager() {
    	reviewList.clear();
    }//End of closeReviewManager
}
