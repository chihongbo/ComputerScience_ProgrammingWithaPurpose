public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // the total number of the random discrete number
        int trials = Integer.parseInt(args[1]); // the total number of the random discrete number
        int[] person = new int[n + 1];  // define the array to accumulate the trail
        double ratio = 0, accCnt = 0;
        for (int i = 0; i < trials; i++) {
            int[] birthday = new int[n];
            for (int j = 0; j <= n; j++) { // enter person into the room one by one
                int randB = (int) (Math.random() * n);
                if (birthday[randB] == 0) {
                    birthday[randB] += 1;
                } else {
                    person[j] += 1;
                    break;
                }
            }

        }

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                ratio = 0;
                accCnt = person[i];
            } else {
                accCnt = accCnt + person[i];
                ratio = accCnt / (trials * 1.0);
            }
            System.out.println(i + 1 + "\t" + person[i] + "\t" + ratio);
            if (ratio >= 0.5) break;
        }

    }
}
