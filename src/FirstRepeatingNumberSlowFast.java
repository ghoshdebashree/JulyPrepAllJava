public class FirstRepeatingNumberSlowFast {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,3};
        System.out.println(checkRepeat(arr));
    }

    private static int checkRepeat(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];
         do{
            slow = arr[slow];
            fast = arr[arr[fast]];

        }while(slow != fast);
        int entry = arr[0];
        while(entry != slow){
            entry = arr[entry];
            slow = arr[slow];
        }
        return entry;
    }
}
