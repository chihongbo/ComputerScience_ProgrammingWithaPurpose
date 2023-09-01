public class DiscreteDistribution {
    public static void main(String[] args) {
        int count = args.length;           // number of the input index number
        int n = Integer.parseInt(args[0]); // the total number of the random discrete number
        int total = 0;
        double r;
        int[] dNum = new int[n];
        int[] index = new int[count - 1];

        for (int i = 0; i < count - 1; i++) {
            if (i == 0) {
                index[i] = Integer.parseInt(args[1]);
            } else {
                index[i] = index[i - 1] + Integer.parseInt(args[i + 1]);
            }
            //System.out.print(index[i] + " ");
        }
        //System.out.println();
        total += index[count - 2];
        for (int i = 0; i < n; i++) {
            r = Math.random() * total;
            if (r <= index[0]) {
                dNum[i] = 1;
            } else {
                for (int j = 1; j < count - 1; j++) {
                    if (r > index[j - 1] && r <= index[j]) {
                        dNum[i] = j + 1;
                        break;
                    }

                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(dNum[i] + " ");
            if ((i + 1) % 25 == 0) {
                System.out.println();
            }

        }
    }
}
