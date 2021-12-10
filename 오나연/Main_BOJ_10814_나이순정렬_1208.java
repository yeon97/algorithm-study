package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
  메모리 : 64184 KB
  시간 : 1848 ms
*/
public class Main_BOJ_10814_나이순정렬_1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		User[] user = new User[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			user[i] = new User(i, age, name);
		}
		Arrays.sort(user);
		
		for(int i=0; i<N; i++) {
			System.out.println(user[i].age + " " + user[i].name);
		}
	}
	
	static class User implements Comparable<User>{
		int idx, age;
		String name;
		public User(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		@Override
		public int compareTo(User o) {
			if(this.age == o.age) return this.idx - o.idx;
			return this.age - o.age;
		}
	}

}
