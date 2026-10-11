# Step Class Semester 3 - Week 1 Assignment

Solutions to **CodInClub (BridgeLabz) Week 1 Assignment — 5 Problems**.

---

## Table of Contents
1. [Problem 1: The Exam Hall Seat Duplication Checker](#problem-1-the-exam-hall-seat-duplication-checker)
2. [Problem 2: The Typing Speed Test Accuracy Checker](#problem-2-the-typing-speed-test-accuracy-checker)
3. [Problem 3: The Traffic Signal Streak Analyzer](#problem-3-the-traffic-signal-streak-analyzer)
4. [Problem 4: The Warehouse Inventory Balancer](#problem-4-the-warehouse-inventory-balancer)
5. [Problem 5: The Movie Review Word Length Profiler](#problem-5-the-movie-review-word-length-profiler)
6. [Category A · Problem 5: Cancelling the k-th Last Order](#category-a--coding-assignment--problem-5-cancelling-the-k-th-last-order)
7. [Category A · Problem 6: Campus Portal Browser History](#category-a--coding-assignment--problem-6-campus-portal-browser-history)
8. [Category A · Railway Counter Ticket Merge](#category-a--coding-assignment--railway-counter-ticket-merge)
9. [Compilation & Execution](#compilation--execution)

---

## Problem 1: The Exam Hall Seat Duplication Checker

### Scenario
The Examination Cell manages seat allocation across a large exam hall for hundreds of students. Before an exam begins, invigilators must confirm that no seat number has been assigned to two different students by mistake.

### Task
- Accept an array of seat numbers (integers) assigned to students in a hall.
- Compare every seat number against every other seat number to check for duplicates (**do not use any Collections class — arrays and loops only**).
- If one or more duplicates are found, print the duplicated seat number(s).
- If no duplicates exist, print a clear confirmation message.

### Method Signature
```java
void checkDuplicateSeats(int[] seatNumbers)
```

### Sample Input & Output
| Input | Output |
| :--- | :--- |
| `{101, 102, 103, 102, 105}` | `Duplicate Seat Number Found: 102` |
| `{101, 102, 103, 104, 105}` | `No Duplicate Seats Found` |

---

## Problem 2: The Typing Speed Test Accuracy Checker

### Scenario
An online typing-practice website shows users a fixed passage and asks them to retype it as quickly and accurately as they can. Once the user submits their attempt, the system compares it character by character against the original passage and reports accuracy percentage along with the first mismatch position.

### Task
- Accept two strings of equal length: the original passage and the user's typed text.
- Compare the two strings character by character using their positions.
- Count how many characters match at the same position.
- Calculate the accuracy percentage: `(matched characters ÷ total characters) × 100`.
- Print the accuracy percentage and the position of the first mismatch (or a message confirming there were no mismatches).

### Method Signature
```java
void checkTypingAccuracy(String original, String typed)
```

### Sample Input & Output
| Input | Output |
| :--- | :--- |
| `original="hello world", typed="hello worlt"` | `Matched: 10/11 \| Accuracy: 90.91% \| First Mismatch at position 11 ('d' vs 't')` |
| `original="coding", typed="coding"` | `Matched: 6/6 \| Accuracy: 100.00% \| No Mismatches` |

---

## Problem 3: The Traffic Signal Streak Analyzer

### Scenario
The city traffic control department logs the color shown by a signal every minute using single letters — `'R'` for red, `'Y'` for yellow, `'G'` for green. Engineers suspect a malfunctioning signal might be getting "stuck" on one color for unusually long stretches.

### Task
- Accept a string representing a sequence of signal readings (e.g., `"RRGGGYRR"`).
- Scan through the string and track the length of each streak of consecutive identical characters.
- Keep a running record of the longest streak found so far — both its color and its length.
- Print the color and length of the longest streak.

### Method Signature
```java
void findLongestStreak(String signalLog)
```

### Sample Input & Output
| Input | Output |
| :--- | :--- |
| `"RRGGGYRR"` | `Longest Streak: 'G' repeated 3 times` |
| `"RRRRYYGG"` | `Longest Streak: 'R' repeated 4 times` |

---

## Problem 4: The Warehouse Inventory Balancer

### Scenario
A retail warehouse stores product categories across two storage sections, Section A and Section B. The inventory team wants to confirm both sections hold matching total quantities and identify the single highest-quantity item across the whole warehouse.

### Task
- Accept two integer arrays of equal length representing item quantities in Section A and Section B.
- Compute the total quantity held in each section.
- Compare the two totals and print whether the sections are `"Balanced"` or `"Not Balanced"`.
- Scan both arrays to find the single highest quantity value and report which section and index it was found at.

### Method Signature
```java
void analyzeInventory(int[] sectionA, int[] sectionB)
```

### Sample Input & Output
| Input | Output |
| :--- | :--- |
| `sectionA={20, 15, 30}, sectionB={25, 10, 30}` | `Section A Total: 65 \| Section B Total: 65 \| Status: Balanced \| Highest Quantity: 30 (Section A, Item 3)` |

---

## Problem 5: The Movie Review Word Length Profiler

### Scenario
A movie-review platform's moderation tool scans newly submitted reviews and profiles the length of the words used in them to detect spam or bot-generated submissions.

### Task
- Accept a movie review as a single string input.
- Split the review into individual words.
- Classify each word as Short (1–4 letters), Medium (5–8 letters), or Long (9+ letters).
- Count how many words fall into each category.
- Print the final counts for Short, Medium, and Long words.

### Method Signature
```java
void classifyWordLengths(String review)
```

### Sample Input & Output
| Input | Output |
| :--- | :--- |
| `"This movie was absolutely fantastic and thrilling"` | `Short: 3 \| Medium: 1 \| Long: 3` |

---

## Compilation & Execution

### Run all solutions in one runner:
```bash
javac Week1Assignment.java
java Week1Assignment
```

### Or run any individual problem class:
```bash
# Problem 1
javac ExamHallSeatDuplicationChecker.java
java ExamHallSeatDuplicationChecker

# Problem 2
javac TypingSpeedTestAccuracyChecker.java
java TypingSpeedTestAccuracyChecker

# Problem 3
javac TrafficSignalStreakAnalyzer.java
java TrafficSignalStreakAnalyzer

# Problem 4
javac WarehouseInventoryBalancer.java
java WarehouseInventoryBalancer

# Problem 5
javac MovieReviewWordLengthProfiler.java
java MovieReviewWordLengthProfiler
```

---

## Category A · Coding Assignment — Problem 5: Cancelling the k-th Last Order

### Scenario
A restaurant keeps today's orders in a singly linked list, newest at the end. A customer cancels the order that is $k$-th from the end.

### Task
- Implement `Node removeKthFromEnd(Node head, int k)` that removes that node in a single pass and returns the head.
- Use your own node class (e.g., `class Node { int data; Node next; }`).
- Do not use `java.util.LinkedList` or other collections for the list itself.

### Method Signature
```java
public static Node removeKthFromEnd(Node head, int k)
```

### Constraints
- $1 \le k \le \text{length of list} \le 10^4$
- Single pass only

### Sample Input & Output
| Sample | Input Orders & $k$ | Expected Output |
| :--- | :--- | :--- |
| **Sample 1** | `orders = 10 -> 20 -> 30 -> 40 -> 50, k = 2` | `10 -> 20 -> 30 -> 50` |
| **Sample 2** | `orders = 10 -> 20 -> 30 -> 40 -> 50, k = 5` | `20 -> 30 -> 40 -> 50` |

### Complexity Analysis
- **Time Complexity:** $O(N)$ — Single pass traversal where $N$ is the number of nodes in the linked list.
- **Space Complexity:** $O(1)$ — In-place pointer manipulation with constant auxiliary memory.

### Head Removal Explanation (Without Special Case)
A dummy node (`dummy.next = head`) is introduced before the head.
The `lead` pointer starts at `dummy` and advances $k + 1$ steps ahead of `trailing` (also starting at `dummy`).
When $k = \text{length}$ (removing the head):
1. `lead` advances $\text{length} + 1$ steps, falling off the end (`lead == null`).
2. The `while (lead != null)` loop doesn't execute, so `trailing` stays at `dummy`.
3. `trailing.next = trailing.next.next` seamlessly bypasses the head (`dummy.next = dummy.next.next`).
4. Returning `dummy.next` yields the new head without any special branch (`if (k == length)`).

### Compilation & Execution
```bash
javac CancellingKthLastOrder.java
java CancellingKthLastOrder
```

---

## Category A · Coding Assignment — Problem 6: Campus Portal Browser History

### Scenario
A campus portal browser opens on a home page and supports three actions:
1. `visit(url)`: visits a new page (which clears all forward history)
2. `back(steps)`: goes back up to $x$ pages (stops at home page)
3. `forward(steps)`: goes forward up to $x$ pages (stops at latest page)

### Task
- Design a `BrowserHistory` class backed by your own doubly linked list.
- Use your own node class (`class BrowserNode { String url; BrowserNode prev, next; }`).
- Do not use `java.util.LinkedList` or other collections for the list itself.

### Constraints
- $1 \le \text{number of actions} \le 5000$
- $1 \le \text{steps} \le 100$
- `visit` is $\mathcal{O}(1)$; `back` and `forward` are $\mathcal{O}(\text{steps})$.

### Sample Trace & Output
- `home = "srm.edu"`
- Actions: `visit a.com`, `visit b.com`, `visit c.com`, `back 1`, `back 1`, `forward 1`, `visit d.com`, `forward 2`, `back 2`, `back 7`
- **Expected Output:** `b.com, a.com, b.com, d.com, a.com, srm.edu`

### Complexity Analysis
- `visit(url)`: $\mathcal{O}(1)$ time, $\mathcal{O}(1)$ space.
- `back(steps)`: $\mathcal{O}(\min(\text{steps}, \text{distance to home}))$ time.
- `forward(steps)`: $\mathcal{O}(\min(\text{steps}, \text{distance to latest}))$ time.
- Space Complexity: $\mathcal{O}(N)$ where $N$ is the number of active history pages.

### Discarding Forward History Explanation
When `visit(url)` is invoked:
- `current.next` is pointed to the newly created node.
- The reference to the existing forward node chain is severed.
- In Java, unreferenced forward nodes become unreachable and are automatically reclaimed by the Garbage Collector (GC).

### Compilation & Execution
```bash
javac BrowserHistory.java
java BrowserHistory
```

---

## Category A · Coding Assignment — Railway Counter Ticket Merge

### Scenario
Two railway counters each produce a singly linked list of ticket numbers in ascending order. At closing time, both lists must be combined into one ascending list.

### Task
- Implement `TicketNode mergeSorted(TicketNode a, TicketNode b)` that merges the lists by relinking existing nodes in ascending order and returns the new head.
- Duplicates are preserved.
- Use your own node class (`class TicketNode { int data; TicketNode next; }`).
- Do not use `java.util.LinkedList` or other collections for the list itself.

### Constraints
- $0 \le \text{length of each list} \le 10^5$
- **No new nodes may be created** (a single dummy node is allowed).

### Sample Input & Output
| Sample | Input Lists | Expected Output |
| :--- | :--- | :--- |
| **Sample 1** | `a = 3 -> 8 -> 15`, `b = 5 -> 8 -> 12 -> 20` | `3 -> 5 -> 8 -> 8 -> 12 -> 15 -> 20` |
| **Sample 2** | `a = (empty)`, `b = 4` | `4` |

### Complexity Analysis & Comparison with Array Sorting
1. **In-place Merge (Implemented):**
   - **Time Complexity:** $\mathcal{O}(m + n)$ — Each comparison advances a list pointer; linear and optimal.
   - **Space Complexity:** $\mathcal{O}(1)$ auxiliary space — Only 1 dummy node is used; nodes are relinked in-place.
   - **Node Creation:** $0$ new nodes created, respecting the strict problem constraint.
2. **Comparison with Array Copy & Sort:**
   - **Time:** Copying to an array and sorting takes $\mathcal{O}((m + n) \log(m + n))$ time, which is strictly slower than $\mathcal{O}(m + n)$.
   - **Space:** Requires $\mathcal{O}(m + n)$ extra heap memory for the array.
   - **Constraint Violation:** Recreating a linked list from the sorted array requires instantiating $m + n$ new nodes, violating the constraint: *"No new nodes may be created"*.

### Compilation & Execution
```bash
javac RailwayTicketMerger.java
java RailwayTicketMerger
```


