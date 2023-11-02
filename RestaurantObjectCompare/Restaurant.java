// Assignment: Assignment 8, Restaurant.java
// Description: Contains methods and attributes for restaurant object
import java.io.Serializable;
public class Restaurant implements Serializable{
	
	//Instance variables
	private static final long serialVersionUID = 205L; 
	private String restaurantName;
	private String review;
	private int stars;
	private int priceRange;
	private String location;
	private Cuisine cuisine;
 
	//Constructor
	public Restaurant(String restaurantName, int stars, String review, int priceRange, String location, Cuisine cuisine) {
		this.restaurantName = restaurantName;
		this.stars = stars;
		this.review = review;
		this.priceRange = priceRange;
		this.location = location;
		this.cuisine = cuisine;
	}//End of Restaurant
	
	//Beginning of Methods
	public String getRestaurantName() {
		return restaurantName;
	}//End of getRestaurantName
	
	public int getStars() {
		return stars;
	}//End of getStars
	
	public int getPriceRange() {
		return priceRange;
	}//End of getPriceRange
	
	public String getLocation() {
		return location;
	}//End of getLocation
	
	public String getReview() {
		return review;
	}//End of getReview
	
	public Cuisine getCuisine() {
		return cuisine;
	}//End of getCuisine
	
	public String toString() {
		String starString = "";
		for (int i = 0; i < stars; i++) {
			starString += "*";
		}//End of starString loop
		
		String priceString = "";
		for (int i = 0; i < priceRange; i++) {
			priceString += "$";
		}//End of priceString loop
		String toString = restaurantName + " restaurant\n" + starString + "\t\t" + priceString + "\n" + cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
		return toString;
	}//End of toString
	
}//End of Restaurant class
