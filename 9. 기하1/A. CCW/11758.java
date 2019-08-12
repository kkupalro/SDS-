import java.io.*;
import java.util.*;

public class Main {
	static int CCW(int ax, int ay, int bx, int by, int cx, int cy) {
		if((ax*by + bx*cy + cx*ay) - (ay*bx + by*cx + cy*ax) > 0)
		{
			return 1;
		}
		else if((ax*by + bx*cy + cx*ay) - (ay*bx + by*cx + cy*ax) < 0)  
		{
			return -1;
		}
		return 0;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		int ax = Integer.parseInt(st.nextToken());
		int ay = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int bx = Integer.parseInt(st.nextToken());
		int by = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		bw.write(CCW(ax,ay,bx,by,cx,cy) + "\n");
		bw.flush();
		bw.close();
	}
}
