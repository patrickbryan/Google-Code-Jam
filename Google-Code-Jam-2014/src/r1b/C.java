package r1b;

import java.io.File;
import java.io.PrintWriter;
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
        in = new Scanner(new File("A-large.in"));
        int testCases;
        
        testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++)
        {
            
            
            out.print("Case #" + i + ": ");
            //out.print();
            out.println();
        }
        
        out.close();
        in.close();
    }
}
