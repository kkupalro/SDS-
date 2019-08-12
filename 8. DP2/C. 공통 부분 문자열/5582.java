package C;

import java.io.*;

public class Main {
	static int s1, s2;
	static String LCS[][];
	static int dp[][];
	static String str[] = new String[2];
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	str[0] = br.readLine();
	str[1] = br.readLine();
	s1 = str[0].length();
	s2 = str[1].length();
	dp = new int[s1+1][s2+1];
	for(int i = 1; i <= s1; i++)
	{
		for(int j= 1; j <= s2; j++)
		{
			if(str[0].charAt(i-1) == str[1].charAt(j-1))
			{
				dp[i][j] = dp[i-1][j-1] + 1;
				
			}
		}
	}
	int MAX = 0;
	for(int i = 1; i<= s1; i++)
	{
		for(int j = 1; j <= s2; j++)
		{
			MAX = Math.max(MAX, dp[i][j]);
		}
	}
	bw.write(MAX + "\n");
	bw.flush();
	bw.close();
	}
}
