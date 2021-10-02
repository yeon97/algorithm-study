package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1202_보석도둑_0925_ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(st.nextToken());  // 보석 개수
		int K = Integer.parseInt(st.nextToken());  // 가방 개수
		
		Jewel[] jewels = new Jewel[N];
		int[] bag = new int[K];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			jewels[i] = new Jewel(weight, price);
		}  // 보석 무게와 가격
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(st.nextToken());
		}  // 가방 무게

		// 1. 보석 무게 기준으로 오름차순 정렬
		// 2. 보석 무게가 같으면 가격으로 내림차순 정렬
		// 3. 가방 무게 기준 오름차순 정렬
		// 4. 각 가방마다 들어갈 수 있는 보석을 우선순위 큐에 넣어 
		//    가격 기준으로 오름차순 정렬
		// 5. 각 가방마다 들어갈 수 있는 보석 중 가격이 가장 큰 보석을 넣어줌
		
		Arrays.sort(jewels);  // 1, 2
		Arrays.sort(bag);	  // 3
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder()); // 4
		int idx = 0;
		long total = 0;
		for(int i=0; i<K; i++) {  // 각 가방마다
			int currentB = bag[i];
			while(idx<N && jewels[idx].weight<=currentB) {
				q.offer(jewels[idx++].price);
			}
			
			if(!q.isEmpty()) total += q.poll();  // 5
		}
		
		sb.append(total).append("\n");
		System.out.println(sb);                            
	}
	
	static class Jewel implements Comparable<Jewel> {
		int weight;
		int price;
		public Jewel(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		@Override
		public int compareTo(Jewel o) {
			if(this.weight==o.weight) return -(this.price-o.price);
			return this.weight-o.weight;
		}
	}
}