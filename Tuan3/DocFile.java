package Tuan3;
import java.io.BufferedReader;
import java.io.FileReader;

class DocFile extends Thread {
    public void run(){
    	try {
    		// tạo một đối tượng FileReader 
    	 FileReader fr = new FileReader("D:\\testin.txt");//đường dẫn chứa tệp muốn đọc file
         BufferedReader br = new BufferedReader(fr);
         int i;
         while ((i = br.read()) != -1) {
             System.out.print((char) i);
         }
         br.close();
         fr.close();
    	}catch(Exception e) {
			e.printStackTrace();
		}
    }
 
    public static void main(String args[]) throws Exception {
    	//tạo 3 đối tượng đọc file
    	DocFile df1 = new DocFile();
    	DocFile df2 = new DocFile();
    	DocFile df3 = new DocFile();
    
        df1.start();//thực hiện chạy đọc file 1
        DocFile.sleep(2000);//quãng thời gian nghỉ 2s
        System.out.print("\n");
        df2.start();//thực hiện chạy đọc file 2
        DocFile.sleep(2000);//quãng thời gian nghỉ 2s
        System.out.print("\n");
        df3.start();//thực hiện chạy đọc file 3
    }
}
