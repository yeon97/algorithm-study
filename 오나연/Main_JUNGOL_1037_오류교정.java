package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JUNGOL_1037_오류교정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] message = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				message[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int noRow = 0;  // 짝수 안되는 행의 개수
		int rowNum = 0;  // 짝수 안되는 행의 인덱스
		for(int i=0; i<n; i++) {
			int row = 0;
			for(int j=0; j<n; j++) {
				if(message[i][j] == 1) row++;
			}
			if(row % 2 != 0) {
				noRow++;
				rowNum = i; 
			}
		}  // 행 검사
		
		int noCol = 0;  // 짝수 안되는 열의 개수
		int colNum = 0;  // 짝수 안되는 열의 인덱스
		for(int i=0; i<n; i++) {
			int col = 0;
			for(int j=0; j<n; j++) {
				if(message[j][i] == 1) col++;
			}
			if(col % 2 != 0) {
				noCol++;
				colNum = i; 
			}
		}  // 열 검사
		
		if(noCol == 0 && noRow == 0) {
			System.out.println("OK");
		} else if(noCol == 1 && noRow == 1) {
			System.out.println("Change bit (" + (rowNum+1) +","+ (colNum+1) + ")");
		} else {
			System.out.println("Corrupt");
		}
	}
}