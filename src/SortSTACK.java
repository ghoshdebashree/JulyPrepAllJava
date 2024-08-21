import java.util.Stack;

public class SortSTACK {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(10);
        stack.push(8);
        sortStack(stack);
        System.out.println(stack);
    }

    private static Stack sortStack(Stack<Integer> stack) {
        Stack<Integer> auxillaryStack = new Stack<>();
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while(!auxillaryStack.isEmpty() && auxillaryStack.peek() < temp){
                stack.push(auxillaryStack.pop());
            }
            auxillaryStack.push(temp);
        }
        while(!auxillaryStack.isEmpty()){
            stack.push(auxillaryStack.pop());
        }
        return stack;
    }
}
