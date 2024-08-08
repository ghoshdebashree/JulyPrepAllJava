public class TestingStringReverse {
    public static void main(String[] args) {
        String  str ="  the   sky is blue  ";
        System.out.println(reverseWords(str));
    }
    private static String reverseWords(String str) {
        String[] words  = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        //int spacecount = 0;

        for(int i=words.length - 1; i >=0; i--){
            sb.append(words[i]);

            sb.append(" ");

        }

        return sb.toString();
    }
}
