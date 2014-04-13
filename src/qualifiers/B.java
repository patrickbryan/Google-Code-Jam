package qualifiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class B {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("ansB.out"));
        Scanner in = new Scanner(new File("B-large.in"));
        int testCases;
        double farmCost, farmCPS, currentCPS, goal, time;

        testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            farmCost = in.nextDouble();
            farmCPS = in.nextDouble();
            goal = in.nextDouble();
            currentCPS = 2.0;
            time = 0.0;

            while (true) {
                if (goal / currentCPS
                        <= (farmCost / currentCPS) + 
                        (goal / (currentCPS + farmCPS))) {
                    time += goal / currentCPS;
                    break;
                } else {
                    time += farmCost / currentCPS;
                    currentCPS += farmCPS;
                }
            }

            out.write("Case #" + i + ": " + String.format("%.7f", time) + "\n");
        }

        out.close();
        in.close();
    }
}
