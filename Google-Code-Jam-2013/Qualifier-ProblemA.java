package q1;

import java.io.*;

/**
 *
 * @author Patrick
 */
public class Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter("test.out"));
        BufferedReader in = new BufferedReader(new FileReader("A-small-attempt1.in"));
        boolean isDraw, isWinner;
        int testCases = 0;
        String line;
        String board[] = new String[4];
        char winner;
        
        //StringBuilder sb = new StringBuilder();
        line = in.readLine();
        testCases = Integer.parseInt(line);

        for (int i = 1; i <= testCases; i++)
        {
            isDraw = true;
            isWinner = false;
            line = in.readLine();
            board[0] = line;
            line = in.readLine();
            board[1] = line;
            line = in.readLine();
            board[2] = line;
            line = in.readLine();
            board[3] = line;
            
            if (board[0].indexOf(".") != -1) {
                isDraw = false;
            }
            else if (board[1].indexOf(".") != -1) {
                isDraw = false;
            }
            else if (board[2].indexOf(".") != -1) {
                isDraw = false;
            }
            else if (board[3].indexOf(".") != -1) {
                isDraw = false;
            }
            
            winner = horzCheck(board);
            if (winner != '.')
            {
                out.write("Case #" + i + ": " + winner + " won\n");
                isWinner = true;
            }
            winner = vertCheck(board);
            if (!isWinner && winner != '.')
            {
                out.write("Case #" + i + ": " + winner + " won\n");
                isWinner = true;
            }
            winner = diagCheck(board);
            if (!isWinner && winner != '.')
            {
                out.write("Case #" + i + ": " + winner + " won\n");
                isWinner = true;
            }
            if (!isWinner && isDraw == true)
            {
                out.write("Case #" + i + ": Draw\n");
            }
            else if (!isWinner && isDraw == false)
            {
                out.write("Case #" + i + ": Game has not completed\n");
            }
            
            line = in.readLine();
        }
        
        out.close();
        in.close();
    }
    
    public static char horzCheck(String board[])
    {
        char player;
        
        for (int i = 0; i < 4; i++)
        {
            player = board[i].charAt(0);
            if (player == 'T')
            {
                player = board[i].charAt(1);
            }
            if (player != '.')
            {
                if ((board[i].charAt(1) == player || board[i].charAt(1) == 'T') && 
                    (board[i].charAt(2) == player || board[i].charAt(2) == 'T') &&
                    (board[i].charAt(3) == player || board[i].charAt(3) == 'T'))
                {
                    return player;
                }
            }
        }
        
        return '.';
    }
    
    public static char vertCheck(String board[])
    {
        char player;
        
        for (int i = 0; i < 4; i++)
        {
            player = board[0].charAt(i);
            if (player == 'T')
            {
                player = board[1].charAt(i);
            }
            if (player != '.')
            {
                if ((board[1].charAt(i) == player || board[1].charAt(i) == 'T') && 
                    (board[2].charAt(i) == player || board[2].charAt(i) == 'T') &&
                    (board[3].charAt(i) == player || board[3].charAt(i) == 'T'))
                {
                    return player;
                }
            }
        }
        
        return '.';
    }
    
    public static char diagCheck(String board[])
    {
        char player;
        
        player = board[0].charAt(0);
        if (player == 'T')
        {
            player = board[1].charAt(1);
        }
        if (player != '.')
        {
            if ((board[1].charAt(1) == player || board[1].charAt(1) == 'T') &&
                (board[2].charAt(2) == player || board[2].charAt(2) == 'T') &&
                (board[3].charAt(3) == player || board[3].charAt(3) == 'T'))
            {
                return player;
            }
        }
        
        player = board[0].charAt(3);
        if (player == 'T')
        {
            player = board[1].charAt(2);
        }
        if (player != '.')
        {
            if ((board[1].charAt(2) == player || board[1].charAt(2) == 'T') &&
                (board[2].charAt(1) == player || board[2].charAt(1) == 'T') &&
                (board[3].charAt(0) == player || board[3].charAt(0) == 'T'))
            {
                return player;
            }
        }
        
        return '.';
    }
}
