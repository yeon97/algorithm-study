package jinmyeong.Aug2021.algo0827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_JO_1037_오류교정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int [][] matrix = new int [n][n];
		
		int [] row = new int[n];
		int [] col = new int[n];
		
		for (int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < n ; j++) {
				int val = Integer.parseInt(st.nextToken());
				matrix[i][j] = val;
				row[i] += val;
				col[j] += val;
			}
		}
		
		int ck = 0;
		int x = 0, y = 0;
		
		for (int i = 0 ; i < n ; i++) {
			if (col[i] % 2 == 0) {
				continue;
			} else {
				for (int j = 0 ; j < n ; j++) {
					if(row[j] %2 != 0) {
						col[i] += 1;
						row[j] += 1;
						x = j+1;
						y = i+1;
						ck += 1;
					}
				}
				if (ck != 1) {
					System.out.println("Corrupt");
					return;
				}
			}
		}
		
		if (ck == 0) System.out.println("OK");
		else System.out.println("Change bit ("+x+","+y+")");
		
	}
}
