package D;

import java.io.*;
import java.util.*;

class node implements Comparable<node> {
	int to; int cost;
	node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
	@Override
	public int compareTo(node target) {
		return this.cost < target.cost?-1:1;
	}
}

public class Main {
	static int N, M, K;
	static final int INF = Integer.MAX_VALUE; 
	static ArrayList<node> adj[];
	static PriorityQueue<node> pq;
	static PriorityQueue<Integer> path[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		pq = new PriorityQueue<node>();
		path = new PriorityQueue[N+1];
		
		for(int i = 0; i <= N; i++)
		{
			adj[i] = new ArrayList<>();
			path[i] = new PriorityQueue<Integer>(new Comparator<Integer>() {
				@Override
				public int compare(Integer a, Integer b) {
					return a<b?1:-1;
				}
			});
			if(i== 1) path[1].add(0);
			else path[i].add(INF);
		}
		
		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new node(b, c));
		}
		pq.add(new node(1, 0)); // 출발 노드 부터 시작
		while(!pq.isEmpty())
		{
			node cur = pq.poll();
			for(int i = 0; i < adj[cur.to].size(); i++) // 연결된 노드 중
			{
				int to = adj[cur.to].get(i).to;
				int cost = cur.cost + adj[cur.to].get(i).cost;
				
				// 기존에 가진 값보다 좋은 경로가 있을 뿐만 아니라 가진 답안의 개수가 K개가
				// 되기전에는 좋은 경로가 아니더라도
				if(path[to].peek() > cost || path[to].size() < K)
				{
					path[to].offer(cost); // 가는데 드는 비용을 저장
					pq.add(new node(to, cost)); // 노드에 추가함
					while(path[to].size() > K) // 저장된 답안 많을 시 뺌
					{
						path[to].poll();
						
					}
				}
			}
		}
		for(int i = 1; i <= N; i++)
		{
			if(path[i].size() < K)
			{
				bw.write("-1\n");
			}
			else
			{
				bw.write(path[i].peek() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}

