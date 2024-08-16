package day08;

import day07.ConsoleChatServer;
import java.net.*;
import java.io.*;

public class ConsoleChatClient implements Runnable{
	// Socket 클래스
	// DataIn,out 객체
	Socket sock = null;
	
	public ConsoleChatClient() {
		

		try {
			sock = new Socket("localhost", 50001);
			System.out.println("서버와 연결성공~");
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pout=new PrintWriter(sock.getOutputStream(), true);
			Thread thread=new Thread(this);
			thread.start();
			String msg="";
			while((msg=key.readLine())!=null) {
				pout.println(msg);
			}
		} catch (IOException e) {

		}

	}

	public static void main(String[] args) {
		new ConsoleChatClient();
	}

	@Override
	public void run() {
		try {
			
			InputStream is =sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String servermsg = "";
			while (true) {
				System.out.println("입력>>");
				servermsg = br.readLine();
				System.out.print("From Server>>" + servermsg);
			}
		} catch (Exception e) {
			System.out.println("예외: ");
		}
	}
	
	

}
