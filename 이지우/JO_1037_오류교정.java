package om8d27;

import java.io.*;
import java.util.StringTokenizer;

public class JO_1037_오류교정 {
	public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
       
        boolean[][] bool = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
        	 StringTokenizer st=new StringTokenizer(br.readLine());
        	 for(int j = 0 ; j < N; j++){
        		 if(st.nextToken().equals("1")){
        			 bool[i][j]=true;
        		 }
        	 }
        }
        boolean col[] = new boolean[N];
        for(int i = 0 ; i < N ; i++){
        	int colCount = 0;
        	for(int j = 0 ; j < N; j++){
        		if(bool[i][j])colCount++;
        	}
        	col[i] = colCount % 2 == 0 ? false : true;
        }
        boolean row[] = new boolean[N];
        for(int i = 0 ; i < N ; i++){
        	int rowCount = 0;
        	for(int j = 0 ; j < N; j++){
        		if(bool[j][i])rowCount++;
        	}
        	row[i] = rowCount % 2 == 0 ? false : true;
        }
        
        //문제가 되는건 true가됨
        int rc=0, cc=0; //잘못된거 카운팅 변수
        int[] rrr = new int[N];
        int[] ccc = new int[N];
        for(int i=0 ; i<N; i++){
        	if(row[i])rrr[rc++] = i;
        	if(col[i])ccc[cc++] = i;
        }
        if(rc+cc == 0){
        	System.out.print("OK");
        }else if(rc == 1 && cc == 1){
        	System.out.printf("Change bit (%d,%d)", ccc[0]+1, rrr[0]+1);
        }else{
        	System.out.print("Corrupt");
        }
    }
}