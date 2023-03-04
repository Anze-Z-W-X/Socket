package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

//  必须先run  SocketTCPServer才不报错
public class SocketTCPClient {
    @SuppressWarnings({"all"})
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(),9999); //链接本机的9999端口
        OutputStream outputStream = s.getOutputStream();    //输出流发出信息
        outputStream.write("Hello,world".getBytes());
        s.shutdownOutput();
        InputStream is = s.getInputStream();
        byte[] b = new byte[32];
        int r = 0;
        while((r=is.read(b))!=-1){
            System.out.println(new String(b,0,r));
        }
        s.close();
        outputStream.close();
        is.close();
    }
}
