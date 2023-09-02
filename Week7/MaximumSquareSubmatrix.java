public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int n = a.length;
        int[][] b = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (a[i][j] == 1) {
                        b[i][j] = 1;
                        if (max < b[i][j]) max = b[i][j];
                    } else b[i][j] = 0;
                } else { // for i>=1 & j>=1

                    if (a[i][j] == 0) {
                        b[i][j] = 0;
                    } else {
                        b[i][j] = Math.min(b[i - 1][j - 1], Math.min(b[i - 1][j], b[i][j - 1])) + 1;
                        if (max < b[i][j]) max = b[i][j];
                    }
                }
            }
        }

        return max;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];


        while (!StdIn.isEmpty()) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = StdIn.readInt();
                }
            }

        }

        System.out.println(size(a));

    }
}
