package F;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static long solve(int n) 
	{
		// dp 이용한 방법
		if(n == 0)
		{
			return 0;
		}
		long dp[] = new long[n+1];
		dp[1] = 1;
		for(int i = 2; i <= n; i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(Long.toString(solve(Integer.parseInt(br.readLine()))) + "\n");
		bw.flush();
		bw.close();
	}
}
