package scsms.jc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import scsms.jc.dao.LoginAndReg.TecRegister;
import scsms.jc.entity.tecTable;
import scsms.jc.entity.usersTable;
import scsms.jc.util.Chooser;
import scsms.jc.util.ConvertStrToDate;
import scsms.jc.util.MailDefify;

public class TecRegiser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8276620698803986661L;
	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_birth;
	private JTextField tf_tel;
	private JTextField tf_email;
//	private JTextField tf_addr;
	private JPasswordField pf_passwd;
	private JTextField tf_tec_num;
 private String sexString;
 public String getSexString() {
	return sexString;
}

public void setSexString(String sexString) {
	this.sexString = sexString;
}

public String getTecnameString() {
	return tecnameString;
}

public void setTecnameString(String tecnameString) {
	this.tecnameString = tecnameString;
}

private String tecnameString="老师";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TecRegiser frame = new TecRegiser();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TecRegiser() {
		 final Chooser  choose =new Chooser();
		this.setVisible(true);
			this.setLocationRelativeTo(null);
		setTitle("教师注册\r\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haolingtianxia\\workspace\\SCSMS\\picture\\userslogin.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 598);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		Border border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder=BorderFactory.createTitledBorder(border, "注册面板", TitledBorder.CENTER, TitledBorder.TOP);
		panel.setBorder(tBorder);
		getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		JLabel lb_stu_name = new JLabel("输入姓名：\r\n");
		lb_stu_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_stu_name.setBounds(10, 57, 75, 15);
		panel.add(lb_stu_name);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_name.setBounds(95, 54, 153, 21);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lb_password = new JLabel("输入教工号：");
		lb_password.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_password.setBounds(10, 98, 84, 15);
		panel.add(lb_password);
		
		JLabel lb_sex = new JLabel("性别：\r\n");
		lb_sex.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_sex.setBounds(10, 200, 54, 15);
		panel.add(lb_sex);
		
		ButtonGroup group=new ButtonGroup();
		final JRadioButton rb_male = new JRadioButton("" ,true);
		rb_male.setFont(new Font("微软雅黑", Font.BOLD, 14));
		rb_male.setBounds(95, 192, 24, 23);
		group.add(rb_male);
		panel.add(rb_male);
		final JLabel tecname_label = new JLabel("老师");
		tecname_label.setBounds(400, 35, 54, 15);
		panel.add(tecname_label);
		final JRadioButton rb_female = new JRadioButton("",true);
		rb_female.setFont(new Font("微软雅黑", Font.BOLD, 14));
		rb_female.setBounds(158, 192, 24, 23);
		group.add(rb_female);
		panel.add(rb_male);
		panel.add(rb_female);
		
		JLabel lb_birth = new JLabel("出生日期：");
		lb_birth.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_birth.setBounds(10, 245, 75, 15);
		panel.add(lb_birth);
		
		final JButton btn_seldate = new JButton("选择日期");
		btn_seldate.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_seldate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choose.selectDate();
			String	data=Chooser.getDate();
				tf_birth.setText(data);
				
			}
		});
		btn_seldate.setBounds(205, 241, 93, 23);
		panel.add(btn_seldate);
		
		tf_birth = new JTextField();
		tf_birth.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_birth.setBounds(95, 243, 98, 21);
		panel.add(tf_birth);
		tf_birth.setColumns(10);
		
		JButton btn_OK = new JButton("确认选择");
		btn_OK.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_OK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String	data=Chooser.getDate();
				tf_birth.setText(data);
				btn_seldate.setVisible(false);
			}
		});
		btn_OK.setBounds(306, 241, 93, 23);
		panel.add(btn_OK);
		
		JLabel lb_tel = new JLabel("联系电话：");
		lb_tel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_tel.setBounds(10, 295, 75, 15);
		panel.add(lb_tel);
		
		tf_tel = new JTextField();
		tf_tel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_tel.setBounds(95, 292, 153, 21);
		panel.add(tf_tel);
		tf_tel.setColumns(10);
		final JLabel male_label = new JLabel("男");
		male_label.setBounds(120, 196, 54, 24);
		panel.add(male_label);
		
		final JLabel female_label = new JLabel("女");
		female_label.setBounds(188, 200, 54, 16);
		panel.add(female_label);
		
		
		JLabel lb_email = new JLabel("输入邮箱：");
		lb_email.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_email.setBounds(10, 340, 75, 15);
		panel.add(lb_email);
		
		tf_email = new JTextField();
		tf_email.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_email.setBounds(95, 337, 153, 21);
		panel.add(tf_email);
		tf_email.setColumns(10);
		
		JLabel lb_info = new JLabel("简介：");
		lb_info.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_info.setBounds(10, 384, 54, 15);
		panel.add(lb_info);
		
