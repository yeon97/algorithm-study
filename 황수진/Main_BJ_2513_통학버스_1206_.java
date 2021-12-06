import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 메모리 : 25128KB
 시  간 : 444ms
 */
public class Main_BJ_2513_통학버스_1206 {

	public static class Apt implements Comparable<Apt> {
		int loc;
		int stu;

		public Apt(int loc, int stu) {
			super();
			this.loc = loc;
			this.stu = stu;
		}

		@Override
		public int compareTo(Apt o) {
			return o.loc - this.loc;
		}

		@Override
		public String toString() {
			return "Apt [loc=" + loc + ", stu=" + stu + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 아파트 단지 수
		int K = Integer.parseInt(st.nextToken()); // 통학버스의 정원
		int S = Integer.parseInt(st.nextToken()); // 학교의 위치

		ArrayList<Apt> lower = new ArrayList<>();
		ArrayList<Apt> higher = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int loc = Integer.parseInt(st.nextToken());
			int stu = Integer.parseInt(st.nextToken());

			if (loc < S) {
				lower.add(new Apt(Math.abs(loc - S), stu));
			} else {
				higher.add(new Apt(Math.abs(loc - S), stu));
			}
		} // array list
		
		Collections.sort(higher);
		Collections.sort(lower);

		int res = 0;
		res += calDistance(K, lower);
		res += calDistance(K, higher);
		System.out.println(res);
	}

	private static int calDistance(int k, ArrayList<Apt> map) {
		int tmpSum = 0; // 버스 이동 거리
		int leftK = k; // 버스 남은 자리
		int move = 0; // 추가해야할 이동 거리

		while(!map.isEmpty()) {
			int curStudent = map.get(0).stu; // 지금 아파트 단지 학생 수
			if (leftK > 0)
				move = Math.max(move, map.get(0).loc);

//			System.out.println("first>>> " + map);

			// 버스 남은 자리 > 현재 아파트에서 탈 학생 수
			if (leftK > curStudent) {
				leftK -= curStudent;
				map.remove(0);
			}
			// 버스 남은 자리 < 현재 아파트에서 탈 학생 수
			else if(leftK < curStudent) {
				map.get(0).stu -= leftK;
				leftK = 0;
			}
			// 버스 남은 자리 = 현재 아파트에서 탈 학생 수
			else {
				map.remove(0);
				leftK = 0;
			}

			if (leftK == 0 || map.isEmpty()) {
				tmpSum += (2 * move);
				move = 0;
				leftK = k;
			}
//			System.out.println(len_sum);
		}
		return tmpSum;
	}
}