package F;

import java.io.*;
import java.util.*;

public class Main {
	static final int KMAX = 17;
	static int N, M, a, b;
	static LinkedList<Integer> adj[] = new LinkedList[100001];
	static int depth[] = new int[100001];
	static int parent[][] = new int[KMAX + 1][100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // N까지의 트리
		// 초기화
		for(int i = 0; i <= N; i++)
		{
			depth[i] = -1;
		}
		for(int i = 0; i <= 100000; i++)
		{
			adj[i] = new LinkedList<>();
		}
		// 양방향 그래프
		for(int i = 1; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			adj[a].offer(b);
			adj[b].offer(a);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		depth[1] = 0;
		parent[0][1] = 0;
		q.offer(1);
		while(!q.isEmpty()) // bfs 통해서 노드별 depth 값, 부모노드 파악
		{
			int cur = q.poll();
			for(int i = 0; i < adj[cur].size(); i++) // 연결된 노드들 중
			{
				int node = adj[cur].get(i);
				if(depth[node] == -1) // 방문안한 노드는
				{
					depth[node] = depth[cur] + 1; // 이전 노드의 depth값 + 1
					parent[0][node] = cur;
					q.offer(node);
				}
			}
		}
		for(int k = 1; k <= KMAX; k++)
		{
			for(int n = 1; n <= N; n++)
			{
				// 기존 정보를 가지고 2의 제곱번째 조상 노드 정보 파악
				parent[k][n] = parent[k-1][parent[k-1][n]];
			}
		}
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(depth[a] > depth[b]) 
			{
				int tmp = a;
				a = b;
				b = tmp;
			}
			for(int k = KMAX; k >= 0; k--)
			{
				if(depth[a] <= depth[parent[k][b]])
				{
					b = parent[k][b];
				}
			}
			for(int k = KMAX; k >= 0 && a != b; k--)
			{
				if(parent[k][a] != parent[k][b])
				{
					a = parent[k][a];
					b = parent[k][b];
				}
			}
			int lca = a;
			if(a != b)
			{
				lca = parent[0][lca];
			}
			bw.write(lca + "\n");
		}
		bw.flush();
		bw.close();
	}
}
