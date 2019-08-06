import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	static final int MOD = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int W = Integer.parseInt(input[0]);
		int H = Integer.parseInt(input[1]);
		int dp[][][] = new int[200][200][2];
		dp[1][1][1] = 1;
		dp[1][1][0] = 1;
		
		for(int i = 1; i <= W; i++)
		{
			for(int j = 1; j <= H; j++)
			{
				
				int now = dp[i][j][0] % MOD;
				dp[i+1][j][0] += now;
				dp[i+1][j+1][1] += now;
				
				now = dp[i][j][1] % MOD;
				dp[i][j+1][1] += now;
				dp[i+1][j+1][0] += now;
				
				dp[i][j][0] %= MOD;
				dp[i][j][1] %= MOD;
			}
		}
        bw.write((dp[W][H][0] + dp[W][H][1]) % MOD + "\n");
        bw.close();
	}
}