//		JLabel lb_addr = new JLabel("地址：");
//		lb_addr.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		lb_addr.setBounds(10, 483, 54, 15);
//		panel.add(lb_addr);
		
//		tf_addr = new JTextField();
//		tf_addr.setFont(new Font("微软雅黑", Font.BOLD, 14));
//		tf_addr.setBounds(95, 480, 304, 21);
//		panel.add(tf_addr);
//		tf_addr.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 383, 287, 64);
		panel.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lb_passwd = new JLabel("输入密码：");
		lb_passwd.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_passwd.setBounds(10, 150, 75, 15);
		panel.add(lb_passwd);
		tf_tec_num = new JTextField();
		tf_tec_num.setBounds(99, 96, 149, 21);
	//	tf_tec_num.setText(int);
		panel.add(tf_tec_num);
		tf_tec_num.setColumns(10);
		pf_passwd = new JPasswordField();
		pf_passwd.setFont(new Font("微软雅黑", Font.BOLD, 14));
		pf_passwd.setBounds(95, 148, 153, 21);
		panel.add(pf_passwd);
		
		JButton btn_ok = new JButton("确定");
		btn_ok.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			tecTable table=new  tecTable();
			usersTable usersTable= new  usersTable();
			table.setTec_name(tf_name.getText());//9
			if(tf_name.getText()==null||tf_name.getText().equals(" "))
			{
				JOptionPane.showMessageDialog(null,"没有此用户！");
			}
		//	table.setTec_num(Integer.parseInt(tf_tec_num.getText());
			try{ 
				//String a=tf_tec_num.getText(); 
				//int b=Integer.parseInt(a.getText());
 Integer integer=new Integer(Integer.parseInt(tf_tec_num.getText().toString().trim()));
			table.setTec_num(integer.intValue());//8
			}
			catch(Exception exception ){ 
				 JOptionPane.showMessageDialog(null, "教师号输入非数字!");
				 
				}
			
//			 table.setTec_num(tf_tec_num.getText());
		//	table.setTec_num(tf_tec_num.getText());
			usersTable.setUsers_passwd(pf_passwd.getText().toString());
			 if (rb_female.isSelected()) {
				 
				table.setTec_sex(female_label.getText().toString());
			}//7
			 if (rb_male.isSelected()) {
				
				table.setTec_sex(male_label.getText().toString());
			}
			 table.setTec_birth(tf_birth.getText());//6
			 try {
				table.setTec_tel(Integer.parseInt(tf_tel.getText().trim()));//5
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "号码输入非数字!");
			}
			     if(MailDefify.validateEmail(tf_email.getText().toString()))
			 table.setTec_email(tf_email.getText());//4
			     else {
					 JOptionPane.showMessageDialog(null, "邮箱不合法");
				}
			 table.setTec_info(textArea.getText());//3
			 usersTable.setUsers_name(tf_name.getText());//2
			 usersTable.setPosition(tecname_label.getText().toString()); //1
			 TecRegister register =new  TecRegister();
			 register.tecRegister(table, usersTable);
			}
		});
		btn_ok.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_ok.setBounds(100, 484, 93, 23);
		panel.add(btn_ok);
		
		JButton btn_exit = new JButton("退出");
		btn_exit.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_exit.setBounds(251, 484, 93, 23);
		panel.add(btn_exit);
		
	
		
		
		
//		JPanel panel_1 = new JPanel();
//		JLabel imgJLabel=new JLabel();
////		imgJLabel.set
//		panel_1.add(imgJLabel);
//		URL url=this.getClass().getResource("jack.jpg");
//		Icon icon=new ImageIcon(url);
//		imgJLabel.setIcon(icon);
//		
		
//		panel_1.setBounds(289, 57, 130, 123);
//		panel.add(panel_1);
	}
	}


