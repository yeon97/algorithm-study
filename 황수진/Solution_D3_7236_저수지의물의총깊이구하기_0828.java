import java.util.Scanner;

public class Solution_D3_7236_저수지의물의총깊이구하기_0828 {

	static int N;
	static char arr[][];
	
	// 8방향 탐색
	static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();	
			arr = new char[N][N];
			
			int sum = 0; // 한 점에서의 깊이
			int res = Integer.MIN_VALUE; // 결과

			// 데이터 입력
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 'W') { // 물이면 cal 메서드 호출
						sum = cal(i, j);
						res = (sum > res)? sum : res;
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
		}
		
		
		sc.close();	
	}

	private static int cal(int x, int y) {
		int tmpSum = 0;
		
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < N) {
				if(arr[nx][ny] == 'W')
					tmpSum++;
			}
		}
		
		// 주변이 다 땅이면 깊이 1
		return (tmpSum == 0)? 1 : tmpSum;
		
	}
}
