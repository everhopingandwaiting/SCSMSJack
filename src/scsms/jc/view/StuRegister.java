package scsms.jc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import scsms.jc.entity.stuTable;
import scsms.jc.entity.usersTable;
import scsms.jc.util.Chooser;

public class StuRegister extends JFrame {

	private JPanel contentPane;
	private JTextField tf_name;
	private JTextField tf_birth;
	private JTextField tf_tel;
	private JTextField tf_email;
	private JTextField tf_addr;
	private JPasswordField pf_passwd;
	private JTextField stuNUM_textField;

	/**
	 * Launch the application.
	 */
	public static void login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuRegister frame = new StuRegister();
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
	public StuRegister() {
		 final Chooser  choose =new Chooser();
		setFont(new Font("微软雅黑", Font.BOLD, 14));
		setTitle("学生注册");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haolingtianxia\\workspace\\SCSMS\\picture\\userslogin.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 627);
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
		panel.setLayout(null);
		
		JLabel lb_stu_name = new JLabel("输入姓名：\r\n");
		lb_stu_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_stu_name.setBounds(10, 57, 75, 15);
		panel.add(lb_stu_name);
		
		tf_name = new JTextField();
		tf_name.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_name.setBounds(84, 40, 153, 21);
		panel.add(tf_name);
		tf_name.setColumns(10);
		
		JLabel lb_password = new JLabel("输入学号：");
		lb_password.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_password.setBounds(10, 98, 75, 15);
		panel.add(lb_password);
		
		JLabel lb_sex = new JLabel("性别：\r\n");
		lb_sex.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_sex.setBounds(10, 200, 54, 15);
		panel.add(lb_sex);
		
		ButtonGroup group=new ButtonGroup();
		final JRadioButton rb_male = new JRadioButton("男" ,true);
		rb_male.setFont(new Font("微软雅黑", Font.BOLD, 14));
		rb_male.setBounds(95, 196, 54, 23);
		group.add(rb_male);
		panel.add(rb_male);
		
		final JRadioButton rb_female = new JRadioButton("女",true);
		rb_female.setFont(new Font("微软雅黑", Font.BOLD, 14));
		rb_female.setBounds(171, 196, 54, 23);
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
		stuNUM_textField = new JTextField();
		stuNUM_textField.setBounds(85, 89, 153, 19);
		panel.add(stuNUM_textField);
		stuNUM_textField.setColumns(10);
		
		JLabel lb_addr = new JLabel("地址：");
		lb_addr.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_addr.setBounds(10, 483, 54, 15);
		panel.add(lb_addr);
		
		tf_addr = new JTextField();
		tf_addr.setFont(new Font("微软雅黑", Font.BOLD, 14));
		tf_addr.setBounds(95, 480, 304, 21);
		panel.add(tf_addr);
		tf_addr.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 383, 287, 64);
		panel.add(scrollPane);
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lb_passwd = new JLabel("输入密码：");
		lb_passwd.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lb_passwd.setBounds(10, 150, 75, 15);
		panel.add(lb_passwd);
		
		pf_passwd = new JPasswordField();
		pf_passwd.setFont(new Font("微软雅黑", Font.BOLD, 14));
		pf_passwd.setBounds(95, 148, 153, 21);
		panel.add(pf_passwd);
		
		JButton btn_ok = new JButton("确定");
		btn_ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 usersTable usersTable =new  usersTable();
			 stuTable stuTable= new  stuTable();
			 usersTable.setPosition("学生");
			 usersTable.setUsers_name(tf_name.getText());
			 usersTable.setUsers_passwd(pf_passwd.getText());
			  stuTable.setStu_addr(tf_addr.getText());
			  stuTable.setStu_birth(tf_birth.getText());
			  stuTable.setStu_email(tf_email.getText());
			  stuTable.setStu_info(textArea.getText());
			  stuTable.setStu_name(tf_name.getText());
		try {
			stuTable.setStu_num(Integer.parseInt(stuNUM_textField.getText().trim()));
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "学号不允许为空");
		}
		if (rb_male.isSelected()) {
			stuTable.setStu_sex("男");
		}
			  if (rb_female.isSelected()) {
				stuTable.setStu_sex("女");
			}
			  try {
				stuTable.setStu_tel(Integer.parseInt(tf_tel.getText().trim()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "电话不允许为空");
			}
			  scsms.jc.dao.LoginAndReg.StuRegister register=new  scsms.jc.dao.LoginAndReg.StuRegister();
			  register.stuRegister(stuTable); register.uStuReg(usersTable);
			}
		});
		btn_ok.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_ok.setBounds(64, 530, 93, 23);
		panel.add(btn_ok);
		
		JButton btn_exit = new JButton("退出");
		btn_exit.setFont(new Font("微软雅黑", Font.BOLD, 14));
		btn_exit.setBounds(289, 530, 93, 23);
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
