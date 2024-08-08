public class Fibonacci {
    public static void main(String[] args){
        int[] arr = {0, 1, 1, 2, 3, 5};
        System.out.println(checkFib(arr));
        int x = 23;
        int  y = 99;
        x = x ^ y;
        y  = x ^ y;
        x = x ^ y;
        System.out.println(x+ "x " + y);
        String str = "hello how are you?";
        reverse(str);


    }
    public static void reverse(String str) {
        char[] rev = new char[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            rev[i] = str.charAt(str.length() - 1 - i);
        }
        for (int i = 0; i < rev.length; i++) {
            System.out.print(rev[i]);

        }
    }

    private static int checkFib(int[] arr) {
        int n = arr.length;
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i =3 ; i <= n ; i++){
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
}
