package E;

import java.io.*;
import java.util.*;

public class Main {
	static int dp[][];
	static int N;
	static final int INF = Integer.MAX_VALUE;
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		dp = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i <= N; i++)
		{
			for(int j = i- 1; j > 0; j--)
			{
				dp[j][i] = INF;
				for(int k = j; k< i; k++)
				{
					dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k+1][i] + (arr[j]==arr[k+1]?0:1));
				}
			}
		}
		bw.write(dp[1][N] + "\n");
		bw.flush();
		bw.close();
	}
}

