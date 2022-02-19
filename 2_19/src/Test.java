import java.util.*;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/2/19 8:50
 * @Version 1.0
 */

class Person{

}

class Student extends Person{

}

public class Test {
    //key是关键字  value是出现的次数
    public static Set<Integer> func2(int[] array) {
        /*Map<Integer,Integer> map = new HashMap<>();
       //判断array中的元素 是否在map当中，如果不在就是1.在就是在原来的基础上+1
        for(int i = 0 ; i < array.length ; i ++){
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }*/
        Set<Integer>set = new HashSet<>();
        int first = 0;
        int ret = 0;
        for (int x: array) {
            if(first == 0 && set.contains(x)){
                first++;
                ret = x;//记录第一个
            }
            set.add(x);
        }
        return set;
    }

    //key是关键字  value是出现的次数
    public static Map<Integer,Integer> func1(int[] array) {
        Map<Integer,Integer> map = new HashMap<>();
       //判断array中的元素 是否在map当中，如果不在就是1.在就是在原来的基础上+1
        for(int i = 0 ; i < array.length ; i ++){
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }
        Set<Integer>set = new HashSet<>();
        int first = 0;
        int ret = 0;
        for (int x: array) {
            if(first == 0 && set.contains(x)){
                first++;
                ret = x;//记录第一个
            }
            set.add(x);
        }
        return map;
    }
    public static void main(String[] args) {
        int[] array = new int[1_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        Map<Integer,Integer> map = func1(array);
        System.out.println(map);
    }
    public static Object[] array = new Object[10];

    public static void main2(String[] args) {
        ArrayList<? super Person>list = new ArrayList<>();
        //Person person = list.get(1);
        //Student student = list.get(1);
        ArrayList<Person>list1 = new ArrayList<>();
    }
    public static void main1(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.get(1);
    }
}
