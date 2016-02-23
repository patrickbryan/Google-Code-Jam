package q3;

import java.io.*;

/**
 *
 * @author Patrick
 */
public class Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("test.out"));
        BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
        int testCases = 0, index, startInt, endInt, fineNums;
        String line;

        line = in.readLine();
        testCases = Integer.parseInt(line);

        for (int i = 1; i <= testCases; i++) {
            fineNums = 0;
            line = in.readLine();
            index = line.indexOf(" ");
            startInt = Integer.parseInt(line.substring(0, index));
            endInt = Integer.parseInt(line.substring(index + 1));
            startInt = (int) Math.ceil(Math.sqrt(startInt));
            endInt = (int) Math.floor(Math.sqrt(endInt));

            for (int k = startInt; k <= endInt; k++) {
                if (isPalindrome(("" + k).toCharArray()) && isPalindrome(("" + (k*k)).toCharArray()))
                {
                    fineNums++;
                }
            }
            
            out.write("Case #" + i + ": " + fineNums + "\n");
        }
        
        out.close();
        in.close();
    }

    /**
     * Taken from http://stackoverflow.com/questions/12192805/convert-a-integer-to-character-array-java
     * @param word
     * @return 
     */
    public static boolean isPalindrome(char[] word) {
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }
}
