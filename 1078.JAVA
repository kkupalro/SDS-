import java.io.*;
import java.util.*;


class Point {
	long x; long y;
	public Point(long x, long y) {
		this.x = x;
		this.y= y;
	}
}

public class Main {
	static long min_y = Long.MAX_VALUE;
	static long min_x = Long.MAX_VALUE;
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
	static long dist(long ax, long ay, long bx, long by) {
		return (bx - ax) * (bx - ax) + (by - ay) * ( by - ay);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		ArrayList<Point> A = new ArrayList<Point>();
		
		for(int i = 1; i <= N; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			long x  = Long.parseLong(st.nextToken());
			long y  = Long.parseLong(st.nextToken());
			
			if(y < min_y)
			{
				min_y = y;
				min_x = x;
			} else if(y == min_y)
			{
				if(x < min_x)
				{
					min_y = y;
					min_x = x;
				}
			}
			A.add(new Point(x, y));
		}
		
		Collections.sort(A, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				long res = CCW(min_x, min_y, p1.x, p1.y, p2.x, p2.y);
				if(res > 0) return -1;
				else if(res < 0) return 1;
				
				long a = dist(min_x, min_y, p1.x, p1.y);
				long b = dist(min_x, min_y, p2.x, p2.y);
				
				if(a < b) return -1;
				else if(a > b) return 1;
				return 0;
			}
		});
		A.add(new Point(min_x, min_y));
		Point xy2 = null, xy1 = null, next = null;
		Stack<Point> s = new Stack<Point>();
		s.push(A.get(0));
		s.push(A.get(1));
		for(int i = 2; i < N; i++)
		{
			while(s.size() >= 2)
			{
				next = A.get(i);
				xy2 = s.pop();
				xy1 = s.peek();
				if (CCW(xy1.x, xy1.y, xy2.x, xy2.y, next.x, next.y) > 0){
					s.push(xy2);
					break;
				} 
			}
			s.push(next);
		}
		bw.write(s.size()+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
