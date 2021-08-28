package om8d26;

import java.io.*;
import java.util.*;

public class BJ_10163_색종이 {
	static class Paper{
		int x,y,width,height,num;

		public Paper(int x, int y, int width, int height, int num) {
			super();
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.num = num;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int [][] field = new int[1001][1001];
		Paper[] pp = new Paper[N];
		
		for(int i = 1 ; i <= N; i ++){
			st = new StringTokenizer(in.readLine());
			pp[i-1]= new Paper(Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()),
								Integer.parseInt(st.nextToken()), i);
		}//종이 생성 완료
		
		for(int i = 0; i < N ; i ++){ // 덮기 시작
			Paper p = pp[i];
			for(int x = p.x; x < p.x+p.width; x++){
				for(int y = p.y; y < p.y+p.height; y++){
					field[y][x] = p.num;
				}
			}
		}//다 덮었음
		
		int[] count = new int[N+1];
		for(int i = 0 ; i < 1001; i++){
			for(int j = 0; j < 1001; j ++){
				count[field[i][j]]++;
			}
		}
		for(int a = 1; a <= N; a++){
			System.out.println(count[a]);
		}
	}

}
