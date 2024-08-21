import java.util.Stack;

public class EvaluatePostfixSTACK {
    public static void main(String[] args) {
        String expression = "231*+9-"; // Example postfix expression

        int result = evaluatePostfix(expression);
        System.out.println("Result of postfix evaluation: " + result);
    }

    private static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(Character.isDigit(ch)){
                stack.push(ch - '0');
            }
            else{
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result;
                switch(ch){
                    case '*' :
                        result = operand1 * operand2;
                        break;
                    case '/' :
                        result = operand1 / operand2;
                        break;
                    case '+' :
                        result = operand1 + operand2;
                        break;
                    case '-' :
                        result = operand1 - operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator" +ch);

                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
