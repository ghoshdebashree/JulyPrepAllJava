import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args){
        int[] arr = {10, 33, 45, 27, 20, 30};
        int sum  = 60;
       if(checkThreeSum(arr, sum)){
           System.out.println("The sum is present");
       }
       else{
           System.out.println("Not");
       }
    }

    private static boolean checkThreeSum(int[] arr, int sum) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 2; i++){
            int left = i + 1;
            int right = arr.length - 1;
            while(left < right){
                int currSum = arr[i] + arr[left] + arr[right];
                if(currSum == sum){
                    return true;
                }
                else if(currSum <= sum){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return false;
    }
}
