import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/4/18 23:05
 * @Version 1.0
 */

public class UdpEchoClient {
    DatagramSocket socket = null;
    private int serverPort;
    private String serverIp;

    public UdpEchoClient(String serverIp, int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("->");
            String request = scan.next();
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),0,request.getBytes().length
            , InetAddress.getByName(serverIp),serverPort);

            socket.send(requestPacket);
            //从服务器读取的响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");
            // 4. 把响应结果显示到控制台上.
            System.out.printf("req: %s, resp: %s\n", request, response);
        }
    }
    public static void main(String[] args) throws IOException {
        // 由于服务器和客户端在同一个机器上, 使用的 IP 仍然是 127.0.0.1 . 如果是在不同的机器上, 当然就需要更改这里的 IP 了
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
