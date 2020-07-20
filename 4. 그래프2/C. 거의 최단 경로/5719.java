package C;

import java.io.*;
import java.util.*;

class edge implements Comparable<edge> {
	int cost; int here;
	edge(int cost, int here)
	{
		this.cost = cost;
		this.here = here;
	}
	@Override
	public int compareTo(edge target) {
		return this.cost - target.cost;
	}
}

public class Main {
	static int a[][] = new int[502][502];
	static int dp[] = new int[502];
	static int N, M, S, D;
	static void dijkstra() {
		Arrays.fill(dp, -1);
		PriorityQueue<edge> pq = new PriorityQueue<edge>();
		pq.offer(new edge(0, S));
		while(!pq.isEmpty())
		{
			edge e = pq.poll();
			int here = e.here;
			int cost = e.cost;
			if(dp[here] != -1) continue;
			dp[here] = cost;
			for(int i = 0; i < N; i++)
			{
				if(a[here][i] == -1) continue;
				if(dp[i] != -1) continue;
				pq.offer(new edge(cost + a[here][i], i));
			}
		}
	}
	static void eraseEdge() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(D);
		while(!q.isEmpty())
		{
			int cx = q.poll();
			for(int i = 0; i < N; i++)
			{
				if(dp[cx] == dp[i] + a[i][cx] && a[i][cx] != -1) 
				{
					a[i][cx] = -1;
					q.offer(i);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		while(N != 0 && M != 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			for (int arr[] : a) {
				Arrays.fill(arr, -1);
			}
			for(int i = 0; i < M; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				a[x][y] = z;
			}
			dijkstra();
			eraseEdge();
			dijkstra();
			bw.write(dp[D] + "\n");
			bw.flush();
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		}
		bw.close();
	}
}