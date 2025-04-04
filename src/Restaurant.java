/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * Restaurant.java
 * This class models how the Restaurant Object will behave in the database.
 * Database Has Restaurants, Use the database to store Restaurants in persistent storage
 */
public class Restaurant {

    private int ID;
    private String name;
    private String phone;
    private String address;
    private String type;
    private float rating;
    private int RatingCount;

    /**
     * method: Restaurant(int ID, String name, String phone, String address, String type, float rating, int ratingCount)
     * @param ID - unique ID of the Restaurant
     * @param name - name of the Restaurant
     * @param phone - phone of the Restaurant
     * @param address - address of the Restaurant
     * @param type - type of the Restaurant
     * @param rating rating of the Restaurant
     * @param ratingCount count of ratings of the Restaurant
     * Every restaurant created must have these parameters. Without these parameters the restaurant is invalid and cannot be used.
     */
    public Restaurant(int ID, String name, String phone, String address, String type, float rating, int ratingCount) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.rating = rating;
        this.RatingCount = ratingCount;
    }

    /**
     * method: getID()
     * @return int unique ID of the Restaurant
     * getter
     */
    public int getID() {
        return ID;
    }


    /**
     * method: getRating()
     * @return float rating of the Restaurant
     * getter
     */
    public float getRating() {
        return rating;
    }

    /**
     * method: setRating()
     * @param rating - float 1-5 to represent the rating of the restaurant
     * setter
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * method: getRatingCount()
     * @return int RatingCount the total count of ratings related to the restaurant
     * getter
     */
    public int getRatingCount() {
        return RatingCount;
    }

    /**
     * method: getRatingCount()
     * @param ratingCount - int the total count of ratings related to the restaurant
     * getter
     */
    public void setRatingCount(int ratingCount) {
        RatingCount = ratingCount;
    }

    /**
     * method: toString()
     * @return String(id + name + phone + address + type + rating + ratingCount)
     * returns a string representation for the object Restaurant
     */
    public String toString() {
        return this.ID + " " + this.name + " " + this.phone + " " + this.address + " " + this.type + " " + this.rating + " " + this.RatingCount;
    }
}
