package r1a;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class B {

    static PrintWriter out;
    static Scanner in;

    public static void main(String[] args) throws Exception {
        out = new PrintWriter(new File("ansB.out"));
        in = new Scanner(new File("BTest.in"));
        int testCases;

        testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int nodes = in.nextInt();

            for (int k = 0; k < nodes; k++) {

            }

            out.print("Case #" + i + ": ");
            //out.print();
            out.println();
        }

        out.close();
        in.close();
    }
}
