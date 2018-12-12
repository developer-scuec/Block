package transmit;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static InetAddress address;
    public static int port;
    public static DatagramSocket datagramSocket;
    public static int localport;
    public Client(){
        try {
            localport=7777;
            datagramSocket=new DatagramSocket(localport);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Server server=new Server(datagramSocket);
            }
        }).start();

    }
    public static void send(String info) throws Exception{
        String size=String.valueOf(info.getBytes().length);
        DatagramPacket sizedp=new DatagramPacket(size.getBytes(),size.getBytes().length,address,port);
        datagramSocket.send(sizedp);
        DatagramPacket infodp=new DatagramPacket(info.getBytes(),info.getBytes().length,address,port);
        datagramSocket.send(infodp);
    }
    public static void Response(String info,InetAddress responseAddress,int responsePort) throws Exception{
        String size=String.valueOf(info.getBytes().length);
        DatagramPacket sizedp=new DatagramPacket(size.getBytes(),size.getBytes().length,responseAddress,responsePort);
        datagramSocket.send(sizedp);
        DatagramPacket infodp=new DatagramPacket(info.getBytes(),info.getBytes().length,responseAddress,responsePort);
        datagramSocket.send(infodp);
    }

}
