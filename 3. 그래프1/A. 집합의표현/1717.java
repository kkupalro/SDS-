package A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int find(int num)
	{
		if(parent[num] == num)
			return num;
		else
			return parent[num] = find(parent[num]);
	}
	static void union(int a, int b)
	{
		a = find(a);
		b = find(b);
		if(a != b)
			parent[b] = a;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // ������ ũ��
		int m = Integer.parseInt(st.nextToken()); // ���� �Է� ����
		parent = new int[n + 1];
		for(int i = 0; i <= n; i++)
		{
			parent[i] = i;
		}
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(br.readLine(), " ");
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0)
			{
				//��ħ
				union(a, b);
			}
			else if(command == 1)
			{
				//ã��
				a = find(a);
				b = find(b);
				if(a == b)
				{
					bw.write("YES\n");
				}
				else if(a != b)
				{
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
}