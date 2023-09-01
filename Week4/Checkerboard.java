public class Checkerboard {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setScale(0, N);

        double x, y;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                x = 0.5 + i;
                y = 0.5 + j;
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(x, y, 0.5);
                }

            }


        }


    }
}
