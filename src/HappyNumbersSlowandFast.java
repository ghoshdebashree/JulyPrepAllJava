public class HappyNumbersSlowandFast {
    public static void main(String[] args){
        int number = 66;
        boolean isHappy = checkHappy(number);
        if(isHappy) System.out.println("Happy");
        else System.out.println("Not Happy");
    }

    private static boolean checkHappy(int number) {
        int slow = number;
        int fast = generateNext(number);
        while(fast != 1 && slow != fast){
            slow = generateNext(slow);
            fast = generateNext(generateNext(fast));
        }
        return fast == 1;

    }
    public static int generateNext(int number){
        int totalSum = 0;
        while(number > 0){
            int digit = number % 10;
            totalSum += digit * digit;
            number = number / 10;
        }
        return totalSum;
    }
}
