package im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> tmp = new Stack<>();
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c == '<') {
				while(str.charAt(i) != '>') {
					System.out.print(str.charAt(i++));
				}
				System.out.print('>');
			} else if (c == ' '){
				System.out.print(' ');
			} else {
				while(i<str.length() && str.charAt(i)!=' ' && str.charAt(i) != '<') {
					tmp.push(str.charAt(i));
					i++;
				}
				i--;
				while(!tmp.isEmpty()) {
					System.out.print(tmp.pop());
				}
			}
		}
	}
}