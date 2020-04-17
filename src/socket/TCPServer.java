package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建socket，并将socket绑定到65000端口上
        ServerSocket serverSocket = new ServerSocket(65000);

        //死循环，使得socket一直等待并处理客户端发送过来的请求
        while(true){
            //监听65000端口，直到客户端返回连接信息才返回
            Socket socket = serverSocket.accept();
            //获取客户端的请求信息后，执行相关业务逻辑
            new LengthCalculator(socket).start();
        }
    }
}
