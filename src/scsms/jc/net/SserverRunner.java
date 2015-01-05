package scsms.jc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class SserverRunner implements Runnable {
   
	private ArrayList<Socket> sockets;
	 private Socket currenSocket;
	 private String ipString;
	public SserverRunner(ArrayList<Socket> sockets,Socket  currentSocket,String ipString) {
		 this.ipString=ipString;
		 this.sockets=sockets;
		 this.currenSocket=currentSocket;
		// TODO Auto-generated constructor stub
	}
	 public void  run() {
		  
		BufferedReader brReader=null;
		
		 try {
			brReader=new BufferedReader(new InputStreamReader(currenSocket.getInputStream()));
			  String string=null;
			  
			   while ((string=brReader.readLine())!=null) {
				   //send message to all the client 
				      for(Socket tempSocket:sockets)
				      {
				    	  PrintWriter pwWriter=new PrintWriter(new OutputStreamWriter(tempSocket.getOutputStream()));
				    	  pwWriter.flush();
				      }
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
