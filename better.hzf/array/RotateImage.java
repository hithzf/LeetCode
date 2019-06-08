package array;

import java.util.Arrays;

/**
 * 48.Rotate Image
 * 给定一个二维数组，将其顺时针旋转90度
 * @author hzf
 * @see https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {
	
	public void rotate(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for(int layer = 0; layer < row / 2; layer++){
        	int i = layer;
        	int last = row-layer-1;
        	for(int j = i; j < last; j++){
        		int temp1 = matrix[j][last];
        		matrix[j][last] = matrix[i][j];
        		
        		int temp2 = matrix[last][last-(j-layer)];
        		matrix[last][last-(j-layer)] = temp1;
        		
        		int temp3 = matrix[last-(j-layer)][i];
        		matrix[last-(j-layer)][i] = temp2;
        		
        		matrix[i][j] = temp3;
        	}
        }
    }

	public static void main(String[] args) {
		RotateImage rotate = new RotateImage();
		int[][] matrix = {{ 5, 1, 9,11, 20},
				  { 2, 4, 8,10, 30},
				  {13, 3, 6, 7, 40},
				  {15,14,12,16, 50},
				  {60, 70, 80, 90, 100}};
		rotate.rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			System.out.println(Arrays.toString(matrix[i]));
		}
	}

}
