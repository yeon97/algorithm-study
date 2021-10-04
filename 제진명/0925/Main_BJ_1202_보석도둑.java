import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 		메모리  120320KB		시간  1944ms
 */


public class Main_BJ_1202_보석도둑 {
	static class Jewel implements Comparable<Jewel>{
		int w, v;

		public Jewel(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.v, this.v);
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Jewel [w=");
			builder.append(w);
			builder.append(", v=");
			builder.append(v);
			builder.append("]");
			return builder.toString();
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N, K;
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Jewel [] jewels;
		int [] bags;
		
		jewels = new Jewel[N];
		bags = new int [K];
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0 ; i < K ; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags);
		Arrays.sort(jewels, new Comparator<Jewel>() {

			@Override
			public int compare(Jewel o1, Jewel o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
			
		});
		
		int ans = 0;
		
		PriorityQueue<Jewel> queue = new PriorityQueue<>();
		
		for (int i = 0, j = 0; i < K ; i++) {
			while (j < N && jewels[j].w<= bags[i]) {
				queue.offer(jewels[j]);
				j++;
			}
			if (!queue.isEmpty()) {
				Jewel jewel = queue.poll();
				ans += jewel.v;
			}
		}
		System.out.println(ans);
	}
	
}
