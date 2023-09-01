public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        int[][] map = new int[m][n];

        int kk = 0;
        while (kk < k) {
            int row = (int) (Math.random() * m);
            int col = (int) (Math.random() * n);
            if (map[row][col] == 0) {
                map[row][col] = -1;
                kk++;
            }
        }
        // assign number to the map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                if (map[i][j] == 0) {
                    for (int ii = i - 1; ii <= i + 1; ii++) {
                        for (int jj = j - 1; jj <= j + 1; jj++) {
                            if (ii >= 0 && ii < m && jj >= 0 && jj < n) {
                                if (map[ii][jj] == -1) num++;
                            }
                        }
                    }
                    map[i][j] = num;
                }

                if (map[i][j] >= 0) System.out.print(map[i][j] + "  ");
                if (map[i][j] == -1) System.out.print("*  ");

            }
            System.out.println();
        }


    }
}
