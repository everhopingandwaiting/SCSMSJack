package scsms.jc.view;

import java.awt.BorderLayout;

import javax.swing.table.AbstractTableModel;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JTabbedPane;

import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import scsms.jc.dao.InfoManage.CousInfoModify;
import scsms.jc.dao.InfoManage.CousInformation;
import scsms.jc.dao.InfoManage.QuestionInfomation;
import scsms.jc.dao.InfoManage.StuInfoModify;
import scsms.jc.dao.InfoManage.StuInformation;
import scsms.jc.dao.InfoManage.UpdatePasswd;
import scsms.jc.entity.SCTable;
import scsms.jc.entity.cousTable;
import scsms.jc.entity.stuTable;
import scsms.jc.net.chatClient;
import scsms.jc.net.sendToServer;
import scsms.jc.util.Filesave;
import scsms.jc.util.TableModel;
import sun.net.www.content.audio.x_aiff;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.JMenu;

public class StuManager extends JFrame {
	private JTextField tf_name;
	private JTextField tf_type;
	private JTextField tf_tel;
	private JTextField tf_addr;
	private JTextField tf_email;
	private JTextField tf_detail;
	private JPasswordField pf_passwd;
	private JPasswordField pf_passwd1;
	private JPasswordField pf_passwd2;
	private JTextField tf_stuname;
	private JTextField tf_num;
	private JTextField tf_sex;
	private JTextField tf_birth;
	private JTextField tf_tel1;
	private JTextField tf_email1;
	private JTextField tf_addr1;
	private JTable table;
	private JTable table_1;
   private Socket socket;
   private JTextArea send_textArea;
     public   CousInformation cousInformation;
   public static TableModel model;
   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
private String name;
   private ResultSet resultSet;
   private JTable table_3;
   private JTable table_2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					StuManager frame = new StuManager();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
   public static void login(String name) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
			//	try {
					
