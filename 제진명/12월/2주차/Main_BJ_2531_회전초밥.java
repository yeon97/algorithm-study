import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *	2021. 12. 8
 *	mem: 16408KB	time: 164ms 
 */

public class Main_BJ_2531_회전초밥 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, d, k, c;
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int [] sushi = new int [N];
		
		for (int i = 0 ; i < N ; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		
		int start = 0;
		int end = 0;
		int cnt = 1;
		
		int [] visited = new int[d+1];
		// 쿠폰으로 발행한 초밥은 일단 먹음
		visited[c] = 1;
		
		// 제일 처음 초밥부터 연속된 접시만큼 일단 먹음
		for (int i = 0 ; i < k ; i++) {
			end = i;
			if (visited[sushi[i]] == 0) {
				cnt++;
			}
			visited[sushi[i]]++;
		}
		
		int ans = cnt;
		// start -> 1칸 end -> 1칸씩 이동하면서 최댓값을 구하기
		for (int i = 0 ; i < N ; i++) {
//			System.out.println(Arrays.toString(visited)+" "+cnt);
			// 이전의 start에 적힌 값을 빼면서 연산
			if (visited[sushi[start]] == 1) {
				cnt--;
			}
			visited[sushi[start]]--;
			// start 한칸 이동
			start++;
			// end한칸 밀고 그 위치의 초밥 먹음
			end++;
			// 배열의 길이가 초밥의 갯수인데 이보다 커질 수 있으니 end는 %초밥의 갯수로 해서 배열의 범위를 벗어나는 경우를 막음
			if (visited[sushi[end%N]] == 0) {
				cnt++;
			}
			visited[sushi[end%N]]++;
			
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		
	}
}
