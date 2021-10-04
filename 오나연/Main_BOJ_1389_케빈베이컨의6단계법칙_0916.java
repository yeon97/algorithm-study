package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1389_케빈베이컨의6단계법칙_0916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] D = new int[N][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			D[x-1][y-1] = 1;
			D[y-1][x-1] = 1;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				D[i][j] = (i!=j && D[i][j]==0) ? 1000: D[i][j];
			}
		}

		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				if(k==i) continue;
				for(int j=0; j<N; j++) {
					if(k==j || i==j) continue;
					D[i][j] = (D[i][j] > D[i][k] + D[k][j]) ? D[i][k] + D[k][j]: D[i][j];
				}				
			}
		}
		
		int min = Integer.MAX_VALUE;
		int idx = 0;
		for(int i=0; i<N; i++) {
			int tmp = 0;
			for(int j=0; j<N; j++) {
				tmp += D[i][j];
			}
			if(min>tmp) {
				min = tmp;
				idx = i+1;
			}
		}
		System.out.println(idx);
	}
}