					StuManager frame = new StuManager(name);
					frame.setVisible(true);
				//} catch (Exception e) {
				//	e.printStackTrace();
				//}
			//}
		//});
	}
	/**
	 * Create the frame.
	 */
	public StuManager(final String name) {
	 this.name=name;
	 this.setTitle("欢迎"+name);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haolingtianxia\\workspace\\SCSMS\\picture\\userslogin.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 504);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("个人管理", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{227, 0};
		gbl_panel.rowHeights = new int[]{39, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 0;
		panel.add(tabbedPane_1, gbc_tabbedPane_1);
		
		JPanel panel_5 = new JPanel();
		
		tabbedPane_1.addTab("学籍管理\r\n", null, panel_5, null);
		//lblNewLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		Border border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder=BorderFactory.createTitledBorder(border, "基本信息", TitledBorder.LEFT, TitledBorder.TOP);
		panel_5.setBorder(tBorder);
		panel_5.setLayout(null);
		
		//getContentPane().add(panel);
		//panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学籍信息",JLabel.CENTER);
		lblNewLabel.setBounds(6, 19, 492, 15);
		lblNewLabel.setBackground(Color.WHITE);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_10 = new JLabel("姓名：");
		lblNewLabel_10.setBounds(6, 39, 48, 15);
		panel_5.add(lblNewLabel_10);
		
		tf_stuname = new JTextField();
		tf_stuname.setEditable(false);
		tf_stuname.setBounds(77, 36, 179, 21);
		panel_5.add(tf_stuname);
		tf_stuname.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("学号：");
		lblNewLabel_11.setBounds(6, 71, 48, 15);
		panel_5.add(lblNewLabel_11);
		
		tf_num = new JTextField();
		tf_num.setEditable(false);
		tf_num.setBounds(77, 67, 179, 21);
		panel_5.add(tf_num);
		tf_num.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("性别：");
		lblNewLabel_12.setBounds(6, 108, 48, 15);
		panel_5.add(lblNewLabel_12);
		
		tf_sex = new JTextField();
		tf_sex.setEditable(false);
		tf_sex.setBounds(77, 105, 179, 21);
		panel_5.add(tf_sex);
		tf_sex.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("出生日期：");
		lblNewLabel_13.setBounds(6, 146, 72, 15);
		panel_5.add(lblNewLabel_13);
		
		tf_birth = new JTextField();
		tf_birth.setEditable(false);
		tf_birth.setBounds(77, 143, 179, 21);
		panel_5.add(tf_birth);
		tf_birth.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("联系电话：");
		lblNewLabel_14.setBounds(6, 186, 72, 15);
		panel_5.add(lblNewLabel_14);
		
		tf_tel1 = new JTextField();
		tf_tel1.setEditable(false);
		tf_tel1.setBounds(77, 183, 179, 21);
		panel_5.add(tf_tel1);
		tf_tel1.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("邮箱地址：");
		lblNewLabel_15.setBounds(6, 227, 72, 15);
		panel_5.add(lblNewLabel_15);
		
		tf_email1 = new JTextField();
		tf_email1.setEditable(false);
		tf_email1.setBounds(77, 224, 321, 21);
		panel_5.add(tf_email1);
		tf_email1.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("详细地址：");
		lblNewLabel_16.setBounds(6, 267, 72, 15);
		panel_5.add(lblNewLabel_16);
		
		tf_addr1 = new JTextField();
		tf_addr1.setEditable(false);
		tf_addr1.setBounds(77, 264, 321, 21);
		panel_5.add(tf_addr1);
		tf_addr1.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		
		tabbedPane_1.addTab("信息管理", null, panel_6, null);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{235, 12, 0, 0};
		gbl_panel_6.rowHeights = new int[]{347, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.insets = new Insets(0, 0, 0, 5);
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 0;
		panel_6.add(panel_16, gbc_panel_16);
		//panel_16.setBorder(tBorder1);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{71, 54, 0};
		gbl_panel_16.rowHeights = new int[]{15, 0, 0, 0};
		gbl_panel_16.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder1=BorderFactory.createTitledBorder(border, "用户信息", TitledBorder.LEFT, TitledBorder.TOP);
		panel_16.setBorder(tBorder1);
		
		JLabel lblNewLabel_1 = new JLabel("用户姓名：");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_16.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tf_name = new JTextField();
		tf_name.setEditable(false);
		GridBagConstraints gbc_tf_name = new GridBagConstraints();
		gbc_tf_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_name.insets = new Insets(0, 0, 5, 0);
		gbc_tf_name.gridx = 1;
		gbc_tf_name.gridy = 1;
		panel_16.add(tf_name, gbc_tf_name);
		tf_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("用户类型：");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_16.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tf_type = new JTextField();
		tf_type.setEditable(false);
		GridBagConstraints gbc_tf_type = new GridBagConstraints();
		gbc_tf_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_type.gridx = 1;
		gbc_tf_type.gridy = 2;
		panel_16.add(tf_type, gbc_tf_type);
		tf_type.setColumns(10);
		
		JPanel panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 2;
		gbc_panel_17.gridy = 0;
		panel_6.add(panel_17, gbc_panel_17);
		//Border border1=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		//TitledBorder tBorder1=BorderFactory.createTitledBorder(border, "用户信息", TitledBorder.LEFT, TitledBorder.TOP);
		Border border2=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder2=BorderFactory.createTitledBorder(border, "个人信息维护", TitledBorder.LEFT, TitledBorder.TOP);
		panel_17.setBorder(tBorder2);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[]{107, 54, 0};
		gbl_panel_17.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_17.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_17.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_17.setLayout(gbl_panel_17);
		
		JLabel lblNewLabel_3 = new JLabel("联系电话：");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_17.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tf_tel = new JTextField();
		GridBagConstraints gbc_tf_tel = new GridBagConstraints();
		gbc_tf_tel.insets = new Insets(0, 0, 5, 0);
		gbc_tf_tel.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tel.gridx = 1;
		gbc_tf_tel.gridy = 0;
		panel_17.add(tf_tel, gbc_tf_tel);
		tf_tel.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("通讯地址：");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_17.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tf_addr = new JTextField();
		GridBagConstraints gbc_tf_addr = new GridBagConstraints();
		gbc_tf_addr.insets = new Insets(0, 0, 5, 0);
		gbc_tf_addr.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_addr.gridx = 1;
		gbc_tf_addr.gridy = 1;
		panel_17.add(tf_addr, gbc_tf_addr);
		tf_addr.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email：");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_17.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tf_email = new JTextField();
		GridBagConstraints gbc_tf_email = new GridBagConstraints();
		gbc_tf_email.insets = new Insets(0, 0, 5, 0);
		gbc_tf_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_email.gridx = 1;
		gbc_tf_email.gridy = 2;
		panel_17.add(tf_email, gbc_tf_email);
		tf_email.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("简介：");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panel_17.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridheight = 7;
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 3;
		panel_17.add(scrollPane_2, gbc_scrollPane_2);
		
		tf_detail = new JTextField();
		scrollPane_2.setViewportView(tf_detail);
		tf_detail.setColumns(10);
		
		JButton btn_baocun = new JButton("保存");
		
		btn_baocun.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_btn_baocun = new GridBagConstraints();
		gbc_btn_baocun.insets = new Insets(0, 0, 0, 5);
		gbc_btn_baocun.gridx = 0;
		gbc_btn_baocun.gridy = 10;
		panel_17.add(btn_baocun, gbc_btn_baocun);
		
		JButton btn_reset = new JButton("重置");
		
		GridBagConstraints gbc_btn_reset = new GridBagConstraints();
		gbc_btn_reset.gridx = 1;
		gbc_btn_reset.gridy = 10;
		panel_17.add(btn_reset, gbc_btn_reset);
		
		 //重置功能 实现 
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// StuInformation  stuInformation =new StuInformation();
				// scsms.jc.entity.stuTable arrayList =stuInformation.SimplestuInfolist(name);
				tf_tel.setText(null);
				tf_email.setText(null);
				tf_addr.setText(null);
				tf_detail.setText(null);
//				  tf_tel.setText(String.valueOf(arrayList.getStu_tel()));
//					tf_email.setText(arrayList.getStu_email());
//					tf_detail.setText(arrayList.getStu_info());
//					tf_addr.setText(arrayList.getStu_addr());
				
			}
		});
		//保存功能实现
		btn_baocun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			stuTable stuTable =new  stuTable();
			stuTable.setStu_name(name);
			try {
				stuTable.setStu_tel(Long.parseLong(tf_tel.getText()));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stuTable.setStu_addr(tf_addr.getText());
			stuTable.setStu_email(tf_email.getText());
			stuTable.setStu_info(tf_detail.getText());
			if(StuInfoModify.InfoModify(stuTable))
				JOptionPane.showMessageDialog(null, "成功");
			else {
				JOptionPane.showMessageDialog(null, "失败！");
			}
			}
		});
		
		
		
		JPanel panel_7 = new JPanel();
		Border border3=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder3=BorderFactory.createTitledBorder(border, "修改密码", TitledBorder.LEFT, TitledBorder.TOP);
		panel_7.setBorder(tBorder3);
		tabbedPane_1.addTab("修改密码", null, panel_7, null);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("修改密码：");
		lblNewLabel_7.setBounds(122, 140, 65, 15);
		panel_7.add(lblNewLabel_7);
		
		pf_passwd = new JPasswordField();
		pf_passwd.setBounds(192, 137, 127, 21);
		panel_7.add(pf_passwd);
		
		JLabel lblNewLabel_8 = new JLabel("确认修改：");
		lblNewLabel_8.setBounds(122, 171, 65, 15);
		panel_7.add(lblNewLabel_8);
		
		pf_passwd1 = new JPasswordField();
		pf_passwd1.setBounds(192, 168, 127, 21);
		panel_7.add(pf_passwd1);
		
		JLabel lblNewLabel_9 = new JLabel("原密码：");
		lblNewLabel_9.setBounds(122, 103, 60, 15);
		panel_7.add(lblNewLabel_9);
		
		pf_passwd2 = new JPasswordField();
		pf_passwd2.setBounds(192, 100, 127, 21);
		panel_7.add(pf_passwd2);
		
		JButton btn_tijiao = new JButton("提交");
		
		btn_tijiao.setBounds(75, 234, 93, 23);
		panel_7.add(btn_tijiao);
		
		JButton btn_reset1 = new JButton("重置");
		btn_reset1.setBounds(324, 234, 93, 23);
		panel_7.add(btn_reset1);
		
		final JLabel repeat_lblNewLabel_25 = new JLabel("");
		repeat_lblNewLabel_25.setForeground(Color.RED);
		repeat_lblNewLabel_25.setBounds(165, 203, 164, 31);
		panel_7.add(repeat_lblNewLabel_25);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("选课管理", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_2 = new GridBagConstraints();
		gbc_tabbedPane_2.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_2.gridx = 0;
		gbc_tabbedPane_2.gridy = 0;
		panel_1.add(tabbedPane_2, gbc_tabbedPane_2);
		
		JPanel panel_9 = new JPanel();
		tabbedPane_2.addTab("选课", null, panel_9, null);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 0, 0};
		gbl_panel_9.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		final JLabel selectCousStatement = new JLabel("");
		selectCousStatement.setForeground(Color.MAGENTA);
		GridBagConstraints gbc_selectCousStatement = new GridBagConstraints();
		gbc_selectCousStatement.insets = new Insets(0, 0, 5, 5);
		gbc_selectCousStatement.gridx = 0;
		gbc_selectCousStatement.gridy = 0;
		panel_9.add(selectCousStatement, gbc_selectCousStatement);
		
		JButton btn_OK = new JButton("确定");
		GridBagConstraints gbc_btn_OK = new GridBagConstraints();
		gbc_btn_OK.anchor = GridBagConstraints.EAST;
		gbc_btn_OK.insets = new Insets(0, 0, 5, 0);
		gbc_btn_OK.gridx = 1;
		gbc_btn_OK.gridy = 0;
		panel_9.add(btn_OK, gbc_btn_OK);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridwidth = 2;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 1;
		panel_9.add(scrollPane_3, gbc_scrollPane_3);
		///table 显示  
