import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeapSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};  // Example array
        int k = 3;  // Window size

        int[] maxInWindows = maxSlidingWindow(nums, k);

        System.out.println("Maximums in each sliding window: " + Arrays.toString(maxInWindows));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            maxHeap.add(nums[i]);
        }
        result[0] = maxHeap.peek();
        for(int i = k; i < n ; i ++){
            maxHeap.remove(nums[i - k]);
            maxHeap.add(nums[i]);
            result[i - k + 1] = maxHeap.peek();
        }
        return result;
    }
}
