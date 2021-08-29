import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, M, L;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int [] count = new int [N];
		
		int idx = 0;
		int cnt = 0;
		count[idx] = 1;
		
		while (count[idx] != M) {
			if (count[idx] %2 != 0) {
				idx = (idx+L)%N;
			} else {
				idx = (idx-L+N)%N;
			}
			count[idx]++;
			cnt++;
		}
		
		System.out.println(cnt);
	}
	
}
