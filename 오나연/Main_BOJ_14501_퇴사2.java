import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사2 {
	static int max, day;
	static int[][] consulting;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		day = Integer.parseInt(br.readLine());
		consulting = new int[day][2];
		
		for(int i=0; i<day; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			consulting[i][0] = Integer.parseInt(st.nextToken());
			consulting[i][1] = Integer.parseInt(st.nextToken());
		}
		max = 0;
		find(0, 0);
		System.out.println(max);
	}
	
	private static void find(int start, int sum) {
		if(start > day) {
			return;
		}
		if(sum > max) {
			max = sum;
		}
		for(int i=start; i<day; i++) {
			find(i+consulting[i][0], sum+consulting[i][1]);
		}
	}
}