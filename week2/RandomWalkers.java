public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int totalSt = 0;
        double avg = 0;
        for (int i = 0; i < trials; i++) {
            int s = 0;
            int d = 0;
            int x = 0;
            int y = 0;
            double r;
            do {
                r = Math.random();
                if (r <= 0.25)
                    x = x + 1;
                else if (r <= 0.5)
                    x = x - 1;
                else if (r <= 0.75)
                    y = y + 1;
                else
                    y = y - 1;

                d = Math.abs(x) + Math.abs(y);
                if (n > 0)
                    s += 1;
            } while (d < n);
            totalSt += s;
        }
        avg = totalSt / (trials * 1.0);
        System.out.println("average number of steps =" + avg);
    }
}
