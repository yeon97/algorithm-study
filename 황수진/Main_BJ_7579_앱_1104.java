import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 메모리 : 20432KB
 시간 : 184ms
 */

public class Main_BJ_7579_앱_1104 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[101];
		int[] c = new int[101];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		

		int matrix[][] = new int[101][10001];
		int res = Integer.MAX_VALUE;

		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j <= 10000; j++) {
				if (c[i] <= j)
					matrix[i][j] = Math.max(matrix[i - 1][j], m[i] + matrix[i - 1][j - c[i]]);
				else {
					matrix[i][j] = matrix[i - 1][j];
				}

				if (matrix[i][j] >= M)
					res = Math.min(res, j);
			}
		}
		System.out.println(res);
	}
}