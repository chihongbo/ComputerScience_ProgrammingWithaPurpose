public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return x;
        if (x < 0) return 0;
        if (x > 0) return 1;
        return 0.5;
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return x;
        return 1.0 / (1 + Math.exp(-x));

    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return x;
        if (x >= 20) return 1.0;
        if (x <= -20) return -1.0;
        return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));

    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return x;
        if (x == Double.POSITIVE_INFINITY) return 1.0;
        if (x == Double.NEGATIVE_INFINITY) return -1.0;
        return x / (1 + Math.abs(x));

    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return x;
        if (x <= -2) return -1;
        if (x < 0) return x + x * x / 4;
        if (x < 2) return x - x * x / 4;
        return 1;

    }


    public static void main(String[] args) {
        String str = args[0].trim();
        int StrLen = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        boolean isNum = true;
        int j = 0; // the count of '.'
        double x;

        //checking for negative numbers
        if (charArray[0] == '-')
            i = 1;
        for (; i < StrLen; i++) {
            if (charArray[i] == '.') {
                j += 1;
                if (j == 2) {
                    isNum = false;
                    break;
                }
                continue;
            }

            if (charArray[i] > '9' || charArray[i] < '0') {
                isNum = false;
            }

        }

        if (isNum) {
            x = Double.parseDouble(args[0]);
        } else {
            x = Double.NaN;
        }
        System.out.println("heaviside(" + x + ") = " + heaviside(x));
        System.out.println("  sigmoid(" + x + ") = " + sigmoid(x));
        System.out.println("     tanh(" + x + ") = " + tanh(x));
        System.out.println(" softsign(" + x + ") = " + softsign(x));
        System.out.println("     sqnl(" + x + ") = " + sqnl(x));


    }
}
