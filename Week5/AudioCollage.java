public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        int n = a.length;
        double[] a1 = new double[n];
        for (int i = 0; i < n; i++) {
            a1[i] = alpha * a[i];
        }

        return a1;

    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        int n = a.length;
        double[] a1 = new double[n];
        for (int i = 0; i < n; i++) {
            a1[i] = a[n - i - 1];
        }

        return a1;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        int na = a.length;
        int nb = b.length;
        double[] a1 = new double[na + nb];
        int i = 0;

        for (; i < na; i++) {
            a1[i] = a[i];
        }

        for (; i < na + nb; i++) {
            a1[i] = b[i - na];
        }

        return a1;

    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int na = a.length;
        int nb = b.length;
        int nc = Math.max(na, nb);
        double[] sum = new double[nc];
        for (int i = 0; i < na; i++) {
            sum[i] += a[i];
        }
        for (int j = 0; j < nb; j++) {
            sum[j] += b[j];
        }
        return sum;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int na = a.length;
        int nb = (int) (na / alpha);
        double[] b = new double[nb];
        int i = 0, j = 0;
        for (j = 0; j < nb; j++) {
            i = (int) (j * alpha);
            b[j] = a[i];
        }
        return b;

    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] a = StdAudio.read("beatbox.wav");
        double[] b = StdAudio.read("buzzer.wav");
        double[] c = StdAudio.read("chimes.wav");
        double[] d = StdAudio.read("cow.wav");
        double[] e = StdAudio.read("piano.wav");
        int na = a.length;
        int nb = b.length;
        int nc = c.length;
        int nd = d.length;
        int ne = e.length;


        StdAudio.play(amplify(a, 2));
        StdAudio.play(reverse(a));
        StdAudio.play(merge(a, b));
        StdAudio.play(mix(a, b));
        StdAudio.play(changeSpeed(a, 3));

        StdAudio.play(amplify(c, 2));
        StdAudio.play(reverse(c));
        StdAudio.play(merge(c, d));
        StdAudio.play(mix(c, d));
        StdAudio.play(changeSpeed(c, 3));

        StdAudio.play(amplify(e, 2));
        StdAudio.play(reverse(e));
        StdAudio.play(merge(e, d));
        StdAudio.play(mix(e, d));
        StdAudio.play(changeSpeed(e, 3));


    }
}
