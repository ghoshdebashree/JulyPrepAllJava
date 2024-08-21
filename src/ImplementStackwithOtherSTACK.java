public class ImplementStackwithOtherSTACK {
    public static void main(String[] args){

    }

}
class StackImplementation{
    private int[] stack;
    private int top;
    private int capacity;
    StackImplementation(int capacity){
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }
    void push(int x){
        if(top == capacity - 1){
            throw new StackOverflowError("Stack overflow" );
        }
        stack[++top] = x;
    }
    int pop(){
        if(top == -1){
            throw new RuntimeException("Stack underflow");
        }
        return stack[top--];
    }
    int top(){
        if(top == -1){
            throw new RuntimeException("Stack is empty");
        }
        return stack[top];
    }
    boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }
}

