import java.util.HashMap;

/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * Database.java
 * This database class handles creating, reading, updating and deleting CustomerReview and Restaurant data.
 * Use this class to facilitate storage of customer reviews.
 */
public class Database {
    int ReviewId, RestaurantId;
    HashMap<Integer, CustomerReview> customerReviews;
    HashMap<Integer, Restaurant> restaurants;

    /**
     * method: Database()
     * purpose: initializes base database with three restaurants for users to add reviews to
     */
    public Database() {
        ReviewId = 0;
        RestaurantId = 1;
        customerReviews = new HashMap<>();
        restaurants = new HashMap<>();

        CreateRestaurant("Gordon's Delight", "123-456-8888", "123 Way out there dr", "Casual", 0, 0);
        CreateRestaurant("Gordon's Trashcan", "123-456-8889", "123 Way out there but to the left dr", "Fine Dining", 0, 0);
        CreateRestaurant("Gordon's Zoo", "123-456-8880", "123 Way out there but to the right dr", "Zoo", 0, 0);
    }

    /**
     * method: CreateReview
     * @param reviewTitle title of customer's review (string)
     * @param reviewComment comment of customer's review (string)
     * @param rating rating of customer's review (int)
     * @param CustomerName customer name of the customer's review (string)
     * @param RestaurantID restaurantID fk of the customer's review (int)
     * @return boolean
     * purpose: Inserts a validated restaurantID, autoincrement ID value to a review, then puts review into the database
     *
     */
    public boolean CreateReview(String reviewTitle, String reviewComment, int rating, String CustomerName, int RestaurantID){
        try {
            CustomerReview r = new CustomerReview(ReviewId, reviewTitle, reviewComment, rating, CustomerName, "2-19-2025", "2-19-2025", RestaurantID);
            if (RestaurantID < 1 || RestaurantID > 3) {
                return false;
            }
            customerReviews.put(ReviewId, r);
            ReviewId++;
            return this.restaurantUpdate();
        }
        catch (Exception e) {
            return false;
        }
    }


    /**
     * method: CreateRestaurant
     * @param restaurantName - String representing the name of the Restaurant
     * @param phone - String representing the phone of the Restaurant
     * @param address - String representing the address of the Restaurant
     * @param type - String representing the type of the Restaurant
     * @param rating - float representing the rating of the Restaurant
     * @param ratingCount - int representing the total count of ratings of the Restaurant
     * @return true upon successful creation and addition of restaurant, false otherwise
     * purpose: Inserts an autoincrement ID value to a restaurant, then puts restaurant into the database
     *
     */
    private boolean CreateRestaurant(String restaurantName, String phone, String address, String type, float rating, int ratingCount){
        try{
            Restaurant r = new Restaurant(RestaurantId, restaurantName, phone, address, type, rating, ratingCount);
            restaurants.put(RestaurantId, r);
            RestaurantId++;
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

    /**
     * method: RemoveReview
     * @param ReviewId represents a valid existing id of a customer's review to remove
     * @return boolean
     * purpose: Removes review from database if the id for the review exists
     *
     */
    public boolean RemoveReview(int ReviewId){
        try {
            if (customerReviews.containsKey(ReviewId)){
                customerReviews.remove(ReviewId);
                return this.restaurantUpdate();
            }
            else{
                return false;
            }

        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * method: RemoveReview
     * @param reviewId valid existing id to be updated
     * @param rating valid rating 1-5 to update original review
     * @param reviewComment valid comment to update original review
     * @return boolean
     * purpose: Updates review from database if the id for the review exists
     *
     */
    public boolean UpdateReview(int reviewId, int rating, String reviewComment){
        try{
            if (customerReviews.containsKey(reviewId) && rating <= 5 && rating >= 1){
                customerReviews.get(reviewId).setRating(rating);
                customerReviews.get(reviewId).setComment(reviewComment);
                return this.restaurantUpdate();
            }
            else{
                return false;
            }
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * method: restaurantUpdate
     * @return boolean
     * purpose: Updates restaurants in database to reflect current review ratings
     * gets called after every CRUD operation to ensure restaurant data is up-to-date
     *
     */
    public boolean restaurantUpdate() {
        try {
            for (Restaurant restaurant : this.getRestaurants().values()) {
                int Rid = restaurant.getID();
                float sum = 0;
                float count = 0;
                for (CustomerReview review : this.getCustomerReviews().values()) {
                    if (Rid == review.getRestaurantID()) {
                        count++;
                        sum += review.getRating();
                    }
                }
                float rating = sum / count;
                restaurant.setRatingCount((int) count);
                restaurant.setRating(rating);
            }
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }


    /**
     * method: getCustomerReviews()
     * @return customerReview hashmap (k,v) = (id, customerReview)
     * Get the current customerReviews of the database
     */
    public HashMap<Integer, CustomerReview> getCustomerReviews() {
        return customerReviews;
    }

    /**
     * method: getRestaurants()
     * @return customerReview hashmap (k,v) = (id, Restaurant)
     * Get the current restaurants of the database
     */
    public HashMap<Integer, Restaurant> getRestaurants() {
        return restaurants;
    }


}
