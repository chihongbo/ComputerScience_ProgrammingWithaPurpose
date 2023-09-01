public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] number = new int[m + 1];
        int count = 0;
        double fequency = 0;
        double entropy = 0;
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            number[x] += 1;
            count++;

        }
        for (int i = 1; i <= m; i++) {
            fequency = number[i] / (count * 1.0);
            if (number[i] > 0) {
                entropy += -1.0 * (fequency * (Math.log(fequency) / Math.log(2)));
            }

        }

        StdOut.printf("%.4f\n", entropy);

    }
}
