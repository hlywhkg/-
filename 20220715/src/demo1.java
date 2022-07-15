import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/7/15 12:55
 * @Version 1.0
 */

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()){
            s2.push(x);
        }else{
            if(s2.peek() > x){
                s2.push(x);
            }
        }
    }

    public void pop() {
        if(s1.pop().equals(s2.peek())){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.pop();
    }
}

class CQueue {

    //出队列
    Stack<Integer> s1;
    //入队列
    Stack<Integer> s2;
    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void appendTail(int value) {
        s2.push(value);
    }

    public int deleteHead() {
        if(!s1.isEmpty()){
            return s1.pop();
        }else if(!s2.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return s1.pop();
        }else{
            return -1;
        }
    }
}


class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(str.contains("joker JOKER")){
                System.out.println("joker JOKER");
            }else{
                String[] ans = str.split("-");
                String x = ans[0],y = ans[1];
                if(isX(x,y)){
                    int p1 = isDX(x),p2 = isDX(y);
                    if(p1 != -1 && p2 != -1){
                        System.out.println("JOKER");
                    }else if(p1 != -1 && p2 == -1 || p1 == -1 && p2 != -2){
                        System.out.println("joker");
                    }else{
                        p1 = compare(x.charAt(0));
                        p2 = compare(y.charAt(0));
                        int n = x.length();
                        if(p1 > p2){
                            System.out.println(x);
                        }else{
                            System.out.println(y);
                        }
                    }
                }else{
                    int n1 = isZ(x),n2 = isZ(y);
                    if(n1 != -1){
                        System.out.println(x);
                    }else if(n2 != -1){
                        System.out.println(y);
                    }else{
                        System.out.println("ERROR");
                    }
                }
            }
        }
    }
    public static int isZ(String str){
        int ans = str.charAt(0) - '0';
        if(str.length() == 4){
            for (int i = 1; i < 4; i++) {
                if(!(str.charAt(i) - '0' == ans)){
                    return -1;
                }
            }
        }
        return ans;
    }
    public static int isDX(String str){
        if(str.equals("joker")){
            return 12;
        }else if(str.equals("JOKER")){
            return 13;
        }else{
            return -1;
        }
    }
    public static int compare(char c){
        String tmp = "34567891JQKA2";
        for (int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == c){
                return i;
            }
        }
        return -1;
    }
    public static boolean isX(String str1,String str2){
        if(str1.length() == str2.length()){
            return true;
        }else{
            return false;
        }
    }
}

public class demo1 {
}
