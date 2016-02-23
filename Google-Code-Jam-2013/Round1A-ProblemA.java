package r1a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Patrick
 */
public class R1a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("test.out"));
        BufferedReader in = new BufferedReader(new FileReader("A-small-attempt0.in"));
        int testCases = 0;
        String line;
        int initialRadius, paint, index, totalRadius, rings;
        double totalArea, tempArea, ringArea;
        boolean stop = false;
        
        line = in.readLine();
        testCases = Integer.parseInt(line);
        
        for (int i = 1; i <= testCases; i++)
        {
            line = in.readLine();
            index = line.indexOf(" ");
            initialRadius = Integer.parseInt(line.substring(0, index));
            paint = Integer.parseInt(line.substring(index + 1));
            //System.out.println(initialRadius + " " + paint);
            rings = 0;
            totalRadius = initialRadius;
            totalArea = totalRadius * totalRadius;
            stop = false;
            do
            {
                totalRadius++;
                tempArea = totalRadius * totalRadius;
                ringArea = (tempArea - totalArea);
                //System.out.println(ringArea);
                if (paint - ringArea < 0)
                {
                    stop = true;
                }
                else
                {
                    paint = paint - (int)ringArea;
                    totalArea = tempArea;
                    rings++;
                }
                totalRadius++;
                totalArea = totalRadius * totalRadius;
            } while (!stop);
            //System.out.println("Case #"+i+": "+rings);
            out.write("Case #" + i + ": "+rings+"\n");
        }
        
        out.close();
        in.close();
    }
}
