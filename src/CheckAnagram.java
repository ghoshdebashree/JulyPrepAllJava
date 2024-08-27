import java.util.Arrays;

public class CheckAnagram {
    public static void main(String[] args){
        String str1 = "Cat";
        String str2 = "Tac";
        if(checkCondition(str1, str2)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }

    private static boolean checkCondition(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }
//        char[] ch1 = str1.toCharArray();
//        char[] ch2 = str2.toCharArray();
//        Arrays.sort(ch1);
//        Arrays.sort(ch2);
//        return Arrays.equals(ch1, ch2);
        int[] allCount = new int[52];
        for(int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
                allCount[str1.charAt(i) - 'a']++;
            }
            else if (str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z') {
                allCount[str1.charAt(i) - 'A' + 26]++;
            }
            if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
                allCount[str2.charAt(i) - 'a']--;
            }
            else if (str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z') {
                allCount[str2.charAt(i) - 'A' + 26]--;
            }
        }
            for(int c : allCount) {
                if (c != 0) {
                    return false;
                }
            }
            return true;
        }




//        int[] charCount = new int[26];
//        for(int i = 0; i < str1.length(); i++){
//            charCount[str1.charAt(i) - 'a']++;
//            charCount[str2.charAt(i) - 'a']--;
//        }
//        for(int c : charCount){
//            if(c != 0){
//                return false;
//            }
//        }
//        return true;
//    }
}
