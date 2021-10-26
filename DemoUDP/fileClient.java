package DemoUDP;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class fileClient {

	public static void main(String[] args)  throws SocketException, IOException{
		
		// Tao datagramsocket cho server
        DatagramSocket ds = new DatagramSocket();
        
        // nhap dia chi server
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dia chi server: ");
        String address = br.readLine();
        InetAddress add_server = InetAddress.getByName(address);
        
 
        // nhap yeu cau
        System.out.println("File can doc: ");
        String file = br.readLine();
        

        // xu ly yeu cau
        System.out.println("nhap duong dan file: ");
        String add_save= br.readLine();
        String yeucau = "READ "+add_save+file;
        
        
       
        // dong goi gui tin sang server dang byte
        int port = 7777;
        DatagramPacket dp_send = new DatagramPacket(yeucau.getBytes(),yeucau.length(),add_server,port);
        ds.send(dp_send);
        
        // nhan goi tin tu server
        byte b[] = new byte[60000];
        DatagramPacket dp_receive = new DatagramPacket(b,b.length);
        ds.receive(dp_receive);
        
        // xu ly goi tin nhan ve
        //---- ghi file
        System.out.println("nhap duong dan luu file: ");
        String add_save_2= br.readLine();
        FileOutputStream fo = new FileOutputStream(""+add_save_2+file);
        fo.write(b,0,b.length);
        System.out.println("Ghi file thanh cong!!!");
        //---- hien thi thong tin ra man hinh
       // System.out.println(new String(dp_receive.getData(),0,dp_receive.getLength()));
    }
		
		
	

}
