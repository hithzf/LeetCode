package binary_search;

/**
 * 74. Search a 2D Matrix
 * @author hzf
 * @see https://leetcode.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
		//TODO:警惕非法输入
		if(matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		//先找到那一行
        int start = 0, end = matrix.length - 1, row = -1;
        while(start < end - 1){
        	int mid = (start + end) / 2;
        	if(target < matrix[mid][0]){
        		end = mid;
        	}else if(target > matrix[mid][0]){
        		start = mid;
        	}else{
        		return true;
        	}
        }
        if(target > matrix[end][0]){
        	row = end;
        }else if(target < matrix[end][0]){
        	row = start;
        }else{
        	return true;
        }
        //从行里面找是否存在target
        int left = 0, right = matrix[row].length - 1;
        while(left <= right){
        	int mid = (left + right) / 2;
        	if(target < matrix[row][mid]){
        		right = mid - 1;
        	}else if(target > matrix[row][mid]){
        		left = mid + 1;
        	}else{
        		return true;
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		SearchA2DMatrix solution = new SearchA2DMatrix();
		int[][] matrix = {{2,3}};
		System.out.println(solution.searchMatrix(matrix, 1));
	}

}
