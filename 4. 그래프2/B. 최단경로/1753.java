package B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class node implements Comparable<node>{
	int v; int w;
	node(int v, int w)
	{
		this.v = v;
		this.w = w;
	}
	@Override
	public int compareTo(node target) {
		return this.w - target.w;
	}
}

public class Main {
	static int INF = 2147483647;
	static int[] dist; // 시작 정점에서 목적 정점까지의 거리
	static boolean[] visit; // 해당 정점 방문 여부
	static int K; // 시작 번호
	static ArrayList<node>[] al;
	static void solve() {
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.offer(new node(K, 0));
		
		while(!pq.isEmpty())
		{
			node n = pq.poll(); // 큐에 들어있는 간선 중 가중치가 낮은것 부터  가져옴.
			if(visit[n.v]) continue;
			visit[n.v] = true;
			for(node t : al[n.v]) {
				if(!visit[t.v])
				{
					dist[t.v] = Math.min(dist[t.v], dist[n.v] + t.w);
					pq.offer(new node(t.v, dist[t.v]));
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int E = Integer.parseInt(st.nextToken()); // 간선의 갯수
        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken())-1; // 시작 정점
        dist = new int[V];
        visit = new boolean[V];
        al = (ArrayList<node>[]) new ArrayList[V]; // 각 정점의 연결된 간선을 저장
        for(int i = 0; i < V; i++)
        {
        	dist[i] = INF; // 모든 정점은 무한으로 초기화
        	al[i] = new ArrayList<node>();
        }
        dist[K] = 0; // 시작 정점에서 시작정점까지의 거리는 0
        
        for(int i = 0; i < E; i++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
        	int u = Integer.parseInt(st.nextToken()) -1; // from
        	int v = Integer.parseInt(st.nextToken()) -1; // to
        	int w = Integer.parseInt(st.nextToken()); // 가중치
        	al[u].add(new node(v, w));
        }
        solve();
        for(int i = 0; i < V; i++)
        {
        	if(dist[i] == INF)
        	{
        		bw.write("INF\n");
        	}
        	else
        	{
        		bw.write(dist[i] + "\n");
        	}
        }
        bw.flush();
        bw.close();
	}
}

