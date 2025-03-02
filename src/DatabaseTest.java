/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * March 2, 2025
 * DatabaseTest.java
 * This class performs unit testing on functions of Database
 */
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    /**
     * method: createReview
     * parameters: none
     * return: none
     * purpose: to test the createReview function of Database
     */
    @org.junit.jupiter.api.Test
    void createReview() {
        Database mockDB = new Database();

        assertAll(
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 2)),
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 3)),
                () -> assertFalse(mockDB.CreateReview("", "", 5, "", 4)),
                () -> assertFalse(mockDB.CreateReview("124", "1234", 5, "555", 4)),
                () -> assertEquals(2, mockDB.getCustomerReviews().size())
        );
    }


    /**
     * method: removeReview
     * parameters: none
     * return: none
     * purpose: to test the removeReview function of Database
     */
    @org.junit.jupiter.api.Test
    void removeReview() {
        Database mockDB = new Database();
        assertAll(
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 2)),
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 3)),
                () -> assertFalse(mockDB.CreateReview("", "", 5, "", 4)),
                () -> assertFalse(mockDB.CreateReview("124", "1234", 5, "555", 4)),
                () -> assertEquals(2, mockDB.getCustomerReviews().size()),
                () -> assertTrue(mockDB.RemoveReview(0)),
                () -> assertTrue(mockDB.RemoveReview(1)),
                () -> assertFalse(mockDB.RemoveReview(2)),
                () -> assertEquals(0, mockDB.getCustomerReviews().size())
        );
    }

    /**
     * method: updateReview
     * parameters: none
     * return: none
     * purpose: to test the updateReview function of Database
     */
    @org.junit.jupiter.api.Test
    void updateReview() {
        Database mockDB = new Database();
        assertAll(
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 2)),
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 3)),
                () -> assertFalse(mockDB.CreateReview("", "", 5, "", 4)),
                () -> assertFalse(mockDB.CreateReview("124", "1234", 5, "555", 4)),
                () -> assertEquals(2, mockDB.getCustomerReviews().size()),

                () -> assertTrue(mockDB.UpdateReview(1,2,"The worst")),
                () -> assertEquals(2, mockDB.getCustomerReviews().get(1).getRating()),
                () -> assertEquals("The worst", mockDB.getCustomerReviews().get(1).getComment()),

                () -> assertTrue(mockDB.UpdateReview(1,5,"The absolute best")),
                () -> assertEquals(5, mockDB.getCustomerReviews().get(1).getRating()),
                () -> assertEquals("The absolute best", mockDB.getCustomerReviews().get(1).getComment()),

                () -> assertFalse(mockDB.UpdateReview(1,6,"The absolute worst")),
                () -> assertEquals(5, mockDB.getCustomerReviews().get(1).getRating()),
                () -> assertEquals("The absolute best", mockDB.getCustomerReviews().get(1).getComment())
        );
    }

    /**
     * method: restaurantUpdate
     * parameters: none
     * return: none
     * purpose: to test the restaurantUpdate function of Database
     */
    @org.junit.jupiter.api.Test
    void restaurantUpdate() {
        Database mockDB = new Database();
        assertAll(
                // add dummy reviews
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 2)),
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 3)),
                () -> assertFalse(mockDB.CreateReview("", "", 5, "", 4)),
                () -> assertFalse(mockDB.CreateReview("124", "1234", 5, "555", 4)),

                // ensure restaurantUpdate is updating the ratings relevant to the restaurant
                () -> assertEquals(Math.sqrt(-1), mockDB.getRestaurants().get(1).getRating()),
                () -> assertEquals(0, (int)mockDB.getRestaurants().get(1).getRatingCount()),

                () -> assertEquals(5, mockDB.getRestaurants().get(2).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(2).getRatingCount()),

                () -> assertEquals(5, mockDB.getRestaurants().get(3).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(3).getRatingCount()),

                // change review
                () -> assertTrue(mockDB.UpdateReview(1,2,"The worst")),
                () -> assertEquals("The worst", mockDB.getCustomerReviews().get(1).getComment()),

                // ensure restaurantUpdate is updating the ratings relevant to the restaurant
                () -> assertEquals(Math.sqrt(-1), mockDB.getRestaurants().get(1).getRating()),
                () -> assertEquals(0, (int)mockDB.getRestaurants().get(1).getRatingCount()),

                () -> assertEquals(5, mockDB.getRestaurants().get(2).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(2).getRatingCount()),

                () -> assertEquals(2, mockDB.getRestaurants().get(3).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(3).getRatingCount()),

                // change review
                () -> assertTrue(mockDB.UpdateReview(1,1,"The absolute best")),
                () -> assertEquals("The absolute best", mockDB.getCustomerReviews().get(1).getComment()),

                () -> assertFalse(mockDB.UpdateReview(1,6,"The absolute worst")),
                () -> assertEquals("The absolute best", mockDB.getCustomerReviews().get(1).getComment()),

                // ensure restaurantUpdate is updating the ratings relevant to the restaurant
                () -> assertEquals(Math.sqrt(-1), mockDB.getRestaurants().get(1).getRating()),
                () -> assertEquals(0, (int)mockDB.getRestaurants().get(1).getRatingCount()),

                () -> assertEquals(5, mockDB.getRestaurants().get(2).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(2).getRatingCount()),

                () -> assertEquals(1, mockDB.getRestaurants().get(3).getRating()),
                () -> assertEquals(1, mockDB.getRestaurants().get(3).getRatingCount())

        );
    }
}