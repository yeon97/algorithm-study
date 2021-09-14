package om9d14;

import java.util.Scanner;

public class EA_5215_햄버거다이어트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i = 1; i <= TC; i++) {
			int N = sc.nextInt();
			int max = sc.nextInt();
			
			int[] flavor = new int[N+1];
			int[] calory = new int[N+1];
			for(int j = 1; j <= N; j++) {
				flavor[j] = sc.nextInt();
				calory[j] = sc.nextInt();
			}
			
			
			int[][] cal = new int[N+1][max+1];
			for(int j = 1; j <= N; j++) {
				for(int c = 1; c <= max; c++) {
					if(c >= calory[j])
					cal[j][c] = Math.max(cal[j-1][c], flavor[j] + cal[j-1][c - calory[j]]);
					else cal[j][c] = cal[j-1][c];
				}
			}
			System.out.println("#" + i + " " + cal[N][max]);
			
		}

	}

}
