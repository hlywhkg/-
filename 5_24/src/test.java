import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/24 19:46
 * @Version 1.0
 */

class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n == 1 || n == 0){
            System.out.println("both");
        }
        String str[] = new String[n];
        for(int i = 0 ; i < n ; i++){
            str[i] = scan.nextLine();
        }
        boolean flg1 = false;
        boolean flg2 = false;
        for(int i = 0 ; i < n - 1 ; i++){
            if(str[i].compareTo(str[i+1]) <= 0){
                flg1 = true;
            }else{
                flg1 = false;
                break;
            }
        }
        for(int i = 0 ; i < n - 1 ; i++){
            if(str[i].length() <= str[i + 1].length()){
                flg2 = true;
            }else{
                flg2 = false;
                break;
            }
        }

        if(flg1 && flg2){
            System.out.println("both");
        }else if(flg1){
            System.out.println("lexicographically");
        }else if(flg2){
            System.out.println("lengths");
        }else{
            System.out.println("none");
        }

    }
}


public class test {
    public static void main(String[] args) {
        //Set<Character> set = new HashSet<>();
        String str = new String("hell>@$osd*emv");
        str = str.replace(str.charAt(1),(char)(str.charAt(1) - 32));
        System.out.println(str);
        String regex = "[^a-zA-Z]";
        //str = str.replaceAll(regex,str);
        String str1[] = str.split(regex);
        System.out.println(Arrays.toString(str1));
        System.out.println(str1.length);
        for (int i = 0; i < str1.length; i++) {
            if(str1[i].equals("")){
                System.out.println("i am null");
            }
        }
        //System.out.println(str);
        StringBuilder sb = new StringBuilder("123 ");
        sb.delete(sb.length()-1,sb.length());
        System.out.print(sb);
        System.out.print("l");
        List list = new LinkedList();

    }
}
