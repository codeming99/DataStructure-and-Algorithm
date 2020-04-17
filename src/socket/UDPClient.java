package socket;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        byte[] buff = "hello world".getBytes();

        InetAddress address = InetAddress.getByName("127.0.0.1");

        DatagramPacket packet = new DatagramPacket(buff,buff.length,address,65001);

        socket.send(packet);

        byte[] data = new byte[100];

        DatagramPacket receivedPacket = new DatagramPacket(data,data.length);

        socket.receive(receivedPacket);

        String content = new String(receivedPacket.getData(),0,receivedPacket.getLength());

        System.out.println(content);
    }
}
