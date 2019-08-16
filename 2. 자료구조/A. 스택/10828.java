package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		StringTokenizer st;
		Stack<Integer> s = new Stack<Integer>();
		while(T-- > 0)
		{
			st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("push"))
			{
				int data = Integer.parseInt(st.nextToken());
				s.push(data);
			}
			else if(str.equals("top"))
			{
				if(s.isEmpty())
				{
					System.out.printf("%d\n", -1);
				}
				else 
				{
					System.out.printf("%d\n", s.peek());
				}
			}
			else if(str.equals("size"))
			{
				System.out.printf("%d\n", s.size());
			}
			else if(str.equals("empty"))
			{
				if(s.isEmpty())
				{
					System.out.printf("%d\n", 1);
				}
				else if(!s.isEmpty())
				{
					System.out.printf("%d\n", 0);
				}
			}
			else if(str.equals("pop"))
			{
				if(s.isEmpty())
				{
					System.out.printf("%d\n", -1);
				}
				else if(!s.isEmpty())
				{
					System.out.printf("%d\n", s.pop());
				}
			}
			
		}
		br.close();
	}

}