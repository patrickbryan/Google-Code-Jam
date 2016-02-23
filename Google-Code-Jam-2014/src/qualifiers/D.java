package qualifiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class D {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("ans.out"));
        Scanner in = new Scanner(new File("D-large.in"));
        int testCases;
        ArrayList<Double> naomiBlocks = new ArrayList();
        ArrayList<Double> kenBlocks = new ArrayList();
        int deceitfulWarSpot, naomiDeceitfulWins, naomiWarWins, blockCount
                ,warSpotKen;

        testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            blockCount = in.nextInt();
            
            readBlocks(naomiBlocks, blockCount, in);
            Collections.sort(naomiBlocks);
            readBlocks(kenBlocks, blockCount, in);
            Collections.sort(kenBlocks);
            
            deceitfulWarSpot = blockCount - 1;
            naomiDeceitfulWins = 0;
            naomiWarWins = 0;
            warSpotKen = blockCount - 1;
            for (int warSpot = deceitfulWarSpot; warSpot >= 0; warSpot--) {
                if (naomiBlocks.get(warSpot) > kenBlocks.get(warSpotKen)) {
                    naomiWarWins++;
                }
                else {
                    warSpotKen--;
                }
                if (naomiBlocks.get(deceitfulWarSpot) > kenBlocks.get(warSpot)) {
                    deceitfulWarSpot--;
                    naomiDeceitfulWins++;
                }
            }
            
            out.write("Case #" + i + ": " + naomiDeceitfulWins + " " + 
                    naomiWarWins + "\n");
        }

        out.close();
        in.close();
    }

    private static void readBlocks(ArrayList<Double> blocks, int count, 
            Scanner in) {
        blocks.clear();
        for (int k = 0; k < count; k++) {
            blocks.add(in.nextDouble());
        }
    }
}
