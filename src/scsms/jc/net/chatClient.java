package scsms.jc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class chatClient extends Thread {
  
	 private Socket socket;
	 private  JTextArea contentArea;
	 
	public chatClient(Socket socket,JTextArea contentArea)  {
		// TODO Auto-generated constructor stub
		 this.socket=socket;
		 this.contentArea=contentArea;
	}
	
	 public void run() {
		BufferedReader bReader=null;
		
		try {
			bReader=new  BufferedReader(new InputStreamReader(socket.getInputStream()));
			// add  chat message to the  contentArea
			 String string=null;
			 while ((string=bReader.readLine())!=null) {
				contentArea.append(string);
				contentArea.append("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bReader!=null) {
					bReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
