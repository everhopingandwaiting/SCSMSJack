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

public class sendMsgToServer {
     private JButton jButton;
     private JTextArea sendArea;
     private String name;
     private Socket socket;
     public sendMsgToServer(Socket socket,JButton jButton,JTextArea sendArea,String name)
     {
    	 this.jButton=jButton;
    	 this.sendArea=sendArea;
    	 this.name=name;
    	 this.socket=socket;
    	 
     }
     
      public void  send() {
		String string=sendArea.getText();
		SimpleDateFormat fDateFormat =new SimpleDateFormat("HH-mm-ss");
		 String dateString=fDateFormat.format(new Date());
		 String sendMString=name+" "+dateString+":"+string;
		 // send to server
		  PrintWriter outWriter=null;
		    try {
				outWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				 //
				outWriter.println(sendMString);
				outWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 sendArea.setText(null);
	}
}
