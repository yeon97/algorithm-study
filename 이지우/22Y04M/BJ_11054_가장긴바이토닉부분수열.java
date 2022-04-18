package M01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11054_가장긴바이토닉부분수열 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		ArrayList<Integer> up = new ArrayList<>();
		ArrayList<Integer> down = new ArrayList<>();
		for(int i = 0 ; i <= N; i++) {
			up.add(-1);
			// 여기는 최장오름차순수열
			loop:
			for(int j = 0 ; j < i; j++) {
				for(int k = up.size()-1 ; k >= 0 ; k--) {
					if(arr[j] > up.get(k)) {
						if(k == up.size()-1)
							up.add(arr[j]);
						else
							up.set(k + 1, arr[j]);
						continue loop;
					}
				}
			}
			
			down.add(up.get(up.size()-1));
			
			// 여기는 최장내림차순수열
			loop2:
			for(int j = i ; j < N; j++) {
				for(int k = down.size()-1 ; k >= 0 ; k--) {
					if(arr[j] < down.get(k)) {
						if(k == down.size()-1)
							down.add(arr[j]);
						else
							down.set(k + 1, arr[j]);
						continue loop2;
					}
				}
				
			}
			max = Math.max(up.size()+down.size()-2, max);
			up.clear();
			down.clear();
		}
		
		System.out.println(max);
	}

}
