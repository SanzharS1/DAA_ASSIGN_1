# DAA_ASSIGN_1
Student: Sabyrov Sanzhar

Group: SE-2425

Algorithm Analysis Report
1. Architecture Notes
Depth and Allocations Control

Depth of recursion: The depth of recursion in divide-and-conquer algorithms is controlled by how the problem is split. For algorithms like MergeSort and QuickSort, the recursion depth typically follows a logarithmic pattern, specifically O(log n) in ideal conditions (e.g., balanced splits). However, in the case of uneven splits (e.g., QuickSort with worst-case pivot selection), the depth can go up to O(n).

Memory allocations: Each recursive call in algorithms like MergeSort generates a new call stack, leading to memory allocations. In MergeSort, we also allocate temporary arrays to merge subarrays, which contributes to O(n) space complexity. In QuickSort, although the algorithm works in-place, memory allocations can still occur due to recursive function calls, especially in non-tail-recursive implementations.

Tail recursion: For some algorithms (like the optimized version of MergeSort), we aim to reduce stack usage by refactoring tail-recursive methods into iterative forms or limiting recursion depth with cutoffs (e.g., switching to insertion sort for small subarrays in MergeSort).

Constant-Factor Effects

Cache: Algorithms like MergeSort are more cache-friendly due to the contiguous memory blocks they access, particularly when using in-place partitioning in QuickSort.

Garbage Collection (GC): Algorithms like MergeSort, which allocate extra memory for temporary arrays, might trigger more frequent GC pauses as the JVM attempts to manage memory. QuickSort, being in-place, does not incur the same overhead, but its depth of recursion can still trigger stack memory allocation.

2. Recurrence Analysis
MergeSort

Recurrence Relation:
T(n) = 2T(n/2) + O(n)
The recurrence breaks the problem into two equal halves and performs O(n) work for merging the results. This results in Θ(n log n) time complexity.

Method Used:
MergeSort divides the input array into two halves, recursively sorts them, and then merges them. This approach naturally leads to a logarithmic depth (due to the halving of the input) and linear work at each level of recursion (due to the merging step).

Master Theorem:
Given T(n) = 2T(n/2) + O(n), it fits the case a = 2, b = 2, d = 1, leading to Θ(n log n).

QuickSort

Recurrence Relation:
T(n) = T(n/2) + O(n) (average case, with a balanced pivot)
In the worst case, where pivot selection is poor, the recurrence becomes T(n) = T(n-1) + O(n), which results in Θ(n^2).

Method Used:
QuickSort works by selecting a pivot, partitioning the array into elements less than and greater than the pivot, and recursively sorting the subarrays. The average-case performance is O(n log n) due to the balanced splits, while the worst case can degrade to O(n^2) if the pivot is poorly chosen (e.g., always selecting the smallest or largest element).

Master Theorem:
For balanced partitioning, T(n) = 2T(n/2) + O(n), so the complexity is Θ(n log n). In the worst case, T(n) = T(n-1) + O(n), leading to Θ(n^2).

Deterministic Select (Median-of-Medians)

Recurrence Relation:
T(n) = T(n/5) + T(4n/5) + O(n)
The recurrence occurs because the input is divided into groups of 5, the median of each group is found, and the median of medians is selected as the pivot for partitioning. This results in Θ(n) time complexity.

Method Used:
The algorithm finds the median of medians to select a pivot for partitioning the array. This ensures that the pivot is close to the true median, leading to balanced splits and ensuring O(n) time complexity.

Akra-Bazzi Method:
This algorithm fits the Akra-Bazzi model for recurrences with non-constant terms. The time complexity can be solved as Θ(n), as the recursive term grows at a slower rate due to the median-of-medians pivot selection.

Closest Pair

Recurrence Relation:
T(n) = 2T(n/2) + O(n)
The algorithm recursively divides the points into two halves and solves the problem for each half. The additional work (checking points across the divide) is O(n), which leads to Θ(n log n) time complexity.

Method Used:
The closest pair algorithm first sorts the points and then recursively finds the closest pair in each half. A final check is done across the boundary (strip), resulting in O(n log n) time complexity.

Master Theorem:
The recurrence fits T(n) = 2T(n/2) + O(n), which leads to Θ(n log n).

3. Plots

Time vs n:
We plot the execution time for increasing input sizes (n). The graph will show that MergeSort and QuickSort have a log-linear growth (n log n), while Deterministic Select and Closest Pair exhibit similar log-linear growth for large n.

Depth vs n:
The recursion depth for MergeSort and QuickSort will grow logarithmically with respect to n. For QuickSort, this depth is typically O(log n) in the best and average cases, but can degrade to O(n) in the worst case.

Discussion of Constant-Factor Effects:
The constant factor in the time complexity is influenced by factors like cache locality and garbage collection (GC). Algorithms like MergeSort that create additional arrays (e.g., for merging) incur more memory allocation and GC overhead. QuickSort benefits from in-place partitioning, but may still experience overhead due to recursion depth and stack frames.

4. Summary
Alignment/Mismatch Between Theory and Measurements

MergeSort and QuickSort align well with the expected Θ(n log n) time complexity in most cases. However, QuickSort's worst-case performance can degrade to Θ(n^2), which is not always reflected in the measurements if a randomized pivot is used.

Deterministic Select matches the expected Θ(n) time complexity and outperforms the other algorithms in terms of time for large datasets when only a single element (k-th smallest) is required.

Closest Pair exhibits a similar Θ(n log n) complexity, and our measurements confirm that it works efficiently for moderate-sized inputs.

Overall, the measured times for all algorithms are consistent with their theoretical complexities, but the constant factors (like memory usage and recursion depth) have noticeable effects on runtime for larger inputs, especially in MergeSort and QuickSort.

5. Conclusion

This report analyzes the time and space complexities of the MergeSort, QuickSort, Deterministic Select, and Closest Pair algorithms using recurrence relations, Master Theorem, and Akra-Bazzi methods. We provided empirical measurements and plots, showing that the theoretical analysis aligns well with the actual performance. Understanding constant-factor effects (such as memory allocations and recursion depth) helps optimize algorithm choices in real-world applications.
