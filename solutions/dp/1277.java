class Solution {
    public int countSquares(int[][] matrix) {
        return dpsol(matrix);
    }
    
    // dp solution
    public int dpsol(int[][] mat) {
        int total = 0;
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0)
                    continue;
                if(i == 0 || j == 0) {
                    total += 1;
                    continue;
                }
                int min = Math.min(mat[i-1][j-1], Math.min(mat[i-1][j], mat[i][j-1]));
                mat[i][j] += min;
                total += mat[i][j];
            }
        }
        return total;
    }
}