// 반례 못찾음 

import java.util.Arrays;
import java.util.Scanner;

public class Main_JUNGOL_1037_오류교정_0828 {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

	
		int x = 0;
		int y = 0;
		int cntX = 0;
		int cntY = 0;
		for (int i = 0; i < N; i++) {
			int sumX = 0;
			int sumY = 0;
			for (int j = 0; j < N; j++) {
				sumX += arr[i][j];
				sumY += arr[j][i];
			}
			if (sumX % 2 != 0) {
				cntX++;
				x = i;
			}
			if (sumY % 2 != 0) {
				cntY++;
				y = i;
			}

		}

		if (cntX == 0 && cntY == 0) {
			System.out.println("OK");
		} else if (cntX == 1 && cntY == 1) {
			System.out.println("Change bit (" + (x + 1) + ", " + (y + 1) + ")");
		} else {
			System.out.println("Corrupt");
		}

		sc.close();
	}
}
