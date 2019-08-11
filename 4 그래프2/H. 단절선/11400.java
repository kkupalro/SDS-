package H;

import java.io.*;
import java.util.*;

class edge implements Comparable<edge> {
	int a; int b; int bridge;
	edge(int a, int b, int bridge) {
		this.a = a;
		this.b = b;
		this.bridge = bridge;
	}
	@Override
	public int compareTo(edge target) {
		if(this.a == target.a)
		{
			if(this.b < target.b)
			{
				return -1;
			}
			else
				return 1;
		}
		else if(this.a < target.a)
		{
			return -1;
		}
		return this.a - target.a;
	}
}

class info {
	int node; int eidx;
	info(int node, int eidx)
	{
		this.node = node;
		this.eidx = eidx;
	}
}
public class Main {
	static ArrayList<info> adj[] = new ArrayList[1000001];
	static edge M[] = new edge[1000001];
	static int v[] = new int[1000001];
	static int vcnt, V, E;
	static int DFS(int node, int parent) {
		v[node] = ++vcnt;
		int ret = v[node];
		for(int i = 0; i < adj[node].size(); i++)
		{
			int nnode = adj[node].get(i).node;
			int idx = adj[node].get(i).eidx; 
			if(parent == nnode) continue;
			if(v[nnode] == -1)
			{
				int low = DFS(nnode, node);
				if(v[node] < low)
				{
					M[idx].bridge = 1;
				}
				ret = Math.min(ret, low);
			}
			else 
				ret = Math.min(ret, v[nnode]);
		}
		return ret;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i = 0; i <= V; i++) {
			v[i] = -1;
			adj[i] = new ArrayList<info>();
		}
		for(int i = 0; i < E; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a < b) M[i] = new edge(a, b, 0);
			else M[i] = new edge(b, a, 0);
		}
		Arrays.sort(M, 0, E);
		for(int i = 0; i < E; i++)
		{
			adj[M[i].a].add(new info(M[i].b, i));
			adj[M[i].b].add(new info(M[i].a, i));
		}
		for(int i = 1; i <= V; i++)
		{
			if(v[i] == -1)
			{
				DFS(i, -1);
			}
		}
		int bcnt = 0;
		for(int i = 0; i < E; i++)
		{
			if(M[i].bridge == 1)
				bcnt++;
		}
		bw.write(bcnt + "\n");
		for(int i = 0; i < E; i++)
		{
			if(M[i].bridge == 1)
			{
				bw.write(M[i].a + " " + M[i].b + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
