package scsms.jc.net;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class severClient {

	  private ArrayList<Socket> sockets =new ArrayList<Socket>();
	   
	  
	public severClient() throws IOException {
		// TODO Auto-generated constructor stub
		 
		this.init();
	}
   public void init()  throws IOException{
	  ServerSocket ssServerSocket=new ServerSocket(12345);
	    
	   while (true) {
//		type type ?= (type) true.nextElement();
		    Socket socket=ssServerSocket.accept();
		    sockets.add(socket);
		    
		    String ipString=socket.getInetAddress().getHostAddress();
		     
		    Thread thread=new Thread(new SserverRunner(sockets,socket,ipString));
		     thread.start();
		
	}
}
      public static void main(String[] args) {
		try {
			new severClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
}

   
