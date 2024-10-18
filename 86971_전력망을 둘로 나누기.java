import java.util.*;

class Solution {
    
    static ArrayList<ArrayList<Integer>> nodes;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        nodes = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n;i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            nodes.add(tmp);
        }
        
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            nodes.get(a).add(b);
            nodes.get(b).add(a);
        }
        
        for(int i=0; i<wires.length; i++){
            int a = 0;
            int b = 0;
            
            a = bfs(wires[i][0], wires[i][1]);
            b = bfs(wires[i][1], wires[i][0]);
            
            answer = Math.min(Math.abs(a-b), answer);
        }

        return answer;
    }

    static int bfs(int idx, int other){
        int sum = 1;
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        map.put(idx, true);
        map.put(other, true);
        
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(idx);
        
        while(!deque.isEmpty()){
            int next = deque.poll();
            int size = nodes.get(next).size();
            for(int i=0; i<size; i++){
                int num = nodes.get(next).get(i);
                if(map.containsKey(num)){
                    continue;
                }
                sum++;
                map.put(num, true);
                deque.add(num);
            }
        }
        return sum;
    }
    
}
