import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int [] cake = new int [L+1];
		
		int pNum = 0;
		int max = 0;
		for (int i = 1 ; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			int fst = Integer.parseInt(st.nextToken());
			int lst = Integer.parseInt(st.nextToken());
			
			int temp = lst - fst + 1;
			if (temp > max) {
				pNum = i;
				max = temp;
			}
			for (int j = fst; j <= lst ; j++) {
				if (cake[j] != 0) continue;
				cake[j] = i;
			}
		}
				
		System.out.println(pNum);
		
		int [] res = new int[N+1];
		for (int i = 1; i <= L ; i++) {
			res[cake[i]]++;
		}
		max = 0;
		for (int i = 1 ; i <= N ; i++) {
			if (res[i]>max) {
				max = res[i];
				pNum = i;
			}
		}
		
		System.out.println(pNum);
	}
}
