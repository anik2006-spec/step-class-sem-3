/**
 * Problem 3: The Traffic Signal Streak Analyzer
 * CodInClub (BridgeLabz)
 *
 * Task:
 * - Accept a string representing a sequence of signal readings (e.g., "RRGGGYRR").
 * - Scan through the string and track the length of each streak of consecutive identical characters.
 * - Keep a running record of the longest streak found so far — both its color and its length.
 * - Print the color and length of the longest streak.
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Finds and prints the longest continuous streak of the same signal reading.
     *
     * @param signalLog string representing signal readings
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

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        findLongestStreak("RRGGGYRR");

        System.out.println("\n--- Test Case 2 ---");
        findLongestStreak("RRRRYYGG");
    }
}
