import java.io.*;
import java.util.*;

public class Main {
	static int N; // [1 ~ 500]
	static int dp[][];
	static int d[][];
	static final int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		dp = new int[501][501];
		d = new int[501][2];
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			d[i][0] = Integer.parseInt(st.nextToken()); // r
			d[i][1] = Integer.parseInt(st.nextToken()); // c
		}
		for(int i = 1; i <= N-1; i++)
		{
			dp[i][i + 1] = d[i][0] * d[i][1] * d[i + 1][1];
		}
		for(int i = 2; i <= N; i++)
		{
			for(int j = 1; j <= N-i; j++)
			{
				int m = i + j;
				dp[j][m] = INF;
				for(int k = j; k < m; k++)
				{
					dp[j][m] = Math.min(dp[j][m], dp[j][k] + dp[k + 1][m] + d[j][0] * d[k][1] * d[m][1]);
				}
			}
		}
		bw.write(dp[1][N] + "\n");
		bw.flush();
		bw.close();
	}
}
