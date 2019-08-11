package F;

import java.io.*;
import java.util.*;

class edge {
	int fx; int fy; int tx; int ty; int cost;
	
	edge(int fx, int fy, int tx, int ty, int cost) {
		this.fx = fx;
		this.fy = fy;
		this.tx = tx;
		this.ty = ty;
		this.cost = cost;
	}
}
public class Main {
	static int W,H,G,E;
	static int map[][] = new int[31][31];
	static int D[][] = new int[31][31];
	static edge M[] = new edge[30*30*5];
	static final int dx[] = {-1, 1, 0, 0};
	static final int dy[] = { 0, 0,-1, 1};
	static final int INF = 10000*30*30+1;
	static int ecnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		while(true)
		{
			st = new StringTokenizer(br.readLine(), " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W==0 && H == 0) break;
			for(int r = 0; r < H; r++)
			{
				for(int c = 0; c < W; c++)
				{
					D[r][c] = INF;
					map[r][c] = 0;
				}
			}
			G = Integer.parseInt(br.readLine());
			for(int i = 0; i < G; i++)
			{
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = -1;
			}
			ecnt = 0;
			E = Integer.parseInt(br.readLine());
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				M[ecnt++] = new edge(x1, y1, x2, y2, t);
				map[y1][x1] = -2;
			}
			map[H-1][W-1] = -2;
			for(int y = 0; y < H; y++)
			{
				for(int x = 0; x < W; x++)
				{
					if(map[y][x] == 0)
					{
						for(int k = 0; k < 4; k++)
						{
							int nx = x + dx[k];
							int ny = y + dy[k];
							if(nx < 0 || ny < 0 || nx == W || ny == H) continue;
							if(map[ny][nx] == -1) continue;
							M[ecnt++] = new edge(x, y, nx, ny, 1);
						}
					}
				}
			}
			D[0][0] = 0;
			// 벨만포드 알고리즘
			for(int v = 0; v < W*H-G; v++) {
				for(int e = 0; e < ecnt; e++) {
					if(D[M[e].fy][M[e].fx] != INF && D[M[e].ty][M[e].tx] > D[M[e].fy][M[e].fx] + M[e].cost)
					{
						D[M[e].ty][M[e].tx] = D[M[e].fy][M[e].fx] + M[e].cost;
					}
				}
			}
			boolean cycle = false;
			for(int e = 0; e < ecnt; e++)
			{
				if(D[M[e].fy][M[e].fx] != INF && D[M[e].ty][M[e].tx] > D[M[e].fy][M[e].fx] + M[e].cost)
				{
					cycle = true;
					break;
				}
			}
			if(cycle)
			{
				bw.write("Never\n");
			}
			else if(D[H-1][W-1] == INF)
			{
				bw.write("Impossible\n");
			}
			else
			{
				bw.write(D[H-1][W-1] + "\n");
			}
			bw.flush();
		}
		bw.close();
	}
}
