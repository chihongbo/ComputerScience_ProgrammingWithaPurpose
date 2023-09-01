public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);
        int c1 = 0;
        while (b1 > 0) {
            c1 = a1;
            a1 = b1;
            b1 = c1 % b1;
        }
        return a1;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        int a1 = Math.abs(a);
        int b1 = Math.abs(b);
        if (a1 == 0 && b1 == 0) return 0;
        return a1 / gcd(a1, b1) * b1;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a, b) == 1) return true;
        return false;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int num = 0;
        if (n <= 0) return 0;
        for (int i = 1; i <= n; i++) {
            if (gcd(i, n) == 1) num++;
        }
        return num;

    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        String str1 = args[0].trim();
        String str2 = args[1].trim();
        int StrLen1 = str1.length();
        int StrLen2 = str2.length();
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int i = 0, j = 0;
        boolean isNum1 = true;
        boolean isNum2 = true;
        int a, b;

        //checking for negative numbers
        if (charArray1[0] == '-')
            i = 1;
        for (; i < StrLen1; i++) {
            if (charArray1[i] > '9' || charArray1[i] < '0') {
                isNum1 = false;
            }

        }

        //checking for negative numbers
        if (charArray2[0] == '-')
            j = 1;
        for (; j < StrLen2; j++) {
            if (charArray2[j] > '9' || charArray2[j] < '0') {
                isNum2 = false;
            }

        }

        if (isNum1 && isNum2) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            System.out.println("gcd(" + a + ", " + b + ") = " + gcd(a, b));
            System.out.println("lcm(" + a + ", " + b + ") = " + lcm(a, b));
            System.out.println("areRelativelyPrime(" + a + ", " + b + ") = " + areRelativelyPrime(a, b));
            System.out.println("totient(" + a + ") = " + totient(a));
            System.out.println("totient(" + b + ") = " + totient(b));
        } else {
            System.out.println(" Please input validate pairs of integers");
        }


    }
}
