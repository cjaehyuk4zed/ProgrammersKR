import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            queue.add(scoville[i]);
        }
        
        int iter = 0;
        while(queue.size() > 1 && queue.peek() < K){
            int a = queue.poll();
            int b = queue.poll();
            
            int c = a + b*2;
            queue.add(c);
            iter++;
        }
        
        if(queue.size() == 1 && queue.peek() < K){
            answer = -1;
        } else{
            answer = iter;
        }
        
        System.out.println(queue);
        
        return answer;
    }
}
