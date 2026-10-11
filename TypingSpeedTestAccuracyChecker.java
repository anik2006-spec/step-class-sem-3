import java.util.Locale;

/**
 * Problem 2: The Typing Speed Test Accuracy Checker
 * CodInClub (BridgeLabz)
 *
 * Task:
 * - Accept two strings of equal length: the original passage and the user's typed text.
 * - Compare the two strings character by character using their positions.
 * - Count how many characters match at the same position.
 * - Calculate the accuracy percentage: (matched characters / total characters) * 100.
 * - Print the accuracy percentage and the position of the first mismatch (or a message confirming no mismatches).
 */
public class TypingSpeedTestAccuracyChecker {

    /**
     * Checks typing accuracy between original and typed strings.
     *
     * @param original original string
     * @param typed    typed string
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

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.println("\n--- Test Case 2 ---");
        checkTypingAccuracy("coding", "coding");
    }
}
