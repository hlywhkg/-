/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/24 14:52
 * @Version 1.0
 */
import java.util.*;

import java.util.LinkedList;

import java.util.LinkedList;


class LRU {
    public void L(int[] seq,int pages){
        int page_break = 0;// 断页次数
        // 储存容器，LinkedList底层通过链表来实现，随着元素的增加不断向链表的后端增加节点
        LinkedList<Integer> list = new LinkedList<Integer>();
        // 通过for循环来遍历seq数组
        for (int i = 0; i < seq.length; i++) {
            if (list.contains(seq[i])) {// 如果即将访问的序列在物理块中，重新记录其访问状态
                int flag = list.indexOf(seq[i]);// 标记已经存在的序列的下标
                list.remove(flag);// 删除这个元素
                list.addLast(seq[i]);// 在末尾重新添加它
            } else {// 如果即将访问的序列不在物理块中，添加到物理块中；如果满了，找到最久不被访问的序列，并删除替换
                if(list.size()!=pages) {
                    list.addLast(seq[i]);// 该方法表示将指定的元素追加到此列表的末尾
                    page_break++;//访问序列不存在，断页加一
                }else {
                    list.removeFirst();// 删除第一个元素
                    list.addLast(seq[i]);// 追加最后一个新元素
                    page_break++;// 置换，断页加一
                }
            }
        }
        // 输出结果
        System.out.println("断页次数：" + page_break + "\n断页中断率：" + page_break * 1.0 / seq.length);
    }
}


class FIFO {
    public void F(int[] seq,int pages) {
        int page_break = 0;// 断页次数
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < seq.length; i++) {
            if (list.contains(seq[i])) {// 如果即将访问的序列在物理块中，直接跳过
                continue;
            } else {// 如果即将访问的序列不在物理块中，添加到物理块中；如果满了，找到最久不被访问的序列，并删除替换
                if(list.size() != pages) {
                    list.addLast(seq[i]);// 该方法表示将指定的元素追加到此列表的末尾
                    page_break++;//访问序列不存在，断页加一
                }else {
                    list.removeFirst();// 删除第一个元素
                    list.addLast(seq[i]);// 追加最后一个新元素
                    page_break++;// 置换，断页加一
                }
            }
        }
        // 输出结果
        System.out.println("断页次数：" + page_break + "\n断页中断率：" + page_break * 1.0 / seq.length);
    }
}



class OPT {
    private static List<Integer> new_list = new ArrayList<Integer>();//定义一个缓存容器，备用
    private static int temp = 0;//定义每次置换时需要替换的元素序列号

    public void O(int[] seq,int pages) {
        int page_break = 0;//定义断页次数
        LinkedList<Integer> list = new LinkedList<Integer>();//定义一个缓存容器
        for (int i = 0; i < seq.length; i++) {
            if (!list.contains(seq[i])) {//如果list不包含访问序列需要访问的序列号时，包含则跳过
                if (list.size() != pages) {//当物理块未满时
                    list.addLast(seq[i]);//追加到此列表的末尾
                    page_break++;//断页加一
                }else {//如果物理块满了
                    int flag = list.indexOf(index(seq,list,i));//此返回值为需要替换的序列号
                    list.remove(flag);//删除这个元素
                    list.addLast(seq[i]);// 追加最后一个新元素
                    page_break++;// 置换，断页加一
                }
            }
        }
        //输出结果
        System.out.println("断页次数：" + page_break + "\n断页中断率：" + page_break * 1.0 / seq.length);
    }
    //此方法主要是寻找需要替换的序列号，参数分别表示为访问序列号，物理块所装的序列号，当前要访问的序列号
    //temp和new_list均为静态变量，因为在进行下一次的调用时，上一次的值会保留下来，这样有利于比较值的大小
    public static int index(int[] seq, LinkedList<Integer> list, int num) {
        int value = 0;//定义返回值
        //该for循环主要是添加当前访问序列之后的所有序列号，每次调用该方法，前一次的数据会被清空，再添加相应的元素
        for (int j = num + 1; j < seq.length; j++) {
            new_list.add(seq[j]);
        }
        //对物理块中的数据进行for循环
        for (int k = 0; k < list.size(); k++) {
            if (new_list.indexOf(list.get(k)) != -1) {//如果能在当前序列号之后的元素中找到相应的的元素
                int flag = new_list.indexOf(list.get(k));//用flag记下它的下标
                if(temp < flag) {//如果temp小于flag，则表明它离当前访问序列号越远，也就是要被淘汰的，赋值给temp
                    temp = flag;
                }
                if(k == list.size() - 1) {//如果到末尾了，将最后所比的值赋值给value
                    value = new_list.get(temp);
                }
            }else {//如果不能在当前序列号之后的元素中找到相应的的元素
                value = list.get(k);//直接获得需要替换的值
                temp = 0;//令temp=0；恢复初始值
                new_list.clear();//清空new_list，恢复初始值
                return value;
            }
        }
        new_list.clear();//清空new_list，恢复初始值
        temp=0;//令temp=0；恢复初始值
        return value;
    }
}

public class demo1 {
    public static void main(String[] args) {
        while(true) {
            int pages = 0;// 定义页面框数
            int num = 0;// 定义选择数字
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入用户访问序列走向：");
            String str = scan.nextLine();// 获取序列
            String[] str1 = str.split(" ");// 将获取的访问序列用分隔符空格分装到字符串数组里
            int[] seq=new int[str1.length];// 定义访问序列
            for (int i = 0; i < str1.length; i++) {
                seq[i] = Integer.valueOf(str1[i]);// 将String数组转化为int数组
            }
            System.out.println("请输入页面框数：");
            pages = scan.nextInt();// 获取页面框数
            System.out.println("**** 1、FIFO ****");
            System.out.println("**** 2、LRU ****");
            System.out.println("**** 3、OPT ****");
            num = scan.nextInt();// 获取选择的数字
            switch (num) {
                case 1:
                    new FIFO().F(seq, pages);
                    break;
                case 2:
                    new LRU().L(seq, pages);
                    break;
                case 3:
                    new OPT().O(seq, pages);;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}

