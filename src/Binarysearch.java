import java.util.Arrays;

public class Binarysearch {
    public  static void main(String[] args){
        int[] arr = {56, 22, 3, 11, 74, 20, 488};
        int ele = 748;
        if(searchData(arr, ele)){
            System.out.println("present");
        }
        else{
            System.out.println("Not present");
        }
    }

    private static boolean searchData(int[] arr, int ele) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            if(ele == arr[left] || ele == arr[right])
                return true;
            if(ele > arr[left]){
                right--;
            }
            else if(ele < arr[right]){
                left++;
            }
        }
        return false;
    }
}
