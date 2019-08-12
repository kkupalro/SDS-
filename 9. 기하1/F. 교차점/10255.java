package F;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Point {
	long x; long y;
	public Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int T, result;
	static int ans;
	static boolean check = false;
	static Point r[], p[]; // 점, 사각형
	static long CCW(long ax, long ay, long bx, long by, long ex, long ey) {
		long temp = (ax*by + bx*ey + ex*ay) - (ay*bx + by*ex + ey*ax); 
		if(temp > 0)
		{
			return 1;
		}
		else if(temp < 0)  
		{
			return -1;
		}
		else return 0; 
	}
	static boolean intersect(long ax, long ay, long bx, long by, long cx, long cy, long dx, long dy) {
		if(CCW(ax, ay, bx, by, cx, cy) == CCW(ax, ay, bx, by, dx, dy)) 
		{
			return false;
		}
		if(CCW(cx, cy, dx, dy, ax, ay) == CCW(cx, cy, dx, dy, bx, by))
		{
			return false;
		}
		return true;
	}
	static boolean chk(long st, long en, long d, long u) {
		if (u > st && d < st)return true;
		if (u > en && d < en)return true;
		if (u <= en && d >= st)return true;
		if (u >= en && d <= st)return true;
		return false;
	}
	static boolean diagonal(long ax, long by, long cx, long cy, long dx, long dy) {
		if((dx - cx) * (by - cy) == (dy - cy) * (ax - cx))
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			r = new Point[2];
			p = new Point[2];
			for(int i = 0; i < 2; i++)
			{
				r[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 2; i++)
			{
				p[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			}
			
			boolean flag = false;
			if(p[0].x == p[1].x)
			{
				if(chk(r[0].y, r[1].y, Math.min(p[0].y, p[1].y), Math.max(p[0].y, p[1].y)))
				{
					if(p[0].x == r[0].x || p[0].x == r[1].x)
					{
						bw.write("4\n");
						flag = true;
					}
				}
				else if(r[0].y == p[0].y || r[0].y == p[1].y || r[1].y == p[0].y || r[1].y == p[1].y)
				{
					bw.write("1\n");
					flag = true;
				}
			}
			else if(p[0].y == p[1].y)
			{
				if(chk(r[0].x, r[1].x, Math.min(p[0].x, p[1].x), Math.max(p[0].x, p[1].x)))
				{
					if(p[0].y == r[0].y || p[0].y == r[1].y)
					{
						bw.write("4\n");
						flag = true;
					}
				}
				else if(r[1].x == p[0].x || r[0].x == p[1].x || r[1].x == p[0].x || r[1].x == p[1].x)
				{
					bw.write("1\n");
					flag = true;
				}
			}
			if(!flag)
			{
				int cnt = 0;
				if(intersect(r[0].x, r[0].y, r[0].x, r[1].y, p[0].x, p[0].y, p[1].x, p[1].y))
				{
					if(!diagonal(r[0].x, r[0].y, p[0].x, p[0].y, p[1].x, p[1].y))
					{
						cnt++;	
					}
				}
				if(intersect(r[0].x, r[0].y, r[1].x, r[0].y, p[0].x, p[0].y, p[1].x, p[1].y))
				{
					if(!diagonal(r[1].x, r[0].y, p[0].x, p[0].y, p[1].x, p[1].y))
					{
						cnt++;	
					}
				}
				if(intersect(r[0].x, r[1].y, r[1].x, r[1].y, p[0].x, p[0].y, p[1].x, p[1].y))
				{
					if(!diagonal(r[0].x, r[1].y, p[0].x, p[0].y, p[1].x, p[1].y))
					{
						cnt++;	
					}
				}
				if(intersect(r[1].x, r[0].y, r[1].x, r[1].y, p[0].x, p[0].y, p[1].x, p[1].y))
				{
					if(!diagonal(r[1].x, r[1].y, p[0].x, p[0].y, p[1].x, p[1].y))
					{
						cnt++;	
					}
				}
				bw.write(cnt + "\n");
			}
			bw.flush();
		}
		bw.close();
	}
}