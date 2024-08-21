import java.util.Stack;

public class MaxMinSTACK {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    private Stack<Integer> maxStack;
    MaxMinSTACK(){
        mainStack = new Stack<>();
        minStack = new Stack<>();
        maxStack = new Stack<>();
    }
    public static void main(String[] args) {
        MaxMinSTACK stack = new MaxMinSTACK();
        stack.push(3);
        stack.push(5);
        System.out.println("Current Min: " + stack.getMin()); // Output: 3
        System.out.println("Current Max: " + stack.getMax()); // Output: 5

        stack.push(2);
        stack.push(1);
        System.out.println("Current Min: " + stack.getMin()); // Output: 1
        System.out.println("Current Max: " + stack.getMax()); // Output: 5

        stack.pop();
        System.out.println("After popping, Current Min: " + stack.getMin()); // Output: 2
        System.out.println("After popping, Current Max: " + stack.getMax()); // Output: 5

        stack.push(6);
        System.out.println("Current Min: " + stack.getMin()); // Output: 2
        System.out.println("Current Max: " + stack.getMax()); // Output: 6
    }

    private void push(int value) {
        mainStack.push(value);
        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
        else{
            minStack.push(minStack.peek());
        }
        if(maxStack.isEmpty() || value >= maxStack.peek()){
            maxStack.push(value);
        }
        else{
            maxStack.push(maxStack.peek());
        }
    }

    private int pop() {
        if(mainStack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        minStack.pop();
        maxStack.pop();
        return mainStack.pop();
    }

    private int getMax() {
        return maxStack.peek();
    }

    private int getMin() {
        return minStack.peek();
    }

}
