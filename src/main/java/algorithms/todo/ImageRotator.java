package algorithms.todo;

/**
 * given an image represented by an NxN matrix, where each pixel in a image is 4 bytes, write a method to rotate the image by 90 degrees.can you do it in place
 */
public class ImageRotator {
    public static void rotateImage(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Invalid matrix input");
        }

        int n = matrix.length;

        // Step 1: Transpose the matrix (swap elements across the main diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }

    // Helper method to print the matrix (for testing)
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Example 3x3 matrix where each number represents a pixel (4 bytes)
        int[][] image = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Image:");
        printMatrix(image);

        rotateImage(image);

        System.out.println("Rotated Image (90 degrees clockwise):");
        printMatrix(image);
    }
}
