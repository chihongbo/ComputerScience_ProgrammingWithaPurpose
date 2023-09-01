public class WorldMap {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            /*
            String text[] = trim(StdIn.readLine()).split(" ");
            int count = 0;
            count = text.split(" ").length;
            if (count == 0) continue;
            if (count == 1) {
                if(Character.isDigit(startsWith(text[0]))){
                    int n=Integer.parseInt(text[0]);
                } else
                {
                    continues;           }
            }

            if(count==2){

            }
            */

            StdIn.readLine();
            StdIn.readLine();
            String regionName = StdIn.readString();
            int n = StdIn.readInt();
            double[] x = new double[n];
            double[] y = new double[n];
            boolean poly = false;
            for (int i = 0; i < n; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
                poly = true;
            }
            if (poly) StdDraw.polygon(x, y);

        }

        StdDraw.show();
    }
}
