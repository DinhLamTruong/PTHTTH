package Tuan4;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;

import java.util.Scanner;
public class NumberClient {
	public static void main(String[] args) throws IOException {
        Socket mySocket = null;

        DataOutputStream dos = null;

        DataInputStream dis=null;

        try {

            mySocket = new Socket("localhost", 6789);//Tạo port

            dos = new DataOutputStream(mySocket.getOutputStream());//DataInputStream nhận dữ liệu xong DataOutputStream sẽ ghi lại dữ liệu

            dis = new DataInputStream(mySocket.getInputStream());//Đọc dữ liệu từ 1 luồng

            Scanner input = new Scanner(System.in);

            String s = null;

            while(true)

            {

                System.out.print("\nNhap Number: ");

                s =input.nextLine();//nhập dữ liệu từ bàn phím

                dos.writeUTF(s);//gửi dữ liệu tới server

               

                String str=dis.readUTF();//nhận dữ liệu từ server

                System.out.print("Server tra KQ : "+str);//in kết quả ra màn hình

            }

        }

        catch(Exception e) {

            System.out.print("Ngat ket noi");

            dis.close();

            dos.close();

            mySocket.close();

            e.printStackTrace();

        }

    }
}