package Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCPClientStr {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(),9999); //链接本机的9999端口
        OutputStream outputStream = s.getOutputStream();    //输出流发出信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));   //用转换流建Bufferedwriter对象
        bufferedWriter.write("hello,server");
        bufferedWriter.newLine();   //插入一个换行符，表示输入结束
        bufferedWriter.flush();     //手动刷新缓存区
        InputStream is = s.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        System.out.println( bufferedReader.readLine());
        s.close();
        outputStream.close();
        is.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
