package Socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {
    public static Map<String, Socket> socketMap = new LinkedHashMap<>();

    public Server() {
        initServer();
    }

//    public static void main(String[] args) {
//        initServer();
//    }

    private static void initServer() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(5002);
            System.out.println("服务器正在运行...");
            for (; ; ) {
                Socket client = ss.accept();
                if((socketMap.get(client.getInetAddress())==null)){
                    System.out.println("新客户端链接：" + socketMap);
                }
                new SocketThread(client).onStart();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static Map<String, Socket> getSocketMap() {
        return socketMap;
    }
    public static void payInfo(String walletAddress, String info) throws Exception{
        System.out.println(socketMap);
        System.out.println("soket.get:"+socketMap.get(walletAddress));
        Socket socket=socketMap.get(walletAddress);
        OutputStream o = socket.getOutputStream();
        PrintWriter w = new PrintWriter(new OutputStreamWriter(o, "UTF-8"), true);
        w.println(info);

    }

}

