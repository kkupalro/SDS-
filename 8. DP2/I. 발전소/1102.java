package I;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dp;
    private static final int SIZE = 1 << 16;
    private static final int MAX = (int) 1e9 + 1;
    private static int P;
    private static int N;
    private static int[][] E;
    private static String onOff;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine().trim());

        E = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 1; j <= N; j++) {
                E[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[SIZE][2];
        for (int i = 0; i < SIZE; i++) {
            dp[i][0] = MAX;
        }
        onOff = br.readLine().trim();
        int index = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (onOff.charAt(N - i) == 'Y') {
                index <<= 1;
                index += 1;
                cnt++;
            } else
                index <<= 1;
        }
        P = Integer.parseInt(br.readLine().trim());
        if (P == 0 || cnt >= P) {
            System.out.println(0);
            return;
        }
        if (cnt == 0) {
            System.out.println(-1);
            return;
        }
        dp[index][0] = 0;
        dp[index][1] = cnt;
        for (int i = 0; i < (1 << N); i++) {
            if (dp[i][0] == MAX)
                continue;
            for (int j = 1; j <= N; j++) {
                if ((i & (1 << (j - 1))) != 0) {
                    for (int k = 1; k <= N; k++) {
                        if ((i & (1 << (k - 1))) == 0) {
                            if (dp[i][0] + E[j][k] < dp[i + (1 << (k - 1))][0]) {
                                dp[i + (1 << (k - 1))][0] = dp[i][0] + E[j][k];
                                dp[i + (1 << (k - 1))][1] = dp[i][1] + 1;
                            }
                        }
                    }
                }
            }
        }
        int ans = MAX;
        for (int i = 0; i < (1 << N); i++) {
            if (dp[i][1] >= P) {
                if (dp[i][0] < ans)
                    ans = dp[i][0];
            }
        }
        System.out.println(ans);
    }
}
