package om8d26;

import java.io.*;
import java.util.*;

public class BJ_10163_색종이_v2 {
	  static final boolean DEBUG = false;
	    static BufferedReader br;
	    static BufferedWriter bw;

	    static String line;
	    static String[] input;

	    static int N;

	    static int[][] board;
	    static void solveCase() throws IOException {
	        N = Integer.parseInt(br.readLine());
	        board = new int[1001][1001];
	        for (int i = 0; i < N; i++) {
	            input = br.readLine().split(" ");
	            int l = Integer.parseInt(input[0]);
	            int t = Integer.parseInt(input[1]);
	            int w = Integer.parseInt(input[2]);
	            int h = Integer.parseInt(input[3]);
	            for (int j = 0; j < h; j++) {
	                Arrays.fill(board[t + j], l, l + w, i + 1);
	            }
	        }

	        int[] count = new int[N + 1];
	        for (int i = 0; i < 1001; i++) {
	            for (int j = 0; j < 1001; j++) {
	                count[board[i][j]]++;
	            }
	        }

	        for (int i = 1; i <= N; i++) {
	            System.out.println(count[i]);
	        }
	    }

	    public static void main(String[] args) {
	        try  {
	            br = new BufferedReader(new InputStreamReader(System.in), 4 * 1024 * 1024);
	            bw = new BufferedWriter(new OutputStreamWriter(System.out), 4 * 1024 * 1024);
	            int T = 1;//Integer.parseInt(br.readLine());
	            for(int i = 0; i < T; i++) {
	                solveCase();
	            }
	            bw.flush();
	        } catch (IOException e) {
	            System.out.println(e.toString());
	            e.printStackTrace();
	        } finally {

	        }
	    }
	}


