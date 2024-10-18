import java.util.*;

class Solution {
    
    static int answer;
    static HashMap<Integer, Boolean> map;
    
    public int solution(int n, int[][] computers) {
        
        map = new HashMap<>();
        
        if(computers.length==1){
            return 1;
        }
        
        answer = 0; // Starts at 1
        for(int i=0; i<computers.length; i++){
            System.out.println("idx : " + i);
            bfs(i, computers);
        }
        
        return answer;
    }
    
    static void bfs(int idx, int[][] computers){
        System.out.println("visited : " + map.keySet());
        if(!map.containsKey(idx)){
            answer++;
        }
        map.put(idx, true);
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(idx);
        
        while(!queue.isEmpty()){
            int next = queue.poll();

            for(int i=0; i<computers[next].length; i++){
                if(!map.containsKey(i) && computers[next][i] == 1){
                    map.put(i, true);
                    queue.add(i);
                }
            }
        }
        System.out.println("num networks : " + answer);
        System.out.println("nowvisited : " + map.keySet() + "\n");
    }
}
