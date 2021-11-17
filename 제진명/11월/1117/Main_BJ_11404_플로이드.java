import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 		2021. 11. 17
 * 		mem: 43216KB		time: 356
 */

public class Main_BJ_11404_플로이드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int INF = 987654321;
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int [][] matrix = new int [V+1][V+1];
		
		for (int i = 0 ; i <= V ; i++) {
			Arrays.fill(matrix[i], INF);
		}
		
		for (int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			matrix[start][end] = Math.min(matrix[start][end], weight);
		}
		
		for (int k = 1 ; k <= V ; k++) {
			for (int i = 1 ; i <= V ; i++) {
				if (i == k) continue;
				for (int j = 1 ; j <= V ; j++) {
					if (i == j || j == k) continue;
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
		
		for (int i = 1 ; i <= V ; i++) {
			for (int j = 1; j <= V ; j++) {
				if (matrix[i][j] == INF) sb.append(0+" ");
				else sb.append(matrix[i][j]+" ");				
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		
	}
}
