public class RevesPuzzle {

    // move N-K smallest discs from one pole to another, using one temp pole (totally 3 poles)
    private static void hanoi(int n, int k, String from, String to, String temp) {
        if (n == 0) return;
        hanoi(n - 1, k, from, temp, to);
        int diskNum = n + k;
        System.out.println("Move disc " + diskNum + " from " + from + " to " + to);
        hanoi(n - 1, k, temp, to, from);
    }

    // move K smallest discs from one pole to another, using the 2 temp poles (totall 4 poles)
    private static void reves(int n, String from, String to, String temp1, String temp2) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
        if (k == 0) {
            if (n > 0) {
                System.out.println("Move disc " + 1 + " from " + from + " to " + to);
                return;
            } else return;
        }

        reves(k, from, temp1, temp2, to);
        hanoi(n - k, k, from, to, temp2);
        reves(k, temp1, to, from, temp2);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "D", "B", "C");

    }


}
