package G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	// 같은 지점 + 1, 반대편 + 2, 중앙
	static int arr[];
	static int dp[][][];
	static final int INF = Integer.MAX_VALUE;
	static int calc(int from, int to)
	{
		if(from == 0)
		{
			return 2;
		}
		else if(from == to)
		{
			return 1;
		}
		else if(Math.abs(from - to) == 2)
		{
			return 4;
		}
		return 3;
	}
	static int solve(int l, int r, int i){
	    if(i == N) return 0;
	    if(dp[l][r][i] != INF) return dp[l][r][i];
	    int left = solve(arr[i], r, i + 1) + calc(l, arr[i]);
	    int right = solve(l, arr[i], i + 1) + calc(r, arr[i]);
	    return dp[l][r][i] = Math.min(left,right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		dp = new int[5][5][1000001]; // L, R, i번
		String s[] = br.readLine().split(" ");
		arr = new int[s.length];
		for(int i = 0; i < s.length-1; i++)
		{
			arr[i] = Integer.parseInt(s[i]);
		}

		N = s.length-1; // 4
		for(int i = 0; i <= N; i++)
		{
			for(int l = 0; l <= 4; l++)
			{
				for(int r= 0; r <= 4; r++)
				{
					dp[l][r][i] = INF;
				}
			}
		}
		
		System.out.println(solve(0, 0, 0));
	}
}
