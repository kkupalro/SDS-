package B;

import java.io.*;
import java.util.*;

class edge implements Comparable<edge> {
	int from;
	int to;
	int cost;
	edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
	@Override
	public int compareTo(edge target) {
		if(this.cost < target.cost)
		{
			return -1;
		}
		else if(this.cost > target.cost)
		{
			return 1;
		}
		return 0;
	}
}


public class Main {
	static int matrix[][];
	static int n;
	static int[] parent;
	static ArrayList<edge> al;
	static int sum = 0;
	
	static int find(int num)
	{
		if(parent[num] == num)
			return num;
		else
			return parent[num] = find(parent[num]);
	}
	static void union(int from, int to)
	{
		from = find(from);
		to = find(to);
		if(from != to)
			parent[to] = from;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		int m = Integer.parseInt(br.readLine()); // 연결 가능 선
		matrix = new int[n][n];
		al = new ArrayList<edge>();
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			al.add(new edge(y, x, c));
		}
		
		Collections.sort(al);
		parent = new int[n];
		for(int i = 0; i < n; i++)
		{
			parent[i] = i;
		}
		
		for(int i = 0; i < m; i++)
		{
			edge e = al.get(i);
			if(find(e.from) == find(e.to)) continue;
			union(e.from, e.to);
			sum += e.cost;
			
		}
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
	}

}
