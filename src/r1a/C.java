package r1a;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class C {

    static PrintWriter out;
    static Scanner in;

    public static void main(String[] args) throws Exception {
        out = new PrintWriter(new File("ansC.out"));
        in = new Scanner(new File("C-small-attempt0.in"));
        int testCases;
        double uniDiff;
        int mean;
        double myDiff;
        int squDiff;

        testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int nums = in.nextInt();
            uniDiff = nums/Math.sqrt(12);
            myDiff = 0;
            mean = 0;
            ArrayList<Integer> shuffle = new ArrayList();
            squDiff = 0;
            
            for (int k = 0; k < nums; k++) {
                int num = in.nextInt();
                shuffle.add(num);
                mean += num;
            }

            mean /= nums;
            
            for (int a : shuffle) {
                squDiff += (a - mean) * (a - mean);
            }
            
            squDiff /= nums;
            myDiff = Math.sqrt(squDiff);
            
            out.print("Case #" + i + ": ");
            if (Math.abs(myDiff - uniDiff) < 0.0005)
                out.print("GOOD");
            else
                out.print("BAD");
            out.println();
        }

        out.close();
        in.close();
    }
}
