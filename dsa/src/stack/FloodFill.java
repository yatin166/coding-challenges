package stack;

public class FloodFill {

    private static void floodFillUsingRecursion(int[][] image, int sr, int sc, int color, int startingColor) {
        if (image[sr][sc] != startingColor) {
            return;
        }

        image[sr][sc] = color;
        // Move up
        if (sr > 0) {
            floodFillUsingRecursion(image, sr - 1, sc, color, startingColor);
        }

        // Move right
        if (sc < image[0].length - 1) {
            floodFillUsingRecursion(image, sr, sc + 1, color, startingColor);
        }

        // Move bottom
        if (sr < image.length - 1) {
            floodFillUsingRecursion(image, sr + 1, sc, color, startingColor);
        }

        // Move left
        if (sc > 0) {
            floodFillUsingRecursion(image, sr, sc - 1, color, startingColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {0,0,0},
                {0,0,0},
                /*{1,0,1}*/
        };
        int sr = 0;
        int sc = 0;
        int color = 0;
        floodFillUsingRecursion(image, sr, sc, color, image[sr][sc]);

        for (int row = 0; row < image.length; row++) {
            for (int col = 0; col < image[row].length; col++) {
                System.out.print(image[row][col] + " ");
            }
            System.out.println();
        }
    }
}
