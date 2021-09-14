package om8d27;

import java.io.*;
import java.util.StringTokenizer;

public class EA_1859_백만장자프로젝트_v2 {
	public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int tn=Integer.parseInt(br.readLine());
        for(int i=1;i<=tn;i++) {
            int inLength=Integer.parseInt(br.readLine());
            StringTokenizer st=new StringTokenizer(br.readLine());
            int[] input=new int[inLength];
            for(int j=0;j<input.length;j++) {
                input[j]=Integer.parseInt(st.nextToken());
            }
            int max=input[inLength-1];
            long result=0L;
            for(int j=(inLength-1);j>=0;j--) {
                if(max>input[j]) {
                    result+=(max-input[j]);
                }else {
                    max=input[j];
                }
            }
            System.out.println("#"+i+" "+result);
        }
    }
}