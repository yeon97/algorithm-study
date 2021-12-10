package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 메모리 : 105060KB
 시  간 : 464ms
 */
public class Main_BJ_2531_회전초밥_1209 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 초밥개수
		int D = Integer.parseInt(st.nextToken()); // 초밥의 가지수
		int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		int dish[] = new int[N + K];

		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0;
		for (int i = N; i < N + K; i++) { // 회전 처리하기 위해서 K만큼 추가하기
			dish[i] = dish[idx++];
		}
//		System.out.println(Arrays.toString(dish));

		int max = 0;
		for (int i = 0; i < N; i++) {
			boolean eat[] = new boolean[D + 1];

			int cnt = 0; // K개 접시를 연속으로 먹었을 때 먹은 초밥의 가지수
			for (int j = i; j < i+K; j++) {
				if (!eat[dish[j]]) {
					cnt++;
					eat[dish[j]] = true;
				}
			}
			max = Math.max(max, cnt);
			if(cnt >= max) {
				if(!eat[C])
					max++;
			}
		}
		System.out.println(max);
	}
}
