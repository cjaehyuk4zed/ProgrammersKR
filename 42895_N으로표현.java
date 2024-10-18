import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(number == N){
            return 1;
        }
        
        List<HashMap<Integer, Boolean>> list = new ArrayList<>();
        for(int i=0; i<=8; i++){
            list.add(new HashMap<Integer, Boolean>());
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(N);
        
        list.get(1).put(Integer.parseInt(String.valueOf(sb)), true);
        
        for(int i=2; i<=8; i++){
            sb.append(N);
            list.get(i).put(Integer.parseInt(String.valueOf(sb)), true);
            
            for(int j=1; j<i; j++){
                int k = i-j;
                for(Integer num1 : list.get(j).keySet()){
                    for(Integer num2 : list.get(k).keySet()){
                        list.get(i).put(num1+num2, true);
                        // Don't need to reverse num1 and num2
                        // It reverses naturally with j++ and k = i-j
                        list.get(i).put(num1-num2, true);
                        list.get(i).put(num1*num2, true);
                        if(num2 != 0){
                            list.get(i).put(num1/num2, true);
                        }
                    }
                }
                for(Integer num : list.get(i).keySet()){
                    if(num == number){
                        return i;
                    }
                }
            }
        }
        
        return -1;
    }
}
