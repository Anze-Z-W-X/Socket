package Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServerStr {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);    //不能有其他服务在监听9999
        System.out.println("端口9999正在监听!");
        Socket s = ss.accept();   //当没有客户端连接9999，程序会阻塞在此
        InputStream s_ac = s.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s_ac));
        System.out.println(bufferedReader.readLine());

        OutputStream os = s.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os));
        bufferedWriter.write("hello,Client");
        bufferedWriter.newLine();
        bufferedWriter.flush();
        ss.close();
        s_ac.close();
        s.close();
        os.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
