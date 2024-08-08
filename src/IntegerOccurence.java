import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerOccurence {
    public static void main(String[] args){
        int number = 1234524363;
      checkOccurance(number);
    }

    private static void checkOccurance(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        while(number > 0){
            int digit = number % 10;
            map.put(digit, map.getOrDefault(digit, 0) + 1);
            number = number / 10;
        }
        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+ " : "+m.getValue());
        }
    }
}
