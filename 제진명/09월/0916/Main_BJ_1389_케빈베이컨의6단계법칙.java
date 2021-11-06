import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1389_케빈베이컨의6단계법칙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int [N][N];
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			arr[x][y] = 1; arr[y][x] = 1;
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if (arr[i][j] != 1 && i != j) arr[i][j] = N*N;
			}
		}
		
		for (int k = 0 ; k < N ; k++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		int ans = 0;
		int temp = Integer.MAX_VALUE;
		for (int i = 0 ; i < N ; i++) {
			int sum = 0;
			for (int j = 0 ; j < N ; j++) {
				sum += arr[i][j];
			}
			if (temp > sum) {
				temp = sum;
				ans = i;
			}
		}
		
		System.out.println(ans+1);
	}
}
