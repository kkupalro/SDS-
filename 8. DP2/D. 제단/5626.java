package D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // [1 ~ 10000]
	static long dp[][]; // i 번쩨 높이가 h일때 가능한 경우의 수
	static long arr[];
	static final int MOD = 1000000007;
	static void swap(long a[], long b[]) {
		for(int i = 0; i <= N; i++)
		{
			dp[0][i] = b[i];
			dp[1][i] = a[i];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		arr = new long[N+1];
		dp = new long[2][N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++)
		{
			arr[i] = Long.parseLong(st.nextToken());
		}
		dp[0][0] = arr[1]<1?1:0; // 1보다 작을 경우 가능한 경우의수 1가지, else 0가지
		
		for(int i = 2; i <= N; i++)
		{
			Arrays.fill(dp[1], 0);
			if(arr[i] == -1)
			{
				dp[1][0] = (dp[0][0] + dp[0][1]) % MOD;
				for(int k = 1; k <= (N+1)/2; k++)
				{
					dp[1][k] = (dp[0][k-1] + dp[0][k] + dp[0][k+1]) % MOD;
				}
			}
			else if(arr[i] == 0)
			{
				dp[1][(int)arr[i]] = (dp[0][(int)arr[i]] + dp[0][(int) (arr[i]+1)]) % MOD;
			}
			else 
			{
				dp[1][(int)arr[i]] = (dp[0][(int)arr[i]-1] + dp[0][(int)arr[i]] + dp[0][(int)arr[i] + 1]) % MOD;
			}
			swap(dp[0], dp[1]);
		}
		bw.write(dp[0][0] + "\n");
		bw.flush();
		bw.close();
	}
}
