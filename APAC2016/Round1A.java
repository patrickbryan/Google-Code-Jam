package gcjapac2016;

import java.io.BufferedReader;

public class Round1A {

    static void solution(BufferedReader br) throws Exception {
        int testCaseNum = Integer.parseInt(br.readLine());
        char ans;

        for (int i = 1; i <= testCaseNum; i++) {
            long charPos = Long.parseLong(br.readLine());

            ans = googolChar(charPos, 0);

            System.out.println("Case #" + i + ": " + ans);
        }
    }

    static char googolChar(long cP, int revs) {
        char ans;
        if (isPowTwoOrOneOff(cP)) {
            if (cP % 2 == 0 || cP == 1) {
                ans = '0';
            } else {
                ans = '1';
            }
            if (revs % 2 == 1) {
                if (ans == '0') {
                    ans = '1';
                } else {
                    ans = '0';
                }
            }
        } else {
            long powDif = Math.abs(largestPowerOf2(cP) - cP) * 2;
            ans = googolChar(cP - powDif, revs+1);
        }

        return ans;
    }

    static boolean isPowTwoOrOneOff(long x) {
        boolean ans = (x != 0) && ((x & (x - 1)) == 0);
        if (!ans) {
            x = x + 1;
            ans = (x != 0) && ((x & (x - 1)) == 0);
        }
        return ans;
    }

    static long largestPowerOf2(long n) {
        return Long.highestOneBit(n-1);
    }
}
