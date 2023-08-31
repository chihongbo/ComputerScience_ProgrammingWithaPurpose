public class GreatCircle {
    public static void main(String[] args) {
        double r = 6371.0;
        double dist = 0;
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double iterm1, iterm2, iterm3;
        iterm1 = Math.sin((x2 - x1) / 2.0);
        iterm1 = Math.pow(iterm1, 2);
        iterm2 = Math.sin((y2 - y1) / 2.0);
        iterm2 = Math.pow(iterm2, 2);
        iterm2 = Math.cos(x1) * Math.cos(x2) * iterm2;
        iterm3 = iterm1 + iterm2;
        iterm3 = Math.sqrt(iterm3);

        dist = 2 * r * Math.asin(iterm3);

        System.out.println(dist + " Kilometers");


    }
}
