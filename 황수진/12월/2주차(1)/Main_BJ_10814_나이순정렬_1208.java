package month12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 메모리 : 60324KB
 시  간 : 1836ms
*/
public class Main_BJ_10814_나이순정렬_1208 {

	public static class Member {
		int no;
		int age;
		String name;
		
		public Member(int no, int age, String name) {
			super();
			this.no = no;
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age + " " + name;
		}

	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		Member[] m = new Member[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			m[i] = new Member(i, age, name);
		}

		Arrays.sort(m, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
			
		});
		
		for (int i = 0; i < N; i++) {
			System.out.println(m[i]);
		}
	}

}
