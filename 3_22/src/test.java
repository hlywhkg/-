import java.util.Locale;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/3/22 8:35
 * @Version 1.0
 */

abstract class fun2{
    int a =1;
    public abstract void fun1();
}
class Main{
    public static void fun1(){
        System.out.println("hello");
    }
}
public class test {
    public static boolean fun1(String a){
        return a.toLowerCase() == "admin";
    }
    void fun2(){

    }
    void test(){

    }
    public static void swap(int i ,int j ,String[]ret){
        String tmp = ret[i];
        ret[i] = ret[j];
        ret[j] = tmp;
    }
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] ret = str.split(" ");
        int length = ret.length;
        for(int i = 0 ; i < length / 2;i++){
            swap(i,length-i-1,ret);
        }
        for(int i = 0;i < length - 1;i++){
            System.out.print(ret[i]+" ");
        }
        System.out.print(ret[length-1]);
    }
    public static void main1(String[] args) {
       Main main = null;
       main.fun1();
        System.out.println(fun1("Admin"));

    }
}

/*"""class Com:
  def __init__(self,a,b,c):
    self.a = a
    self.b = b
    self.c = c
  def add(self):
    sum = self.a+self.b+self.c
    return sum
  def avg(self):
    sum = self.a+self.b+self.c
    return sum/3
a,b,c =map(int, input().split())
com = Com(a,b,c)
print(com.add())
print(com.avg())"""



        """class Student:
  def __init__(self,name):
    self.name = name
  def p(self):
    print(self.name)
    print(Student.__name__)
n = input()
s1 = Student(n)
s1.p()"""


        # class Student:
        #   def __init__(self,name):
        #     self.name = name
        #   def p(self):
        #     print(self.name + " loves study")
        # n = input()
        # s1 = Student(n)
        # s1.p()

class Animal(object):
        def __init__(self,name):
        self.name = name
        def say(self):
        print(self.name + "say")
        def says(animal):
        animal.say()

class Cow(Animal):
        def __init__(self,name):
        super(Cow, self).__init__(name)
        def say(self):
        print(self.name + ' says "muu"')

class Sheep(Animal):
        def __init__(self,name):
        super(Sheep, self).__init__(name)
        def say(self):
        print(self.name + ' says "mee"')

        a = input()
        b = input()
        if a == "cow":
        k = Cow(b)
        k.say()
        if a == "sheep":
        k = Sheep(b)
        k.say()*/
