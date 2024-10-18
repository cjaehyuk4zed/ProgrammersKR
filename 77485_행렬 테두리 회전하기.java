import java.util.*;

class Solution {
    
    static int[][] matrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        
        // Init matrix;
        matrix = new int[rows][columns];
        int num = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                num++;
                matrix[i][j] = num;
            }
        }
        
        for(int i=0; i<queries.length;i++){
            int min = calc(queries[i]);
            list.add(min);
        }
        
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static int calc(int[] query){
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        
        int start = matrix[x1][y1];
        int min = start;
        
        // Move ^
        for(int i=x1; i<x2;i++){
            int num = matrix[i+1][y1];
            matrix[i][y1] = num;
            min = Math.min(min, num);
        }
        // Move <-
        for(int i=y1; i<y2; i++){
            int num = matrix[x2][i+1];
            matrix[x2][i] = num;
            min = Math.min(min, num);
        }
        // Move V
        for(int i=x2; i>x1; i--){
            int num = matrix[i-1][y2];
            matrix[i][y2] = num;
            min = Math.min(min, num);
        }
        // Move <-
        for(int i=y2; i>y1+1; i--){
            int num = matrix[x1][i-1];
            matrix[x1][i] = num;
            min = Math.min(min, num);
        }
        matrix[x1][y1+1] = start;
        return min;
    }
    
}
