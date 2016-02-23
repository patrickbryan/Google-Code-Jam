package r1b;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class A {
    static PrintWriter out;
    static Scanner in;
    
    public static void main(String[] args) throws Exception {
        out = new PrintWriter(new File("ansA.out"));
        in = new Scanner(new File("A-small-attempt0.in"));
        int testCases;
        
        testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++)
        {
            int numStrings = in.nextInt();
            ArrayList<String> s = new ArrayList();
            boolean pass = true;
            int changes = 0;
            
            in.nextLine();
            for (int k = 0; k < numStrings; k++) {
                s.add(in.nextLine());
            }
            
            String cur;
            String comp;
                    
            if (s.get(0).length() >= s.get(1).length()) {
                cur = s.get(0);
                comp = s.get(1);
            }
            else {
                cur = s.get(1);
                comp = s.get(0);
            }
            int countLetter = 1;
            int countComp;
            char curLetter = cur.charAt(0);
            int spotComp = 0;
            for (int k = 1; k < cur.length(); k++) {
                if (cur.charAt(k) == curLetter) {
                    countLetter++;
                }
                else {
                    countComp = 0;
                    if (spotComp < comp.length()-1) {
                        //System.out.println(spotComp + " "  + comp.length());
                    for (; comp.charAt(spotComp) == curLetter; spotComp++) {
                        countComp++;
                    }
                    }
                    changes += Math.abs(countLetter - countComp);
                    curLetter = cur.charAt(k);
                    countLetter = 1;
                    if (countComp == 0) {
                        pass = false;
                        break;
                    }
                }
            }
            
            
            out.print("Case #" + i + ": ");
            if (!pass) {
                out.print("Fegla Won" );
            }
            else {
                out.print(changes);
            }
            out.println();
        }
        
        out.close();
        in.close();
    }
}
