public class ColorHSB {
    private int h, s, b;
    //private final String Name;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h > 359 | h < 0) {
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        }
        if (s < 0 | s > 100) {
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        }
        if (b < 0 | b > 100) {
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        }
        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + h + ", " + s + ", " + b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (s == 0 | b == 0) {
            return true;
        }
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int distance = 0;
        distance = Math.min((h - that.h) * (h - that.h), (int) Math.pow(360 - Math.abs(h - that.h), 2)) + (s - that.s) * (s - that.s) + (b - that.b) * (b - that.b);
        return distance;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB c = new ColorHSB(h, s, b);
        String name = "", cname = "";
        int h1, s1, b1;
        int mdist = 1000000;//Integer.MAX_VALUE;
        ColorHSB c1 = null;
        ColorHSB cc1 = null;


        while (!StdIn.isEmpty()) {
            name = StdIn.readString();
            h1 = StdIn.readInt();
            s1 = StdIn.readInt();
            b1 = StdIn.readInt();
            c1 = new ColorHSB(h1, s1, b1);
            if (mdist > c.distanceSquaredTo(c1)) {
                mdist = c.distanceSquaredTo(c1);
                cname = name;
                cc1 = c1;
            }
            //StdOut.println(c.distanceSquaredTo(c1));
        }
        System.out.println(cname + " " + cc1);


    }
}
