package om8d30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class EA_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[][] field = new int[N][N];
		for(int t = 1; t <= TC; t++){
			
			int answer = 0;
			for(int i = 0 ; i < N/2 ; i ++){
				String str = br.readLine();
				for(int j = N/2 - i ; j <= N/2 + i; j++){
					answer+=str.charAt(j)-'0';
				}
			}
			for(int i = N/2 ; i < N ; i ++){
				String str = br.readLine();
				for(int j = i- N/2 ; j < N - i + N/2; j++){
					answer+=str.charAt(j)-'0';
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
