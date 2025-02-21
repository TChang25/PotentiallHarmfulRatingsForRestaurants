/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * CustomerReview.java
 * This class models how the CustomerReview Object will behave in the database.
 */

public class CustomerReview {
    private int ID;
    private String Title;
    private String Comment;
    private int Rating;
    private String customerName;
    private String publishDate;
    private String LastUpdated;
    private int RestaurantID;

    public CustomerReview() {

    }
    public CustomerReview(int Id, String Title, String Comment, int Rating, String customerName, String publishDate, String lastUpdated, int RestaurantID) {
        this.ID = Id;
        this.Title = Title;
        this.Comment = Comment;
        this.Rating = Rating;
        this.customerName = customerName;
        this.publishDate = publishDate;
        this.LastUpdated = lastUpdated;
        this.RestaurantID = RestaurantID;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getLastUpdated() {
        return LastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        LastUpdated = lastUpdated;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        RestaurantID = restaurantID;
    }

    public String toString() {
        return this.getID() + "-" + this.getTitle() + "-" + this.getComment() + "-" + this.getRating() + "-" +
                this.getCustomerName() + "-" + this.getRestaurantID() + "-" + this.getLastUpdated() + "-" +
                this.getPublishDate() + "-";
    }
}
