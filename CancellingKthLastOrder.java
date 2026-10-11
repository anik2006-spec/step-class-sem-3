/**
 * Category A · Coding Assignment
 * Problem 5: Cancelling the k-th Last Order
 *
 * TASK:
 * A restaurant keeps today's orders in a singly linked list, newest at the end.
 * A customer cancels the order that is k-th from the end.
 *
 * Implement Node removeKthFromEnd(Node head, int k) that removes that node
 * in a single pass and returns the head. Use your own node class (for example
 * class Node { int data; Node next; }); do not use java.util.LinkedList or other
 * collections for the list itself.
 *
 * CONSTRAINTS:
 * • 1 <= k <= length of list <= 10^4
 * • Single pass only
 *
 * COMPLEXITY:
 * • Time Complexity: O(N) — Single pass traversal where N is the length of the list.
 * • Space Complexity: O(1) — In-place pointer manipulation with constant auxiliary space.
 *
 * HEAD REMOVAL WITHOUT SPECIAL CASE:
 * By introducing a dummy node placed immediately before the head (dummy.next = head),
 * the dummy node acts as a uniform predecessor for all nodes in the list, including the head.
 * When k equals the length of the list (removing the head), the trailing pointer stops at the
 * dummy node, allowing the operation 'trailing.next = trailing.next.next' to seamlessly update
 * dummy.next to point to the new head without requiring an explicit 'if (k == length)' check.
 */

// Node definition as required by the assignment
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class CancellingKthLastOrder {

    /**
     * Removes the k-th node from the end of the singly linked list in a single pass.
     *
     * @param head head node of the singly linked list
     * @param k    1-based position from the end of the list
     * @return the head node of the modified list
     */
    public static Node removeKthFromEnd(Node head, int k) {
        // Step 1: Create a dummy node that points to head
        Node dummy = new Node(0);
        dummy.next = head;

        Node lead = dummy;
        Node trailing = dummy;

        // Step 2: Advance lead pointer k + 1 steps ahead
        for (int i = 0; i <= k; i++) {
            if (lead == null) {
                // If k exceeds list length, return original head
                return head;
            }
            lead = lead.next;
        }

        // Step 3: Move both lead and trailing one step at a time
        // until the lead pointer falls off the end (becomes null)
        while (lead != null) {
            lead = lead.next;
            trailing = trailing.next;
        }

        // Step 4: Delete the k-th node from end by skipping it
        trailing.next = trailing.next.next;

        // Step 5: Return the modified head
        return dummy.next;
    }

    /**
     * Helper method to construct a singly linked list from an array of integers.
     *
     * @param values array of values
     * @return head of the constructed linked list
     */
    public static Node buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Helper method to print the linked list in format: 10 -> 20 -> 30 -> 40 -> 50
     *
     * @param head head of the list
     */
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println("===============================================================");
        System.out.println("Problem 5: Cancelling the k-th Last Order");
        System.out.println("===============================================================\n");

        // --- Sample 1 ---
        System.out.println("--- Sample 1 ---");
        int[] input1 = {10, 20, 30, 40, 50};
        int k1 = 2;
        Node orders1 = buildList(input1);
        System.out.print("Input Orders:    ");
        printList(orders1);
        System.out.println("k = " + k1);

        orders1 = removeKthFromEnd(orders1, k1);
        System.out.print("Expected Output: 10 -> 20 -> 30 -> 50\n");
        System.out.print("Actual Output:   ");
        printList(orders1);
        System.out.println();

        // --- Sample 2 ---
        System.out.println("--- Sample 2 (Removing Head) ---");
        int[] input2 = {10, 20, 30, 40, 50};
        int k2 = 5;
        Node orders2 = buildList(input2);
        System.out.print("Input Orders:    ");
        printList(orders2);
        System.out.println("k = " + k2);

        orders2 = removeKthFromEnd(orders2, k2);
        System.out.print("Expected Output: 20 -> 30 -> 40 -> 50\n");
        System.out.print("Actual Output:   ");
        printList(orders2);
        System.out.println();

        // --- Complexity & Explanation ---
        System.out.println("===============================================================");
        System.out.println("COMPLEXITY ANALYSIS & HEAD REMOVAL EXPLANATION");
        System.out.println("===============================================================");
        System.out.println("1. Time Complexity:  O(N) - Single pass through the list of N nodes.");
        System.out.println("2. Space Complexity: O(1) - Constant auxiliary space, in-place deletion.");
        System.out.println("3. Head Removal without Special Case:");
        System.out.println("   A dummy node is placed in front of head (dummy.next = head).");
        System.out.println("   The lead pointer advances k + 1 steps ahead of trailing (starting at dummy).");
        System.out.println("   When k = N (Sample 2, removing head):");
        System.out.println("     - lead moves N + 1 steps and immediately hits null.");
        System.out.println("     - trailing stays at dummy node.");
        System.out.println("     - trailing.next = trailing.next.next changes dummy.next to node 2 (20).");
        System.out.println("     - Returning dummy.next correctly returns the new head (20) with no");
        System.out.println("       special if-else branches needed.");
        System.out.println("===============================================================");
    }
}

