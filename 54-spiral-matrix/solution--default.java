class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        int i = 0;
        int j = 0;
        int direction = 1;
        
        int starti = 0;
        int startj = 0;
        int border = 1;
        
        while (i < matrix.length && j < matrix[0].length && matrix[i][j] != Integer.MAX_VALUE) {
            result.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;
            
            switch (direction) {
                // -- right
                case 1: {
                    if (j < matrix[0].length - border) { j++; break; }
                    else direction = 2;
                }
                // -- down
                case 2: {
                    if (i < matrix.length - border) { i++; break; }
                    else direction = 3;
                }
                // -- left
                case 3: {
                    if (j >= border) { j--; break; }
                    else direction = 4;
                }
                // - up
                case 4: {
                    if (i > border && (i - 1 != starti || j != startj)) i--;
                    else {
                        j++;
                        direction = 1;
                        startj = j;
                        starti = i;
                        border++;
                    }
                }
                default: break;
            }
        }
        
        return result;
    }
}