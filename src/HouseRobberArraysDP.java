public class HouseRobberArraysDP {
    public static void main(String[] args){
        int[] arr = {2, 7, -9, 3, 1};
        System.out.println(maxRobbed(arr));
    }

    private static int maxRobbed(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr[0] == 0){
            return arr[0];
        }
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(arr[i] + dp [i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
