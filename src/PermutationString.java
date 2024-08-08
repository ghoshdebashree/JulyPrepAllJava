import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationString {
    public static void main(String[] args){
        String str = "deb";
        char[] chars = str.toCharArray();
        List<Character> listChar = new ArrayList<>();
        for(Character c : chars){
            listChar.add(c);
        }
        List<String> result = new ArrayList<>();
        permutationList(listChar, 0 , result);
        for(String l : result){
            System.out.println(l);
        }

    }

    private static void permutationList(List<Character> listChar, int left, List<String> result) {
        if(left == listChar.size() - 1){
            StringBuilder sb = new StringBuilder();
            for(char c : listChar){
                sb.append(c);
            }
            result.add(sb.toString());
        }
        for(int i = left; i < listChar.size(); i++){
            Collections.swap(listChar, left, i);
            permutationList(listChar, left +  1, result);
            Collections.swap(listChar, left, i);
        }
    }
}
