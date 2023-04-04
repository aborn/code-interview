package other.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @desc: 客户端：
 *  1. 使用 Socket 绑定服务端的 ip:port
 *  2. 用客户端 socket 获取输入输出流，再包装成缓冲流
 *
 * 循环事件：
 *  1. 使用 BufferedWriter#write() 发送信息给服务端
 *  2. 使用 BufferedReader#readLine() 读取服务端返回的信息
 *
 * @author: AruNi_Lu
 * @date: 2023/4/4
 */
public class TcpClient {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("127.0.0.1", 8888);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            System.out.println("客户端启动！");
            StringBuilder cmd = new StringBuilder();
            while (true) {
                System.out.print("发送命令：");
                String str = sc.nextLine();
                cmd.append(str);

                // 读取到 "\n"，则发送命令给服务端
                if (str.endsWith("\\n")) {
                    writer.write(cmd + "\n");
                    writer.flush();
                    cmd = new StringBuilder();
                    // 读取服务端返回的信息
                    String receive = reader.readLine();
                    System.out.println("接收到服务端的回复：" + receive);
                }
            }
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
