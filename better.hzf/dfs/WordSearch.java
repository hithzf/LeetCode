package dfs;

/**
 * 79. Word Search
 * @author hzf
 * @see https://leetcode.com/problems/word-search/
 */
public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
		if(word.isEmpty() || board.length == 0){
			return false;
		}
		boolean res = false;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if(board[i][j] == word.charAt(0)){
					boolean[][] passed = new boolean[board.length][board[0].length];
					res = res || canMatch(board, passed, i, j, word);
				}
			}
		}
		return res;
    }
	
	public boolean canMatch(char[][] board, boolean[][] passed, int i, int j, String word){
		if(word.isEmpty()){
			return true;
		}
		if(board[i][j] != word.charAt(0) || passed[i][j] == true){
			return false;
		}else{
			//TODO:do not ignore
			if(word.length() == 1){
				return true;
			}
			boolean res = false;
			passed[i][j] = true;
			if(i-1 > -1){
				res = res || canMatch(board, passed, i-1, j, word.substring(1));
			}
			if(i+1 < board.length){
				res = res || canMatch(board, passed, i+1, j, word.substring(1));
			}
			if(j-1 > -1){
				res = res || canMatch(board, passed, i, j-1, word.substring(1));
			}
			if(j+1 < board[0].length){
				res = res || canMatch(board, passed, i, j+1, word.substring(1));
			}
			//TODO:key step
			if(res == false){
				passed[i][j] = false;
			}
			return res;
		}
	}

	public static void main(String[] args) {
		char[][] board =
			{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
			};
		String word = "";
		WordSearch wordSearch = new WordSearch();
		System.out.println(wordSearch.exist(board, word));
	}

}
