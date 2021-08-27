import java.util.Scanner;

public class Main_BJ_10163_색종이_0827 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 색종이 개수
		int arr[][] = new int[1001][1001]; // 평면
		int res[] = new int[N+1]; // 각 색종이 별 면적
		
		for(int t = 1; t <= N; t++) {
			int x = sc.nextInt(); // x좌표
			int y = sc.nextInt(); // y좌표
			int w = sc.nextInt(); // 너비
			int h = sc.nextInt(); // 높이

			// 색종이 크기만큼 돌면서 평면 채우기
			for (int i = x; i < x+w ; i++) {
				for (int j = y; j < y+h; j++) {
					arr[i][j] = t;
				}
			}
		}
		
		// 색종이 별로 면적 세기
		for(int i = 0; i < 1001; i++) {
			for(int x1: arr[i]) 
				res[x1]++;
		}
		
		// 결과 출력
		for(int i = 1; i <= N; i++) {
			System.out.println(res[i]);
		}
		
		sc.close();
	} // end main

} // end class
