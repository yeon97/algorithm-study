package jinmyeong.Aug2021.algo0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_JO_1205_조커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> seq = new LinkedList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int joker = 0;
		
		for (int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num == 0) {
				joker++;
			} else {
				seq.add(num);
			}
			
		}
		
		Collections.sort(seq);
		
		int now = 0;
		int next = now+1;
		int j = joker;
		int temp = 1; // 현재 최대 스트레이트 수 계산 초기 = 첫번째 카트만 포함한 개수
		int ans = 0; // 최종 최대 스트레이트 수 변수
		int preIdx = 0; // 조커를 처음 사용한 위치의 인덱스 값 저장
		int prepreIdx = 0;
		
		if (seq.size() == 0) {
			System.out.println(j);
			return;
		}
		
		while(true) {
			// 탈출 조건 현재 인덱스가 seq.size()보다 같으면 더이상 다음 인덱스와 비교 불가
			if(now == seq.size()-1) {
				// 마지막 인덱스에 도착 하였을 때 남은 연산 처리를 해야함
				// j의 값이 다 사용되지 않고 남아있는 경우
				if (j != 0) {
					// 현재 스트레이트 값에 남은 j값 추가
					temp += j;
				}
				// 전체 최대 스트레이트 값 보다 현재  스트레이트 값이 크다면 업데이트
				if (ans < temp) ans = temp;
				break;				
			}
			// 현재 카드 숫자와 다음 카드 숫자 값이 같을 때
			if (seq.get(now).equals(seq.get(next))) {
				now += 1; // 다음 카드로 이동
				next = now + 1;
			}
			// 현재 카드 숫자와 다음 카드 숫자의 차이가 남아있는 조커의 수 이하일 때
			// 다음 카드 숫자와 현재 카드 숫자 사이에 들어갈 수 있는 숫자 개수 = (seq.get(next) - seq.get(now)) -1
			else if (((seq.get(next) - seq.get(now)) -1)  <= j) {
				// 소모한 j의 값을 줄여줌
				j = j - ((seq.get(next) - seq.get(now)) -1);	// 사용한 j만큼 j감소
				temp = temp + (seq.get(next) - seq.get(now)); // 현재 스트레이트 수에 다음 카드 숫자와 현재 카드 숫자의 차이만큼을 더해줌
				if (preIdx == 0 && ((seq.get(next) - seq.get(now)) -1) != 0) { // 이전에 조커를 사용한 기록이 없는경우
					preIdx = next; // 조커를 사용하여 연결된 다음 카드 인덱스를 저장
				}
				now += 1; // 다음 카드로 이동
				next += 1; 
			} else {	// 현재카드와 다음 카드의 숫자의 차이가 남은 조커의 숫자보다 커서 더이상 스트레이트를 구성할 수 없는 경우
				// 스트레이트 구성은 불가능하지만 남은 j가 남아있는 경우
				if (j != 0) {
					temp += j;
				}
				
				if (preIdx == 0) {	// 과거에 조커를 사용한 경험이 없는 경우
					now += 1;
					next = now +1;
				} else {	// 과거에 조커를 사용한 경험이 있는경우
					
					if (prepreIdx != 0) {
						if (((seq.get(prepreIdx) - seq.get(prepreIdx-1))-1) <= j) {
							temp+=1;
						}
					}
					now = preIdx;	// 과거 조커를 사용한 위치로 현재 인덱스를 이동
					next = now+1;
					prepreIdx = preIdx;
					preIdx = 0; // 과거에 조커를 사용한 인덱스의 값 0으로 초기화
				}
				if (ans < temp) ans = temp; // 현재 스트레이트가 과거의 스트레이트 수보다 큰경우 업데이트
				temp = 1; // 스트레이트가 끊어졌으므로 현재 스트레이트 값 0으로 초기화
				j = joker;
			}
			
		}
		System.out.println(ans);
	}
}
