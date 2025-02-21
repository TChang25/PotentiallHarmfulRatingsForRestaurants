/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * Restaurant.java
 * This class models how the Restaurant Object will behave in the database.
 */

public class Restaurant {

    private int ID;
    private String name;
    private String phone;
    private String address;
    private String type;
    private float rating;
    private int RatingCount;

    public Restaurant(int ID, String name, String phone, String address, String type, float rating, int ratingCount) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.type = type;
        this.rating = rating;
        this.RatingCount = ratingCount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRatingCount() {
        return RatingCount;
    }

    public void setRatingCount(int ratingCount) {
        RatingCount = ratingCount;
    }

    public String toString() {
        return this.ID + " " + this.name + " " + this.phone + " " + this.address + " " + this.type + " " + this.rating + " " + this.RatingCount;
    }
}
