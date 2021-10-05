package zm10d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BJ_1043_거짓말 {
	static int[] parents, judge;
	static int N,M;
	static ArrayList<Integer>[] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int knt = Integer.parseInt(st.nextToken());
		judge = new int[knt];
		for(int i = 0 ; i < knt; i++) {
			judge[i] = Integer.parseInt(st.nextToken());
		}
		party = new ArrayList[M];
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<>();
			for(int j = 0 ; j < cnt ; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		make();
		for(int i = 0 ; i < M; i++) {
			for(int j = 0 ; j < party[i].size()-1; j++){
				int tmpA = party[i].get(j);
				int tmpB = party[i].get(j+1);
				union(tmpA, tmpB);
			}
		}
		int answer = 0;
		loop:
		for(int i = 0 ; i < M; i++) {
			for(int j = 0 ; j < party[i].size(); j++){
				if(check(find(party[i].get(j)))){
					continue loop;
				}
			}
			answer++;
		}
		System.out.println(answer);
	}
	public static boolean check(int a) {
		for(int i = 0 ; i < judge.length; i++) {
			if(find(judge[i]) == a) {
				return true;
			}
		}
		return false;
	}
	public static void make() {
		parents = new int[N+1];
		for(int i = 1 ; i <= N; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	public static void union(int a, int b) {
		int A = find(a); int B = find(b);
		if( A == B)return;
		parents[A] = B;
		return;
	}
}
