import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BJ_17413_단어뒤집기2_0829 {
	
	static StringBuilder sb;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine() + " "; // 다음 값을 보고 while을 종료하기 때문에 공백 추가
		
		sb = new StringBuilder(); // 최종 결과
		stack = new Stack<>(); // 문자열만 있을 경우 뒤집기
		
		int i = 0; // 인덱스
		
		while(i < str.length()) {
			char c = str.charAt(i);
			
			// < > 는 그대로 출력
			if(c == '<') { // 여는 괄호가 나오면
				while(c != '>') { // 닫는 괄호가 나올때까지 인덱스 +1하면서 sb에 추가 
					sb.append(c);
					i += 1;
					c = str.charAt(i);
				}
				sb.append(c); // 닫는 괄호 추가
			}
			
			// 문자열 -> 뒤집기
			else {
				while(c != ' ' && c != '<') { // 공백이나 여는 괄호가 나오는 경우 = 문자열 종료
					// 문자열 끝까지 스택에 넣기
					stack.push(c);
					i += 1;
					c = str.charAt(i);
				}
				
				// 문자열 끝났으면 출력
				printStack();
				
				// 다음에 여는 괄호가 있으면 위 if 문 조건에 걸려야하기 때문에 i -= 1;
				if (c == '<')
					i-=1;
				else // 공백이면 결과에 추가하기
					sb.append(c);
					
			}
			i += 1;
		}
		
		System.out.println(sb.toString());
		
	}

	// 스택 출력 - 문자열 역순 출력
	private static void printStack() {
		while(!stack.isEmpty()) 
			sb.append(stack.pop());
	}
}
