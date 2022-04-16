package jinmyeong.Aug2021.algo0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		char[] chars = str.toCharArray();

		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<Character>();
		
		int opt = 1; // i == 1이면 stack에 넣고 2이면 그냥 넣는다.

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (opt == 1 && (c == ' ' || c == '<')) {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				if (c == ' ') {
					sb.append(c);
				} else {
					opt = 2;
					sb.append(c);
				}
				continue;
			} else if (c == '<') {
				opt = 2;
				sb.append(c);
				continue;
			} else if (c == '>') {
				opt = 1;
				sb.append(c);
				continue;
			}  
			
			if (opt == 1) {
				stack.push(c);
			} else {
				sb.append(c);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
