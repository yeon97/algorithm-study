package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L+1];
		int[] person = new int[N+1];
		int max = 0;
		int maxIdx = 0;
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int current = end - start;
			if(current > max) {
				max = current;
				maxIdx = i;
			}
			for(int j=start; j<=end; j++) {
				if(cake[j] == 0)	cake[j] = i;
			}
		}
		System.out.println(maxIdx);
		
		for(int i=1; i<=L; i++) {
			person[cake[i]]++;
		}
		
		max = 0;
		maxIdx = 0;
		for(int i=1; i<=N; i++) {
			if(person[i] > max) {
				max = person[i];
				maxIdx = i;
			}
		}
		
		System.out.println(maxIdx);
	}
}
