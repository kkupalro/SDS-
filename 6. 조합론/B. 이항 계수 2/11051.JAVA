import java.io.*;
import java.util.*;

public class Main {
	static final int div = 10007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // ÆÄ½ºÄ®ÀÇ »ï°¢Çü
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // N(C)K
        long dp[][] = new long[N+1][];
        for(int i = 0; i <= N; i++)
        {
        	dp[i] = new long[i+1];
        	dp[i][0] = 1;
        	dp[i][i] = 1;
        }
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 1; j < dp[i].length-1; j++)
        	{
        		dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % div;
        	}
        }
        bw.write(dp[N][K] + "\n");
        bw.flush();
        bw.close();
	}
}

