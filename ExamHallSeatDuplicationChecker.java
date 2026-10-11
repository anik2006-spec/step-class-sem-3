import java.util.Scanner;

/**
 * Problem 1: The Exam Hall Seat Duplication Checker
 * CodInClub (BridgeLabz)
 *
 * Task:
 * - Accept an array of seat numbers (integers) assigned to students in a hall.
 * - Compare every seat number against every other seat number to check for duplicates
 *   (do not use any Collections class — arrays and loops only).
 * - If one or more duplicates are found, print the duplicated seat number(s).
 * - If no duplicates exist, print a clear confirmation message.
 */
public class ExamHallSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers in the given array.
     *
     * @param seatNumbers array of seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats provided.");
            return;
        }

        boolean foundAnyDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Check if already processed to prevent duplicate prints
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }

            if (alreadyReported) {
                continue;
            }

            // Check against remaining elements
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundAnyDuplicate = true;
                    break;
                }
            }
        }

        if (!foundAnyDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        // Sample Test Cases
        System.out.println("--- Test Case 1 ---");
        int[] sample1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(sample1);

        System.out.println("\n--- Test Case 2 ---");
        int[] sample2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(sample2);
    }
}
