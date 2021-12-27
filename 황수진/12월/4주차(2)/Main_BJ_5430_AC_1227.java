package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 메모리 : 127404KB
 시  간 : 812ms
 */
public class Main_BJ_5430_AC_1227 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			// 수행할 함수
			String S = br.readLine();

			// 배열에 들어있는 수의 개수
			int N = Integer.parseInt(br.readLine());

			// 배열 - 대괄호 없애고 ,을 구분자로 해서 배열로
			String input = br.readLine();
			input = input.replace("[", "");
			input = input.replace("]", "");
			String number[] = input.split(",");

			int s = 1; // 첫번째 위치
			int e = N; // 마지막 위치
			int check = 1; // 뒤집기 체크(버리기 할 때 사용)

			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);

				// 뒤집기면 swap(s, e) 하고 뒤집기 체크
				if (c == 'R') {
					int tmp = s;
					s = e;
					e = tmp;
					check *= -1;
				}
				// 버리기면 시작 위치 변경
				// check = 1이면 1 -> 2
				// check = -1이면 3 -> 2
				else 
					s += check;
			}

			// 지금 테스트케이스의 길이 체크
			int cnt;
			
			// 순서대로이고 배열의 범위를 넘어가지 않았을 경우
			if (check == 1 && (s - e) < 2) {
				cnt = 1;
				sb.append("[");
				// 시작 위치 ~ 마지막 위치까지 sb에 추가
				for (int i = s - 1; i < e; i++) {
					sb.append(number[i] + ",");
					cnt++;
				}
				// 숫자가 있었다면 마지막에 , 제거
				if (cnt >= 2) {
					sb.setLength(sb.length() - 1);
				}
				sb.append("]");

			// 역순이고 배열의 범위를 넘어가지 않았을 경우
			} else if (check == -1 && (e - s) < 2) {
				cnt = 1;
				sb.append("[");
				for (int i = s - 1; i >= e - 1; i--) {
					sb.append(number[i] + ",");
					cnt++;
				}
				if (cnt >= 2) {
					sb.setLength(sb.length() - 1);
				}
				sb.append("]");
			// 에러
			} else {
				sb.append("error");
			}
			sb.append("\n");
		} // end while

		// 마지막 개행 제거
		sb.setLength(sb.length() - 1);
		
		// 결과 출력
		System.out.println(sb.toString());
	}

}

/*
예외처리 테케
==input==
5
DDD
2
[1,2]
RDD
2
[1,2]
RDRD
3
[1,2,3]
RRRRRRR
3
[1,2,3]
R
0
[]

==output==
error
[]
[2]
[3,2,1]
[]

==input==
3
D
0
[]
R
0
[]
R
0
[]

==output==
error
[]
[]
*/
