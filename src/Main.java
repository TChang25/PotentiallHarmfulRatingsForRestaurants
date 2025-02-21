import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * February 23, 2025
 * Main.java
 * This application will prompt the user various actions to view, edit, delete details related to reviews of restaurants.
 * In particular, they can view, edit, and delete without regards to whom the original user was.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        Database db = new Database();
        while (true) {
            int menuInput = main.getIntValueFromInput(main.Menu());
            switch (menuInput) {
                case 1:
                    System.out.println("All restaurants displayed.");
                    System.out.println("ID-Name-Phone-Address-Type-Rating-RatingCount");
                    for (Restaurant restaurant : db.getRestaurants().values()){
                        System.out.println(restaurant);
                    }
                    break;
                case 2:
                    System.out.println("Please ensure your review data looks like Title-Comment-Rating-CustomerName-RestaurantID");
                    String fileName = main.getStringValueFromInput("Please enter a filename: ");
                    try {
                        Scanner scFile = new Scanner(new File(fileName));
                        while (scFile.hasNextLine()) {
                            String line = scFile.nextLine();
                            String[] reviewParts = line.split("-");
                            try{
                                if (db.CreateReview(reviewParts[0], reviewParts[1], Integer.parseInt(reviewParts[2]), reviewParts[3], Integer.parseInt(reviewParts[4]))){
                                   System.out.println("Review Created Successfully: " + line);
                                }
                                else{
                                    System.out.println("Review Not Created Unsuccessfully: " + line);
                                }

                            }
                            catch(Exception e){
                                System.out.println("Parsing error while creating review: " + line);
                                System.out.println("Continuing to parse the file.");
                                continue;
                            }

                        }
                        System.out.println("Completed processing file: " + fileName);
                    } catch (Exception e) {
                        System.out.println("File not found. Try again.");
                        continue;
                    }
                    break;
                case 3:
                    if (db.getCustomerReviews().isEmpty()) {
                        System.out.println("No customer reviews found.");
                        break;
                    }
                    System.out.println("ID-Title-Comment-Rating-CustomerName-RestaurantID-LastUpdated-PublishDate");
                    for (CustomerReview review : db.getCustomerReviews().values()) {
                        System.out.println(review);
                    }
                    break;
                case 4:
                    String reviewTitle = main.getStringValueFromInput("Please enter a review title:");
                    String reviewComment = main.getStringValueFromInput("Please enter a review comment:");

                    int reviewRating = main.getIntValueFromInput("Please enter a review rating 1 - 5:");
                    while (reviewRating > 5 || reviewRating < 1) {
                        System.out.println("Invalid review Rating. Try again.");
                        reviewRating = main.getIntValueFromInput("Please enter a review rating 1 - 5:");
                    }

                    String customerName = main.getStringValueFromInput("Please enter a customer name:");
                    int restaurantID = main.getIntValueFromInput("Please enter a restaurant ID (1-3):");
                    while (!db.getRestaurants().containsKey(restaurantID)) {
                        System.out.println("Please enter a valid restaurant ID.");
                        restaurantID = main.getIntValueFromInput("Please enter a restaurant ID (1-3):");
                    }

                    if (db.CreateReview(reviewTitle, reviewComment, reviewRating, customerName, restaurantID)){
                        System.out.println("Review created.");
                    }
                    break;
                case 5:
                    int reviewIDDelete = main.getIntValueFromInput("Please enter a review ID to be removed: ");
                    if (db.RemoveReview(reviewIDDelete)){
                        System.out.println("Review removed.");
                    }
                    else{
                        System.out.println("Review not found.");
                    }
                    break;
                case 6:
                    int reviewIDUpdate = main.getIntValueFromInput("Please enter a review ID to be updated: ");
                    String reviewCommentUpdate = main.getStringValueFromInput("Please enter a new review comment: ");
                    int reviewRatingUpdate = main.getIntValueFromInput("Please enter a new review rating");
                    if (db.UpdateReview(reviewIDUpdate, reviewRatingUpdate, reviewCommentUpdate)){
                        System.out.println("Review updated.");
                    }
                    else{
                        System.out.println("Review not found.");
                    }
                    break;
                case 7:
                    int restaurantIDScore = main.getIntValueFromInput("Please enter a restaurant ID (1-3) to view their grade: ");
                    String restaurantGrade = main.calculateRestaurantGrade(db, restaurantIDScore);
                    if (restaurantGrade.isEmpty()){
                        System.out.println("Restaurant reviews do not exist for this restaurant.");
                    }
                    else{
                        System.out.println("Restaurant [" + restaurantIDScore + "] Grade: " + restaurantGrade);
                    }
                    break;
                case 8:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
            }
        }


    }

    /**
     * method: calculateRestaurantGrade
     * @param Database, int
     * @return String
     * purpose: To perform custom action of calculating the total rating of a restaurant then returning
     * as a letter associated with the rating average.
     */
    public String calculateRestaurantGrade(Database db, int restaurantID) {
        float sum = 0;
        float count = 0;
        for (CustomerReview review: db.getCustomerReviews().values()) {
            if (review.getRestaurantID() == restaurantID) {
                sum += review.getRating();
                count++;
            }
        }
        float avg = sum / count;
        if (avg == 5){
            return "A";
        }
        else if (avg > 4){
            return "B";
        }
        else if (avg > 3){
            return "C";
        }
        else if (avg > 2){
            return "D";
        }
        else if (avg > 1){
            return "F";
        }
        else {
            return "";
        }
    }

    /**
     * method: Menu
     * params: None
     * @return String
     * purpose: Store the menu standard output for better readability
     */
    public String Menu(){
        return """
                Welcome to Potentially Harmful Ratings for Restaurants!
                Please enter your choice as a number 1-7.
                1. View all restaurants
                2. Enter review data from txt file
                3. View all reviews
                4. Create a new review
                5. Remove a review
                6. Update a review
                7. View a restaurant's score of A-F
                8. Exit
                Enter your choice:\s""";
    }

    /**
     * method: getIntValueFromInput
     * @param String
     * @return int
     * purpose: Int scan helper function to prevent bad values from being entered
     */
    public int getIntValueFromInput(String msg) {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println(msg);
            String inputLine = in.nextLine();

            try {
                return Integer.parseInt(inputLine);
            } catch (NumberFormatException var4) {
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
            }
        }
    }

    /**
     * method: getIntValueFromInput
     * @param String
     * @return double
     * purpose: double scan helper function to prevent bad values from being entered
     */
    public double getDoubleValueFromInput(String msg) {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println(msg);
            String inputLine = in.nextLine();

            try {
                return Double.parseDouble(inputLine);
            } catch (NumberFormatException var4) {
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
            }
        }
    }

    /**
     * method: getIntValueFromInput
     * @param String
     * @return String
     * purpose: String scan helper function to prevent bad values from being entered
     */
    public String getStringValueFromInput(String msg) {
        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.println(msg);
            String inputLine = in.nextLine();

            try {
                return inputLine;
            } catch (NumberFormatException var4) {
                System.out.println("Not a valid input.");
                System.out.println("Please try again.");
            }
        }
    }
}