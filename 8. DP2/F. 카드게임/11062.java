package F;

import java.io.*;
import java.util.*;

public class Main {
	static int T;
	static int N; // [1 ~ 1000]
	static int dp[][];
	static int arr[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			N = Integer.parseInt(br.readLine());
			arr = new int[N+1];
			dp = new int[N+1][N+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++)
			{
				dp[i][i] = Integer.parseInt(st.nextToken());  
				arr[i] = dp[i][i] + arr[i-1];
			}
			for(int k = 1; k <= N-1; k++)
			{
				for(int i = 1; i <= N-k; i++)
				{
					dp[i][k+i] = arr[k+i] - arr[i-1] - Math.min(dp[i][k+i-1], dp[i+1][k+i]);
				}
			}
			bw.write(dp[1][N] +"\n");
			bw.flush();
		}
		bw.close();
	}
}