import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1859_백만장자프로젝트_0827 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N =  sc.nextInt();
			int arr[] = new int[N-1]; // 매매가
			
			// 매매가 입력 - 마지막 날은 넣을 필요 없음
			for (int i = 0; i < N-1; i++) {
				arr[i] = sc.nextInt();
			}

			int lastDay = sc.nextInt(); // 마지막날
			
			int max = lastDay; // 현재 팔 수 있는 최대 금액
			long res = 0; // 결과값 - Integer 범위를 넘어감
			
			// 마지막날부터 첫날까지
			for(int i = N-2; i >= 0; i-- ) {
				if(arr[i] < max) { // 현재 팔 수 있는 최대 값보다 작으면 
					res += (max - arr[i]); // 최대값 - 현재 값을 누적으로 더함
				}
				else { // 현재 팔 수 있는 최대값보다 크면
					max = arr[i]; // 최대값 정정
				}
			}
			
			System.out.println("#" + t + " " + res);
			
		}
		
		sc.close();
	} // end main

} // end class

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc&categoryId=AV5LrsUaDxcDFAXc&categoryType=CODE&problemTitle=1859&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1