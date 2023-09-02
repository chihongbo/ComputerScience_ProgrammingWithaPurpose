public class Inversions {


    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int aLen = a.length;
        long count = 0;
        for (int i = 0; i < aLen; i++) {
            for (int j = i + 1; j < aLen; j++) {
                if (a[i] > a[j]) count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] a = new int[n];
        int[] b = new int[n];
        int n1 = n;
        long k1 = k;
        int index = 0;
        long index1 = 0;
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        for (int j = 0; j < n; j++) {
            if (k1 >= n1 - 1) {
                b[index] = a[n1 - 1];
                k1 = k1 - (n1 - 1);
                n1 = n1 - 1;
                index += 1;
                //System.out.println("k1=" + k1 + ", n1=" + n1 + " ,j=" + j + " ,index=" + index);
            } else if (k1 < n1 - 1) { // reshuffle the a1 array and copy the array to b1 array

                index1 = n1 - k1 - 1;
                for (int jj = 0; jj < n1; jj++) {
                    if (jj < index1) {
                        //System.out.println("k1=" + k1 + " ,j=" + j + ", jj=" + jj + " ,n1=" + n1 + " ,index=" + index + ", index1=" + index1 + ",k1=" + k1);
                        b[index] = a[jj];
                        index += 1;
                    } else if (jj == index1) {
                        b[index] = a[n1 - 1];
                        index += 1;
                    } else {
                        b[index] = a[jj - 1];
                        index += 1;
                    }
                }

                break;


            }
        }
        return b;


    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        if (k > n * (n - 1) / 2.0) {
            System.out.println("null");
        } else {
            int[] b = generate(n, k);
            for (int i = 0; i < n - 1; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println(b[n - 1]);
            //System.out.println(Arrays.toString(generate(n, k)));
            //System.out.println(count(generate(n, k)));
        }


    }
}
