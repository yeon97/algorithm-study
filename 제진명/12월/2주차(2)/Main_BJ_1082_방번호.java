
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 	mem: 18676KB	time: 212ms
 */

public class Main_BJ_1082_방번호 {
	
	static String [] dp;
	static int N;
	static int [] cost;
	static int price;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dp = new String[51];
		Arrays.fill(dp, "");
		cost = new int[10];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		price = Integer.parseInt(br.readLine());
		
		for (int i = 0 ; i <= price ; i++) {
			for (int j = N-1 ; j >= 0 ; j--) {
				if (i - cost[j] < 0) continue;
				
				for (int k = 0 ; k < dp[i - cost[j]].length() ; k++) {
					if (dp[i-cost[j]].charAt(k) - '0' < j) {
						String t = dp[i-cost[j]].substring(0, k) + String.valueOf(j) + dp[i - cost[j]].substring(k);
						if (dp[i].length() < t.length()) dp[i] = t;
						else if (dp[i].length() == t.length()) dp[i] = compare(dp[i], t);
					}
				}
				if (dp[i-cost[j]].length() == 0 && j == 0) continue;
				
				String t = dp[i-cost[j]] + String.valueOf(j);
				if (dp[i].length() < t.length()) dp[i] = t;
				else if(dp[i].length() == t.length()) dp[i] = compare(dp[i], t);
			}
		}
		if (dp[price].length() == 0) System.out.println("0");
		else System.out.println(dp[price]);
	}
	
	static String compare(String n1, String n2) {
		for (int  i = 0 ; i < n1.length() ; i++) {
			if (n1.charAt(i) == n2.charAt(i)) continue;
			else if (n1.charAt(i) > n2.charAt(i)) return n1;
			else return n2;
		}
		return n1;
	}
}