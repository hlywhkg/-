import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/18 22:36
 * @Version 1.0
 */
//基于Upd形式创建的服务器
public class UdpEchoServer {
    //创建一个socket对象
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }
    //启动服务器
    public void start() throws IOException {
        while(true){
            //用一个容器接收客户端的请求信息
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            //抛出异常的原因是客户端什么时候发来请求是不确定的
            //接收客户端发来的请求
            socket.receive(requestPacket);
            //把响应的请求转化为String类型
            String request = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
            //响应请求,这只是一个回显服务器,因此许多功能不需要实现
            String response = process(request);
            //把响应写回客户端
            DatagramPacket datagramPacket = new DatagramPacket(response.getBytes(),0,response.getBytes().length
            ,requestPacket.getSocketAddress());
            socket.send(datagramPacket);
            System.out.printf("[%s:%d] req: %s,resp : %s\n",requestPacket.getAddress(),requestPacket.getPort(),request,response);
        }
    }

    private String process(String response) {
        return response;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer udp = new UdpEchoServer(9090);
        udp.start();
    }
}
