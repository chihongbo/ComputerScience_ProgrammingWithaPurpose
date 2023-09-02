public class TrinomialDP {

    public static long trinomial(int n, int k) {
        long[][] memo = new long[n + 1][2 * n + 1];
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 2 * i; j++) {
                if (i == 0 && j == 0) memo[i][j] = 1;
                else if (j - 1 < 0) memo[i][j] = memo[i - 1][j];
                else if (j - 2 < 0) memo[i][j] = memo[i - 1][j - 1] + memo[i - 1][j];
                else memo[i][j] = memo[i - 1][j - 2] + memo[i - 1][j - 1] + memo[i - 1][j];

            }
        }
        return memo[n][n + k];
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));

    }
}
