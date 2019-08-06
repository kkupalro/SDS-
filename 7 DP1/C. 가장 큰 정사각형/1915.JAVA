import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N; // [1 ~ 1000]
	static int M; // [1 ~ 1000]
	static int dp[][];
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		String input[] = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		dp = new int[N+1][M+1];
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			StringBuilder sb = new StringBuilder().append(st.nextToken());
			for(int j = 1; j <= M; j++)
			{
				dp[i][j] = Integer.parseInt(Character.toString(sb.charAt(j-1)));
			}
		}
		for(int i = 1; i <= N; i++)
		{
			for(int j = 1; j <= M; j++)
			{
				if(dp[i][j] >= 1)
				{
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;					
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		bw.write(result*result + "\n");
		bw.flush();
		bw.close();
	}
}
