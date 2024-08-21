import java.util.Stack;

public class CelebritySTACK {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 0}
        };

        int n = matrix.length;
        int result = findCelebrity(matrix, n);
        if (result == -1) {
            System.out.println("There is no celebrity.");
        } else {
            System.out.println("The celebrity is person " + result);
        }
    }

    private static int findCelebrity(int[][] matrix, int n) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            stack.push(i);
        }

        while(stack.size() > 1){
            int a = stack.pop();
            int b = stack.pop();
            if(knows(matrix, a, b)){
                stack.push(b);
            }
            else{
                stack.push(a);
            }
        }
        int candidate = stack.pop();
        for(int i = 0; i < n; i++){
            if(i != candidate){
                if(knows(matrix, candidate, i) || ! knows(matrix, i, candidate)){
                    return -1;
                }
            }

        }
        return candidate;
    }
    private static boolean knows(int[][]matrix, int a, int b){
        return matrix[a][b] == 1;
    }

}
