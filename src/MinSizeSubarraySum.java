public class MinSizeSubarraySum {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(s, nums);
        System.out.println("Minimum size subarray length: " + result); // Output: 2
    }

    private static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= s){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 :minLen;

    }
}
