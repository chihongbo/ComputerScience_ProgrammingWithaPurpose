public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0;
        for (int i = 0; i < n; i++) {
            h += 1.0 / Math.pow(i + 1, r);
        }
        System.out.println(h);

    }
}
