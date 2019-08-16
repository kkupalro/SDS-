package B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Integer> q = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스
		while(N-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken().toString()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(q.isEmpty()) bw.write("-1\n");
				else bw.write(q.poll() + "\n");
				bw.flush();
				break;
			case "size":
				bw.write(q.size() + "\n");
				bw.flush();
				break;
			case "empty":
				if(q.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
				bw.flush();
				break;
			case "front":
				if(q.isEmpty()) bw.write("-1\n");
				else bw.write(q.peek() + "\n");
				bw.flush();
				break;
			case "back":
				if(q.isEmpty()) bw.write("-1\n");
				else
				{
					Iterator<Integer> it = q.iterator();
					while(it.hasNext())
					{
						result = it.next();
					}
					bw.write(result + "\n");
				}
				bw.flush();
				break;
			default:
				break;
			}
		}
	}
}
