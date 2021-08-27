import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		st.nextToken();
		
		int sum = 0;
		int max = 0;
		int first = Integer.parseInt(st.nextToken());
		int init = first;
		for (int i = 1 ; i < 6 ; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int temp = Integer.parseInt(st.nextToken());
			if(first*temp > max) max = first*temp;
			sum += first*temp;
			first = temp;
		}
		
		if(first*init > max) max = first*init;
		sum+=first*init;
		
		System.out.println((max-(max*3 - sum))*N);
		
		
	}
}
