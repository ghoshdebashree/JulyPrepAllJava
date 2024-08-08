import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTestingString {
    public static void main(String[] args){
        String str = "debashree";
        checkCharacters(str);

    }

    private static void checkCharacters(String str) {
        char[] chars = str.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        for (char c : chars) {
//
//            map.put(c, map.getOrDefault(c, 0) +1);
//        }
        for (char c : chars) {
            if(map.containsKey(chars)) {
                map.put(c, map.get(c) + 1);
            }
            else{
                map.put(c, 1);
            }
        }
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }
}
