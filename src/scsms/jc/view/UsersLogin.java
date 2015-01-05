package scsms.jc.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;

import javax.swing.ImageIcon;

import scsms.jc.dao.LoginAndReg.LoginCheck;
import scsms.jc.entity.usersTable;

import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class UsersLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JPasswordField pf_password;
	private JTextField tf_verifycode;
	private  Image image;
    private static	UsersLogin frame;
    private int integer;
	/**
	 * Launch the application.
	 * @return 
	 */
	public void BackgroundJframe(String path)
	{
		

        
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new UsersLogin();
					//frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UsersLogin() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haolingtianxia\\workspace\\SCSMS\\picture\\userslogin.jpg"));
		setFont(new Font("微软雅黑", Font.BOLD, 12));
		setBackground(Color.ORANGE);
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 436);
		contentPane = new JPanel();
		//JPanel jPanel=new JPanel();
//		JLabel imgLabel=new JLabel();
//	    jPanel.add(imgLabel);
//	    URL url=this.getClass().getResource("background.jpg");
//	    Icon icon=new ImageIcon(url);
//	    imgLabel.setIcon(icon);
		
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lb_title = new JLabel("\u5929\u6D25\u57CE\u5EFA\u5927\u5B66\r\n");
		lb_title.setBounds(157, 50, 120, 33);
		lb_title.setFont(new Font("微软雅黑", Font.BOLD, 20));
		contentPane.add(lb_title);
		
		JLabel lb_type = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lb_type.setBounds(90, 110, 71, 24);
		lb_type.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(lb_type);
		
		final JComboBox cb_type = new JComboBox();
		cb_type.setBounds(171, 112, 157, 21);
		cb_type.addItem("管理员");
		cb_type.addItem("老师");
		cb_type.addItem("学生");
		cb_type.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(cb_type);
		
		JLabel lb_name = new JLabel(" 用户名：");
		lb_name.setBounds(102, 161, 71, 15);
		lb_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(lb_name);
		final JLabel lblLoding = new JLabel("   loding..");
		lblLoding.setBounds(274, 236, 94, 50);
		contentPane.add(lblLoding);
		tf_name = new JTextField();
		tf_name.setBounds(171, 159, 157, 19);
		tf_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lb_password = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lb_password.setBounds(90, 208, 83, 15);
		lb_password.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(lb_password);
		
		pf_password = new JPasswordField();
		pf_password.setBounds(171, 205, 157, 21);
		pf_password.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(pf_password);
		
		JButton btn_register = new JButton("\u6CE8\u518C");
		btn_register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				if (cb_type.getSelectedItem().equals("管理员")) {
					JOptionPane.showMessageDialog(null,"管理员不允许注册","错误",
							JOptionPane.ERROR_MESSAGE);
				}
				 if (cb_type.getSelectedItem().equals("教师")) {
					   
					 new TecRegiser();
					 frame.dispose();
					  //UsersLogin.DISPOSE_ON_CLOSE;
					  
					
				}
				 if (cb_type.getSelectedItem().equals("学生")) {
					StuRegister.login();
					 frame.dispose();
				}
			}
		});
		btn_register.setBounds(342, 111, 71, 23);
		btn_register.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(btn_register);
		
       
		final JLabel lb_verifycode = new JLabel("\u9A8C\u8BC1\u7801\uFF1A");
		lb_verifycode.setBounds(103, 252, 58, 15);
		lb_verifycode.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(lb_verifycode);
		
		tf_verifycode = new JTextField();
		tf_verifycode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    
				integer=(int)(Math.random()*1000+1000);
			lblLoding.setText(String.valueOf(integer));		
			}
		});
		tf_verifycode.setBounds(171, 252, 71, 19);
		tf_verifycode.setFont(new Font("微软雅黑", Font.BOLD, 14));
		contentPane.add(tf_verifycode);
		tf_verifycode.setColumns(10);
		
		JButton btn_reset = new JButton("重置");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 tf_name.setText(null);
			 pf_password.setText(null);
			 tf_verifycode.setText(null);
			}
		});
		btn_reset.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_reset.setBounds(275, 311, 93, 23);
		contentPane.add(btn_reset);
		
		 JButton btn_login = new JButton("\u767B\u5F55");
	        btn_login.addActionListener(new ActionListener() {
	        	@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
	        	    if (tf_verifycode.getText().equals(String.valueOf(integer))) {
						usersTable users=new usersTable();
						users.setUsers_name(tf_name.getText().toString().trim());
						users.setPosition(cb_type.getSelectedItem().toString());
						users.setUsers_passwd(pf_password.getText());
	        	    	if(LoginCheck.check(users)){
	        	    		////
	        	    		if(users.getPosition().equals("管理员")){
	        	    			AdminManage.login(tf_name.getText().toString());
	        	    		} // 管理员 登录
	        	    		if(users.getPosition().equals("老师")){
	        	    			TecManager.login(tf_name.getText().toString());
	        	    			
	        	    		} //
	        	    		if(users.getPosition().equals("学生")){
	        	    			StuManager.login(tf_name.getText().toString());// stuManager=new StuManager();
	        	    	//	stuManager.setName(tf_name.getText().toString());
	        	    		} //
	        	    	}
	        	    	else {
							JOptionPane.showMessageDialog(null,"没有此用户！");
						}
	        	    		//
					}
	        	    else {
						JOptionPane.showMessageDialog(null,"验证码错误！！");
					}
	        	}
	        });
			btn_login.setBounds(94, 311, 93, 23);
			btn_login.setFont(new Font("微软雅黑", Font.BOLD, 14));
			contentPane.add(btn_login);
			
		
	}
}
