import java.util.Collections;
import java.util.PriorityQueue;

public class NthMax {
    public static void main(String[] args){
        int[] arr = {675, 827, 334, 81, 900, 1000};
        int n = 3;
        System.out.println(findMax(arr, n));
        System.out.println(findMin(arr, n));
    }
    public static int findMin(int[] arr, int n){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            maxHeap.add(arr[i]);
        }
        for(int i = n; i< arr.length; i++){
            if(arr[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }

    private static int findMax(int[] arr, int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        if(arr == null || arr.length < n){
            throw new IllegalArgumentException("Not valid");
        }
        for(int i = 0; i< n; i++){
            minHeap.add(arr[i]);
        }
        for(int i = n; i <arr.length; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek();
    }
}
