package om8d26;

import java.io.*;
import java.util.*;

public class BJ_13300_방배정_v2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		int cnt=0;
		int arr[][]=new int[7][2];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[b][a]++;
			
		}
		
		for(int i=1;i<=6;i++) {
			if(arr[i][0]%k==0) {
				cnt+=arr[i][0]/k;
			}
			else {
				cnt+=arr[i][0]/k+1;
			}
			if(arr[i][1]%k==0) {
				cnt+=arr[i][1]/k;
			}
			else {
				cnt+=arr[i][1]/k+1;
			}
		}
		
		System.out.println(cnt);
		
	}

}