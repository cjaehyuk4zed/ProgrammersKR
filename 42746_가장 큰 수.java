import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(new SortInt());
        
        for(int i=0; i<numbers.length;i++){
            queue.add(numbers[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        if(queue.peek() == 0){
            return "0";
        }
        
        int size = queue.size();
        for(int i=0; i<size; i++){
            sb.append(String.valueOf(queue.poll()));
        }

        return String.valueOf(sb);
    }
    
    static class SortInt implements Comparator<Integer>{
        @Override
        public int compare(Integer n1, Integer n2){
            String s1 = String.valueOf(n1);
            String s2 = String.valueOf(n2);
            return -(s1+s2).compareTo(s2+s1);
        }
        
    }
    
}
