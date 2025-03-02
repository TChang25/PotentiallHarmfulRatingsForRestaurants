/**
 * Tommy Chang
 * CEN 3024 Software Development 1
 * March 2, 2025
 * MainTest.java
 * This class performs unit testing on functions of Main
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    /**
     * method: calculateRestaurantGrade
     * parameters: none
     * return: none
     * purpose: to test the calculateRestaurantGrade function of Main
     */
    @Test
    void calculateRestaurantGrade() {
        Database mockDB = new Database();
        Main mockMain = new Main();
        assertAll(
                () -> assertTrue(mockDB.CreateReview("", "", 5, "", 2)),
                () -> assertTrue(mockDB.CreateReview("", "", 1, "", 3)),
                () -> assertEquals("", mockMain.calculateRestaurantGrade(mockDB, 1)),
                () -> assertEquals("A", mockMain.calculateRestaurantGrade(mockDB, 2)),
                () -> assertEquals("F", mockMain.calculateRestaurantGrade(mockDB, 3)),
                () -> assertEquals("", mockMain.calculateRestaurantGrade(mockDB, 4))
        );
    }

    /**
     * method: processInputFile
     * parameters: none
     * return: none
     * purpose: to test the processInputFile function of Main
     */
    @Test
    void processInputFile() {
        Database mockDB = new Database();
        Main mockMain = new Main();
        assertAll(
                () -> assertEquals(0, mockDB.getCustomerReviews().size()),
                () -> assertFalse(mockMain.processInputFile("test22.txt", mockDB)),
                () -> assertEquals(0, mockDB.getCustomerReviews().size()),
                () -> assertTrue(mockMain.processInputFile("test.txt", mockDB)),
                () -> assertEquals(15, mockDB.getCustomerReviews().size())
        );
    }
}