package om9d30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_벽부수고이동하기 {
	static int N,M;
	static int[][] field, cost;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        cost = new int[N][M];
        for(int i = 0; i < N; i++) {
        	String tmp = br.readLine();
        	for(int j = 0 ; j < M; j++) {
        		field[i][j] = tmp.charAt(j) - '0';
        		cost[i][j] = 1000001;
        	}
        }
        bfs();
//        for(int i = 0; i < N; i++) {
//        	for(int j = 0 ; j < M; j++) {
//        		System.out.print(cost[i][j] + " ");
//        	}
//        	System.out.println();
//        }
        
	}
	public static void bfs() {
		int[] dy = new int[] {-1,1,0,0};
		int[] dx = new int[] {0,0,-1,1};
		boolean[][][] visited = new boolean[N][M][2];
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {0,0,0});
		cost[0][0] = 1;
		visited[0][0][0]=true;
		visited[0][0][1]=true;
		while(!que.isEmpty()) {
			int[] p = que.poll();
			int r = p[0];
			int c = p[1];
			int k = p[2];
			if(r==N-1 && c ==M-1) {
				System.out.println(cost[r][c]);
			}
			for(int d = 0; d < 4; d++) {
				int rr = r + dy[d];
				int cc = c + dx[d];
				if(rr<0 ||cc<0||rr>=N||cc>=M||k+field[rr][cc] >= 2 ||visited[rr][cc][k+field[rr][cc]])continue;
				visited[rr][cc][k+field[rr][cc]] = true;;
				cost[rr][cc] = cost[r][c] + 1;
				que.add(new int[] {rr,cc,k+field[rr][cc]});
				
			}
		}
		System.out.println("-1");
	}
}
