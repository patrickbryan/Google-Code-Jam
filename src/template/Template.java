package template;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class Template {
    
    static PrintWriter out;
    static Scanner in;
    
    public static void main(String[] args) throws Exception {
        out = new PrintWriter(new File("ansA.out"));
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
