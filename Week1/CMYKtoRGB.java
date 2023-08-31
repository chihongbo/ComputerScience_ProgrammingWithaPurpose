public class CMYKtoRGB {
    public static void main(String[] args) {
        double red, green, blue;
        double c = Double.parseDouble(args[0]);
        double m = Double.parseDouble(args[1]);
        double y = Double.parseDouble(args[2]);
        double k = Double.parseDouble(args[3]);


        red = 255.0 * (1 - k) * (1 - c);
        green = 255.0 * (1 - k) * (1 - m);
        blue = 255.0 * (1 - k) * (1 - y);

        System.out.println("red = " + Math.round(red));
        System.out.println("green = " + Math.round(green));
        System.out.println("blue = " + Math.round(blue));


    }
}
