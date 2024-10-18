import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        char[] arr = number.toCharArray();
        
        int start = 0;
        // Iter = length of final number
        int iter = number.length() - k;
        
        while(iter > 0){
            char max = '0';
            for(int j = start; j<= number.length() - iter; j++){
                if(arr[j] > max){
                    max = arr[j];
                    start = j+1;
                }
            }
            answer.append(max);
            
            iter--;
        }
        
        return String.valueOf(answer);
    }
}
