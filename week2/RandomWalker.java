public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int s = 0;
        int d = 0;
        int x = 0;
        int y = 0;
        double r;
        System.out.println("(" + x + ", " + y + ")");
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
            if (n > 0) {
                System.out.println("(" + x + ", " + y + ")");
                s += 1;
            }
        } while (d < n);
        System.out.println("steps =" + s);
    }
}
