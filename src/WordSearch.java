public class WordSearch {
    public static void main(String[] args){
        WordSearch ws = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABFDE";
        if(ws.search(board, word)){
            System.out.println("The word exists in the board.");
        } else {
            System.out.println("The word does not exist in the board.");
        
        }
    }

    private boolean search(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <cols; j++){
                if(board[i][j] == word.charAt(0) && findSearch(board, word, i, j ,0))
                    return true;
            }
        }
        return false;
    }

    private boolean findSearch(char[][] board, String word, int rows, int cols, int index) {
        if(index == word.length()){
            return true;
        }
        if(rows < 0 || rows >=board.length || cols < 0 || cols >=board[0].length || board[rows][cols] != word.charAt(index)){
                return false;

        }
        char temp = board[rows][cols];
        board[rows][cols] = '#';
        boolean found = findSearch(board, word, rows + 1, cols, index + 1)||
        findSearch(board, word, rows - 1, cols, index + 1)||
        findSearch(board, word, rows , cols + 1, index + 1)||
        findSearch(board, word, rows, cols -1, index + 1);
        board[rows][cols] = temp;
        return found;

    }
}
