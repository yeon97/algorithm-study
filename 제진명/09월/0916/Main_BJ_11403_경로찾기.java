import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11403_경로찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int [N][N];
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N ; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 0) arr[i][j] = N*N;
				else arr[i][j] = n;
			}
		}
		
		for (int k = 0 ; k < N ; k++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if(arr[i][j] == N*N) System.out.print(0+" ");
				else System.out.print(1+" ");
			}
			System.out.println();
		}
	}
}
