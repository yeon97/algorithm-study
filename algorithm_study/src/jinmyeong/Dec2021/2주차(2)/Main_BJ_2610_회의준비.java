
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 	mem: 16456KB	time: 204ms
 */

public class Main_BJ_2610_회의준비 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N+1][N+1];
		
		for (int  i = 1 ; i <= N ; i++) {
			for (int j = 1 ; j <= N ; j++) {
				if (i == j) continue;
				else arr[i][j] = 100_000_000;
			}
		}
		
		for (int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start][end] = 1;
			arr[end][start] = 1;
			
		}
		
		for (int k = 1 ; k <= N ; k++) {
			for(int i = 1 ; i <= N ; i++) {
				for (int j = 1 ; j <= N ; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j])
						arr[i][j] = arr[i][k] + arr[k][j];
				}
			}
		}
		
		//	위원회의 개수 구하기
		boolean [] visited = new boolean[N+1];
		List<Integer> deapyos = new ArrayList<Integer>();
		int ans = 0;
		for (int i = 1 ; i<= N ; i++) {
			if (visited[i]) continue;
			ans++;
			boolean [] temp = new boolean[N+1];
			temp[i] = true;
			for (int j = 1 ; j <= N ; j++) {
				if (arr[i][j] != 100_000_000) {
					visited[j] = true;
					temp[j] = true;
				}
			}
			
			// 위원회 대표 구하기
			int deapyo = -1;
			int cnt = 100_000_000;
			for (int j = 1 ; j <= N ; j++) {
				if (!temp[j]) continue;
				int now = 0;
				for (int k = 1 ; k <= N ; k++) {
					if (arr[j][k] != 100_000_000)
						now = Math.max(now, arr[j][k]);
				}
				if (now < cnt) {
					cnt = now;
					deapyo = j;
				}
			}
			deapyos.add(deapyo);
		}
		
		Collections.sort(deapyos);
		
		sb.append(ans+"\n");
		
		for (int i = 0 ; i < deapyos.size() ; i++) {
			sb.append(deapyos.get(i)+"\n");
		}
		
		System.out.println(sb);
	}
}
