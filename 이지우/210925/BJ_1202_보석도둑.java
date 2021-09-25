package om9d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1202_보석도둑 {
	public static class Jewery implements Comparable<Jewery>{
		int m, v;
		public Jewery(int m, int v) {
			this.m = m;
			this.v = v;
		}
		public int compareTo(Jewery o) {
			// TODO Auto-generated method stub
			return this.m - o.m;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Jewery[] jew = new Jewery[N];
		for(int i= 0 ; i < N ; i++ ) {
			st = new StringTokenizer(br.readLine());
			
			jew[i] = new Jewery(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int[] bag = new int[K];
		for(int k = 0 ; k < K; k++) {
			bag[k] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(jew);
		Arrays.sort(bag);
		PriorityQueue<Integer> pque = new PriorityQueue<>((x,y) -> Integer.compare(y, x)); 
		long answer = 0;
		int index = 0;
		
		for(int k = 0; k < K; k++ ) {
			int canm = bag[k];
			while(index != N && canm >= jew[index].m) {
				pque.add(jew[index].v);
				index++;
				if (index == N)break;
			}
			if(!pque.isEmpty())answer += pque.poll();
		}
		
		System.out.println(answer);
	}

}
