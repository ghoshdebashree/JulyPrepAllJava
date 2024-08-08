public class DutchFlag {
    public static void main(String[] args){
        int[] arr = {1,0,1,0,2,2, 1,0};
        int[] result = rearrange(arr);
        for(int r : result){
            System.out.println(r);
        }
    }

    private static int[] rearrange(int[] arr) {
        int forZeros = 0;
        int current = 0;
        int forTwos = arr.length -1;
        while(current <= forTwos){
                if(arr[current] == 0){
                    swapData(arr, forZeros, current);
                    forZeros++;
                    current++;
                }
                else if(arr[current] == 1){
                     current++;
                }
                else {
                    swapData(arr, current, forTwos);
                    forTwos--;
                }

            }

        return arr;
}

    private static void swapData(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
