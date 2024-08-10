import java.util.HashSet;
import java.util.Set;

public class DNARepeatedStringSlidingWindow {
    public static void main(String[] args){
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(checkRepition(str));

    }

    private static String checkRepition(String str) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for(int i = 0; i <= str.length() - 10; i++){
            String sequence = str.substring(i, i + 10);
            if(seen.contains(sequence)){
                repeated.add(sequence);
            }
            else{
                seen.add(sequence);
            }
        }
        return repeated.toString();
    }
}
