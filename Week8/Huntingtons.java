public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int count = 0;
        int max = 0;
        int n = dna.length();

        for (int i = 0; i <= n - 3; i++) {
            String s = dna.substring(i, i + 3);
            if (s.equals("CAG")) {
                count++;
                i += 2;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }


        }
        return max;

    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String str;
        str = s.replaceAll("\\s", "");
        str = str.replaceAll("\t", "");
        str = str.replaceAll("\n", "").replaceAll("\r", "");
        return str;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats >= 0 && maxRepeats <= 9) return "not human";
        else if (maxRepeats >= 10 && maxRepeats <= 35) return "normal";
        else if (maxRepeats >= 36 && maxRepeats <= 39) return "high risk";
        else if (maxRepeats >= 40 && maxRepeats <= 180) return "Huntington’s";
        else return "not human";

    }

    public static void main(String[] args) {
        String s = new In(args[0]).readAll();
        s = removeWhitespace(s);
        System.out.println("max repeats = " + maxRepeats(s));
        System.out.println(diagnose(maxRepeats(s)));


    }
}
