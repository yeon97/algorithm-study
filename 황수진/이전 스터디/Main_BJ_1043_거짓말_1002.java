import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 	메모리 14300KB
 	시간 156ms
 */

public class Main_BJ_1043_거짓말_1002 {

	private static class Party {
		ArrayList<Integer> p; // 파티에 참여한 사람들
		int cnt; // 진실을 알고 있는 사람들 수

		public Party(ArrayList<Integer> p, int cnt) {
			super();
			this.p = p;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Party [p=" + p + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int M = Integer.parseInt(st.nextToken()); // 파티 수

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수

		// 진실을 아는 사람이 없으면 파티 수 출력
		if (T == 0) {
			System.out.println(M);
		}

		else {
			ArrayList<Integer> truePeople = new ArrayList<>(); // 진실을 아는 사람
			
			// 진실을 아는 사람을 truePeople에 저장
			while (st.hasMoreTokens()) {
				truePeople.add(Integer.parseInt(st.nextToken()));
			}

			// 파티별로 참가한 사람들
			Queue<Party> p = new LinkedList<Party>();
			
			ArrayList<Integer> temp; // 각 파티에 참여한 사람들
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 파티 참여자 수 제외하기
				temp = new ArrayList<>();

				// 파티 참여자를 temp에 임시로 저장
				while (st.hasMoreTokens()) {
					temp.add(Integer.parseInt(st.nextToken()));
				}
				
				// 파티 참여자 추가
				p.add(new Party(temp, 0));
			}

			while (!p.isEmpty()) {
				Party curP = p.poll(); // 지금 파티
				ArrayList cur = curP.p;
				int cnt = curP.cnt; // 현재 진실을 알고 있는 사람 수

				boolean flag = false;

				// 지금 파티에 참여한 사람 중에서 진실을 아는 사람이 있는지 체크
				for (int x : truePeople) {
					if (cur.contains(x)) {
						flag = true;
						break;
					}
				}

				if (flag) { // 진실을 아는 사람이 있는 경우
					if (cur.size() > 1) { // 파티 참여자가 2명 이상일 때
						for (int i = 0; i < cur.size(); i++) {
							int tmp = (int) cur.get(i); // 이미 진실을 알고 있는 사람
							if (!truePeople.contains(tmp)) { // 새롭게 진실을 안 사람(이미 진실을 알고 있는 사람을 제외한 사람)을 제외하고
								truePeople.add(tmp); // 진실을 아는 사람에 추가
							}
						}
					}
				} else { // 진실을 모르면 큐에 다시 추가
					p.add(new Party(cur, truePeople.size()));
				}

				// 진실을 아는 사람 숫자가 더 이상 변경되지 않으면 멈춤
				if (cnt == truePeople.size()) {
					break;
				}

			}
			System.out.println(p.size());
		}

	}

}
