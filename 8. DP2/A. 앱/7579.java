package A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int dp[], m[], c[];
	static int cost = 100;
	static int N, M, sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		m = new int[101];
		c = new int[101];
		dp = new int[10001];
		String mem[] = br.readLine().split(" ");
		String cos[] = br.readLine().split(" ");
		for(int i = 1; i <= N; i++)
		{
			m[i] = Integer.parseInt(mem[i-1]);
			c[i] = Integer.parseInt(cos[i-1]);
			sum += c[i];
		}
		for(int i =1; i <= N; i++)
		{
			for(int j = sum; j > c[i]; j--)
			{
				dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
			}
		}
		for(int i = 1; i <= sum && dp[i] < M;  i++)
		{
			cost = i;
		}
		bw.write(cost + "\n");
		bw.flush();
		bw.close();
	}
}
