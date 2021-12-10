package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 메모리 : 11548KB
 시  간 : 84ms
 */
public class Main_BJ_1082_방번호_1209 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 문방구에서 파는 숫자
		int p[] = new int[N]; // 숫자별 가격
		int res[] = new int[51]; // 자리수마다 들어올 숫자
		
		int min = 100; // 제일 싼 숫자 가격
		int idx = 0; // 제일 싼 숫자 인덱스
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			p[i] = tmp;
			
			// 제일 싼 숫자 가격, 인덱스 저장
			if(tmp < min) {
				min = tmp;
				idx = i;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		int len_ = 0; // 최대가 될 수 있는 방 번호 길이
		// 제일 싼 숫자로 최대 길이 만들기
		while(M >= min) {
			res[len_] = idx;
			M -= min;
			len_++;
		}
		
		int start = 0; // 방 번호가 시작되는 위치
		for (int i = 0; i < len_; i++) {
			for (int j = N - 1; j >= 0; j--) {
				// 지금 남은 돈 + 제일 싼 숫자를 환불한 값으로 살 수 있는 제일 큰 숫자 고르기
				if(M + min >= p[j]) {
					M += min - p[j]; // 환불하고 큰 숫자 사고 남은 돈
					res[i] = j; // 지금 숫자를 자리에 저장
					break;
				}
			}
			
			// 제일 싼 숫자를 환불해도 살 수 있는 값이 없으면
			// 제일 싼 숫자 환불하고 다음 자리 탐색
			if(res[start] == 0) { 
				start++;
				M += min;
			}
		}
		
		// 정수 범위를 넘어갈 수 있기 때문에 스트링으로
		String ans = ""; 
		
		for (int i = start; i < len_; i++) {
			ans += Integer.toString(res[i]);
		}
		
		// 첫 자리가 0이면 0으로 지정
		if(ans == "" || ans.charAt(0) == '0')
			ans = "0";
		
		System.out.println(ans);
		
	}

}
