/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * CustomerReview.java
 * This class models how the CustomerReview Object will behave in the database.
 * For a customerReview to be valid, it must contain a valid restaurant id as a Foreign Key (FK)
 * Database Has CustomerReviews, Use the database to store customerReviews in persistent storage
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

    /**
     * method: CustomerReview(int Id, String Title, String Comment, int Rating, String customerName, String publishDate, String lastUpdated, int RestaurantID)
     * @param Id - Unique ID of the customerReview
     * @param Title - Title of the customerReview
     * @param Comment - Comment of the customerReview
     * @param Rating - Rating of the customerReview
     * @param customerName - customerName of the customerReview
     * @param publishDate - publishDate of the customerReview
     * @param lastUpdated - lastUpdated of the customerReview
     * @param RestaurantID - FK RestaurantID of the customerReview; ties customerReview obj to Restaurant obj
     * Every CustomerReview created must have these parameters. Without these parameters the CustomerReview is invalid and cannot be used.
     */
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

    /**
     * method: getID()
     * @return int ID - unique pk of customerReview
     * getter
     */
    public int getID() {
        return ID;
    }

    /**
     * method: getTitle()
     * @return String Title - title of the customerReview
     * getter
     */
    public String getTitle() {
        return Title;
    }

    /**
     * method: getComment()
     * @return String Title - Comment of the customerReview
     * getter
     */
    public String getComment() {
        return Comment;
    }

    /**
     * method: setComment()
     * @param comment - String representing the comment related to the customerReview
     * setter
     */
    public void setComment(String comment) {
        Comment = comment;
    }

    /**
     * method: getRating()
     * @return int Rating - Rating of the customerReview
     * getter
     */
    public int getRating() {
        return Rating;
    }

    /**
     * method: setRating()
     * @param rating - int representing the rating related to the customerReview
     * setter
     */
    public void setRating(int rating) {
        Rating = rating;
    }

    /**
     * method: getCustomerName()
     * @return String customerName - customerName of the customerReview
     * getter
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * method: getPublishDate()
     * @return String publishDate - publishDate of the customerReview
     * getter
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * method: getLastUpdated()
     * @return String LastUpdated - LastUpdated of the customerReview
     * getter
     */
    public String getLastUpdated() {
        return LastUpdated;
    }

    /**
     * method: getRestaurantID()
     * @return int RestaurantID - RestaurantID of the customerReview
     * getter
     */
    public int getRestaurantID() {
        return RestaurantID;
    }

    /**
     * method: toString()
     * @return String(id-title-comment-rating-customerName-restaurantId-lastUpdated-publishDate)
     * returns a string representation for the object CustomerReview delimited by hyphens
     */
    public String toString() {
        return this.getID() + "-" + this.getTitle() + "-" + this.getComment() + "-" + this.getRating() + "-" +
                this.getCustomerName() + "-" + this.getRestaurantID() + "-" + this.getLastUpdated() + "-" +
                this.getPublishDate() + "-";
    }
}
