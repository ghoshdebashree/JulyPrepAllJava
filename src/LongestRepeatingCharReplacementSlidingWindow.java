import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharReplacementSlidingWindow {
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 1;
        System.out.println("The length of the longest substring is: " + longestSubstring(s, k)); // Output: 4
    }

    private static int longestSubstring(String s, int k) {
        int start = 0;
        int maxLength = 0;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(endChar));
            int currentWindowSize = end - start + 1;
            int charTochange = currentWindowSize - maxFreq;
            if(charTochange > k){
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;

    }
}
