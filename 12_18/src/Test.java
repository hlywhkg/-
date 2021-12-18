/**
 * @ClassName $申先生
 * @Description days
 * @date 2021/12/18 8:15
 * @Version 1.0
 */
class Solution1 {
    //给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
    //
    //战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/battleships-in-a-board
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int countBattleships(char[][] board) {//如果是战舰，则相邻的有x则一定是同一架，则返回继续寻找
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            int k = i;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') {
                        continue;
                    }
                    if (j > 0 && board[i][j - 1] == 'X') {
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
}
class Solution2 {
    //给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
    //
    //回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        String str = Integer.toString(x);
        int left = 0;
        int right = str.length()-1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        if(left >= right){
            return true;
        }
        return false;
    }
}
public class Test {
    public static void main(String[] args) {
        /*String str = "123321";
        int left = 0;
        int right = str.length();
        while(left < right) {
            System.out.println(str.charAt(left));
            left++;
            System.out.println(str.charAt(right));
            right--;
            System.out.println(str.charAt(left) == str.charAt(right));
        }*/
        int a = 10;
        Solution2 solution2 = new Solution2();
        boolean b = solution2.isPalindrome(a);
        System.out.println(b);
    }
}
