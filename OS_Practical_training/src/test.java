import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.win32.StdCallLibrary;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/5/27 18:43
 * @Version 1.0
 */


public class test{
    /**
     * 调用系统自带dll文件
     */
    public interface  CLibrary extends Library {
        CLibrary a = (CLibrary)Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),CLibrary.class);
        void printf(String format , Object ... args);
    }

    public static void main1(String[] args) {
        CLibrary.a.printf("Hello,World, DLL is successful");

        for (int i = 0; i < args.length; i++) {
            CLibrary.a.printf("Argument %d : %s/n",i,args[i]);
        }
        System.getProperty("java.library.path");
    }

}

class Main{

    public interface CLibrary extends StdCallLibrary{
        CLibrary a = (CLibrary) Native.loadLibrary("D:\\gitee\\one-question-per-day\\OS_Practical_training\\MyDLL.dll",CLibrary.class);
        int add(int a,int b);
    }

    public static void main(String[] args) {
        System.out.println("the result of calling MyDLL.dll is " + CLibrary.a.add(2,3));
    }
}