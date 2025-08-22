class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] matrix = new boolean[numCourses][numCourses];
        for(int[] arr : prerequisites){
            int row = arr[0];
            int col = arr[1];
            matrix[row][col] = true;
        }
        for(int V = 0;V < numCourses;V++){
            for(int i = 0;i<numCourses;i++){
                for(int j = 0;j < numCourses;j++){
                    if(!matrix[i][j]){
                        matrix[i][j] = matrix[i][V] && matrix[V][j];
                    }
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            int[] arr = queries[i];
            ans.add(matrix[arr[0]][arr[1]]);
        }
        return ans;
    }
}