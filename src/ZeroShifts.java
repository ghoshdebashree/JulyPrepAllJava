import java.util.Stack;

public class ZeroShifts {
    public static void main(String[] args) {
        int[] arr = {0, 9, 0, 11, 0, 3};
        int[] res = checkZeros(arr);
        for (int a : res) {
            System.out.println(a);
        }
        int[] result = shiftZerosToLeft(arr);
        for (int a : result) {
            System.out.println(a);
        }

        String str = "Hello how are you ?";
        System.out.println(reverseString(str));
        String newStr = "madam";
        if (checkPalindromeString(newStr)) {
            System.out.println("Palindrome");
        } else if (!checkPalindromeString(str)) {
            System.out.println("Not Palindrome");
        }

    }

    private static boolean checkPalindromeString(String newStr) {
        int left = 0;
        int right = newStr.length() - 1;
        if (newStr.length() % 2 == 0) return false;
        while (left < right) {
            if (newStr.charAt(left) != newStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String reverseString(String str) {
        String[] words = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
        }
        return sb.toString();

    }

    private static int[] checkZeros(int[] arr) {
        int left = 0;
        int right = 0;
        int n = arr.length;
        while (right < n) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
        return arr;
    }

    public static int[] shiftZerosToLeft(int[] nums) {
        int n = nums.length;
        int lastZeroFoundAt = 0; // Pointer to track the position of the next zero

        // Traverse the array
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Swap the current zero with the element at lastZeroFoundAt
                swap(nums, i, lastZeroFoundAt);
                lastZeroFoundAt++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}