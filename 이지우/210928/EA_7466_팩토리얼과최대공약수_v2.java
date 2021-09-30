package om9d27_28;

import java.io.*;
import java.util.StringTokenizer;

public class EA_7466_팩토리얼과최대공약수_v2 {
    static int result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            result = 1;
            if (K <= N) {
                result = K;
            } else {
                for (int i = N; i > 0; i--) {
                    if (K == 1)
                        break;
                    if (K % i == 0) {
                        result *= i;
                        K /= i;
                     
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}