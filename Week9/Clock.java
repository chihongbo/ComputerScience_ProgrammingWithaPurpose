public class Clock {
    private int h, m;
    //private String s;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h > 23 | h < 0) {
            throw new IllegalArgumentException("the hour must be between 0 and 23");
        }
        if (m < 0 | m > 59) {
            throw new IllegalArgumentException("the minute must be between 0 and 59");
        }
        this.h = h;
        this.m = m;


    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        int len = s.length();
        int index = s.indexOf(":");
        if (index < 0) {
            throw new IllegalArgumentException(": is missing");
        }
        String substr1 = s.substring(0, index);
        String substr2 = s.substring(index + 1, len);

        for (int a = 0; a < substr1.length(); a++) {
            if (a == 0 && substr1.charAt(a) == '-')
                continue;
            if (!Character.isDigit(substr1.charAt(a)))
                throw new IllegalArgumentException("the hour must be between 0 and 23");
        }

        for (int a = 0; a < substr2.length(); a++) {
            if (a == 0 && substr2.charAt(a) == '-')
                continue;
            if (!Character.isDigit(substr2.charAt(a)))
                throw new IllegalArgumentException("the minute must be between 0 and 59");
        }

        int h1 = Integer.parseInt(substr1);
        int m1 = Integer.parseInt(substr2);
        if (h1 > 23 | h1 < 0) {
            throw new IllegalArgumentException("the hour must be between 0 and 23");
        }
        if (m1 < 0 | m1 > 59) {
            throw new IllegalArgumentException("the minute must be between 0 and 59");
        }
        this.h = h1;
        this.m = m1;

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d", h) + ":" + String.format("%02d", m);

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (h < that.h) return true;
        if (h == that.h && m < that.m) return true;
        return false;

    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.m == 59) {
            if (this.h == 23) {
                this.h = 0;
                this.m = 0;

            } else {
                this.h += 1;
                this.m = 0;
            }
        } else {
            this.m += 1;
        }

    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("the minute must be positive");
        }
        int h1 = delta / 60;
        //int h2 = h1 % 24;
        int delta1 = delta % 60;

        for (int i = 1; i <= delta1; i++) {
            tic();
        }
        this.h = (h1 + this.h) % 24;


    }

    public static void main(String[] args) {
        Clock c = null;
        Clock c1 = null;
        if (args.length == 2) {
            int h = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            c = new Clock(h, m);
            c1 = new Clock(h, m);
        } else if (args.length == 1) {
            String s = args[0];
            c = new Clock(s);
            c1 = new Clock(s);

        }

        //Clock c1 = c;
        c1.toc(10034);
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c.isEarlierThan(c1));
    }
}
