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
	static int[] dist; // ���� �������� ���� ���������� �Ÿ�
	static boolean[] visit; // �ش� ���� �湮 ����
	static int K; // ���� ��ȣ
	static ArrayList<node>[] al;
	static void solve() {
		PriorityQueue<node> pq = new PriorityQueue<node>();
		pq.offer(new node(K, 0));
		
		while(!pq.isEmpty())
		{
			node n = pq.poll(); // ť�� ����ִ� ���� �� ����ġ�� ������ ����  ������.
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
        int V = Integer.parseInt(st.nextToken()); // ������ ����
        int E = Integer.parseInt(st.nextToken()); // ������ ����
        st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken())-1; // ���� ����
        dist = new int[V];
        visit = new boolean[V];
        al = (ArrayList<node>[]) new ArrayList[V]; // �� ������ ����� ������ ����
        for(int i = 0; i < V; i++)
        {
        	dist[i] = INF; // ��� ������ �������� �ʱ�ȭ
        	al[i] = new ArrayList<node>();
        }
        dist[K] = 0; // ���� �������� �������������� �Ÿ��� 0
        
        for(int i = 0; i < E; i++)
        {
        	st = new StringTokenizer(br.readLine(), " ");
        	int u = Integer.parseInt(st.nextToken()) -1; // from
        	int v = Integer.parseInt(st.nextToken()) -1; // to
        	int w = Integer.parseInt(st.nextToken()); // ����ġ
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

