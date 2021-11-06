import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_10163_색종이 {
	static class colorPaper {
		int x,y,w,h; // (x, y)는 제일 오른쪽 위 좌표

		public colorPaper(int x, int y, int w, int h) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[1001][1001];
		
		for(int i = 0 ; i < 1001; i++) {
			Arrays.fill(map[i], 0);
		}
		
		
		Stack<colorPaper> cp = new Stack<>();
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int x, y, w, h;
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			cp.push(new colorPaper(x, y, w, h));
			
			for(int j = x ; j < x+w ; j++) {
				for (int k = y ; k < y+h ; k++ ) {
					map[j][k] = 1;
				}
			}
		}
		
		Stack<Integer> ans = new Stack<>();
		
		int cnt;
		while(!cp.isEmpty()) {
			colorPaper c = cp.pop();
			cnt = 0;
			for (int i = c.x ; i < c.x+c.w; i++) {
				for (int j = c.y; j < c.y+c.h ;j++) {
					if(map[i][j] == 1) {
						cnt++;
						map[i][j]= 0;
					}
				}
			}
			ans.push(cnt);
		}
		while(!ans.isEmpty()) {
			System.out.println(ans.pop());
		}
	}
}
