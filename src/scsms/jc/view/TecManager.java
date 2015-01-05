package scsms.jc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
//import net.miginfocom.swing.MigLayout;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.factories.FormFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import scsms.jc.dao.InfoManage.CousInfoModify;
import scsms.jc.dao.InfoManage.CousInformation;
import scsms.jc.dao.InfoManage.QuestionInfomation;
import scsms.jc.dao.InfoManage.TecInfoModify;
import scsms.jc.dao.InfoManage.TecInformation;
import scsms.jc.dao.InfoManage.UpdatePasswd;
import scsms.jc.entity.SCTable;
import scsms.jc.entity.countOfValueAtQues;
import scsms.jc.entity.tecTable;
import scsms.jc.net.chatClient;
import scsms.jc.net.sendToServer;
import scsms.jc.net.severClient;
import scsms.jc.util.ButtonTable;
import scsms.jc.util.Filesave;
import scsms.jc.util.MyRender;
import scsms.jc.util.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;

import java.awt.Color;

public class TecManager extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6224065168639624967L;
	private JTextArea send_textArea;
    private Socket socket;
   
	private String name;
    private JTextField tecName_textField;
    private JTextField tecnum_textField;
    private JTextField birth_textField_1;
    private JTextField telphone_textField_1;
    private JTextField Mail_textField_1;
    private JPasswordField oldPasswd_textField_1;
    private JPasswordField NewPasswd_textField_2;
    private JPasswordField SecondPasswd_textField_3;
    public static TableModel model;
    private JTable table_1;
    private JTable table_2;
    
   
	/**
	 * Launch the application.
	 */
	public static void login(final String name) {
	//	EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
					 
					TecManager frame = new TecManager(name);
					frame.setVisible(true);
					//System.out.println(name);test 
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
		//});
	}

	/**
	 * Create the frame.
	 */
	public TecManager(final String name) {
		
			 this.name=name;
			this.setTitle("欢迎"+name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 514);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{624, 0};
		gridBagLayout.rowHeights = new int[]{15, 436, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panelMain = new JPanel();
		tabbedPane.addTab("教师个人信息管理", null, panelMain, null);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0};
		gbl_panelMain.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
		gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_1.gridx = 0;
		gbc_tabbedPane_1.gridy = 0;
		panelMain.add(tabbedPane_1, gbc_tabbedPane_1);
		
		JPanel panel_3 = new JPanel();
	
		tabbedPane_1.addTab("信息查看", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel = new JLabel("个人信息查看",JLabel.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		final JToggleButton toggleButton = new JToggleButton("修改");
		
		GridBagConstraints gbc_toggleButton = new GridBagConstraints();
		gbc_toggleButton.insets = new Insets(0, 0, 5, 5);
		gbc_toggleButton.gridx = 2;
		gbc_toggleButton.gridy = 1;
		panel_3.add(toggleButton, gbc_toggleButton);
		
		JButton button_2 = new JButton("提交");
		
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 3;
		gbc_button_2.gridy = 1;
		panel_3.add(button_2, gbc_button_2);
		
		JLabel lblNewLabel_1 = new JLabel("教师姓名：");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tecName_textField = new JTextField();
		tecName_textField.setEditable(false);
		GridBagConstraints gbc_tecName_textField = new GridBagConstraints();
		gbc_tecName_textField.gridwidth = 2;
		gbc_tecName_textField.insets = new Insets(0, 0, 5, 0);
		gbc_tecName_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tecName_textField.gridx = 2;
		gbc_tecName_textField.gridy = 2;
		panel_3.add(tecName_textField, gbc_tecName_textField);
		tecName_textField.setColumns(10);
		
		JLabel label_1 = new JLabel("教师工号：");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 3;
		panel_3.add(label_1, gbc_label_1);
		
		tecnum_textField = new JTextField();
		tecnum_textField.setEditable(false);
		GridBagConstraints gbc_tecnum_textField = new GridBagConstraints();
		gbc_tecnum_textField.gridwidth = 2;
		gbc_tecnum_textField.insets = new Insets(0, 0, 5, 0);
		gbc_tecnum_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tecnum_textField.gridx = 2;
		gbc_tecnum_textField.gridy = 3;
		panel_3.add(tecnum_textField, gbc_tecnum_textField);
		tecnum_textField.setColumns(10);
		
		JLabel label_2 = new JLabel("性   别：");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 4;
		panel_3.add(label_2, gbc_label_2);

		final JLabel GradeCousStatement = new JLabel("");
	
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("男");
		rdbtnNewRadioButton.setEnabled(false);
		rdbtnNewRadioButton.setSelected(true);
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.fill = GridBagConstraints.VERTICAL;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.gridx = 2;
		gbc_rdbtnNewRadioButton.gridy = 4;
		panel_3.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		
		final JRadioButton radioButton = new JRadioButton("女");
		radioButton.setEnabled(false);
		GridBagConstraints gbc_radioButton = new GridBagConstraints();
		gbc_radioButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_radioButton.insets = new Insets(0, 0, 5, 0);
		gbc_radioButton.gridx = 3;
		gbc_radioButton.gridy = 4;
		panel_3.add(radioButton, gbc_radioButton);
		
		  ButtonGroup bGroup=new ButtonGroup();
		   bGroup.add(radioButton); bGroup.add(rdbtnNewRadioButton);
		JLabel label_3 = new JLabel("出生日期：");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 5;
		panel_3.add(label_3, gbc_label_3);
		
		birth_textField_1 = new JTextField();
		birth_textField_1.setEditable(false);
		GridBagConstraints gbc_birth_textField_1 = new GridBagConstraints();
		gbc_birth_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_birth_textField_1.gridwidth = 2;
		gbc_birth_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_birth_textField_1.gridx = 2;
		gbc_birth_textField_1.gridy = 5;
		panel_3.add(birth_textField_1, gbc_birth_textField_1);
		birth_textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("联系电话：");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.anchor = GridBagConstraints.EAST;
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 1;
		gbc_label_4.gridy = 6;
		panel_3.add(label_4, gbc_label_4);
		
		telphone_textField_1 = new JTextField();
		telphone_textField_1.setEditable(false);
		GridBagConstraints gbc_telphone_textField_1 = new GridBagConstraints();
		gbc_telphone_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_telphone_textField_1.gridwidth = 2;
		gbc_telphone_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_telphone_textField_1.gridx = 2;
		gbc_telphone_textField_1.gridy = 6;
		panel_3.add(telphone_textField_1, gbc_telphone_textField_1);
		telphone_textField_1.setColumns(10);
		
		JLabel label_5 = new JLabel("邮  箱：");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 1;
		gbc_label_5.gridy = 7;
		panel_3.add(label_5, gbc_label_5);
		
		Mail_textField_1 = new JTextField();
		Mail_textField_1.setEditable(false);
		GridBagConstraints gbc_Mail_textField_1 = new GridBagConstraints();
		gbc_Mail_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_Mail_textField_1.gridwidth = 2;
		gbc_Mail_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Mail_textField_1.gridx = 2;
		gbc_Mail_textField_1.gridy = 7;
		panel_3.add(Mail_textField_1, gbc_Mail_textField_1);
		Mail_textField_1.setColumns(10);
		
		JLabel label_6 = new JLabel("简  介：");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 8;
		panel_3.add(label_6, gbc_label_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridheight = 2;
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 8;
		panel_3.add(scrollPane_2, gbc_scrollPane_2);
		
		final JTextArea info_textArea = new JTextArea();
		info_textArea.setEditable(false);
		scrollPane_2.setViewportView(info_textArea);
		
		JLabel lblNewLabel_2 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 9;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel label_11 = new JLabel("     ");
		GridBagConstraints gbc_label_11 = new GridBagConstraints();
		gbc_label_11.insets = new Insets(0, 0, 0, 5);
		gbc_label_11.gridx = 1;
		gbc_label_11.gridy = 10;
		panel_3.add(label_11, gbc_label_11);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("修改密码", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_8 = new JLabel("原密码：");
		label_8.setBounds(114, 93, 48, 15);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("新密码：");
		label_9.setBounds(114, 119, 48, 15);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("验证新密码：");
		label_10.setBounds(90, 145, 72, 15);
		panel_2.add(label_10);
		
		JLabel label_7 = new JLabel(" ");
		label_7.setBounds(527, 378, 6, 15);
		panel_2.add(label_7);
		
		JButton submit_button_2 = new JButton("提交");
		
		submit_button_2.setBounds(90, 236, 93, 23);
		panel_2.add(submit_button_2);
		
		JButton reset_button_3 = new JButton("重置");
		
		reset_button_3.setBounds(230, 236, 93, 23);
		panel_2.add(reset_button_3);
		
		oldPasswd_textField_1 = new JPasswordField();
		oldPasswd_textField_1.setBounds(167, 90, 115, 21);
		panel_2.add(oldPasswd_textField_1);
		
		NewPasswd_textField_2 = new JPasswordField();
		NewPasswd_textField_2.setBounds(167, 118, 115, 21);
		panel_2.add(NewPasswd_textField_2);
		
		SecondPasswd_textField_3 = new JPasswordField();
		SecondPasswd_textField_3.setBounds(167, 145, 115, 21);
		panel_2.add(SecondPasswd_textField_3);
		
		final JLabel status_lblNewLabel_3 = new JLabel("");
		status_lblNewLabel_3.setForeground(Color.RED);
		status_lblNewLabel_3.setBounds(126, 189, 205, 37);
		panel_2.add(status_lblNewLabel_3);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("学生信息管理", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_2 = new GridBagConstraints();
		gbc_tabbedPane_2.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_2.gridx = 0;
		gbc_tabbedPane_2.gridy = 0;
		panel.add(tabbedPane_2, gbc_tabbedPane_2);
		
		JPanel panel_4 = new JPanel();
	
		tabbedPane_2.addTab("学生成绩录入", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 0, 506, 414);
		panel_4.add(scrollPane_3);
		
		table_2 = new JTable();{
//			 public void changeSelection(int rowIndex, int columnIndex,
//		                boolean toggle, boolean extend){
//		                super.changeSelection(rowIndex, columnIndex, toggle, extend);
//		                super.editCellAt(rowIndex, columnIndex, null);
//		                if(table_2.isEditing()){
//		                	table_2.getCellEditor().stopCellEditing();
//		                } 
//
//			 }
//		};
		scrollPane_3.setColumnHeaderView(table_2);
		//set table model
			
		
		{	table_2.removeAll();
			
			ArrayList<SCTable> arrayList=CousInformation.tecSelectededCous(name);
			model=new  TableModel(arrayList, 6);
//			table_2.getColumnModel().getColumn(1).setCellEditor(new MyRender());//设置编辑器
//			table_2.getColumnModel().getColumn(1).setCellRenderer(new MyRender() );
//	//JtableModel table=	new JtableModel(arrayList,6,table_2);
			table_2.setModel(model);
		
			table_2.revalidate();
		}
						JPopupMenu popupMenu_1 = new JPopupMenu();
						addPopup(table_2, popupMenu_1);
						
						JMenuItem menuItem = new JMenuItem("保存");
						popupMenu_1.add(menuItem);
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("授课评价信息管理", null, panel_1, null);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{1, 0};
		gbl_panel_1.rowHeights = new int[]{1, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.LEFT);
		GridBagConstraints gbc_tabbedPane_3 = new GridBagConstraints();
		gbc_tabbedPane_3.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane_3.gridx = 0;
		gbc_tabbedPane_3.gridy = 0;
		panel_1.add(tabbedPane_3, gbc_tabbedPane_3);
		
		JPanel panel_5 = new JPanel();
		tabbedPane_3.addTab("查看评价", null, panel_5, null);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{530, 0};
		gbl_panel_5.rowHeights = new int[]{375, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		scrollPane_3.setViewportView(GradeCousStatement);
		table_1 = new JTable();
		GridBagConstraints gbc_table_1 = new GridBagConstraints();
		gbc_table_1.fill = GridBagConstraints.BOTH;
		gbc_table_1.gridx = 0;
		gbc_table_1.gridy = 0;
		panel_5.add(table_1, gbc_table_1);
			
		//set table_1 model
		{	
		//	QuestionInfomation infomation=new  QuestionInfomation();
			try {
				table_1.removeAll();
				ArrayList<countOfValueAtQues> arrayList1=QuestionInfomation.tecGetValueOfQuestion(name);
					TableModel	model1=new  TableModel(arrayList1, 7);
					table_1.setModel(model1);
					table_1.revalidate();

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				
			}
			
			
		}
		JPanel chat_panel = new JPanel();
		tabbedPane.addTab("师生交互", null, chat_panel, null);
		
		JPanel title_panel_7 = new JPanel();
		
		JPanel panel_8 = new JPanel();
		GroupLayout gl_chat_panel = new GroupLayout(chat_panel);
		gl_chat_panel.setHorizontalGroup(
			gl_chat_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chat_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(title_panel_7, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
				.addGroup(gl_chat_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_chat_panel.setVerticalGroup(
			gl_chat_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_chat_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(title_panel_7, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel content_panel_7 = new JPanel();
		
		JPanel panel_7 = new JPanel();
		
		final JButton sendButton = new JButton("发送");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				  sendToServer.send(socket, send_textArea, sendButton, name);
			     
			    
			}
		});
		
		JButton button = new JButton("重置");
		
		
		JLabel label = new JLabel("当前在线人数：");
		
		JLabel state_label = new JLabel("未知");
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(content_panel_7, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(13, Short.MAX_VALUE))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(state_label)
							.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
							.addComponent(button)
							.addGap(96)
							.addComponent(sendButton)
							.addGap(96))))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(content_panel_7, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(12)
							.addComponent(label))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(14)
							.addComponent(state_label))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_8.createParallelGroup(Alignment.BASELINE)
								.addComponent(sendButton)
								.addComponent(button))))
					.addContainerGap())
		);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 16, 550, 38);
		panel_7.add(scrollPane_1);
		
		send_textArea = new JTextArea();
		scrollPane_1.setViewportView(send_textArea);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  send_textArea.setText(null);
			}
		});
		content_panel_7.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 556, 254);
		content_panel_7.add(scrollPane);
		
		final JTextArea content_textArea = new JTextArea();
		scrollPane.setViewportView(content_textArea);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(content_textArea, popupMenu);
		
		JMenuItem clear_menu = new JMenuItem("清空消息");
		clear_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				content_textArea.setText(null);
			}
		});
		
		clear_menu.setSelected(true);
		popupMenu.add(clear_menu);
		
		JMenuItem saveMsg_menu = new JMenuItem("保存消息");
		saveMsg_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				Filesave.svaeFile(content_textArea);
			   
			}
		});
		popupMenu.add(saveMsg_menu);
		panel_8.setLayout(gl_panel_8);
		
		JLabel title_label = new JLabel("欢迎进入师生互动交流室");
		
		JButton button_1 = new JButton("开始聊天");
		button_1.addActionListener(new ActionListener() {
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
		
		JLabel lb_info = new JLabel("教师信息管理端");
		GridBagConstraints gbc_lb_info = new GridBagConstraints();
		gbc_lb_info.anchor = GridBagConstraints.NORTHWEST;
		gbc_lb_info.insets = new Insets(0, 0, 5, 0);
		gbc_lb_info.gridx = 0;
		gbc_lb_info.gridy = 0;
		getContentPane().add(lb_info, gbc_lb_info);
		GroupLayout gl_title_panel_7 = new GroupLayout(title_panel_7);
		gl_title_panel_7.setHorizontalGroup(
			gl_title_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_title_panel_7.createSequentialGroup()
					.addGap(219)
					.addComponent(title_label)
					.addPreferredGap(ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
					.addComponent(button_1)
					.addGap(26))
		);
		gl_title_panel_7.setVerticalGroup(
			gl_title_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_title_panel_7.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_title_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(title_label)
						.addComponent(button_1))
					.addContainerGap(3, Short.MAX_VALUE))
		);
		title_panel_7.setLayout(gl_title_panel_7);
		chat_panel.setLayout(gl_chat_panel);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.anchor = GridBagConstraints.EAST;
		gbc_tabbedPane.fill = GridBagConstraints.VERTICAL;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		submit_button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(UpdatePasswd.updatePasswd(name, oldPasswd_textField_1,NewPasswd_textField_2, SecondPasswd_textField_3, status_lblNewLabel_3))
				{ 
					JOptionPane.showMessageDialog(null, "修改成功");
				}
				
		else { JOptionPane.showMessageDialog(null, "修改失败", "密码修改", 1);}
			
				}
			
			
		});
		reset_button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 oldPasswd_textField_1.setText(null);
			 NewPasswd_textField_2.setText(null);
			 SecondPasswd_textField_3.setText(null);
			}
		});
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   boolean flag=true;
			   
			   if(toggleButton.getText().toString().equals("修改"))
				{	//tecName_textField.setEditable(true);
				   // tecnum_textField.setEditable(true);
			 // rdbtnNewRadioButton.setEnabled(true);
			//  radioButton.setEnabled(true);
			  birth_textField_1.setEditable(true);
			  telphone_textField_1.setEditable(true);
			  Mail_textField_1.setEditable(true);
			  info_textArea.setEditable(true);
			  flag=!flag;
				}
			   if(toggleButton.getText().toString().equals("不修改"))
				{tecName_textField.setEditable(false);
		      	    tecnum_textField.setEditable(false);
			  rdbtnNewRadioButton.setEnabled(false);
			  radioButton.setEnabled(false);
			  birth_textField_1.setEditable(false);
			  telphone_textField_1.setEditable(false);
			  Mail_textField_1.setEditable(false);
			  info_textArea.setEditable(false);
			 
				}
			  
			   if (flag) {
				 toggleButton.setText("修改");
			}
			    if (!flag) {
					toggleButton.setText("不修改");
				}
			 }
		});
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			 
			  
			   TecInformation tecInformation=new TecInformation();
			tecTable table=tecInformation.tecInfom(name);
			tecName_textField.setText(table.getTec_name());
			tecnum_textField.setText(String.valueOf(table.getTec_num()));
			if (table.getTec_sex().equals("女")) {
				radioButton.setSelected(true);
			}
			if (table.getTec_sex().equals("男")) {
				rdbtnNewRadioButton.setSelected(true);
			}
			birth_textField_1.setText(table.getTec_birth().toString());
			 telphone_textField_1.setText(String.valueOf(table.getTec_tel()));
			 Mail_textField_1.setText(table.getTec_email());
			 info_textArea.setText(table.getTec_info());
			       
				  
			}
		});
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//
				tecTable tecTable=new tecTable();
				  tecTable.setTec_name(name);
				  tecTable.setTec_birth(birth_textField_1.getText().toString());
				  try {
					tecTable.setTec_tel(Long.parseLong(telphone_textField_1.getText().toString()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "不能有空项！！");
				}
				  tecTable.setTec_email(Mail_textField_1.getText().toString());
				  tecTable.setTec_info(info_textArea.getText().toString());
				  try {
					tecTable.setTec_num(Integer.parseInt(tecnum_textField.getText().toString()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
				       if (rdbtnNewRadioButton.isSelected()) {
						tecTable.setTec_sex("男");
					}
				       if (radioButton.isSelected()) {
						tecTable.setTec_sex("女");
					}
				  if(TecInfoModify.InfoModify(tecTable))
					  JOptionPane.showMessageDialog(null, "提交成功！");
				  else {
					  JOptionPane.showMessageDialog(null, "提交失败！");
				  }
			}
		});
		//学生成绩 录入  
//		panel_4.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			
//				
//				int CurrentSelectRows=table_2.getSelectedRow();
//				String[] strings1=new String[3];
//				Float float1=new Float(	table_2.getValueAt(CurrentSelectRows, 2).toString());
//				strings1[0]=table_2.getValueAt(CurrentSelectRows, 0).toString();
//				strings1[1]=name;
//				strings1[2]=table_2.getValueAt(CurrentSelectRows,3).toString();
//				
//				
//				
//			
//				if (CousInfoModify.ModiftscGrade(float1,strings1[0], strings1[1], strings1[2])) {
//					GradeCousStatement.setText("成绩录入成功！！");
//				}
//				else {
//					GradeCousStatement.setText("成绩录入失败！！");
//				}
//				String tecString=name;
//				table_2.removeAll();
//			
//				ArrayList<SCTable> arrayList=CousInformation.tecSelectededCous(tecString);
//				model=new  TableModel(arrayList, 6);
//				table_2.setModel(model);
//				table_2.revalidate();
//			
//			}
//		});
		//save grage

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int CurrentSelectRows=table_2.getSelectedRow();
				String[] strings1=new String[3];
			
			//	=new Float(	table_2.getValueAt(CurrentSelectRows, 2).toString());
			//	Float float1	=new Float(table_2.getCellEditor(CurrentSelectRows, 2).toString());
				String string=table_2.getValueAt(CurrentSelectRows, 2).toString();
				Float float1=Float.parseFloat(string);
				strings1[0]=table_2.getValueAt(CurrentSelectRows, 0).toString();
				strings1[1]=name;
				strings1[2]=table_2.getValueAt(CurrentSelectRows,3).toString();
				
				
				
			
				if (CousInfoModify.ModiftscGrade(float1,strings1[0], strings1[1], strings1[2])) {
					GradeCousStatement.setText("成绩录入成功！！");
				}
				else {
					GradeCousStatement.setText("成绩录入失败！！");
				}
				
			}
		});
	
		}	
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
