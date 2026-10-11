import java.util.ArrayList;
import java.util.List;

/**
 * Category A · Coding Assignment
 * Problem 6: Campus Portal Browser History
 *
 * TASK:
 * A campus portal browser opens on a home page and supports three actions:
 * 1. visit a new page (which clears all forward history)
 * 2. go back up to x pages (stops at the first page available)
 * 3. go forward up to x pages (stops at the last page available)
 *
 * Design a BrowserHistory class backed by your own doubly linked list, with:
 * - visit(url)
 * - back(steps) -> returns current page
 * - forward(steps) -> returns current page
 *
 * Back and forward stop at the first and last pages available.
 * Use your own node class (e.g. class Node { String url; Node prev, next; });
 * do not use java.util.LinkedList or other collections for the list itself.
 *
 * CONSTRAINTS:
 * • 1 <= number of actions <= 5000
 * • 1 <= steps <= 100
 * • Each visit is O(1); back and forward are O(steps)
 *
 * COMPLEXITY:
 * • visit(url): O(1) time, O(1) auxiliary space.
 * • back(steps): O(min(steps, distance_to_head)) time.
 * • forward(steps): O(min(steps, distance_to_tail)) time.
 * • Overall Space: O(N) where N is the total number of live visited pages.
 *
 * FORWARD HISTORY DISCARD EXPLANATION:
 * When visit(url) is called, current.next is updated to point directly to the newly created node,
 * and the new node's prev pointer points back to current.
 * Any existing forward chain that was previously attached to current.next is decoupled.
 * In Java, because those forward nodes are no longer reachable from any root or active reference,
 * they become eligible for automatic garbage collection (GC) and their memory is reclaimed.
 */

class BrowserNode {
    String url;
    BrowserNode prev;
    BrowserNode next;

    public BrowserNode(String url) {
        this.url = url;
        this.prev = null;
        this.next = null;
    }
}

public class BrowserHistory {

    private BrowserNode current;

    /**
     * Initializes the browser history with the given homepage.
     *
     * @param homepage the starting homepage URL
     */
    public BrowserHistory(String homepage) {
        this.current = new BrowserNode(homepage);
    }

    /**
     * Visits a new URL from the current page.
     * Clears all forward history.
     * Cost: O(1) time.
     *
     * @param url the URL to visit
     */
    public void visit(String url) {
        BrowserNode newNode = new BrowserNode(url);
        // Link new node after current
        newNode.prev = current;
        current.next = newNode;
        // Move current pointer to the new node
        current = newNode;
    }

    /**
     * Navigates back up to 'steps' pages in history.
     * Stops at the first page available (home page).
     * Cost: O(steps) time.
     *
     * @param steps number of steps to go back
     * @return the current URL after moving back
     */
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    /**
     * Navigates forward up to 'steps' pages in history.
     * Stops at the latest page available.
     * Cost: O(steps) time.
     *
     * @param steps number of steps to go forward
     * @return the current URL after moving forward
     */
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    /**
     * Returns the URL of the current page.
     *
     * @return current URL
     */
    public String getCurrentPage() {
        return current.url;
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("Problem 6: Campus Portal Browser History");
        System.out.println("===============================================================\n");

        System.out.println("Initializing BrowserHistory with home = \"srm.edu\"");
        BrowserHistory browser = new BrowserHistory("srm.edu");

        System.out.println("Actions:");
        System.out.println("  visit(\"a.com\")");
        browser.visit("a.com");

        System.out.println("  visit(\"b.com\")");
        browser.visit("b.com");

        System.out.println("  visit(\"c.com\")");
        browser.visit("c.com");

        List<String> outputs = new ArrayList<>();

        System.out.println("  back(1)");
        String r1 = browser.back(1);
        outputs.add(r1);

        System.out.println("  back(1)");
        String r2 = browser.back(1);
        outputs.add(r2);

        System.out.println("  forward(1)");
        String r3 = browser.forward(1);
        outputs.add(r3);

        System.out.println("  visit(\"d.com\") [clears forward history]");
        browser.visit("d.com");

        System.out.println("  forward(2)");
        String r4 = browser.forward(2);
        outputs.add(r4);

        System.out.println("  back(2)");
        String r5 = browser.back(2);
        outputs.add(r5);

        System.out.println("  back(7)");
        String r6 = browser.back(7);
        outputs.add(r6);

        System.out.println("\nExpected Output: b.com, a.com, b.com, d.com, a.com, srm.edu");
        System.out.println("Actual Output:   " + String.join(", ", outputs));

        System.out.println("\n===============================================================");
        System.out.println("COMPLEXITY ANALYSIS & DISCARDED HISTORY EXPLANATION");
        System.out.println("===============================================================");
        System.out.println("1. Time Complexity per Operation:");
        System.out.println("   - visit(url):    O(1) - Constant pointer updates.");
        System.out.println("   - back(steps):   O(steps) - Traverses at most 'steps' prev pointers.");
        System.out.println("   - forward(steps):O(steps) - Traverses at most 'steps' next pointers.");
        System.out.println("2. Space Complexity: O(N) where N is the number of active history pages.");
        System.out.println("3. How visit discards forward history:");
        System.out.println("   - Setting current.next = newNode severs the reference to any previous");
        System.out.println("     forward node chain.");
        System.out.println("   - Unreferenced forward nodes become unreachable from the active list");
        System.out.println("     and are automatically reclaimed by Java's Garbage Collector (GC).");
        System.out.println("===============================================================");
    }
}
