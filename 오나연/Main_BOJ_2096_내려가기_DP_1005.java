package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 41840 KB
  시간 : 368 ms
*/
public class Main_BOJ_2096_내려가기_DP_1005 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][][] arr = new int[2][2][3];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<3; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[0][0][i] = tmp;
			arr[1][0][i] = tmp;
		}
		
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				int current = Integer.parseInt(st.nextToken());
				int pre = j-1;
				int post = j+1;
				
				int minTmp = arr[0][(i-1)%2][j] + current;
				int maxTmp = arr[1][(i-1)%2][j] + current;
				if(pre>=0) {
					minTmp = (arr[0][(i-1)%2][pre] + current < minTmp)? arr[0][(i-1)%2][pre] + current: minTmp;
					maxTmp = (arr[1][(i-1)%2][pre] + current > maxTmp)? arr[1][(i-1)%2][pre] + current: maxTmp;					
				}
				if(post<3) {
					minTmp = (arr[0][(i-1)%2][post] + current < minTmp)? arr[0][(i-1)%2][post] + current: minTmp;
					maxTmp = (arr[1][(i-1)%2][post] + current > maxTmp)? arr[1][(i-1)%2][post] + current: maxTmp;					
				} 
				arr[0][i%2][j] = minTmp;
				arr[1][i%2][j] = maxTmp;
			}
		}
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i=0; i<3; i++) {
			if(arr[0][(N-1)%2][i] < min) min = arr[0][(N-1)%2][i];
			if(arr[1][(N-1)%2][i] > max) max = arr[1][(N-1)%2][i];
		}
		System.out.println(max + " " + min);
	}
}