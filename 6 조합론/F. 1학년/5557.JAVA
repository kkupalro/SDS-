import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static long dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
        N = Integer.parseInt(br.readLine()); // N °³ÀÇ ¼ö
        int arr[] = new int[N];
        dp = new long[N+1][21];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
        {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][arr[0]] = 1;
        for(int i = 2; i < dp.length; i++)
        {
        	for(int j = 0; j < 21; j++)
        	{
        		if(dp[i-1][j] != 0)
        		{
        			if(j + arr[i-1] <= 20 && j + arr[i-1] >= 0)
        			{
        				dp[i][j + arr[i-1]] += dp[i-1][j];
        			}
        			if(j - arr[i-1] >= 0 &&  j - arr[i-1] <= 20)
        			{
        				dp[i][j - arr[i-1]] += dp[i-1][j];
        			}
        		}
        	}
        }
        bw.write(dp[N-1][arr[N-1]] + "\n");
        bw.close();
	}
}
