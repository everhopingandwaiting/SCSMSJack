package scsms.jc.net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextArea;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class sendToServer {
   
	public sendToServer() {
		// TODO Auto-generated constructor stub
	}

	 public static void send(Socket socket,JTextArea sendArea ,JButton jButton,String name) {
		 String sendString=sendArea.getText();
		 
		 SimpleDateFormat simpleDateFormat=new  SimpleDateFormat("HH-mm-ss");
		 String  timeString=simpleDateFormat.format( new Date());
		  String sendString2=name+" "+timeString+":"+sendString;
		   PrintWriter pwWriter=null;
		   
		    try {
				pwWriter =new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				 pwWriter.println(sendString2);
				  pwWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       sendArea.setText(null);
				 
	}
}
