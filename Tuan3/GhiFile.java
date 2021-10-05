package Tuan3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
public class GhiFile extends Thread {
	public void run(){
    	try {
    		// tạo một đối tượng FileWriter 
    		    FileWriter writer = new FileWriter("D:\\testin.txt");//đường dẫn chứa tệp muốn ghi file
    	        BufferedWriter buffer = new BufferedWriter(writer);
    	        buffer.write("0 1 2 3 4 5 6 7 8 9 ");// tạo 1 dãy số
    	        buffer.close();
    	        System.out.println("Ghi file thanh cong ...");
    	    }
    	catch(Exception e) {
			e.printStackTrace();
		 }
	}
	public static void main(String args[]) throws Exception {
		//tạo 3 đối tượng ghi file
		GhiFile gf1 = new GhiFile();
		GhiFile gf2 = new GhiFile();
		GhiFile gf3 = new GhiFile();
		
        gf1.start(); //thực hiện chạy ghi file 1
        GhiFile.sleep(2000);//quãng thời gian nghỉ 2s
        System.out.print("\n");
        gf2.start();//thực hiện chạy ghi file 2
        GhiFile.sleep(2000);//quãng thời gian nghỉ 2s
        System.out.print("\n");
        gf3.start();//thực hiện chạy ghi file 3
    }

}
