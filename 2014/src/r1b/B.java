package r1b;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
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
        in = new Scanner(new File("B-large.in"));
        int testCases;
        
        testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++)
        {
            long a = in.nextInt();
            long b = in.nextInt();
            long k = in.nextInt();
            long wins = 0;
            
            for (long w = 0; w < a; w++) {
                for (long v = 0; v < b; v++) {
                    long bitAnd = w&v;
                    if (bitAnd < k) {
                        wins++;
                    }
                }
            }
            
            out.print("Case #" + i + ": ");
            out.print(wins);
            out.println();
        }
        out.close();
        in.close();
    }
}
