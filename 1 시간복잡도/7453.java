package D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int lower_bound(int left, int right, int key, int array[])
	{
		while(left < right)
		{
			int mid = (left + right) / 2;
			if(key > array[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}
		return right;
	}
	static int upper_bound(int left, int right, int key, int array[])
	{
		while(left < right)
		{
			int mid = (left + right) / 2;
			if(key >= array[mid])
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}
		return right;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기
		int a[] = new int[N];
		int b[] = new int[N];
		int c[] = new int[N];
		int d[] = new int[N];
		// 입력값 저장
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		// 부분합 저장
		int ab[] = new int[N*N];
		int cd[] = new int[N*N];
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				ab[N * i + j] = a[i] + b[j];
				cd[N * i + j] = -(c[i] + d[j]);
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);
		int left = 0;
		int right = N * N;
		long result = 0;
		for(int i = 0; i < N*N; i++)
		{
			int low = lower_bound(left, right, ab[i], cd);
			int high = upper_bound(left, right, ab[i], cd);
			result += (long)(high - low);
		}
		bw.write(Long.toString(result) + "\n");
		bw.flush();
		bw.close();
	}
}

