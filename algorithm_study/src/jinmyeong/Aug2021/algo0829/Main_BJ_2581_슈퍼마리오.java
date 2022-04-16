package jinmyeong.Aug2021.algo0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2581_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int more = 0;
		int loss = 0;
		int temp = 0;
		
		for (int i = 0 ; i < 10 ; i++) {
			temp += Integer.parseInt(br.readLine());
			if(temp <= 100) {
				loss = temp;
			}else
				more = temp;
			if(temp > 100) {
				break;
			}
		}
				
		if(more == 0) {
			System.out.println(loss);
			return;
		}
		
		if ((more-100)<=(100-loss)) {
			System.out.println(more);
		} else {
			System.out.println(loss);
		}
	}
}
