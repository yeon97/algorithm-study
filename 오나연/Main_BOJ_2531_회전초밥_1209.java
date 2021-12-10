package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 16356 KB
  시간 : 136 ms 
*/
public class Main_BOJ_2531_회전초밥_1209 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushi = new int[N+k-1];
		int[] able = new int[d+1];
		
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			if(i < k-1) sushi[N+i] = sushi[i];
		}
		
		int cnt = 0;
        for(int i=0; i<k; i++) {
            if(able[sushi[i]]++ == 0) cnt++;
        }
        
        int max = cnt;
        if(able[c] == 0) max++;
         
        for(int i=0; i<N-1; i++) {
            if(--able[sushi[i]] == 0) cnt--;
            if(able[sushi[i+k]]++ == 0) cnt++;
             
            int tmp = cnt;
            if(able[c] == 0) tmp++;
             
            max = (tmp>max)? tmp: max;
        }
        System.out.println(max);
	}
}