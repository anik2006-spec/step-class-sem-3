/**
 * Problem 4: The Warehouse Inventory Balancer
 * CodInClub (BridgeLabz)
 *
 * Task:
 * - Accept two integer arrays of equal length representing item quantities in Section A and Section B.
 * - Compute the total quantity held in each section.
 * - Compare the two totals and print whether the sections are "Balanced" or "Not Balanced".
 * - Scan both arrays to find the single highest quantity value and report which section and index it was found at.
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory between Section A and Section B.
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

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}
