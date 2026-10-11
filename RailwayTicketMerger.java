/**
 * Category A · Coding Assignment
 * Problem: Railway Counter Ticket Merge (Merge Two Sorted Linked Lists)
 *
 * TASK:
 * Two railway counters each produce a singly linked list of ticket numbers in ascending order.
 * At closing time, both lists must be combined into one ascending list.
 *
 * Implement Node mergeSorted(Node a, Node b) that merges the lists by relinking
 * the existing nodes and returns the new head. Duplicates are kept.
 * Use your own node class (for example class Node { int data; Node next; });
 * do not use java.util.LinkedList or other collections for the list itself.
 *
 * CONSTRAINTS:
 * • 0 <= length of each list <= 10^5
 * • No new nodes may be created (a single dummy node is allowed)
 *
 * COMPLEXITY:
 * • Time Complexity: O(m + n) where m and n are the lengths of list a and list b.
 *   Each comparison advances at least one pointer, taking at most m + n steps.
 * • Space Complexity: O(1) auxiliary space.
 *   Only a single dummy node is allocated (as explicitly allowed); existing nodes
 *   are spliced in-place by updating their next references.
 *
 * COMPARISON WITH ARRAY COPY & SORT:
 * • Time Complexity:
 *   - In-place Linked List Merge: O(m + n) linear time — optimal.
 *   - Array Copy & Sort: O((m + n) log(m + n)) time — requires iterating through both lists
 *     to fill an array, executing comparison-based sorting, and reconstructing a list.
 * • Space Complexity:
 *   - In-place Linked List Merge: O(1) auxiliary space (no extra memory).
 *   - Array Copy & Sort: O(m + n) extra memory to hold the array elements.
 * • Node Allocation:
 *   - In-place Linked List Merge: Zero new nodes created (respects strict problem constraint).
 *   - Array Copy & Sort: Recreating a linked list from the sorted array requires creating
 *     m + n brand new nodes, strictly violating the assignment constraints.
 */

class TicketNode {
    int data;
    TicketNode next;

    public TicketNode(int data) {
        this.data = data;
        this.next = null;
    }

    public TicketNode(int data, TicketNode next) {
        this.data = data;
        this.next = next;
    }
}

public class RailwayTicketMerger {

    /**
     * Merges two sorted singly linked lists by relinking existing nodes in ascending order.
     *
     * @param a head of first sorted list
     * @param b head of second sorted list
     * @return head of the combined sorted list
     */
    public static TicketNode mergeSorted(TicketNode a, TicketNode b) {
        // Fast paths for empty lists
        if (a == null) return b;
        if (b == null) return a;

        // Single dummy node allowed to anchor the merged list
        TicketNode dummy = new TicketNode(0);
        TicketNode tail = dummy;

        // Relink nodes by comparing current heads
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Attach any remaining nodes from either list
        if (a != null) {
            tail.next = a;
        } else {
            tail.next = b;
        }

        return dummy.next;
    }

    /**
     * Helper method to construct a singly linked list from an integer array.
     *
     * @param values values array
     * @return head of the created list
     */
    public static TicketNode buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        TicketNode head = new TicketNode(values[0]);
        TicketNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new TicketNode(values[i]);
            current = current.next;
        }
        return head;
    }

    /**
     * Helper method to print the linked list in format: 3 -> 5 -> 8 -> ...
     *
     * @param head head of list
     */
    public static void printList(TicketNode head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        TicketNode current = head;
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
        System.out.println("Railway Counter Ticket Merge (Merge Two Sorted Linked Lists)");
        System.out.println("===============================================================\n");

        // --- Sample 1 ---
        System.out.println("--- Sample 1 ---");
        int[] arrA1 = {3, 8, 15};
        int[] arrB1 = {5, 8, 12, 20};

        TicketNode a1 = buildList(arrA1);
        TicketNode b1 = buildList(arrB1);

        System.out.print("List a:          ");
        printList(a1);
        System.out.print("List b:          ");
        printList(b1);

        TicketNode merged1 = mergeSorted(a1, b1);
        System.out.print("Expected Output: 3 -> 5 -> 8 -> 8 -> 12 -> 15 -> 20\n");
        System.out.print("Actual Output:   ");
        printList(merged1);
        System.out.println();

        // --- Sample 2 ---
        System.out.println("--- Sample 2 ---");
        TicketNode a2 = null; // empty list
        int[] arrB2 = {4};
        TicketNode b2 = buildList(arrB2);

        System.out.print("List a:          ");
        printList(a2);
        System.out.print("List b:          ");
        printList(b2);

        TicketNode merged2 = mergeSorted(a2, b2);
        System.out.print("Expected Output: 4\n");
        System.out.print("Actual Output:   ");
        printList(merged2);
        System.out.println();

        // --- Complexity Analysis ---
        System.out.println("===============================================================");
        System.out.println("COMPLEXITY ANALYSIS & ARRAY COMPARISON");
        System.out.println("===============================================================");
        System.out.println("1. In-place Relinking Approach:");
        System.out.println("   - Time Complexity:  O(m + n) - Single pass merging both lists.");
        System.out.println("   - Space Complexity: O(1) auxiliary space - Only 1 dummy node used.");
        System.out.println("   - Node Creation:    0 new nodes created; existing pointers relinked.");
        System.out.println("2. Comparison with Copying to Array & Sorting:");
        System.out.println("   - Time: Array approach requires O((m + n) log(m + n)) to sort,");
        System.out.println("           which is slower than our linear O(m + n) merge.");
        System.out.println("   - Space: Array approach requires O(m + n) auxiliary memory for the array.");
        System.out.println("   - Constraints: Recreating the linked list would create m + n new nodes,");
        System.out.println("                  which directly violates the 'No new nodes' constraint.");
        System.out.println("===============================================================");
    }
}
