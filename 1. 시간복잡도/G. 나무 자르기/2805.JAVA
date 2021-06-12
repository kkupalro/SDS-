package C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, matrix[];
	static boolean solve(int mid) {
		long sum = 0; // int 범위 초과할수 있음.
		for(int i = 1; i <= N; i++)
		{
			if(matrix[i] > mid)
			{
				sum += matrix[i] - mid;
			}
		}
		if(sum >= M)
		{
			return true;
		}
		else return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 나무의 수
		M = Integer.parseInt(st.nextToken()); // 나무의 길이
		st = new StringTokenizer(br.readLine(), " ");
		matrix = new int[N+1];
		for(int i = 1; i <= N; i++)
		{
			matrix[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(matrix);
		int left = 1;
		int right = matrix[N];
		int mid = 0;
		int result = 0;
		while(left <= right)
		{
			mid = (left + right) / 2;
			if(solve(mid))
			{
				left = mid+1;
				result = mid;
			}
			else {
				right = mid-1;
			}
		}
		bw.write(Long.toString(result) + "\n");
		bw.flush();
		bw.close();
	}

}
