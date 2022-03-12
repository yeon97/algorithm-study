package M01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1374_강의실 {
	static ArrayList<int[]> tmp = new ArrayList<int[]>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int [][] lt = new int[N*2][2];
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			lt[2*i] = new int[] {Integer.parseInt(st.nextToken()),0};
			lt[2*i+1] = new int[] {Integer.parseInt(st.nextToken()),1};
		}
		int ans = 1;
		int cnt = 0;
		mergeSort(lt, 0, 2*N-1);
		for (int i = 0 ; i < N*2 ; i++) {
			if(lt[i][1] == 0)cnt++;
			else cnt--;
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
	
	private static void mergeSort(int[][] lt, int i, int j) {
		if(i < j) {
			int m = (i+j)/2;
			mergeSort(lt,i,m);
			mergeSort(lt,m+1,j);
			merge(lt , i, j, m);
		}
		
	}
	private static void merge(int[][] lt, int i, int j, int m) {
		tmp.clear();
		int left = i; int right = m+1; int copy = 0;
		
		while(left <= m && right <= j) {
			if(lt[left][0] < lt[right][0])tmp.add(lt[left++]);
			else if(lt[left][0] > lt[right][0])tmp.add(lt[right++]);
			else if(lt[left][0] == lt[right][0]) {
				if(lt[left][1] > lt[right][1]) {
					tmp.add(lt[left++]);
				}else {
					tmp.add(lt[right++]);
				}
			}
		}
		while(left <= m)tmp.add(lt[left++]);
		while(right <= j)tmp.add(lt[right++]);
		
		for(int index = i; index <= j; index++) {
			lt[index] = tmp.get(copy++);
		}
	}
}
