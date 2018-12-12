package Socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        initClient();
    }

    private static void initClient() {
        try {
            boolean flag = true;
            Socket socket = new Socket("127.0.0.1", 5002);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
            Scanner scanner = new Scanner(System.in);
            while (flag) {
                String content = scanner.next();
                System.out.println("client 等待用户输入：");
                writer.println(content + ":" + System.currentTimeMillis());
                SocketThread socketThread=new SocketThread(socket);
                socketThread.start();

            }
            scanner.close();
            reader.close();
            writer.close();
            socket.close();

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    static class SocketThread extends Thread {
        private Socket socket;
        private boolean flag = true;

        public SocketThread(Socket socket) {
            this.socket = socket;
        }

        public void onStart() {
            this.start();
        }

        @Override
        public void run() {
            System.out.println("链接成功！");
            BufferedReader reader = null;
            BufferedWriter writer = null;
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

                while (flag) {
                    String content = reader.readLine();
                    if (content == null || content.equals("bye")) {
                        flag = false;
                        System.out.println(socket.getPort() + "已经断开链接");
                    } else {
                        System.out.println("收到消息：" + content);
                        writer.write("我收到了您的消息！ 在" + System.currentTimeMillis());
                        writer.flush();
                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                System.out.println(socket.getPort() + "已经断开链接");
                flag = false;
            } finally {
                try {
                    reader.close();
                    writer.close();
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }
    public static void write(String info, PrintWriter writer){
        writer.println(info);

    }

}
