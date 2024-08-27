import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args){
     String str = "DC";
     System.out.println(calculateValues(str));

    }

    private static int calculateValues(String str) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;
        int currentValue;
        for(int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            currentValue = romanMap.get(c);

            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            prevValue = currentValue;
        }
        return total;
    }
}
