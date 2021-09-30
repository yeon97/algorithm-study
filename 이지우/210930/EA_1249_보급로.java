package om9d30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class EA_1249_보급로 {
	static class Point implements Comparable<Point>{
		int r,c,w;
		public Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
		
	}
	static int N;
	static int[][] field;
	static int[][] cost;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			field = new int[N][N];
			cost = new int[N][N];
			for(int i = 0 ; i < N; i++) {
				char[] tmp = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					field[i][j] = tmp[j] - '0';
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			sb.append("#" + t + " " + bfs() + "\n");
			
		}
		System.out.print(sb);
	}
	public static int bfs() {
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,-1,1};
		PriorityQueue<Point> pque = new PriorityQueue<>();
		pque.add(new Point(0,0,field[0][0]));
		cost[0][0] = 0;
		while(!pque.isEmpty()) {
			Point p = pque.poll();
			for(int d = 0; d < 4; d++) {
				int rr = p.r+dy[d];
				int cc = p.c+dx[d];
				if(rr < 0 || cc < 0 || rr >= N || cc >= N)continue;
				if(cost[rr][cc] > cost[p.r][p.c] + p.w) {
					cost[rr][cc] = cost[p.r][p.c] + p.w;
					pque.add(new Point(rr,cc,field[rr][cc]));
				}
			}
		}
		
		return cost[N-1][N-1];
	}
}
