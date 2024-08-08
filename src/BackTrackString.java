public class BackTrackString {
    public static void main(String[] args){
        String str = "011011?0??1101?";
        char[] ch = str.toCharArray();
        checkCombination(ch, 0);

    }

    private static void checkCombination(char[] ch, int index) {
        if(index == ch.length){
            System.out.println(ch);
            return ;
        }
        if(ch[index] == '?'){
            ch[index] = '0';
            checkCombination(ch, index + 1);
            ch[index] = '1';
            checkCombination(ch, index + 1);
            ch[index] = '?';
        }
        else{
            checkCombination(ch, index + 1);
        }

    }
}
