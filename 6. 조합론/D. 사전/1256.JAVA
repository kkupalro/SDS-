import java.io.*;
import java.util.*;

public class Main {
	static int N; // ~100
	static int M; // ~100
	static int K; // ÃÖ´ë 10¾ï
	static StringBuilder result;
	static int dp[][];
	static final int DIV = 1000000000;
	static void calc()
	{
		for (int i = 0; i < 201; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (dp[i-1][j] > DIV || dp[i-1][j-1] > DIV ) {
                        dp[i][j] = 1000000001;
                    }else if((dp[i-1][j] + dp[i-1][j-1]) > DIV) {
                        dp[i][j] = 1000000001;
                    }else {
                        dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                    } 
                }
            }
        }
	}
	static void solve(int LENGTH, int NM)
	{
		if(dp[NM][N] < K) {
            result.append("-1");
        }else {
            for (int i = 0; i < LENGTH; i++) {
                if (N <= 0) {
                    result.append("z");
                    continue;
                }

                if (dp[NM-1][N-1] >= K) {
                    result.append("a");
                    N--;
                }else {
                    result.append("z");
                    K = (int) (K - dp[NM-1][N-1]);
                    M--;
                }
                NM--;
            }
        }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[201][201];
        calc();
        int LENGTH = N + M;
        int NM = N+M;
        result = new StringBuilder();
        solve(LENGTH, NM);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
	}
}
