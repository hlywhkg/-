import javax.swing.tree.TreeNode;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/2 21:44
 * @Version 1.0
 */

/*class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            ThreeNode tmp = root.right;
            while(tmp.left!=null)tmp = tmp.left;
            tmp.left = root.left;
            return root.right;
        }else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}*/

class Solution1 {
    /*public int check(int i,int j,int m,int n){
        int dx[] = {-1,1,0,0,-1,-1,1,1};
        int dy[] = {0,0,-1,1,-1,1,-1,1};
        int count = 0;
        for (int k = 0; k < 8; k++) {
            if(i+dx[k] >= 0 && i+dx[k] < m && j+dy[k] >=0 && j+dy[k] < n){
                count++;
            }
        }
        return count;
    }*/
    public int[][] imageSmoother(int[][] img) {
        int m = img.length,n = img[0].length;
        int[][] tmp = new int[m+1][n+1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tmp[i][j] = tmp[i-1][j] + tmp[i][j-1]  - tmp[i-1][j-1] + img[i-1][j-1];
            }
        }
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lr = Math.max(0, i - 1), lc = Math.max(0, j - 1);
                int rr = Math.min(m - 1, i + 1), rc = Math.min(n - 1, j + 1);
                int count = (rr - lr + 1) * (rc - lc + 1);
                ret[i][j] =(tmp[rr+1][rc+1] - tmp[rr+1][lc] - tmp[lr][rc+1] + tmp[lr][lc])/count;
            }
        }
        return ret;
    }
}

class NumMatrix {

    int[][] tmp;
    public NumMatrix(int[][] matrix) {
        tmp = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                tmp[i][j] = tmp[i-1][j] + tmp[i][j-1] - tmp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return tmp[row2+1][col2+1] - tmp[row1][col2+1] - tmp[row2+1][col1] + tmp[row1][col1];
    }
}


public class demo {
}
