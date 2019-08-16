package G;

import java.io.*;
import java.util.*;

public class Main {
	static final int KMAX = 17;
	static final int INF = 1000001;
	static int N, K;
	static LinkedList<Integer> adj[] = new LinkedList[100001];
	static LinkedList<Integer> adjv[] = new LinkedList[100001];
	static int depth[] = new int[100001];
	static int parent[][] = new int[KMAX + 1][100001]; 
	static int minLen[][] = new int[KMAX + 1][100001]; 
	static int maxLen[][] = new int[KMAX + 1][100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); // N까지의 트리
		// 초기화
		for(int i = 0; i <= 100000; i++)
		{
			adj[i] = new LinkedList<>();
			adjv[i] = new LinkedList<>();
		}
		for(int i = 0; i <= N; i++)
		{
			depth[i] = -1;
			for(int k = 0; k <= KMAX; k++)
			{
				parent[k][i] = 0;
				minLen[k][i] = INF;
				maxLen[k][i] = -1;
			}
		}
		for(int i = 1; i < N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].offer(b);
			adjv[a].offer(c);
			adj[b].offer(a);
			adjv[b].offer(c);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		depth[1] = 0;
		q.offer(1);
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i = 0; i < adj[cur].size(); i++)
			{
				int n = adj[cur].get(i);
				int c = adjv[cur].get(i);
				if(depth[n] == -1)
				{
					depth[n] = depth[cur] + 1;
					parent[0][n] = cur;
					minLen[0][n] = c;
					maxLen[0][n] = c;
					q.offer(n);
				}
			}
		}
		for(int k = 1; k <= KMAX; k++)
		{
			for(int n = 1; n <= N; n++)
			{
				// 2^k 번째 조상 노드 파악할때, 동시에 2^k 번째 경로상에서 최소, 최대 도로길이를 저장한후 수행.
				parent[k][n] = parent[k-1][parent[k-1][n]];
				minLen[k][n] = Math.min(minLen[k-1][n], minLen[k-1][parent[k-1][n]]);
				maxLen[k][n] = Math.max(maxLen[k-1][n], maxLen[k-1][parent[k-1][n]]);
			}
		}
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());		
			int minL = INF;
			int maxL = -1;
			if(depth[d] > depth[e])
			{
				int tmp = d;
				d = e;
				e = tmp;
			}
			for(int k = KMAX; k >= 0; k--)
			{
				// e노드를 d노드에 가깝게 가면서 경로상의 최소, 최대 도로길이를 파악
				if(depth[d] <= depth[parent[k][e]])
				{
					minL = Math.min(minL, minLen[k][e]);
					maxL = Math.max(maxL, maxLen[k][e]);
					e = parent[k][e];
				}
			}
			for(int k = KMAX; k >= 0 && d != e; k--)
			{
				// 같은 depth에서 부터 같은 조상을 만나기까지 최소, 최대 도로길이를 파악
				if(parent[k][d] != parent[k][e])
				{
					minL = Math.min(minL, minLen[k][d]);
					minL = Math.min(minL, minLen[k][e]);
					maxL = Math.max(maxL, maxLen[k][d]);
					maxL = Math.max(maxL, maxLen[k][e]);
					d = parent[k][d];
					e = parent[k][e];
				}
			}
			if(d != e)
			{
				// 본인들 값까지는 계산이 안되서 계산 추가
				minL = Math.min(minL, minLen[0][d]);
				minL = Math.min(minL, minLen[0][e]);
				maxL = Math.max(maxL, maxLen[0][d]);
				maxL = Math.max(maxL, maxLen[0][e]);
			}
			bw.write(minL + " " + maxL + "\n");
		}
		bw.flush();
		bw.close();
	}
}
