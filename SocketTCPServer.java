package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
@SuppressWarnings({"all"})
public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket s = new ServerSocket(9999);    //不能有其他服务在监听9999
        System.out.println("端口9999正在监听!");
        Socket s_ac1 = s.accept();   //当没有客户端连接9999，程序会阻塞在此
        InputStream s_ac = s_ac1.getInputStream();
        byte[] b = new byte[32];
        int r = 0;
        while((r=s_ac.read(b))!=-1){
            System.out.println(new String(b,0,r));
        }
        s_ac1.shutdownInput();
        OutputStream os = s_ac1.getOutputStream();
        os.write("Hello,Client".getBytes());
        s.close();
        s_ac.close();
        s_ac1.close();
        os.close();
    }
}
