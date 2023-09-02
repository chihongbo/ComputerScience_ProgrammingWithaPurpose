import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weight = new double[3][3];
        weight[1][1] = 1.0;
        return kernel(picture, weight);

    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = 1 / 16.0;
        weights[0][1] = 2 / 16.0;
        weights[0][2] = 1 / 16.0;
        weights[1][0] = 2 / 16.0;
        weights[1][1] = 4 / 16.0;
        weights[1][2] = 2 / 16.0;
        weights[2][0] = 1 / 16.0;
        weights[2][1] = 2 / 16.0;
        weights[2][2] = 1 / 16.0;
        return kernel(picture, weights);

    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][1] = -1;
        weights[1][0] = -1;
        weights[1][1] = 5;
        weights[1][2] = -1;
        weights[2][1] = -1;
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                weights[i][j] = -1;

        }
        weights[1][1] = 8;
        return kernel(picture, weights);

    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = -2;
        weights[0][1] = -1;
        weights[1][0] = -1;
        weights[1][1] = 1;
        weights[1][2] = 1;
        weights[2][1] = 1;
        weights[2][2] = 2;

        return kernel(picture, weights);

    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                if (i == j) {
                    weights[i][j] = 1 / 9.0;
                }
        }
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        int mf = weights.length; // row
        int nf = weights[0].length; // column
        int halfm = (mf / 2);
        int halfn = (nf / 2);
        int mh = picture.height(); // row
        int nw = picture.width(); // column
        int mx = 0, nx = 0;
        int[] conValue1 = new int[3];
        double[] conValue = new double[3];
        Picture pic = new Picture(nw, mh); // Create a blanket


        for (int col = 0; col < nw; col++)
            for (int row = 0; row < mh; row++) {
                for (int ii = 0; ii < 3; ii++) {
                    conValue[ii] = 0;
                }
                for (int colf = 0; colf < nf; colf++) {
                    for (int rowf = 0; rowf < mf; rowf++) {
                        nx = col + colf - halfn; // the column # of the picture
                        mx = row + rowf - halfm; // the row # in the picture
                        if (nx < 0) nx = nx + nw;
                        else if (nx > nw - 1) nx = nx - nw;
                        if (mx < 0) mx = mx + mh;
                        else if (mx > mh - 1) mx = mx - mh;
                        Color color = picture.get(nx, mx);
                        conValue[0] += color.getRed() * weights[colf][rowf];
                        conValue[1] += color.getGreen() * weights[colf][rowf];
                        conValue[2] += color.getBlue() * weights[colf][rowf];
                    }
                }

                for (int ii = 0; ii < 3; ii++) {
                    conValue1[ii] = (int) Math.round(conValue[ii]);
                    if (conValue1[ii] < 0) conValue1[ii] = 0;
                    if (conValue1[ii] > 255) conValue1[ii] = 255;
                }

                Color color2 = new Color(conValue1[0], conValue1[1], conValue1[2]);
                pic.set(col, row, color2);
            }
        return pic;

    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture pic = new Picture(args[0]);
        identity(pic).show();
        gaussian(pic).show();
        sharpen(pic).show();
        laplacian(pic).show();
        emboss(pic).show();
        motionBlur(pic).show();


    }
}
