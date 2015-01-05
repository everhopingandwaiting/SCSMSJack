package scsms.jc.util;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplit {
	public static void main(String[] args) {
		JSplitPane jPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new  JPanel(), new JPanel());
		   jPane.setDividerLocation(200);
		   
		   jPane.setOneTouchExpandable(true);
		   jPane.setDividerSize(5);
		   
		    JFrame jFrame=new JFrame();
		    
		    jFrame.setBounds(200, 300, 500, 300);
		    jFrame.add(jPane,BorderLayout.CENTER);
		    
		    jFrame.setVisible(true);
	}
}
