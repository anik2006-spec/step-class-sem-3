import java.util.Locale;

/**
 * Week 1 Assignment - 5 Problems
 * CodInClub (BridgeLabz)
 */
public class Week1Assignment {

    // =========================================================================
    // Problem 1: The Exam Hall Seat Duplication Checker
    // =========================================================================
    /**
     * Checks for duplicate seat numbers using only arrays and loops (no Collections).
     *
     * @param seatNumbers array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seats provided.");
            return;
        }

        boolean foundAnyDuplicate = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            // Check if this number has already been processed earlier
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

            // Check if it appears at any later index
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

    // =========================================================================
    // Problem 2: The Typing Speed Test Accuracy Checker
    // =========================================================================
    /**
     * Compares original and typed passages character by character,
     * calculating accuracy and reporting the first mismatch position.
     *
     * @param original original text
     * @param typed    typed text
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int total = original.length();
        int compareLength = Math.min(total, typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char firstOrigChar = ' ';
        char firstTypedChar = ' ';

        for (int i = 0; i < compareLength; i++) {
            char origChar = original.charAt(i);
            char typChar = typed.charAt(i);

            if (origChar == typChar) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-indexed position
                firstOrigChar = origChar;
                firstTypedChar = typChar;
            }
        }

        // If lengths differed and no mismatch found yet
        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLength + 1;
            firstOrigChar = (compareLength < original.length()) ? original.charAt(compareLength) : ' ';
            firstTypedChar = (compareLength < typed.length()) ? typed.charAt(compareLength) : ' ';
        }

        double accuracy = (total == 0) ? 100.0 : ((double) matched / total) * 100.0;

        if (firstMismatchPos != -1) {
            System.out.printf(Locale.US,
                    "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatchPos, firstOrigChar, firstTypedChar);
        } else {
            System.out.printf(Locale.US,
                    "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        }
    }

    // =========================================================================
    // Problem 3: The Traffic Signal Streak Analyzer
    // =========================================================================
    /**
     * Scans through a sequence of signal readings and reports the longest
     * continuous streak of the same color.
     *
     * @param signalLog string representing signal readings (e.g. "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("No signal data available");
            return;
        }

        char longestChar = signalLog.charAt(0);
        int maxStreak = 1;

        char currentChar = signalLog.charAt(0);
        int currentStreak = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char c = signalLog.charAt(i);
            if (c == currentChar) {
                currentStreak++;
            } else {
                currentChar = c;
                currentStreak = 1;
            }

            if (currentStreak > maxStreak) {
                maxStreak = currentStreak;
                longestChar = currentChar;
            }
        }

        System.out.printf("Longest Streak: '%c' repeated %d times%n", longestChar, maxStreak);
    }

    // =========================================================================
    // Problem 4: The Warehouse Inventory Balancer
    // =========================================================================
    /**
     * Computes totals for two storage sections, verifies balance, and identifies
     * the item with the single highest quantity.
     *
     * @param sectionA item quantities in Section A
     * @param sectionB item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            System.out.println("Invalid section data.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        int maxQuantity = Integer.MIN_VALUE;
        String maxSection = "";
        int maxItemNumber = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemNumber = i + 1; // 1-indexed item number
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemNumber = i + 1; // 1-indexed item number
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, status, maxQuantity, maxSection, maxItemNumber);
    }

    // =========================================================================
    // Problem 5: The Movie Review Word Length Profiler
    // =========================================================================
    /**
     * Splits a review into words and profiles word lengths into Short (1-4),
     * Medium (5-8), and Long (9+) categories.
     *
     * @param review string review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] words = review.trim().split("\\s+");
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            int len = word.length();
            if (len >= 1 && len <= 4) {
                shortCount++;
            } else if (len >= 5 && len <= 8) {
                mediumCount++;
            } else if (len >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortCount, mediumCount, longCount);
    }

    // =========================================================================
    // Main Method to Demonstrate and Test all 5 Problems
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("Week 1 Assignment - CodInClub (BridgeLabz)");
        System.out.println("==================================================\n");

        // --- Problem 1 Tests ---
        System.out.println("--- Problem 1: Exam Hall Seat Duplication Checker ---");
        int[] seats1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> Output: ");
        checkDuplicateSeats(seats1);

        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> Output: ");
        checkDuplicateSeats(seats2);
        System.out.println();

        // --- Problem 2 Tests ---
        System.out.println("--- Problem 2: Typing Speed Test Accuracy Checker ---");
        System.out.println("Test 1:");
        checkTypingAccuracy("hello world", "hello worlt");
        System.out.println("Test 2:");
        checkTypingAccuracy("coding", "coding");
        System.out.println();

        // --- Problem 3 Tests ---
        System.out.println("--- Problem 3: Traffic Signal Streak Analyzer ---");
        System.out.print("Input: \"RRGGGYRR\" -> Output: ");
        findLongestStreak("RRGGGYRR");
        System.out.print("Input: \"RRRRYYGG\" -> Output: ");
        findLongestStreak("RRRRYYGG");
        System.out.println();

        // --- Problem 4 Tests ---
        System.out.println("--- Problem 4: Warehouse Inventory Balancer ---");
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};
        analyzeInventory(secA, secB);
        System.out.println();

        // --- Problem 5 Tests ---
        System.out.println("--- Problem 5: Movie Review Word Length Profiler ---");
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review);
        System.out.println();

        System.out.println("==================================================");
        System.out.println("All sample tests executed successfully!");
        System.out.println("==================================================");
    }
}
