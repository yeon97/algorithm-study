package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
  메모리 : 69804 KB
  시간 : 320 ms 
*/
public class Main_BOJ_1107_리모컨_1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		
		if(M>0) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				broken[tmp] = true;
			}
		}
		int cnt = Math.abs(N-100);
		
		if(N == 100) {
			System.out.println(0);
		}
//		else if(M == 0) {  // 이거 왜 틀릴까...
//			String tmp = String.valueOf(N);
//			System.out.println(tmp.length());
//		}
		/*
		  반례 :
		  101
		  0
		  정답 : 1
		  오답 : 3
		 */
		else if(M == 10) {
			System.out.println(cnt);
		} else {
			for(int i=0; i<1000000; i++) {
				String str = String.valueOf(i);
				int len = str.length();
				
				boolean check = false;
				for(int j=0; j<len; j++) {
					if(broken[str.charAt(j)-'0']) {
						check = true;
						break;
					}
				}
				
				if(!check) {
					int tmp = Math.abs(N-i) + len;
					if(cnt > tmp) cnt = tmp;
				}
			}
			System.out.println(cnt);
		}
	}
}