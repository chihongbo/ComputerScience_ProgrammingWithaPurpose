import java.util.Arrays;
import java.util.Collections;

public class BarChartRacer {
    private static boolean isInteger(String input) {
        boolean flag = true;
        for (int a = 0; a < input.length(); a++) {
            if (a == 0 && input.charAt(a) == '-')
                continue;
            if (!Character.isDigit(input.charAt(a)))
                flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        //StdAudio.playInBackground("soundtrackA.wav");
        StdDraw.setCanvasSize(1000, 700);
        In in;
        String s;
        String caption = null;
        String title = null;
        String xAxis = null;
        String source = null;


        int lineNo = 0;
        int count = 0;
        String filename = args[0];
        int size = Integer.parseInt(args[1]);
        in = new In(filename);
        title = in.readLine();
        xAxis = in.readLine();
        source = in.readLine();
        BarChart chart = new BarChart(title, xAxis, source);

        while (!in.isEmpty()) {
            s = in.readLine();
            if (s.isEmpty()) continue;
            if (isInteger(s)) {
                count = Integer.parseInt(s);// the following loop is used to extract the
                Bar[] bars = new Bar[count];
                for (int i = 0; i < count; i++) {
                    String s1 = in.readLine();
                    String[] result = s1.split(",");
                    String name = result[1];
                    int value = Integer.parseInt(result[3]);
                    String category = result[4];
                    caption = result[0];
                    bars[i] = new Bar(name, value, category);

                }
                Arrays.sort(bars, Collections.reverseOrder());
                chart.setCaption(caption);
                chart.reset();
                for (int i = 0; i < size; i++) {
                    chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
                }
                // draw the bar chart

                StdDraw.clear();

                chart.draw();
                StdDraw.show();
                StdDraw.pause(100);


            }

        }


    }
}
