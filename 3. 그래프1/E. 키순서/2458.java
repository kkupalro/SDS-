package E;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int m = Integer.parseInt(st.nextToken()); // 비교 횟수
		int matrix[][] = new int[n][n];
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			matrix[y][x] = 1;
		}
		for(int k = 0; k < n; k++)
		{
			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					if(matrix[i][k] == 1 && matrix[k][j] == 1)
					{
						matrix[i][j] = 1;
					}
				}
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++)
		{
			int cnt = 0;
			for(int j = 0; j < n; j++)
			{
				if(i!=j)
				{
					cnt += matrix[i][j] + matrix[j][i];
				}
			}
			if(cnt == n-1)
			{
				result++;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
	}

}
