package D;

import java.io.*;
import java.util.*;

public class Main {
	static long num[] = new long[1000001];
	static long tree[] = new long[3000000];
	static void update(int n, int s, int e, int t, int diff)
	{
		if(s <= t && t <= e)
		{
			tree[n] += diff;
		}
		else return;
		if(s == e) return;
		int m = (s + e) / 2;
		update(n * 2, s, m, t, diff);
		update(n * 2 + 1, m + 1, e, t, diff);
	}
	static long sum(int l, int r, int n, int s, int e)
	{
		if(l <= s && e <= r) return tree[n];
		if(r < s || e < l) return 0;
		int m = (s + e) / 2;
		return sum(l, r, n * 2, s, m) + sum(l, r, n * 2 + 1, m + 1, e);
	}
	static long init(int n, int s, int e)
	{
		if(s == e) return tree[n] = num[s];
		int m = (s + e) / 2;
		tree[n] = init(n * 2, s, m) + init(n * 2 + 1, m + 1, e);
		return tree[n];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= N; i++)
        {
        	num[i] = Integer.parseInt(br.readLine());
        }
        init(1, 1, N);
        for(int i = 0; i < M + K; i++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	if(a == 1)
        	{
        		int diff = (int)(c - num[b]);
        		num[b] = c;
        		update(1, 1, N, b, diff);
        	}
        	else bw.write(sum(b, c, 1, 1, N) + "\n");
        }
        bw.flush();
        bw.close();
	}
}
