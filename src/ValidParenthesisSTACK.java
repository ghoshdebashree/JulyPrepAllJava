import java.util.Stack;

public class ValidParenthesisSTACK {
    public static void main(String[] args){
        String str = "[[[]]]";
        if(checkValid(str)){
            System.out.println("Valid parenthesis");
        }
        else{
            System.out.println("Not valid");
        }
    }

    private static boolean checkValid(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                char top = stack.pop();
                if((ch == ')' && !(top == '(')) || (ch == '}' && !(top == '{')) || (ch == ']' && !(top == '[')))
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
