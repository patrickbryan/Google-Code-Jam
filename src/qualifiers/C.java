package qualifiers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Patrick Bryan
 */
public class C {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("ansC.out"));
        Scanner in = new Scanner(new File("C-small-attempt2.in"));
        int testCases;
        int rows, columns, mines, max, freeSpots, spots, spotsNeeded;
        boolean possible, usedSpot;
        String grid;
        boolean[][] matrix;

        testCases = in.nextInt();

        for (int i = 1; i <= testCases; i++) {
            rows = in.nextInt();
            columns = in.nextInt();
            mines = in.nextInt();
            possible = false;
            grid = "";
            freeSpots = 0;
            spotsNeeded = (rows * columns) - mines;

            if (rows > columns) {
                max = rows;
            } else {
                max = columns;
            }
            matrix = new boolean[rows][columns];

            if (spotsNeeded == 1) {
                grid = createGrid(matrix);
                possible = true;
            } else if ((rows == 2 || columns == 2) && rows != 1 && columns != 1
                    && mines % 2 == 1) {
                
            } else {
                matrix[0][0] = true;
                spots = 1;
                for (int t = 0; t < (2 * max) - 1; t++) {
                    int rightX, rightY, downX, downY, diagX, diagY;
                    usedSpot = false;

                        for (int k = 0; k <= t; k++) {
                            rightX = k + 1;
                            rightY = t - k;
                            downX = k;
                            downY = t - k + 1;
                            diagX = rightX;
                            diagY = downY;
                            
                            if (columns < 3 && rightX > columns - 1) {
                                rightX--;
                                diagX--;
                                diagY--;
                            } 
                            if (rows < 3 && downY > rows - 1) {
                                downY--;
                                diagX--;
                                diagY--;
                            }

                            try {
                                if (countSpaces(matrix[rightY][rightX],
                                        matrix[downY][downX],
                                        matrix[diagY][diagX])
                                        <= spotsNeeded - spots) {
                                    usedSpot = true;
                                    spots += countSpaces(matrix[rightY][rightX],
                                        matrix[downY][downX],
                                        matrix[diagY][diagX]);
                                    matrix[rightY][rightX] = true;
                                    matrix[downY][downX] = true;
                                    matrix[diagY][diagX] = true;
                                }
                            } catch (ArrayIndexOutOfBoundsException ex) {
                            }
                        }
                    if (!usedSpot) {
                        break;
                    } else if (spots == spotsNeeded) {
                        possible = true;
                        grid = createGrid(matrix);
                        break;
                    }
                }
            }

            if (possible) {
                out.write("Case #" + i + ":" + "\n" + grid);
            } else {
                out.write("Case #" + i + ":\n" + "Impossible" + "\n");
            }
        }

        out.close();
        in.close();
    }

    private static int countSpaces(boolean one, boolean two, boolean three) {
        int count = 0;
        if (!one) {
            count++;
        }
        if (!two) {
            count++;
        }
        if (!three) {
            count++;
        }
        return count;
    }

    private static String createGrid(boolean[][] matrix) {
        String grid = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                if (i == 0 && k == 0) {
                    grid += "c";
                } else if (matrix[i][k]) {
                    grid += ".";
                } else {
                    grid += "*";
                }
            }
            grid += "\n";
        }

        return grid;
    }
}
