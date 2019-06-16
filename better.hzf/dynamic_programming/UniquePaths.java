package dynamic_programming;

/**
 * 62.Unique Paths
 * m x n�ľ��󣬴����Ϸ��ߵ����·��ж������߷���һ��ֻ�����Һ������ƶ�һ��
 * @author hzf
 * @see https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {
	public int uniquePaths(int m, int n) {
        int down = m + n - 2;
        int up = Math.min(n - 1, m - 1);
        long res = 1;
        for(int i = 1; i <= up; i++){
            res *= (down - i + 1);
        }
        for(int i = 1; i <= up; i++){
            res /= i;
        }
        return (int)res;
    }
}
