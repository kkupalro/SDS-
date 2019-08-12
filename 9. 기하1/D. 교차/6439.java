package D;

import java.io.*;
import java.util.*;

class Point {
	long x; long y;
	Point(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static long temp;
	static Point P[];
	static Point Rect[];
	static long CCW(long ax, long ay, long bx, long by, long ex, long ey) {
		if((ax*by + bx*ey + ex*ay) - (ay*bx + by*ex + ey*ax) > 0)
		{
			return 1;
		}
		else if((ax*by + bx*ey + ex*ay) - (ay*bx + by*ex + ey*ax) < 0)  
		{
			return -1;
		}
		return 0; 
	}
	static boolean check(long ax, long ay, long bx, long by, long cx, long cy, long dx, long dy) {
		long ccwA = CCW(ax, ay, bx, by, cx, cy) * CCW(ax, ay, bx, by, dx, dy);
		long ccwB = CCW(cx, cy, dx, dy, ax, ay) * CCW(cx, cy, dx, dy, bx, by);
		if(ccwA == 0 && ccwB == 0)
		{
			if(cx == dx)
			{
				// ���η� ������ x��ǥ�� ����
				if(Math.max(ay, by) < Math.min(cy, dy) || Math.max(cy, dy) < Math.min(ay, by))
				{
					return false;
				}
			}
			else if(cy == dy)
			{
				// ���η� ������ y ��ǥ�� ����
				if(Math.max(ax, bx) < Math.min(cx, dx) || Math.max(cx,  dx) < Math.min(ax, bx))
				{
					return false;
				}
			}
			
		}
		return (ccwA <= 0 && ccwB <= 0);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0)
		{
			// �Է°� : ����  s(x, y), d(x, y) �� ���簢�� ������ s(x, y) ,���� d(x, y)
			P = new Point[2];
			Rect = new Point[2];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i< 2; i++)
			{
				P[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			}
			for(int i = 0; i< 2; i++)
			{
				Rect[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
			}
			// ���� ��ǥ ����
			if(P[0].x < P[1].x)
			{
				temp = P[0].x;
				P[0].x = P[1].x;
				P[1].x = temp;
				temp = P[0].y;
				P[0].y = P[1].y;
				P[1].y = temp;
			}
			// �簢�� ��ǥ ����
			if(Rect[0].x > Rect[1].x)
			{
				temp = Rect[0].x;
				Rect[0].x = Rect[1].x;
				Rect[1].x = temp;
			}
			if(Rect[0].y < Rect[1].y)
			{
				temp = Rect[0].y;
				Rect[0].y = Rect[1].y;
				Rect[1].y = temp;
			}
			//   0 0 1 1    0 0 1 1
			//(p)x y x y (R)x y x y
 			//   a b c d    e f g h
			// ������ �簢�� ����
			if((Rect[0].x <= P[0].x && P[0].x <= Rect[1].x && Rect[1].y <= P[0].y && P[0].y <= Rect[0].y) || (Rect[0].x <= P[1].x && P[1].x <= Rect[1].x && Rect[1].y <= P[1].y && P[1].y <= Rect[0].y))
			{
				bw.write("T\n");
			}
			else 
			{
				boolean flag = false;
				//   0 0 1 1    0 0 1 1
				//(p)x y x y (R)x y x y
	 			//   a b c d    e f g h
				if(check(P[0].x, P[0].y, P[1].x, P[1].y, Rect[0].x, Rect[0].y, Rect[1].x, Rect[0].y))
				{
					flag = true;
				}
				if(check(P[0].x, P[0].y, P[1].x, P[1].y, Rect[0].x, Rect[0].y, Rect[0].x, Rect[1].y))
				{
					flag = true;
				}
				if(check(P[0].x, P[0].y, P[1].x, P[1].y, Rect[0].x, Rect[1].y, Rect[1].x, Rect[1].y))
				{
					flag = true;
				}
				if(check(P[0].x, P[0].y, P[1].x, P[1].y, Rect[1].x, Rect[1].y, Rect[1].x, Rect[0].y))
				{
					flag = true;
				}
				if(flag)
				{
					bw.write("T\n");
				}
				else if(!flag) {
					bw.write("F\n");
				}
			}
			bw.flush();
		}
		bw.close();
	}
}
