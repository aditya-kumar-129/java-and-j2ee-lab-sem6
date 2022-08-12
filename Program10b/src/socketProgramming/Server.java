package socketProgramming;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String message = dis.readUTF();
			System.out.println("Message is :- " + message);
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}