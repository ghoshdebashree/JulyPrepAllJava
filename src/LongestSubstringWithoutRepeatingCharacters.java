import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String str = "abcabcbb";
        System.out.println(checkForString(str));
        System.out.println("Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(str)); // Output: 3

    }

    private static String checkForString(String str) {
        int maxString = 0;
        int left = 0;
        int maxLength = 0;
        HashSet<Character> hashTable = new HashSet<Character>();
        for(int right = 0; right < str.length(); right++){
            char currentChar = str.charAt(right);
            while(hashTable.contains(currentChar)){
                hashTable.remove(str.charAt(left));
                left++;
            }
            hashTable.add(currentChar);
            if(right - left + 1 > maxLength){
                maxLength = right - left + 1;
                maxString = left;
            }
        }
        return str.substring(maxString, maxString + maxLength);
    }

    private static int lengthOfLongestSubstring(String str) {
        int maxLength = 0;
        int left = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(int right = 0; right < str.length(); right++){
            char currentChar = str.charAt(right);
            while(hashSet.contains(currentChar)){
                hashSet.remove(str.charAt(left));
                left++;
            }
            hashSet.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
