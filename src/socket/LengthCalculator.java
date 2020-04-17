package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LengthCalculator extends Thread{
    private Socket socket;

    public LengthCalculator(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run(){
        try{
            //获取socket的输入输出流
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();

            int ch;
            //buff主要用来读取输入的内容，存成byte数组
            byte[] buff = new byte[1024];

            ch = is.read(buff);
            //将接收流的byte数组转换成字符串
            String content = new String(buff,0,ch);
            System.out.println(content);
            //往输出流里写入获得的字符串的长度，回发给客户端
            os.write(String.valueOf(ch).getBytes());

            is.close();
            os.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
