package Socket;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.Socket;
import java.util.Map;

class SocketThread extends Thread {
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
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);
            while (flag) {
                String content = reader.readLine();
                if (content == null || content.equals("bye")) {
                    flag = false;
                    System.out.println(socket.getInetAddress() + "已经断开链接");
                    Server.socketMap.remove(socket.getInetAddress());
                    System.out.println(Server.socketMap);
                } else {
                    System.out.println("收到消息：" + content);
                    JSONObject json = JSONObject.parseObject(content);
                    String preString = json.getString("preString");
                    if (preString.equals("connect")) {
                        Server.socketMap.put(json.getString("data"), socket);
                        System.out.println(Server.socketMap);
                    }
                    transmitInfo(content);
                }

            }
        } catch (Exception e) {
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

    public void transmitInfo(String content) throws Exception {
        Map<String, Socket> socketMap = Server.getSocketMap();
        for (Map.Entry<String, Socket> entry : socketMap.entrySet()) {
            Socket s = entry.getValue();
            OutputStream o = s.getOutputStream();
            PrintWriter w = new PrintWriter(new OutputStreamWriter(o, "UTF-8"), true);
            w.println(content);
        }
    }


}