package scsms.jc.util;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.io.*;
//import com.sun.java.util.jar.pack.Package.File;

public class Filesave {
// private JTextArea contentArea;
	public Filesave(JTextArea contentArea) {
	//	this.contentArea=contentArea;
		// TODO Auto-generated constructor stub
	}
      public static void svaeFile(JTextArea contenTextArea) {
		
    	  JFileChooser chooser = new JFileChooser();    
			//	FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT","txt");//建立过滤器    
				//chooser.setFileFilter(filter);//开始过滤    
				int returnVal =chooser.showSaveDialog(chooser);
				if(returnVal == JFileChooser.APPROVE_OPTION) {    
				 File file = chooser.getSelectedFile();
				 if (file.exists()) {
				 int copy = JOptionPane.showConfirmDialog(null,"是否要覆盖当前文件？", "保存", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				     if (copy == JOptionPane.YES_OPTION){
				     chooser.approveSelection();
				        try {
							FileWriter fileWriter=new FileWriter(file);
							  fileWriter.write(contenTextArea.getText());
							  fileWriter.flush();fileWriter.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				     
				     }
				 }
				 else
				 {
					  chooser.approveSelection();
					    try {
							FileWriter fileWriter=new FileWriter(file);
							  fileWriter.write(contenTextArea.getText());
							  fileWriter.flush();fileWriter.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				}
	}
}
