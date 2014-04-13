package qualifiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class A {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("ansA.out"));
        Scanner in = new Scanner(new File("A-small-attempt0 (1).in"));
        int testCases;
        ArrayList<Integer> origSpread = new ArrayList();
        ArrayList<Integer> shuffleSpread = new ArrayList();
        int origRow, shuffleRow, card, origBegin, shuffleBegin;
        boolean foundOneCard, multipleCards;
        
        testCases = in.nextInt();
        
        for (int i = 1; i <= testCases; i++)
        {
            origRow = in.nextInt();
            readSpread(origSpread, in);
            shuffleRow = in.nextInt();
            readSpread(shuffleSpread, in);
            
            foundOneCard = false;
            multipleCards = false;
            card = -1;
            origBegin = (origRow - 1) * 4;
            shuffleBegin = (shuffleRow - 1) * 4;
            for (int orig = origBegin; orig < origBegin + 4; orig++) {
                for (int shuf = shuffleBegin; shuf < shuffleBegin + 4; shuf++) {
                    if (!foundOneCard && 
                            origSpread.get(orig) == shuffleSpread.get(shuf)) {
                        card = origSpread.get(orig);
                        foundOneCard = true;
                    }
                    else if (origSpread.get(orig) == shuffleSpread.get(shuf)) {
                        multipleCards = true;
                    }
                    
                }
            }
            
            out.write("Case #" + i + ": ");
            if (multipleCards) {
                out.write("Bad magician!");
            }
            else if (!foundOneCard) {
                out.write("Volunteer cheated!");
            }
            else {
                out.write("" + card);
            }
            out.write("\n");
        }
        
        out.close();
        in.close();
    }
    
    private static void readSpread(ArrayList<Integer> spread, Scanner in) {
        spread.clear();
        for (int i = 0; i < 16; i++) {
            spread.add(in.nextInt());
        }
    }
}
