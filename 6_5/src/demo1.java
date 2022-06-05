import java.util.Random;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/6/5 21:47
 * @Version 1.0
 */
//    F(i) = F(i-1) + sum - n * A(n-i)
class Solution2 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0,F = 0,ret = 0,n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        ret = F;
        for (int i = 1; i < n; i++) {
            F = F + sum - n * nums[n - i];
            if(ret < F){
                ret = F;
            }
        }
        return ret;
    }
}

class Solution {
    double r,x,y;
    Random random = new Random();
    public Solution(double radius, double x_center, double y_center) {
        this.r = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(random.nextDouble()*r*r),ang = random.nextDouble() * 2 * Math.PI;
        double dx = len * Math.cos(ang),dy = len * Math.sin(ang);
        return new double[]{dx,dy};
    }
}

public class demo1 {
}
