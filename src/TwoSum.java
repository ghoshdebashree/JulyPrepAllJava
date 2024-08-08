import java.util.Arrays;

public class TwoSum{
    public static void main(String[] args){
        int[] arr = {23, 45, 18, 20, 27};
        int sum = 30;
        if(checkTwoSum(arr, sum)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    private static boolean checkTwoSum(int[] arr, int sum) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int newSum = arr[left] + arr[right];
            if(newSum == sum){
                return true;
            }
            else if(newSum < sum){
                left ++;
            }
            else{
                right --;
            }
        }
       return false;
    }
}
