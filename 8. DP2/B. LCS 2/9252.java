package B;

import java.io.*;
import java.util.Arrays;

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
		LCS = new String[s1 + 1][s2 + 1];
		for(int i = 0; i <= s1; i++)
		{
			Arrays.fill(LCS[i], "");
		}
		dp = new int[s1+1][s2+1];
		for(int i = 1; i <= s1; i++)
		{
			for(int j= 1; j <= s2; j++)
			{
				if(str[0].charAt(i-1) == str[1].charAt(j-1))
				{
					dp[i][j] = dp[i-1][j-1] + 1;
					LCS[i][j] += LCS[i-1][j-1] + str[0].charAt(i-1);
				}
				else 
				{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					if(LCS[i-1][j].length() > LCS[i][j-1].length())
					{
						LCS[i][j] = LCS[i-1][j];
					}
					else 
					{
						LCS[i][j] = LCS[i][j-1];
					}
				}
			}
		}
		bw.write(dp[s1][s2] + "\n" + LCS[s1][s2]);
		bw.flush();
		bw.close();
		br.close();
	}
}

