package other.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @desc: 服务端，不断循环接受客户端的连接，接受到一个连接就为其分配一个线程（使用线程池），去执行读写
 * @author: AruNi_Lu
 * @date: 2023/4/4
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8888);
        ) {
            // 使用线程池来提高效率
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50,
                    100, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));

            System.out.println("服务端启动！");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("客户端连接成功：IP[" + clientSocket.getInetAddress() + "]，" + "PORT[" + clientSocket.getPort() + "]");
                // 为每个客户端分配一个线程去执行数据的读写
                executor.execute(new ServerHandler(clientSocket));
            }
        } catch (Exception e) {
            throw new IOException("服务端出错", e);
        }
    }

    /**
     * 服务端执行的任务
     */
    private static class ServerHandler implements Runnable {
        private Socket socket;

        public ServerHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
            ) {
                while (true) {
                    String receiveCMD = reader.readLine();
                    System.out.println("收到 " + socket.getRemoteSocketAddress() + " 的命令: " + receiveCMD);

                    // 回复客户端
                    String replyInfo = new StringBuilder(receiveCMD)
                            .delete(receiveCMD.length() - 2, receiveCMD.length())
                            .reverse()
                            .toString();
                    replyInfo += "\\n";
                    writer.write(replyInfo + "\n");
                    writer.flush();
                }
            } catch (Exception e) {
                System.out.println(socket.getRemoteSocketAddress() + " 已断开连接！");
            }
        }
    }
}
