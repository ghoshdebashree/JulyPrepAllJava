import java.util.Arrays;
import java.util.PriorityQueue;

public class MinHeapSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};  // Example array
        int k = 3;  // Window size

        int[] minInWindows = minSlidingWindow(nums, k);

        System.out.println("Min in each sliding window: " + Arrays.toString(minInWindows));
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1]; // Array to store the result

        // Min-heap to store elements in the current window
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Initial window
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        result[0] = minHeap.peek(); // Min of the first window

        // Sliding the window
        for (int i = k; i < n; i++) {
            minHeap.remove(nums[i - k]); // Remove the element going out of the window
            minHeap.add(nums[i]); // Add the new element coming into the window
            result[i - k + 1] = minHeap.peek(); // Current min in the window
        }

        return result;
    }
}
