package C;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
    static int M;
    static ArrayList<Integer>[] al;
    static boolean[] visit;
    static Stack<Integer> s;
    
    static void solve(int check){
        visit[check] = true;
        for(int i = 0; i < al[check].size(); i++){
            int next = al[check].get(i);
            if(!visit[next])
            {
            	solve(next);
            }
        }
        s.push(check);
    }
    @SuppressWarnings("unchecked")
	public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        al = new ArrayList[N];
        visit = new boolean[N];
        s = new Stack<Integer>();
        for(int i = 0; i < N; i++){
            al[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            al[from].add(to);
        }
        for(int i = 0; i < N; i++){
            if(!visit[i])
            {
            	solve(i);
            }
        }
        while(!s.isEmpty()){
        	bw.write(s.pop() + 1 + " ");
        }
        bw.flush();
        bw.close();
    }
}