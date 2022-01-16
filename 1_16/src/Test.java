import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/1/16 9:11
 * @Version 1.0
 */

class RecentCounter {
    //写一个 RecentCounter 类来计算特定时间范围内最近的请求。
    //
    //请你实现 RecentCounter 类：
    //
    //    RecentCounter() 初始化计数器，请求数为 0 。
    //    int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
    //
    //保证 每次对 ping 的调用都使用比之前更大的 t 值
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
            return queue.size();
    }
}
class MyQueue {
    //请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    //
    //实现 MyQueue 类：
    //
    //    void push(int x) 将元素 x 推到队列的末尾
    //    int pop() 从队列的开头移除并返回元素
    //    int peek() 返回队列开头的元素
    //    boolean empty() 如果队列为空，返回 true ；否则，返回 false
    //
    //
    //
    //说明：
    //
    //    你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
    //    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    //
    //
    //
    //进阶：
    //
    //    你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(!stack2.isEmpty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                int a = stack1.pop();
                stack2.push(a);
            }
            return stack2.pop();
        }
    }

    public int peek() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }else{
            while(!stack1.isEmpty()){
                int a = stack1.pop();
                stack2.push(a);
            }
            return stack2.peek();
        }
    }

    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())return true;
        else return false;
    }
}
class MyCircularQueue {
    //设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
    //
    //循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
    //
    //你的实现应该支持如下操作：
    //
    //    MyCircularQueue(k): 构造器，设置队列长度为 k 。
    //    Front: 从队首获取元素。如果队列为空，返回 -1 。
    //    Rear: 获取队尾元素。如果队列为空，返回 -1 。
    //    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    //    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    //    isEmpty(): 检查循环队列是否为空。
    //    isFull(): 检查循环队列是否已满。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/design-circular-queue
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int []elem;
    public int front;
    public int rear;
    public MyCircularQueue(int k) {
        this.elem = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull())return false;
        else {
            this.elem[rear] = value;
            rear = (rear+1)%elem.length;
            return true;
        }
    }

    public boolean deQueue() {
        if(isEmpty())return false;
        else{
            elem[front] = 0;
            front = (front+1)%elem.length;
            return true;
        }
    }

    public int Front() {
        if(isEmpty())return -1;
        else return this.elem[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int index = -1;
        if(rear == 0) {
            index = elem.length-1;
        }else {
            index = rear-1;
        }
        return elem[index];
    }

    public boolean isEmpty() {
        if(front == rear && elem[rear] == 0)return true;
        else return false;
    }

    public boolean isFull() {
        if(front == rear && elem[rear] != 0)return true;
        else return false;
    }
}
public class Test {
    public static void main(String[] args) {
        MyCircularQueue mq = new MyCircularQueue(3);
        System.out.println(mq.enQueue(1));
        System.out.println(mq.enQueue(2));
        System.out.println(mq.enQueue(3));;
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
        System.out.println(mq.enQueue(3));
        System.out.println(mq.enQueue(5));
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
        System.out.println(mq.deQueue());
    }
}
