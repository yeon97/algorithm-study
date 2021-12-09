import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 	2021. 12. 8
 * 	mem: 57828KB	time: 1732ms
 */

public class Main_BJ_10814_나이순정렬 {
	static class People implements Comparable<People>{
		int age, order;
		String name;
		
		public People(int age, int order, String name) {
			super();
			this.age = age;
			this.order = order;
			this.name = name;
		}

		@Override
		public int compareTo(People o) {
			if (this.age == o.age) {
				return this.order - o.order;
			}
			return this.age - o.age;
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<People> peoples = new ArrayList<>(); 
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			peoples.add(new People(Integer.parseInt(st.nextToken()), i, st.nextToken()));
		}
		
		Collections.sort(peoples);
		
		for (int i = 0 ; i < N ; i++) {
			System.out.println(peoples.get(i));
		}
	}
}
