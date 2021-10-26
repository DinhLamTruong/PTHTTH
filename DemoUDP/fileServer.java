package DemoUDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class fileServer {

	public static void main(String[] args)throws SocketException, IOException {
		// TODO Auto-generated method stub
		
		
		// Tao DatagramSocket cho server UDP tren cong 
        DatagramSocket ds = new DatagramSocket(7777);
        System.out.println("server running...");
        
        // nhan goi tin tu client
        byte b1[] = new byte[60000];
        DatagramPacket dp_receive = new DatagramPacket(b1,b1.length);
       ds.receive(dp_receive);
        
        // xu ly goi tin nhan
        String kq = new String(dp_receive.getData(),0,dp_receive.getLength());
        System.out.println("Xu ly: "+kq);
        String file = kq.substring(("READ ").length(), kq.length());
        System.out.println("Doc file: "+file);
        File docfile = new File(file);
        if(docfile.exists()){
            FileInputStream fo = new FileInputStream(file);
            int n = fo.available();
            byte b2[] = new byte[n];
            fo.read(b2, 0, n);
            // gui file qua server
            DatagramPacket dp_send = new DatagramPacket(b2,b2.length,dp_receive.getAddress(),dp_receive.getPort());
            ds.send(dp_send);
            // hien thi thong tin file ra man hinh
          //  System.out.println(new String(dp_send.getData(),0,dp_send.getLength()));
            System.out.println("Gui file thanh cong!!!");
            fo.close();
        }
        else{
            String err_notfound = "Khong tim thay file "+file;
            System.out.println(err_notfound);
            // Gui thong bao loi sang client
           DatagramPacket dp_send_err = new DatagramPacket(err_notfound.getBytes(),err_notfound.length(),dp_receive.getAddress(),dp_receive.getPort());
           ds.receive(dp_receive);
        }
        ds.close();
        // gui ket qua sau khi xu ly
    }

	

}
