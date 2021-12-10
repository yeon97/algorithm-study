import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3985_롤케이크_0911 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		// 가장 많은 조각을 받도록 예상되는 방청객
		int sub = 0; // 조각 개수
		int res = 0; // 방청객 번호

		int arr[] = new int[L + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken()); 
			int k = Integer.parseInt(st.nextToken());

			// 예상 구하기
			if (sub < k - p) {
				sub = k - p;
				res = i;
			}

			// 방청객한테 줄 수 있는 롤케이크 주기
			for (int j = p; j <= k; j++) {
				if (arr[j] == 0) {
					arr[j] = i;
				}
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		int idx = 0; // 실제로 받는 방청객 번호
		int max = 0; // 제일 많이 받을 방청객이 받는 케이크 조각 수
		int cnt = 1; // 각 방청객 별로 받는 케이크 조각 수
		
		for (int i = 1; i < L; i++) {
			if (arr[i] != 0 && arr[i] == arr[i + 1]) {
				cnt++;
			} else {
				cnt = 1;
			}
			if (cnt > max) {
				max = cnt;
				idx = arr[i + 1];
			}

		}

		System.out.println(res);
		System.out.println(idx);
	}
}

/*
 * 10 2 2 3 4 10
 * 
 * 10 3 1 2 4 8 9 10
 */
