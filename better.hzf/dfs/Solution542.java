package dfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution542 {

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] res = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] - 1 > -1 && matrix[cur[0]-1][cur[1]] == 1){
                if(res[cur[0]-1][cur[1]] == 0 || res[cur[0]][cur[1]] + 1 < res[cur[0]-1][cur[1]]){
                    res[cur[0]-1][cur[1]] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{cur[0]-1, cur[1]});
                }
            }
            if(cur[0] + 1 < matrix.length && matrix[cur[0]+1][cur[1]] == 1){
                if(res[cur[0]+1][cur[1]] == 0 || res[cur[0]][cur[1]] + 1 < res[cur[0]+1][cur[1]]){
                    res[cur[0]+1][cur[1]] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{cur[0]+1, cur[1]});
                }
            }
            if(cur[1] - 1 > -1 && matrix[cur[0]][cur[1]-1] == 1){
                if(res[cur[0]][cur[1]-1] == 0 || res[cur[0]][cur[1]] + 1 < res[cur[0]][cur[1]-1]){
                    res[cur[0]][cur[1]-1] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{cur[0], cur[1]-1});
                }
            }
            if(cur[1] + 1 < matrix[0].length && matrix[cur[0]][cur[1]+1] == 1){
                if(res[cur[0]][cur[1]+1] == 0 || res[cur[0]][cur[1]] + 1 < res[cur[0]][cur[1]+1]){
                    res[cur[0]][cur[1]+1] = res[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{cur[0], cur[1]+1});
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] matrix = {{0,1,1,1}, {0,1,1,1},{1,1,0,1},{1,1,1,1}};
        int[][] res = new Solution542().updateMatrix(matrix);
    }
}