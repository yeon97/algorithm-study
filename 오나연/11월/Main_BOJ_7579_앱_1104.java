package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 11976 KB
  시간 : 100 ms
*/

public class Main_BOJ_7579_앱_1104 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memory = new int[N];
		int[] cost = new int[N];
		
		int min = 0;
		st = new StringTokenizer(br.readLine());
		st2 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st2.nextToken());
			min += cost[i];
		}
		
		int[] D = new int[min+1];
		
		for(int i=0; i <N; i++) {
			int curM = memory[i];
			int curC = cost[i];
			for(int j=min; j>=1; j--) {
				if(j < curC) break;
				else {
					D[j] = (D[j-curC] + curM > D[j]) ? D[j-curC] + curM: D[j];
					if(D[j] >= M && min > j) min = j;
				}
			}
		}
		System.out.println(min);
	}
}