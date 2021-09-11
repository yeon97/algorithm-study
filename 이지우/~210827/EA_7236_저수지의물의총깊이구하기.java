package om8d27;

import java.io.*;
import java.util.StringTokenizer;

public class EA_7236_저수지의물의총깊이구하기 {
	static int N;
	static char[][] field;
	//12시부터 시계방향으로 방향 배열생성
	static int[] dirY = new int[]{-1,-1,0,1,1,1,0,-1};
	static int[] dirX = new int[]{0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int t=1;t<=TC;t++) {
			N=Integer.parseInt(br.readLine());
			field= new char[N][N];
			for(int i = 0 ; i< N ; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N ; j++){
					field[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int Max = 1;
			for(int i = 0 ; i< N ; i++){
				for(int j= 0 ; j < N ; j++){
					if(field[i][j] == 'W'){
						Max = Math.max(sol(i,j), Max);
					}
				}
			}
			System.out.println("#"+t+" "+ Max);
		}
    }
	public static int sol(int y, int x){
		int dir = -1;
		int cnt = 0;
		while(dir++ < 7 && dirY[dir]+y >= 0 && dirY[dir]+y < N && dirX[dir]+x >= 0 && dirX[dir]+x < N ){
			if(field[dirY[dir]+y][dirX[dir]+x] == 'W'){
				cnt++;
			}
		}
		return cnt;
	}
}