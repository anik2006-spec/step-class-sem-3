/**
 * Problem 5: The Movie Review Word Length Profiler
 * CodInClub (BridgeLabz)
 *
 * Task:
 * - Accept a movie review as a single string input.
 * - Split the review into individual words.
 * - Classify each word as Short (1–4 letters), Medium (5–8 letters), or Long (9+ letters).
 * - Count how many words fall into each category.
 * - Print the final counts for Short, Medium, and Long words.
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Classifies words in a review into Short, Medium, and Long length categories.
     *
     * @param review review string
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

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        String review = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + review + "\"");
        System.out.print("Output: ");
        classifyWordLengths(review);
    }
}
