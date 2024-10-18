import java.util.*;

class Solution {
    
    static int count;
    static HashMap<Integer, Boolean> map;
    
    public int solution(String numbers) {
        int answer = 0;
        
        count = 0;
        map = new HashMap<Integer, Boolean>();
        
        // Create queue with numbers in length order
        // How to create this queue?
        
        // poll() queue and calc isPrime() until queue.isEmpty()
        // for(int i=0; i<numbers.length;i++){
        //     char[] arr = new char[numbers.length -1];
        //     String str = String.valueOf(numbers.charAt(i));
        //     for(int j=0; j<numbers.length; j++){
        //         if(j==i){continue;}
        //         arr[j] = 
        //     }
        // }
        calc("", numbers.toCharArray());
        
        answer = count;
        return answer;
    }
    
    static void calc(String str, char[] arr){
        if(str != ""){
            int num = Integer.parseInt(str);
            if(!map.containsKey(num)){
                map.put(num, true);
                if(isPrime(num)){
                    count++;
                }
            }
        }
        
        // System.out.println(map.keySet());
        if(arr.length == 0){
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            String nextStr = str + String.valueOf(arr[i]);
            List<Character> list = new ArrayList<>();
            for(int j=0; j<arr.length; j++){
                if(j==i){continue;}
                list.add(arr[j]);
            }
            char[] nextArr = new char[arr.length-1];
            for(int j=0; j<nextArr.length; j++){
                nextArr[j] = list.get(j);
            }
            
            calc(nextStr, nextArr);
        }
    }
    
    static boolean isPrime(int num){
        if(num == 0 || num == 1){return false;}
        if(num == 2){return true;}
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
}
