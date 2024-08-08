import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8 {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(3,5,1,8,0,9);

        // 1. FIND THE SQUARES OF ALL THE ELEMENT IN THE LIST AND SUM ALL THE SQUARED

        int solution1 = list.stream()
                .map(x -> x * x)
                .reduce((x, y) -> x+ y).orElse(0);
        int solution2 = list.stream()
                        .map(x ->x * x)
                                .mapToInt(Integer::intValue)
                                        .sum();

        System.out.println(solution2);

        // 2. SORT THE LIST OF STRINGS IN A LIST

        List<String> strList = Arrays.asList("debashree","shree","hello how are you?","hey");
        List<String> sortList = strList.stream()
                .sorted((x,y) -> Integer.compare(x.length(), y.length()))
                .collect(Collectors.toList());
        sortList.forEach(System.out::println);

        // 3.FIND THE FIRST NON REPEATED CHARACTER IN A STRING

        String str = "ebashree";
        Character ch = str.chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap :: new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry :: getKey)
                .findFirst()
                .orElse(null);
        System.out.println(ch);

        // 4. FIND THE OCCURENCE OF EACH CHARACTER IN A STRING

        Map<Character, Long> countOcc = str.chars()
                .mapToObj(c ->(char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countOcc);

        // 5. CHECK STRING PALINDROME

        String s = "madssasam";
        boolean isPalindrome = IntStream.range(0, s.length())
                .allMatch(i -> s.charAt(i) == s.charAt(s.length() - i - 1));
        System.out.println(isPalindrome);

        //6. SORT LIST OF STRINGS BY LENGTH

        List<String> liststr = Arrays.asList("gfgfg","cfcfcjc","dtyddd", "hj","vvjvgvvv");
        Map<Integer, List<String>> sorted = liststr.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(sorted);

        // 7. FIND MAXIMUM LENGTH STRING
        String maxLength = liststr.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);

        System.out.println(maxLength);

        List<String> sortedLen = liststr.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
        sortedLen.forEach(System.out::println);

        // 8. FIND THE MAX VALUE IN A LIST

        int maxValue = list.stream()
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println(maxValue);


    }
}