//		 // List<Teacher> list = new ArrayList<Teacher>();
//			Teacher teacher = teacherService.findTeacherByTId(Integer.valueOf(textField_9.getText()));
//			list.add(teacher);
//			tm = new TableModel(list, 4);
//			table.setModel(tm);
//			table.revalidate();
		table = new JTable();
		scrollPane_3.setViewportView(table);
		CousInformation cousInformation1=new  CousInformation();
		ArrayList<cousTable> arrayList =cousInformation1.AllCousInfo();
		//table 显示  选课信息显示
		model=new TableModel(arrayList, 1);
		table.setModel(model);
		
		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(table, popupMenu_1);
		
		JMenuItem menuItem_2 = new JMenuItem("开始选课");
	
		popupMenu_1.add(menuItem_2);
		
		JPanel panel_8 = new JPanel();
		
		tabbedPane_2.addTab("已选课程", null, panel_8, null);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0, 0};
		gbl_panel_8.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel label_4 = new JLabel("");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.gridheight = 2;
		gbc_label_4.fill = GridBagConstraints.BOTH;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 0;
		panel_8.add(label_4, gbc_label_4);
		
		JLabel lblNewLabel_17 = new JLabel("浏览");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_17.gridx = 1;
		gbc_lblNewLabel_17.gridy = 1;
		panel_8.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
		gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_6.gridwidth = 2;
		gbc_scrollPane_6.gridx = 0;
		gbc_scrollPane_6.gridy = 2;
		panel_8.add(scrollPane_6, gbc_scrollPane_6);
		//已选课程 表
		table_1 = new JTable();
		CousInformation information=new  CousInformation();
		ArrayList<SCTable> selectcousScTables=information.stuSelectedCous(name);
		model=new TableModel(selectcousScTables, 2);
		table_1.setModel(model);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table_1.removeAll();
				CousInformation information=new  CousInformation();
				ArrayList<SCTable> selectcousScTables=information.stuSelectedCous(name);
				model=new TableModel(selectcousScTables, 2);
				table_1.setModel(model);
				table_1.revalidate();
			}
		});
		scrollPane_6.setColumnHeaderView(table_1);
		
		JPanel panel_10 = new JPanel();
		panel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				table_2.removeAll();
				CousInformation cousInformation3=new CousInformation();
				 ArrayList<SCTable> selectedCousDeList=cousInformation3.stuSelectedCous(name);
				 model=new  TableModel(selectedCousDeList, 2);
				 table_2.setModel(model);
				 table_2.revalidate();
			}
		});
		tabbedPane_2.addTab("已选课程删除", null, panel_10, null);
		panel_10.setLayout(null);
		
		JButton btn_delete = new JButton("删除");
		btn_delete.setBounds(601, 0, 57, 23);
		panel_10.add(btn_delete);
		// 已选课程删除 表
		CousInformation cousInformation3=new CousInformation();
		 ArrayList<SCTable> selectedCousDeList=cousInformation3.stuSelectedCous(name);
		 model=new  TableModel(selectedCousDeList, 2);
		 
		 JScrollPane scrollPane_4 = new JScrollPane();
		 scrollPane_4.setBounds(2, 43, 656, 367);
		 panel_10.add(scrollPane_4);
		 
		 table_2 = new JTable();
		 scrollPane_4.setViewportView(table_2);
		 table_2.setModel(model);
		 
		 JPopupMenu popupMenu_2 = new JPopupMenu();
		 addPopup(table_2, popupMenu_2);
		 
		 JMenuItem menuItem_3 = new JMenuItem("删除课程");
		
		 popupMenu_2.add(menuItem_3);
		 
		 final JLabel delcousStatementLabel = new JLabel("");
		 delcousStatementLabel.setForeground(Color.ORANGE);
		 delcousStatementLabel.setBounds(96, 4, 292, 29);
		 panel_10.add(delcousStatementLabel);
		CousInformation cousInformation2=new CousInformation();
		ArrayList<SCTable> arrayListScTables=cousInformation2.stuSelectedCous(name);
		model=new TableModel(arrayListScTables, 2);
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("教学评估", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_3 = new GridBagConstraints();
		gbc_tabbedPane_3.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_3.gridx = 0;
		gbc_tabbedPane_3.gridy = 0;
		panel_2.add(tabbedPane_3, gbc_tabbedPane_3);
		
		JPanel panel_11 = new JPanel();
		
		tabbedPane_3.addTab("评估", null, panel_11, null);
		panel_11.setLayout(null);
		
		JLabel lblNewLabel_18 = new JLabel("1、你对老师的授课方式是否满意：");
		lblNewLabel_18.setBounds(10, 10, 263, 15);
		panel_11.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("2、老师上课是否有接电话的行为：");
		lblNewLabel_19.setBounds(10, 60, 238, 15);
		panel_11.add(lblNewLabel_19);
		
		final JRadioButton rdb_yes = new JRadioButton("是");
		rdb_yes.setBounds(20, 31, 49, 23);
		ButtonGroup buttonGroup1=new  ButtonGroup();
		
		panel_11.add(rdb_yes);
		
		final JRadioButton rdb_no = new JRadioButton("否");
		rdb_no.setBounds(68, 31, 55, 23);
		buttonGroup1.add(rdb_yes);
		buttonGroup1.add(rdb_no);
		panel_11.add(rdb_no);
		
		final JRadioButton rdb_yes1 = new JRadioButton("是");
		rdb_yes1.setBounds(20, 81, 49, 23);
		panel_11.add(rdb_yes1);
		
		final JRadioButton rdb_no1 = new JRadioButton("否");
		rdb_no1.setBounds(68, 81, 43, 23);
		ButtonGroup buttonGroup2=new  ButtonGroup();
		buttonGroup2.add(rdb_yes1);buttonGroup2.add(rdb_no1);
		panel_11.add(rdb_no1);
		
		JLabel lblNewLabel_20 = new JLabel("3、老师是否有迟到早退的行为：");
		lblNewLabel_20.setBounds(10, 110, 211, 15);
		panel_11.add(lblNewLabel_20);
		
		final JRadioButton rdb_yes2 = new JRadioButton("是");
		rdb_yes2.setBounds(20, 131, 49, 23);
		panel_11.add(rdb_yes2);
		
		JRadioButton rdb_no2 = new JRadioButton("否");
		rdb_no2.setBounds(68, 131, 43, 23);
		ButtonGroup buttonGroup3=new  ButtonGroup();
		buttonGroup3.add(rdb_yes2);buttonGroup3.add(rdb_no2);
		panel_11.add(rdb_no2);
		
		JLabel lblNewLabel_21 = new JLabel("4、老师对你的提问是否热心简答：");
		lblNewLabel_21.setBounds(10, 157, 211, 15);
		panel_11.add(lblNewLabel_21);
		
		final JRadioButton rdb_yes3 = new JRadioButton("是");
		rdb_yes3.setBounds(20, 178, 49, 23);
		panel_11.add(rdb_yes3);
		
		final JRadioButton rdb_no3 = new JRadioButton("否");
		rdb_no3.setBounds(68, 178, 49, 23);
		ButtonGroup buttonGroup4=new  ButtonGroup();
		buttonGroup4.add(rdb_yes3);buttonGroup4.add(rdb_no3);
		
		panel_11.add(rdb_no3);
		
		JLabel lblNewLabel_22 = new JLabel("5、老师是否定期回顾已学过的知识点：");
		lblNewLabel_22.setBounds(10, 207, 238, 15);
		panel_11.add(lblNewLabel_22);
		
		final JRadioButton rdb_yes4 = new JRadioButton("是");
		rdb_yes4.setBounds(20, 228, 43, 23);
		
		panel_11.add(rdb_yes4);
		
		final JRadioButton rdb_no4 = new JRadioButton("否");
		rdb_no4.setBounds(68, 228, 43, 23);
		ButtonGroup buttonGroup5=new  ButtonGroup();
		buttonGroup5.add(rdb_yes4);buttonGroup5.add(rdb_no4);
		panel_11.add(rdb_no4);
		
		JLabel lblNewLabel_23 = new JLabel("6、你对老师的意见或建议：");
		lblNewLabel_23.setBounds(10, 261, 211, 15);
		panel_11.add(lblNewLabel_23);
		
		final JTextArea ta_jianyi = new JTextArea();
		ta_jianyi.setBounds(32, 286, 402, 55);
		panel_11.add(ta_jianyi);
		
		JButton btnNewButton = new JButton("提交");
		
		btnNewButton.setBounds(351, 353, 68, 23);
		panel_11.add(btnNewButton);
		
		JButton btn_reset2 = new JButton("重置");
		btn_reset2.setBounds(450, 353, 68, 23);
		panel_11.add(btn_reset2);
		
		final JComboBox<String> selectTecBox = new JComboBox();
		selectTecBox.setBounds(378, 61, 142, 21);
		panel_11.add(selectTecBox);
		
		JLabel label_3 = new JLabel("选择评价老师（授课）");
		label_3.setBounds(373, 35, 170, 15);
		panel_11.add(label_3);
		
		final JLabel insertStatementLabel = new JLabel("");
		insertStatementLabel.setForeground(Color.PINK);
		insertStatementLabel.setFont(new Font("宋体", Font.BOLD, 20));
		insertStatementLabel.setBounds(292, 110, 211, 112);
		panel_11.add(insertStatementLabel);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("综合查询", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_4 = new GridBagConstraints();
		gbc_tabbedPane_4.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_4.gridx = 0;
		gbc_tabbedPane_4.gridy = 0;
		panel_3.add(tabbedPane_4, gbc_tabbedPane_4);
		
		JPanel panel_14 = new JPanel();
		tabbedPane_4.addTab("查看成绩", null, panel_14, null);
		
		 panel_14.setLayout(null);
		 
		 JScrollPane scrollPane_5 = new JScrollPane();
		 scrollPane_5.setBounds(0, 0, 651, 411);
		 panel_14.add(scrollPane_5);
		//table3 显示   
		 table_3 = new JTable();
		 scrollPane_5.setColumnHeaderView(table_3);

		 CousInformation cousInformation=new  CousInformation();
		 ArrayList<SCTable> arrayList3=cousInformation.stuSelectCousGrade(name);
		 model=new TableModel(arrayList3, 3);
		table_3.setModel(model);
		JLabel lblNewLabel_24 = new JLabel("New label");
		lblNewLabel_24.setBounds(214, 416, 54, 15);
		panel_14.add(lblNewLabel_24);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("互动交流", null, panel_4, null);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_5 = new GridBagConstraints();
		gbc_tabbedPane_5.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_5.gridx = 0;
		gbc_tabbedPane_5.gridy = 0;
		panel_4.add(tabbedPane_5, gbc_tabbedPane_5);
		
		JPanel panel_15 = new JPanel();
		tabbedPane_5.addTab("交流平台", null, panel_15, null);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[]{51, 579, 0};
		gbl_panel_15.rowHeights = new int[]{23, 370, 0};
		gbl_panel_15.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_15.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_15.setLayout(gbl_panel_15);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.anchor = GridBagConstraints.NORTH;
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.gridx = 1;
		gbc_panel_12.gridy = 0;
		panel_15.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{219, 132, 81, 0};
		gbl_panel_12.rowHeights = new int[]{23, 0};
		gbl_panel_12.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		JLabel label = new JLabel("欢迎进入师生互动交流室");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		panel_12.add(label, gbc_label);
		JButton button = new JButton("开始聊天");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						socket=new Socket("127.0.0.1",12345);
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					chatClient thChatClient=new chatClient(socket, send_textArea);
					thChatClient.start();
			}
		});
		
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.NORTHWEST;
		gbc_button.gridx = 2;
		gbc_button.gridy = 0;
		panel_12.add(button, gbc_button);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 1;
		panel_15.add(panel_13, gbc_panel_13);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		
		JPanel panel_19 = new JPanel();
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[]{57, 0};
		gbl_panel_19.rowHeights = new int[]{0, 0};
		gbl_panel_19.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_19.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_19.setLayout(gbl_panel_19);
		
		JLabel label_1 = new JLabel("当前在线：");
		
		JLabel label_2 = new JLabel("未知");
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 send_textArea.setText(null);
			}
		});
		
		final JButton sendButton = new JButton("发送");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 sendToServer.send(socket, send_textArea, sendButton, name);
			}
		});
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGap(0, 579, Short.MAX_VALUE)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_13.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_18, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addGroup(gl_panel_13.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(96)
							.addComponent(sendButton)
							.addGap(96))
						.addGroup(Alignment.LEADING, gl_panel_13.createSequentialGroup()
							.addGap(46)
							.addComponent(panel_19, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_13.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_19, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_18, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_13.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_13.createSequentialGroup()
							.addGap(12)
							.addComponent(label_1))
						.addGroup(gl_panel_13.createSequentialGroup()
							.addGap(14)
							.addComponent(label_2))
						.addGroup(gl_panel_13.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_13.createParallelGroup(Alignment.BASELINE)
								.addComponent(sendButton)
								.addComponent(button_1))))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 546, 34);
		panel_18.add(scrollPane);
		
		final JTextArea send_textArea_1 = new JTextArea();
		scrollPane.setViewportView(send_textArea_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_19.add(scrollPane_1, gbc_scrollPane_1);
		
		final JTextArea content_textArea = new JTextArea();
		scrollPane_1.setViewportView(content_textArea);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(content_textArea, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("清空消息");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				content_textArea.setText(null);
			}
		});
		menuItem.setSelected(true);
		popupMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("保存消息");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filesave.svaeFile(content_textArea);
			}
		});
		popupMenu.add(menuItem_1);
		panel_13.setLayout(gl_panel_13);
		///点击   面板中 获取 学生 信息  
		
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				stuTable stuTable=new stuTable();
				stuTable.setStu_name(name);
				 StuInformation  stuInformation =new StuInformation();
			//resultSet=	 stuInformation.stuINfo(stuTable);
				stuTable stuTable2=stuInformation.SimplestuInfolists(name);
				 
				  tf_stuname.setText(stuTable.getStu_name().toString());
				  tf_num.setText(String.valueOf(stuTable2.getStu_num()));
				tf_sex.setText(stuTable2.getStu_sex().toString());
				tf_birth.setText(stuTable2.getStu_birth().toString());
				tf_tel1.setText(String.valueOf(stuTable2.getStu_tel()));
				tf_email1.setText(stuTable2.getStu_email());
				tf_addr1.setText(stuTable2.getStu_addr());
				 
				
			}
		});
		panel_6.addMouseListener(new MouseAdapter() {   // panel6  information manager
			@Override
			public void mouseClicked(MouseEvent e) {
			   
				stuTable stuTable=new stuTable();
				stuTable.setStu_name(name);
			
				 StuInformation  stuInformation =new StuInformation();
			
				 //排错
				 tf_name.setText(stuTable.getStu_name().toString());
				  tf_type.setText("学生");
				
					
						 scsms.jc.entity.stuTable arrayList =stuInformation.SimplestuInfolists(name);
				  tf_tel.setText(String.valueOf(arrayList.getStu_tel()));
					tf_email.setText(arrayList.getStu_email());
					tf_detail.setText(arrayList.getStu_info());
					tf_addr.setText(arrayList.getStu_addr());
			}
		});
		btn_tijiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			       
				if(UpdatePasswd.updatePasswd(name, pf_passwd2	,pf_passwd, pf_passwd1,repeat_lblNewLabel_25))
				{ 
					JOptionPane.showMessageDialog(null, "修改成功");
				}
				
			else { JOptionPane.showMessageDialog(null, "修改失败", "密码修改", 1);}
			}
			
		});
		// 填充 combox
		panel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				CousInformation information=new  CousInformation();
				selectTecBox.removeAll();
				ArrayList<SCTable> arrayList=information.tecnameThatselectededBystu(name);
				int index=arrayList.size();
						for(int i=0;i<index;i++)
							selectTecBox.addItem(arrayList.get(i).getTec_name().toString());
			}
			
		});
		//提交xinxi信息 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string1[]=new String[6];
				String string2[]=new  String[6];
				string1[0]="1、你对老师的授课方式是否满意：";
				string1[1]="2、老师上课是否有接电话的行为：";
				string1[2]="3、老师是否有迟到早退的行为：";
				string1[3]="4、老师对你的提问是否热心简答：";
				string1[4]="5、老师是否定期回顾已学过的知识点：";
				string1[5]="6、你对老师的意见或建议";
				if (rdb_yes.isSelected()) {
					string2[0]="是";
				}
				if (rdb_no.isSelected()) {
					string2[0]="否";
				}
				if (rdb_yes1.isSelected()) {
					string2[1]="是";
				}
				if (rdb_no1.isSelected()) {
					string2[1]="否";
				}
				if (rdb_yes2.isSelected()) {
					string2[2]="是";
				}
				if (rdb_no.isSelected()) {
					string2[2]="否";
				}
				if (rdb_yes3.isSelected()) {
					string2[3]="是";
				}
				if (rdb_no3.isSelected()) {
					string2[3]="否";
				}
				if (rdb_yes4.isSelected()) {
					string2[4]="是";
				}
				if (rdb_no4.isSelected()) {
					string2[4]="否";
				}
				string2[5]=ta_jianyi.getText();
				int qnum[]=new int[6];
				for(int i=0;i<6;i++) qnum[i]=i+1;
				
				//zhii
				int count=0;
				for(int j=0;j<6;j++)
					count+=QuestionInfomation.InsertQuestion(qnum[j], string2[j], string1[j], selectTecBox.getSelectedItem().toString());
				if (count==6) {
					insertStatementLabel.setText("评价成功！");
				}
				
				else {
					insertStatementLabel.setText("评价失败！一个老师只允许评价一次！！");
				}
			}
		});
		// select cous start
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int CurrentSelectRows=table.getSelectedRow();
			String[] strings1=new String[3];
			strings1[0]=table.getValueAt(CurrentSelectRows, 1).toString();
			strings1[1]=table.getValueAt(CurrentSelectRows, 5).toString();
			strings1[2]=name;
			if (CousInfoModify.Addsc(strings1[2], strings1[1], strings1[0])) {
				selectCousStatement.setText("选课成功！！");
			}
			else {
				selectCousStatement.setText("选课失败！！");
			}
			}
		});
		// del selecteded cous
		 menuItem_3.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
			
			 		int CurrentSelectRows=table_2.getSelectedRow();
					String[] strings1=new String[3];
					strings1[0]=table_2.getValueAt(CurrentSelectRows, 0).toString();
					strings1[1]=table_2.getValueAt(CurrentSelectRows, 1).toString();
					strings1[2]=table_2.getValueAt(CurrentSelectRows, 2).toString();;
					if (CousInfoModify.Delsc(strings1[0], strings1[1], strings1[2])) {
						delcousStatementLabel.setText("删课成功！！");
					}
					else {
						delcousStatementLabel.setText("删课失败！！");
					}
			 	}
			 });
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
