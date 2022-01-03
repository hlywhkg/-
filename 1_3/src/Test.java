/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/3 19:46
 * @Version 1.0
 */

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        //给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
        //
        //输入为三个整数：day、month 和 year，分别表示日、月、年。
        //
        //您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
        //
        //来源：力扣（LeetCode）
        //链接：https://leetcode-cn.com/problems/day-of-the-week
        //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
        int []months = {31,28,31,30,31,30,31,31,30,31,30,31};
        String []week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        //总天数
        int days =( year - 1971 ) * 365 + (year - 1969) /4;//只有到1971年才算贡献了一年的天数，所以从1971年开始，1969是因为1968年是闰年，1969年闰年才贡献了一天
        for (int i = 0; i < month-1; i++) {
            days += months[i];
        }
        if(year %4==0 && year % 100 !=0 || year %400==0){
            if(month > 2)days += 1;
        }
        days += day;
        return week[(days+3) %7];
    }
}
public class Test {
}
