public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long a1 = Math.round(Math.pow(n, 1 / 3.0));
        long b1 = 0;
        int count = 0;

        for (long i = 1; i <= a1; i++) {
            double b2 = 0;
            b2 = Math.pow(n - i * i * i, 1 / 3.0);
            b1 = Math.round(b2);
            if (Math.abs(b1 - b2) < 0.000001 && i <= b1) {
                if ((long) (i * i * i + b1 * b1 * b1) == n) count++;
            }
        }

        if (count >= 2) return true;
        return false;
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        if (isRamanujan(n)) System.out.println("true");
        else System.out.println("false");

    }
}
