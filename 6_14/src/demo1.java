/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/14 21:19
 * @Version 1.0
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {

    }
}

class Solution1 {
    public int[] findDiagonalOrder(int[][] mat) {
        int x = mat.length,y = mat[0].length,n = x * y;
        int dir = 1,index = 0;
        int[] ans = new int[n];
        int p = 0, q = 0;
        while(index < n){
            ans[index++] = mat[p][q];
            int xp = p,yq = q;
            if(dir == 1){
                xp -= 1;
                yq += 1;
            }else {
                xp += 1;
                yq -= 1;
            }
            if(index < n && (xp < 0 || xp >= x || yq < 0 || yq >= y )){
                if(dir == 1){
                    xp = q + 1 < y ? xp : xp - 1;
                    yq = q + 1 < y ? yq + 1 : yq;
                }else {
                    xp = p + 1 < x ? xp + 1 : xp;
                    yq = p + 1 < x ? yq : yq + 1;
                }
                dir *= -1;
            }
            p = xp;
            q = yq;
        }
        return ans;
    }
}


public class demo1 {
    public static void main(String[] args) {

    }
}
