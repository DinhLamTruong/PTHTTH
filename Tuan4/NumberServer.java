package Tuan4;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

public class NumberServer {
	private static ServerSocket serverSocket = null;
	
	public static void main(String[] args) throws IOException{

		
		    DataOutputStream dos = null;

		    DataInputStream dis=null;

		    try {

		        serverSocket = new ServerSocket(6789);

		        System.out.print("Server running... \n" );

		        Socket clientSocket = null;

		        clientSocket = serverSocket.accept();

		        dos=new DataOutputStream(clientSocket.getOutputStream());//DataInputStream nhận dữ liệu xong DataOutputStream sẽ ghi lại dữ liệu

		        dis=new DataInputStream(clientSocket.getInputStream());//Đọc dữ liệu từ 1 luồng

		        String inline="";//tạo 1 inline kiểu chuỗi ban đầu rỗng

		        while(true)

		        {

		            inline = dis.readUTF();//đọc một chuỗi đã được mã hóa bằng cách sử dụng định dạng UTF-8, nhận từ client

		            char ch[]=inline.toCharArray();//chuyển đổi chuỗi thành các mảng ký tự

		            if(Character.isDigit(ch[0]))//isDigit kiểm tra ký tự đã truyền có phải là số không

		                {

		                int i=Integer.parseInt(inline);//parseInt phân tích 1 chuỗi trả về số nguyên

		                switch(i)

		                {
		                // client nhập dữ liệu là số server trả về các case 0-9
		                    case 0:inline="Khong";break;

		                    case 1:inline="Mot";break;

		                    case 2:inline="Hai";break;

		                    case 3:inline="Ba";break;

		                    case 4:inline="Bon";break;

		                    case 5:inline="Nam";break;

		                    case 6:inline="Sau";break;

		                    case 7:inline="Bay";break;

		                    case 8:inline="Tam";break;

		                    case 9:inline="Chin";break;

		                }

		                dos.writeUTF(inline);//trả dữ liệu về client

		            }

		            else
		            	
		            	//client nhập không phải số hiển thị không phải số nguyên
		                dos.writeUTF("khong phai so nguyen");

		        }

		    }

		    catch(Exception e) {

		        dos.close();

		        serverSocket.close();

		        dis.close();

		        System.out.print(e.getMessage());

		    }

		}

}
