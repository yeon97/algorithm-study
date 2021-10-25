package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 *  	메모리 : 111,152 KB		시간 : 1998ms
 */

public class Solution_SWEA_12094_오래된스마트폰 {
	
	static int N, O, M, W, ans;
	static int [] nums;
	static int [] oper;
	static int [] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1 ; tc <= T ; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			O = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());

			// 터치 가능한 숫자 배열
			nums = new int[N];
			for (int i = 0 ; i < N ; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			// 터치가능한 연산자 1: +  2: -  3: *  4: /
			oper = new int[O];
			for (int i = 0 ; i < O ; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			W = Integer.parseInt(br.readLine());
			
			ans = Integer.MAX_VALUE;
			visited = new int[1000];
			Arrays.fill(visited, 1000);
			
			dfs (0, -1, "", 0);
			
			ans = ans==Integer.MAX_VALUE? -1:ans;
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
	
	
	// cnt = 터치한 횟수 기록, res = 현재까지 연산 결과 값, tmep = 다음 연산을 위한 숫자, flag = 연산을 한번이라도 했는지 여부
	static void dfs(int cnt, int res, String temp, int flag) {
		// 탈출 조건
		
		// 1. 현재 cnt가 ans보다 큰 경우
		if (cnt > ans) return;
		// 2. 연산 결과가 W와 같은 경우
		if (res == W) {
			ans = Math.min(ans, cnt+(1*flag));
			return;
		}
		// 3. 마지막에 = 연산을 해야하기에 cnt < M인 경우에만 반복 더이상 계산을 하여도 결과를 얻을 수 없는 경우
		if (cnt == M-1 || (cnt == M-2 && temp.length() == 0)) {
			return;
		}
		
		for (int i = 0 ; i < N ; i++) {
			// 숫자를 추가하는 경우
			// 첫번째 숫자로 0이 오면 안됨, 1000 이하의 숫자여야 하므로 temp의 길이가 4보다 작을 때만 숫자 추가
			if (temp.length() == 0 && nums[i] == 0) continue;
			if (temp.length() < 3) {
				dfs (cnt+1, res, temp+String.valueOf(nums[i]), flag);
			}
			// 처음 숫자 삽입
			if (res == -1 && temp.length() != 0) {
				dfs (cnt, Integer.parseInt(temp), "", flag);
			}
			
			// 연산을 하는 경우
			// temp가 비어있으면 안됨, 제일 처음엔 연산 못함
			if (temp.length() != 0 && res != -1) {
				for (int j = 0 ; j < O ; j++) {
					int n = res;
					if (oper[j] == 1) {
						n += Integer.parseInt(temp);
					} else if (oper[j] == 2) {
						n -= Integer.parseInt(temp);
					} else if (oper[j] == 3) {
						n *= Integer.parseInt(temp);
					} else if (oper[j] == 4) {
						n /= Integer.parseInt(temp);
					}
					if (n < 0 || n > 999 || cnt+1>=visited[n]) continue;
					visited[n] = cnt+1;
					dfs (cnt+1, n, "", 1);
				}
			}
		}
	}
}
