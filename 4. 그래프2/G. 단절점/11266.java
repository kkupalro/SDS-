package G;

import java.io.*;
import java.util.*;

public class Main {
	static int V, E;
	static ArrayList<Integer> adj[] = new ArrayList[10001];
	static int v[] = new int[10001];
	static int ans[] = new int[10001];
	static int vcnt;
	static int DFS(int node, int parent) {
		v[node] = ++vcnt;   // 몇번째로 호출된 dfs 인지 저장
	    int ret = v[node];
	    int child_cnt=0;
	    for(int i=0,nnode;i<adj[node].size();i++)
	    {
	        nnode = adj[node].get(i);   // 연결된 노드들 중에서
	        if(nnode == parent) continue;
	        if(v[nnode] == -1)      // 방문안한 노드는 dfs 재귀호출
	        {
	            int low = DFS(nnode,node);
	            if(parent != - 1 && v[node] <= low) // 루트가 아니고 현재노드를거치지않고 더 빠른 방문순서를 가진 노드로 갈수없으면 단절점으로 체크
	                ans[node]=1;
	            ret = Math.min(ret, low);
	            child_cnt++;
	        }
	        else            // 방문했던 노드는 현재노드 방문순서랑 가지고있던 방문순서중 작은값 리턴
	        {
	        	ret = Math.min(ret, v[nnode]);
	        }
	    }
	    if(parent == -1 && child_cnt>1) ans[node]=1;    // 루트거나 자식이2개이상이면 단절점으로 체크
	    return ret;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i = 0; i<= V; i++)
		{
			v[i] = -1;
			ans[i]=0;
	        adj[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < E; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		vcnt = 0;
		for(int n = 1; n <= V; n++)
		{
			if(v[n] == -1)
			{
				DFS(n, -1);
			}
		}
		int acnt = 0;
		for(int n = 1; n <= V; n++)
		{
			if(ans[n] == 1)
			{
				acnt++;
			}
		}
		bw.write(acnt + "\n");
		for(int n = 1; n <= V; n++)
		{
			if(ans[n] == 1)
			{
				bw.write(n + " ");
			}
		}
		bw.flush();
		bw.close();
	}
}
