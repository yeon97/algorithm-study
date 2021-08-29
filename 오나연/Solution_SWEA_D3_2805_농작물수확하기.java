package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA_D3_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=testCase; tc++) {
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			int answer = 0;
			int half = size/2;
			
			for(int i=0; i<size; i++) {
				String str = br.readLine();
				for(int j=0; j<size; j++) {
					farm[i][j] = str.charAt(j)-'0';
				}
			} // 농장 상태 초기화
			
			for(int i=0; i<(size+1)/2; i++) {
				for(int j=half; j<size-half; j++) {
					answer += farm[i][j];
				}
				half--;
			}
			half += 2;
			
			for(int i=(size+1)/2; i<size; i++) {
				for(int j=half; j<size-half; j++) {
					answer += farm[i][j];
				}
				half++;
			}
			System.out.println("#" + tc + " " + answer);
		} // testCase
	}
}