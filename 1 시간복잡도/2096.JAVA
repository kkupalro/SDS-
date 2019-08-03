package G;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int min[][] = new int[2][4];
		int max[][] = new int[2][4];
		st = new StringTokenizer(br.readLine(), " ");
		// 시작줄 저장 dp 이용
		for(int i = 1; i <= 3; i++)
		{
			min[0][i] = Integer.parseInt(st.nextToken());
			max[0][i] = min[0][i];
		}
		for(int i = 2; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 1열
			int b = Integer.parseInt(st.nextToken()); // 2열
			int c = Integer.parseInt(st.nextToken()); // 3열
			// 최소
			min[1][1] =  a + Math.min(min[0][1], min[0][2]);
			min[1][2] =  b + Math.min(min[0][1], Math.min(min[0][2], min[0][3]));
			min[1][3] =  c + Math.min(min[0][2], min[0][3]);
			min[0][1] = min[1][1];
			min[0][2] = min[1][2];
			min[0][3] = min[1][3];
			// 최대
			max[1][1] = a + Math.max(max[0][1], max[0][2]);
			max[1][2] = b + Math.max(max[0][1], Math.max(max[0][2], max[0][3]));
			max[1][3] = c + Math.max(max[0][2], max[0][3]);
			max[0][1] = max[1][1];
			max[0][2] = max[1][2];
			max[0][3] = max[1][3];
		}
		bw.write(Math.max(max[0][1], Math.max(max[0][2], max[0][3])) + " " + Math.min(min[0][1], Math.min(min[0][2], min[0][3])) + "\n");
		bw.flush();
		bw.close();		
	}
}
