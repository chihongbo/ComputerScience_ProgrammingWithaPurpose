public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int index = (int) Math.ceil(Math.log(n) / Math.log(2));
        int n1 = (int) Math.pow(2, index);
        int[] morse = new int[n1];

        for (int i = 0; i < n1; i++) {
            if (i == 0) morse[i] = 0;
            else if (i % 2 > 0) morse[i] = 1 - morse[i - 1];
            else morse[i] = morse[i / 2];

        }
        //print the morse matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (morse[i] == morse[j]) System.out.print("+  ");
                else System.out.print("-  ");
            }
            System.out.println();
        }

    }
}
