package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭 {
	static int N, M, max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] cards = new int[N];
		int[] combCard = new int[3];
		max = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken()); 
		}
		comb(0, 0, cards, combCard);
		System.out.println(max);
	}
	
	private static void comb(int cnt, int start, int[] cards, int[] combCard) {
		if(cnt>=3) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum+= combCard[i];
			}
			max = (sum<=M && sum>max) ? sum: max;
			return;
		}
		
		for(int i=start; i<N; i++) {
			combCard[cnt] = cards[i];
			comb(cnt+1, i+1, cards, combCard);
		}
	}
}