import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {
    public static void main(String[] args){
        RestoreIPAddress rip = new RestoreIPAddress();
        String s = "25525511135";
        List<String> output = rip.checkTheValue(s);
        for(String o : output){
            System.out.println(o);
        }
    }

    private  List<String> checkTheValue(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if(n < 4 || n > 12){
            return result;
        }
        for(int i = 1;  i < 4 && i < n - 2 ; i++){
            for(int j = i + 1; j < i + 4 && j < n -1; j++){
                for(int k = j + 1; k < j + 4 && k < n ; k++){
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i , j);
                    String s3 = s.substring(j , k);
                    String s4 = s.substring(k);
                    if(isValidCheck(s1) && isValidCheck(s2) && isValidCheck(s3) && isValidCheck(s4)){
                        result.add(s1+ "." +s2+ "."+s3+ "." +s4);
                    }
                }
            }
        }
    return result;
    }

    private static boolean isValidCheck(String segment) {
        if(segment.length() > 1 && segment.startsWith("0")){
            return false;
        }
        int value = Integer.parseInt(segment);
        return value >=0 && value <= 255;
    }
}
