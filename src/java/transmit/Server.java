package transmit;

import block.Block;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Server {
    public static DatagramSocket datagramSocket;
    public static DatagramPacket datagramPacket;
    public static File file;
    private static List<String> Clients = new ArrayList<>();
    private static Map<String, InetAddress> addressMap = new LinkedHashMap<>();
    private static Map<String, Integer> portMap = new LinkedHashMap<>();

    public Server(DatagramSocket ds) {

        try {
            byte buffer[] = new byte[1024];
            datagramSocket = ds;
            datagramPacket = new DatagramPacket(buffer, buffer.length);
            while (true) {
                receiveString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void receiveString() throws Exception {
        datagramSocket.receive(datagramPacket);
        String receive = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        datagramPacket.setLength(1024);
        int size = Integer.parseInt(receive);
        byte buffer[] = new byte[size];
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        datagramSocket.receive(dp);
        String info = new String(dp.getData(), 0, dp.getLength());
        JSONObject jsonObject = JSON.parseObject(info);
        System.out.println(jsonObject);
        String preString = jsonObject.getString("preString");
        if (preString.equals("connect")) {
            String name = jsonObject.getString("walletAddress");
            InetAddress address = dp.getAddress();
            int port = dp.getPort();
            Clients.add(name);
            addressMap.put(name, address);
            portMap.put(name, port);
            System.out.println(Clients);
            System.out.println(addressMap);
            System.out.println(portMap);
            JSONObject jsonObject1=new JSONObject();
            jsonObject1.put("preString","respons_connect");
            jsonObject1.put("status","success");
            Client.Response(jsonObject1.toJSONString(),address,port);

        }
        if (preString.equals("newUser")) {
            transmit(info);
//            String data=jsonObject.getString("data");
//            ArrayList<Block> blockChians = readFile(file);
//            Block block=null;
//            if (blockChians == null) {
//                blockChians=new ArrayList<>();
//                block=new Block(data,String.valueOf(0));
//            }else {
//                block=new Block(data,blockChians.get(blockChians.size() - 1).hash);
//            }
//            blockChians.add(block);
//            String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChians);
//            outputFile(file,blockchainJson);
//
//            String blockJson = new GsonBuilder().setPrettyPrinting().create().toJson(block);

        }
    }

    public static ArrayList<Block> readFile(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fis);
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String str;
        String info = "";
        while ((str = bf.readLine()) != null) {
            info += str;
        }
        ArrayList<Block> blocks = new ArrayList<>();
        if (!info.equals("")) {
            blocks = (ArrayList<Block>) JSONObject.parseArray(info, Block.class);
            System.out.println(blocks);
            return blocks;
        }
        return null;
    }
        public static void transmit(String info) throws Exception{
        String size=String.valueOf(info.getBytes().length);
        for(int i=0;i<Clients.size();i++){
            String clientName=Clients.get(i);
            System.out.println(clientName);
            InetAddress Address=addressMap.get(clientName);
            int InetPort=portMap.get(clientName);
            DatagramPacket dp=new DatagramPacket(size.getBytes(),size.getBytes().length,Address,InetPort);
            datagramSocket.send(dp);
            dp=new DatagramPacket(info.getBytes(),info.getBytes().length,Address,InetPort);
            datagramSocket.send(dp);
        }
        System.out.println("server transmit string");

    }
    public static void outputFile(File file, String info) throws Exception {
        info = info + "\r\n";
        byte infos[] = info.getBytes();
        FileOutputStream fos = new FileOutputStream(file, false);
        fos.write(infos, 0, infos.length);

    }
}
