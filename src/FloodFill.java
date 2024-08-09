public class FloodFill {
    public static void main(String[] args){
        FloodFill f = new FloodFill();
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, newColor = 2;
        int[][] result = f.floodFill(image, sr, sc, newColor);
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if(originalColor != newColor){
            fillColor(image, sr, sc, originalColor, newColor);

        }
        return image;
    }

    private static void fillColor(int[][] image, int row, int col, int originalColor, int newColor) {
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor){
            return;
        }
        image[row][col] = newColor;
        fillColor(image,row + 1, col, originalColor, newColor);
        fillColor(image, row - 1, col,originalColor, newColor);
        fillColor(image, row, col - 1, originalColor, newColor);
        fillColor(image, row, col + 1,originalColor, newColor);

    }
}
