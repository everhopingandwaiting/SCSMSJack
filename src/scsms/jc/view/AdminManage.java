package scsms.jc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Toolkit;
import java.awt.FlowLayout;

import javax.swing.JTabbedPane;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import scsms.jc.dao.InfoManage.CousInfoModify;
import scsms.jc.dao.InfoManage.CousInformation;
import scsms.jc.dao.InfoManage.StuInfoModify;
import scsms.jc.dao.InfoManage.StuInformation;
import scsms.jc.dao.InfoManage.TecInfoModify;
import scsms.jc.dao.InfoManage.TecInformation;
import scsms.jc.entity.cousTable;
import scsms.jc.entity.stuTable;
import scsms.jc.entity.tecTable;
import scsms.jc.util.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;
import com.sun.org.apache.bcel.internal.generic.I2F;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AdminManage extends JFrame {
	private JTextField tf_stunum;
	private JTextField tf_stuname;
	private JTextField tf_stunum1;
	private JTextField tf_stuname1;
	private JTextField tf_stuname2;
	private JTextField tf_stunum2;
	private JTextField tf_stubirth;
	private JTextField tf_stutel;
	private JTextField tf_stuemail;
	private JTextField tf_tecnum;
	private JTextField tf_tecname;
	private JTextField tf_tecnum1;
	private JTextField tf_tecname1;
	private JTextField tf_tecname2;
	private JTextField tf_tecnum2;
	private JTextField tf_tecbirth;
	private JTextField tf_tectel;
	private JTextField tf_tecemail;
	private JTextField tf_cousnum;
	private JTextField tf_cousname;
	private JTextField tf_cousname1;
	private JTextField tf_cousnum1;
	private JTextField tf_couscredit;
	 public static TableModel model;
	 private JTable table;
	 private JTable table_1;
	 private JTable table_2;
	 private JTable table_3;
	 private JTable table_4;
	 private JTable table_5;
	private final	JLabel temp_cousNameLabel;
	private JTextField cous_tec;
	public final String name;

	/**
	 * Launch the application.
	 */
	public static void login(final String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminManage frame = new AdminManage(name);
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
	public AdminManage(final String name) {
		this.name=name;
		setTitle("欢迎进入管理员权限中心  当前："+this.name+"在线");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\haolingtianxia\\workspace\\SCSMS\\picture\\userslogin.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 639);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{765, 0};
		gridBagLayout.rowHeights = new int[]{572, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		Border border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder=BorderFactory.createTitledBorder(border, "更新学生信息", TitledBorder.LEFT, TitledBorder.TOP);
		
		ButtonGroup group=new ButtonGroup();
		Border border1=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder1=BorderFactory.createTitledBorder(border, "更新教师信息", TitledBorder.LEFT, TitledBorder.TOP);
		
		ButtonGroup group2=new ButtonGroup();
		Border border2=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder2=BorderFactory.createTitledBorder(border, "更新课程信息", TitledBorder.LEFT, TitledBorder.TOP);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(765, 572);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("管理学生", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{760, 0};
		gbl_panel.rowHeights = new int[]{543, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
			
			JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.LEFT);
			GridBagConstraints gbc_tabbedPane_2 = new GridBagConstraints();
			gbc_tabbedPane_2.fill = GridBagConstraints.BOTH;
			gbc_tabbedPane_2.gridx = 0;
			gbc_tabbedPane_2.gridy = 0;
			panel.add(tabbedPane_2, gbc_tabbedPane_2);
			
			JPanel panel_3 = new JPanel();
			tabbedPane_2.addTab("●查询学生信息", null, panel_3, null);
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{214, 80, 105, 80, 122, 0};
			gbl_panel_3.rowHeights = new int[]{23, 21, 23, 0, 0};
			gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_3.setLayout(gbl_panel_3);
			
			JLabel lblNewLabel = new JLabel("查询单个学生");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 0;
			panel_3.add(lblNewLabel, gbc_lblNewLabel);
			
			JButton btn_stuselect = new JButton("查询");
			GridBagConstraints gbc_btn_stuselect = new GridBagConstraints();
			gbc_btn_stuselect.anchor = GridBagConstraints.NORTH;
			gbc_btn_stuselect.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_stuselect.insets = new Insets(0, 0, 5, 0);
			gbc_btn_stuselect.gridx = 4;
			gbc_btn_stuselect.gridy = 0;
			panel_3.add(btn_stuselect, gbc_btn_stuselect);
			
			
			final JComboBox cb_stutype = new JComboBox();
			cb_stutype.addItem("按学号查询");
			cb_stutype.addItem("按姓名查询");
			GridBagConstraints gbc_cb_stutype = new GridBagConstraints();
			gbc_cb_stutype.anchor = GridBagConstraints.NORTHEAST;
			gbc_cb_stutype.insets = new Insets(0, 0, 5, 5);
			gbc_cb_stutype.gridx = 0;
			gbc_cb_stutype.gridy = 1;
			panel_3.add(cb_stutype, gbc_cb_stutype);
			
			JLabel lblNewLabel_3 = new JLabel("查询方式：");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 1;
			panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
			
			JLabel lblNewLabel_1 = new JLabel("按学号查询：");
			GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
			gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_1.gridx = 1;
			gbc_lblNewLabel_1.gridy = 1;
			panel_3.add(lblNewLabel_1, gbc_lblNewLabel_1);
			
			tf_stunum = new JTextField();
			GridBagConstraints gbc_tf_stunum = new GridBagConstraints();
			gbc_tf_stunum.anchor = GridBagConstraints.NORTH;
			gbc_tf_stunum.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stunum.insets = new Insets(0, 0, 5, 5);
			gbc_tf_stunum.gridx = 2;
			gbc_tf_stunum.gridy = 1;
			panel_3.add(tf_stunum, gbc_tf_stunum);
			tf_stunum.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("按姓名查询：");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 3;
			gbc_lblNewLabel_2.gridy = 1;
			panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			tf_stuname = new JTextField();
			GridBagConstraints gbc_tf_stuname = new GridBagConstraints();
			gbc_tf_stuname.anchor = GridBagConstraints.NORTH;
			gbc_tf_stuname.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stuname.insets = new Insets(0, 0, 5, 0);
			gbc_tf_stuname.gridx = 4;
			gbc_tf_stuname.gridy = 1;
			panel_3.add(tf_stuname, gbc_tf_stuname);
			tf_stuname.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("      查询全部学生");
			GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
			gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_4.gridx = 0;
			gbc_lblNewLabel_4.gridy = 2;
			panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
			
			JButton btn_stuallselect = new JButton("查询");
		
			GridBagConstraints gbc_btn_stuallselect = new GridBagConstraints();
			gbc_btn_stuallselect.insets = new Insets(0, 0, 5, 0);
			gbc_btn_stuallselect.anchor = GridBagConstraints.NORTH;
			gbc_btn_stuallselect.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_stuallselect.gridx = 4;
			gbc_btn_stuallselect.gridy = 2;
			panel_3.add(btn_stuallselect, gbc_btn_stuallselect);
			
			JScrollPane scrollPane = new JScrollPane();
			GridBagConstraints gbc_scrollPane = new GridBagConstraints();
			gbc_scrollPane.fill = GridBagConstraints.BOTH;
			gbc_scrollPane.gridwidth = 5;
			gbc_scrollPane.gridx = 0;
			gbc_scrollPane.gridy = 3;
			panel_3.add(scrollPane, gbc_scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JPanel panel_4 = new JPanel();
			tabbedPane_2.addTab("●更新学生信息", null, panel_4, null);
			panel_4.setBorder(tBorder);
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[]{1, 40, 31, 25, 84, 72, 111, 135, 125, 0};
			gbl_panel_4.rowHeights = new int[]{0, 1, 21, 21, 21, 23, 21, 21, 21, 168, 133, 23, 0};
			gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_4.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_4.setLayout(gbl_panel_4);
			
			final JLabel stuStatementLabel = new JLabel("");
			stuStatementLabel.setForeground(Color.ORANGE);
			GridBagConstraints gbc_stuStatementLabel = new GridBagConstraints();
			gbc_stuStatementLabel.fill = GridBagConstraints.VERTICAL;
			gbc_stuStatementLabel.gridwidth = 2;
			gbc_stuStatementLabel.insets = new Insets(0, 0, 5, 5);
			gbc_stuStatementLabel.gridx = 5;
			gbc_stuStatementLabel.gridy = 0;
			panel_4.add(stuStatementLabel, gbc_stuStatementLabel);
			
			JLabel label = new JLabel("");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.anchor = GridBagConstraints.NORTHWEST;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 1;
			panel_4.add(label, gbc_label);
			
			JLabel lblNewLabel_5 = new JLabel("查询方式：");
			GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
			gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_5.gridwidth = 3;
			gbc_lblNewLabel_5.gridx = 1;
			gbc_lblNewLabel_5.gridy = 2;
			panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);
			
			final JComboBox cb_stuselecttype = new JComboBox();
			cb_stuselecttype.addItem("按学号查询");
			cb_stuselecttype.addItem("按姓名查询");
			GridBagConstraints gbc_cb_stuselecttype = new GridBagConstraints();
			gbc_cb_stuselecttype.anchor = GridBagConstraints.NORTH;
			gbc_cb_stuselecttype.fill = GridBagConstraints.HORIZONTAL;
			gbc_cb_stuselecttype.insets = new Insets(0, 0, 5, 5);
			gbc_cb_stuselecttype.gridwidth = 2;
			gbc_cb_stuselecttype.gridx = 3;
			gbc_cb_stuselecttype.gridy = 2;
			panel_4.add(cb_stuselecttype, gbc_cb_stuselecttype);
			
			JLabel lblNewLabel_6 = new JLabel("按学号查询：");
			GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
			gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_6.gridx = 5;
			gbc_lblNewLabel_6.gridy = 2;
			panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
			
			tf_stunum1 = new JTextField();
			GridBagConstraints gbc_tf_stunum1 = new GridBagConstraints();
			gbc_tf_stunum1.anchor = GridBagConstraints.NORTH;
			gbc_tf_stunum1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stunum1.insets = new Insets(0, 0, 5, 5);
			gbc_tf_stunum1.gridx = 6;
			gbc_tf_stunum1.gridy = 2;
			panel_4.add(tf_stunum1, gbc_tf_stunum1);
			tf_stunum1.setColumns(10);
			
			JLabel lblNewLabel_7 = new JLabel("按姓名查询：");
			GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
			gbc_lblNewLabel_7.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_7.gridx = 7;
			gbc_lblNewLabel_7.gridy = 2;
			panel_4.add(lblNewLabel_7, gbc_lblNewLabel_7);
			
			tf_stuname1 = new JTextField();
			GridBagConstraints gbc_tf_stuname1 = new GridBagConstraints();
			gbc_tf_stuname1.anchor = GridBagConstraints.NORTH;
			gbc_tf_stuname1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stuname1.insets = new Insets(0, 0, 5, 0);
			gbc_tf_stuname1.gridx = 8;
			gbc_tf_stuname1.gridy = 2;
			panel_4.add(tf_stuname1, gbc_tf_stuname1);
			tf_stuname1.setColumns(10);
			
			JLabel lblNewLabel_8 = new JLabel("姓名：");
			GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
			gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_8.gridx = 1;
			gbc_lblNewLabel_8.gridy = 3;
			panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);
			
			tf_stuname2 = new JTextField();
			tf_stuname2.setEditable(false);
			GridBagConstraints gbc_tf_stuname2 = new GridBagConstraints();
			gbc_tf_stuname2.anchor = GridBagConstraints.NORTH;
			gbc_tf_stuname2.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stuname2.insets = new Insets(0, 0, 5, 5);
			gbc_tf_stuname2.gridwidth = 3;
			gbc_tf_stuname2.gridx = 2;
			gbc_tf_stuname2.gridy = 3;
			panel_4.add(tf_stuname2, gbc_tf_stuname2);
			tf_stuname2.setColumns(10);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
			gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane_1.gridheight = 8;
			gbc_scrollPane_1.gridwidth = 4;
			gbc_scrollPane_1.gridx = 5;
			gbc_scrollPane_1.gridy = 3;
			panel_4.add(scrollPane_1, gbc_scrollPane_1);
			
			table_1 = new JTable();
			
			scrollPane_1.setViewportView(table_1);
			
			JLabel lblNewLabel_9 = new JLabel("学号：");
			GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
			gbc_lblNewLabel_9.anchor = GridBagConstraints.SOUTHWEST;
			gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_9.gridx = 1;
			gbc_lblNewLabel_9.gridy = 4;
			panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);
			
			tf_stunum2 = new JTextField();
			GridBagConstraints gbc_tf_stunum2 = new GridBagConstraints();
			gbc_tf_stunum2.anchor = GridBagConstraints.NORTH;
			gbc_tf_stunum2.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_stunum2.insets = new Insets(0, 0, 5, 5);
			gbc_tf_stunum2.gridwidth = 3;
			gbc_tf_stunum2.gridx = 2;
			gbc_tf_stunum2.gridy = 4;
			panel_4.add(tf_stunum2, gbc_tf_stunum2);
			tf_stunum2.setColumns(10);
			
			JLabel lblNewLabel_10 = new JLabel("性别：");
			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
			gbc_lblNewLabel_10.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_10.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_10.gridx = 1;
			gbc_lblNewLabel_10.gridy = 5;
			panel_4.add(lblNewLabel_10, gbc_lblNewLabel_10);
			final JRadioButton rdb_sex_m = new JRadioButton("男" ,true);
			group.add(rdb_sex_m);
			GridBagConstraints gbc_rdb_sex_m = new GridBagConstraints();
			gbc_rdb_sex_m.anchor = GridBagConstraints.NORTH;
			gbc_rdb_sex_m.fill = GridBagConstraints.HORIZONTAL;
			gbc_rdb_sex_m.insets = new Insets(0, 0, 5, 5);
			gbc_rdb_sex_m.gridwidth = 2;
			gbc_rdb_sex_m.gridx = 2;
			gbc_rdb_sex_m.gridy = 5;
			panel_4.add(rdb_sex_m, gbc_rdb_sex_m);
			
			//ButtonGroup group=new ButtonGroup();
			final JRadioButton rdb_sex_f = new JRadioButton("女",false);
			group.add(rdb_sex_f);
			GridBagConstraints gbc_rdb_sex_f = new GridBagConstraints();
			gbc_rdb_sex_f.anchor = GridBagConstraints.NORTHWEST;
			gbc_rdb_sex_f.insets = new Insets(0, 0, 5, 5);
			gbc_rdb_sex_f.gridx = 4;
			gbc_rdb_sex_f.gridy = 5;
			panel_4.add(rdb_sex_f, gbc_rdb_sex_f);
			
				
				JLabel lblNewLabel_11 = new JLabel("出日：");
				GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
				gbc_lblNewLabel_11.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_11.gridwidth = 2;
				gbc_lblNewLabel_11.gridx = 1;
				gbc_lblNewLabel_11.gridy = 6;
				panel_4.add(lblNewLabel_11, gbc_lblNewLabel_11);
				
				tf_stubirth = new JTextField();
				GridBagConstraints gbc_tf_stubirth = new GridBagConstraints();
				gbc_tf_stubirth.anchor = GridBagConstraints.NORTH;
				gbc_tf_stubirth.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_stubirth.insets = new Insets(0, 0, 5, 5);
				gbc_tf_stubirth.gridwidth = 3;
				gbc_tf_stubirth.gridx = 2;
				gbc_tf_stubirth.gridy = 6;
				panel_4.add(tf_stubirth, gbc_tf_stubirth);
				tf_stubirth.setColumns(10);
				
				JLabel lblNewLabel_12 = new JLabel("电话：");
				GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
				gbc_lblNewLabel_12.anchor = GridBagConstraints.SOUTH;
				gbc_lblNewLabel_12.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_12.gridwidth = 2;
				gbc_lblNewLabel_12.gridx = 1;
				gbc_lblNewLabel_12.gridy = 7;
				panel_4.add(lblNewLabel_12, gbc_lblNewLabel_12);
				
				tf_stutel = new JTextField();
				GridBagConstraints gbc_tf_stutel = new GridBagConstraints();
				gbc_tf_stutel.anchor = GridBagConstraints.NORTH;
				gbc_tf_stutel.fill = GridBagConstraints.HORIZONTAL;
				gbc_tf_stutel.insets = new Insets(0, 0, 5, 5);
				gbc_tf_stutel.gridwidth = 3;
				gbc_tf_stutel.gridx = 2;
				gbc_tf_stutel.gridy = 7;
				panel_4.add(tf_stutel, gbc_tf_stutel);
				tf_stutel.setColumns(10);
				
				JLabel lblNewLabel_13 = new JLabel("邮箱：");
				GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
				gbc_lblNewLabel_13.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_13.gridwidth = 2;
				gbc_lblNewLabel_13.gridx = 1;
				gbc_lblNewLabel_13.gridy = 8;
				panel_4.add(lblNewLabel_13, gbc_lblNewLabel_13);
				
				JScrollPane scrollPane_4 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
				gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_4.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane_4.gridwidth = 3;
				gbc_scrollPane_4.gridx = 2;
				gbc_scrollPane_4.gridy = 8;
				panel_4.add(scrollPane_4, gbc_scrollPane_4);
				
				tf_stuemail = new JTextField();
				scrollPane_4.setViewportView(tf_stuemail);
				tf_stuemail.setColumns(10);
				
				JLabel lblNewLabel_14 = new JLabel("介绍：");
				GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
				gbc_lblNewLabel_14.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel_14.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_14.gridwidth = 2;
				gbc_lblNewLabel_14.gridx = 1;
				gbc_lblNewLabel_14.gridy = 9;
				panel_4.add(lblNewLabel_14, gbc_lblNewLabel_14);
				
				JScrollPane scrollPane_2 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
				gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane_2.gridwidth = 3;
				gbc_scrollPane_2.gridx = 2;
				gbc_scrollPane_2.gridy = 9;
				panel_4.add(scrollPane_2, gbc_scrollPane_2);
				
				final JTextArea ta_studetail = new JTextArea();
				scrollPane_2.setViewportView(ta_studetail);
				
				JLabel lblNewLabel_15 = new JLabel("地址：");
				GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
				gbc_lblNewLabel_15.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel_15.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_15.gridwidth = 2;
				gbc_lblNewLabel_15.gridx = 1;
				gbc_lblNewLabel_15.gridy = 10;
				panel_4.add(lblNewLabel_15, gbc_lblNewLabel_15);
				
				JScrollPane scrollPane_3 = new JScrollPane();
				scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
				gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane_3.gridwidth = 3;
				gbc_scrollPane_3.gridx = 2;
				gbc_scrollPane_3.gridy = 10;
				panel_4.add(scrollPane_3, gbc_scrollPane_3);
				
				final JTextArea textArea = new JTextArea();
				scrollPane_3.setViewportView(textArea);
				
				JButton btn_stuselect2 = new JButton("查询");
				
				GridBagConstraints gbc_btn_stuselect2 = new GridBagConstraints();
				gbc_btn_stuselect2.anchor = GridBagConstraints.NORTH;
				gbc_btn_stuselect2.insets = new Insets(0, 0, 0, 5);
				gbc_btn_stuselect2.gridx = 4;
				gbc_btn_stuselect2.gridy = 11;
				panel_4.add(btn_stuselect2, gbc_btn_stuselect2);
				
				JButton btn_stumodify = new JButton("修改");
				
				GridBagConstraints gbc_btn_stumodify = new GridBagConstraints();
				gbc_btn_stumodify.anchor = GridBagConstraints.NORTH;
				gbc_btn_stumodify.fill = GridBagConstraints.HORIZONTAL;
				gbc_btn_stumodify.insets = new Insets(0, 0, 0, 5);
				gbc_btn_stumodify.gridx = 6;
				gbc_btn_stumodify.gridy = 11;
				panel_4.add(btn_stumodify, gbc_btn_stumodify);
				
				
				JButton btn_stushanchu = new JButton("删除");
			
				GridBagConstraints gbc_btn_stushanchu = new GridBagConstraints();
				gbc_btn_stushanchu.anchor = GridBagConstraints.NORTH;
				gbc_btn_stushanchu.fill = GridBagConstraints.HORIZONTAL;
				gbc_btn_stushanchu.gridx = 8;
				gbc_btn_stushanchu.gridy = 11;
				panel_4.add(btn_stushanchu, gbc_btn_stushanchu);
		
										
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("管理教师", null, panel_1, null);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0};
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
			tabbedPane_3.addTab("●查询教师信息", null, panel_5, null);
			GridBagLayout gbl_panel_5 = new GridBagLayout();
			gbl_panel_5.columnWidths = new int[]{79, 119, 209, 79, 119, 0};
			gbl_panel_5.rowHeights = new int[]{23, 21, 23, 418, 0};
			gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_5.setLayout(gbl_panel_5);
			
			JLabel lblNewLabel_16 = new JLabel("查询单个老师");
			GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
			gbc_lblNewLabel_16.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_16.gridx = 0;
			gbc_lblNewLabel_16.gridy = 0;
			panel_5.add(lblNewLabel_16, gbc_lblNewLabel_16);
			
			JButton btn_tecselect = new JButton("查询");
			
			GridBagConstraints gbc_btn_tecselect = new GridBagConstraints();
			gbc_btn_tecselect.anchor = GridBagConstraints.NORTH;
			gbc_btn_tecselect.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_tecselect.insets = new Insets(0, 0, 5, 0);
			gbc_btn_tecselect.gridx = 4;
			gbc_btn_tecselect.gridy = 0;
			panel_5.add(btn_tecselect, gbc_btn_tecselect);
			
			JLabel lblNewLabel_17 = new JLabel("选择查询方式：");
			GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
			gbc_lblNewLabel_17.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_17.gridwidth = 2;
			gbc_lblNewLabel_17.gridx = 0;
			gbc_lblNewLabel_17.gridy = 1;
			panel_5.add(lblNewLabel_17, gbc_lblNewLabel_17);
			
			final JComboBox cb_tectype = new JComboBox();
			cb_tectype.addItem("按教工号查询");
			cb_tectype.addItem("按姓名查询");
			GridBagConstraints gbc_cb_tectype = new GridBagConstraints();
			gbc_cb_tectype.anchor = GridBagConstraints.NORTH;
			gbc_cb_tectype.fill = GridBagConstraints.HORIZONTAL;
			gbc_cb_tectype.insets = new Insets(0, 0, 5, 5);
			gbc_cb_tectype.gridx = 1;
			gbc_cb_tectype.gridy = 1;
			panel_5.add(cb_tectype, gbc_cb_tectype);
			
			JLabel lblNewLabel_18 = new JLabel("按教工号查询： ");
			lblNewLabel_18.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
			gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_18.gridx = 2;
			gbc_lblNewLabel_18.gridy = 1;
			panel_5.add(lblNewLabel_18, gbc_lblNewLabel_18);
			
			tf_tecnum = new JTextField();
			tf_tecnum.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_tf_tecnum = new GridBagConstraints();
			gbc_tf_tecnum.anchor = GridBagConstraints.NORTHEAST;
			gbc_tf_tecnum.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecnum.gridx = 2;
			gbc_tf_tecnum.gridy = 1;
			panel_5.add(tf_tecnum, gbc_tf_tecnum);
			tf_tecnum.setColumns(10);
			
			JLabel lblNewLabel_19 = new JLabel("按姓名查询：");
			GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
			gbc_lblNewLabel_19.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_19.gridx = 3;
			gbc_lblNewLabel_19.gridy = 1;
			panel_5.add(lblNewLabel_19, gbc_lblNewLabel_19);
			
			tf_tecname = new JTextField();
			GridBagConstraints gbc_tf_tecname = new GridBagConstraints();
			gbc_tf_tecname.anchor = GridBagConstraints.NORTH;
			gbc_tf_tecname.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tecname.insets = new Insets(0, 0, 5, 0);
			gbc_tf_tecname.gridx = 4;
			gbc_tf_tecname.gridy = 1;
			panel_5.add(tf_tecname, gbc_tf_tecname);
			tf_tecname.setColumns(10);
			
			JLabel lblNewLabel_20 = new JLabel("查询全部教师");
			GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
			gbc_lblNewLabel_20.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_20.gridx = 0;
			gbc_lblNewLabel_20.gridy = 2;
			panel_5.add(lblNewLabel_20, gbc_lblNewLabel_20);
			
			JButton btn_tecallselect = new JButton("查询");
		
			GridBagConstraints gbc_btn_tecallselect = new GridBagConstraints();
			gbc_btn_tecallselect.anchor = GridBagConstraints.NORTH;
			gbc_btn_tecallselect.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_tecallselect.insets = new Insets(0, 0, 5, 0);
			gbc_btn_tecallselect.gridx = 4;
			gbc_btn_tecallselect.gridy = 2;
			panel_5.add(btn_tecallselect, gbc_btn_tecallselect);
			
			JScrollPane scrollPane_5 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_5 = new GridBagConstraints();
			gbc_scrollPane_5.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_5.gridwidth = 5;
			gbc_scrollPane_5.gridx = 0;
			gbc_scrollPane_5.gridy = 3;
			panel_5.add(scrollPane_5, gbc_scrollPane_5);
			
			table_2 = new JTable();
			scrollPane_5.setViewportView(table_2);
			
			JPanel panel_6 = new JPanel();
			tabbedPane_3.addTab("●更新教师信息", null, panel_6, null);
			panel_6.setBorder(tBorder1);
			GridBagLayout gbl_panel_6 = new GridBagLayout();
			gbl_panel_6.columnWidths = new int[]{68, 50, 72, 3, 193, 83, 134, 0, 0};
			gbl_panel_6.rowHeights = new int[]{21, 30, 21, 23, 21, 21, 21, 144, 23, 0, 0, 0, 0};
			gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel_6.setLayout(gbl_panel_6);
			
			JLabel lblNewLabel_21 = new JLabel("选择查询方式：");
			GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
			gbc_lblNewLabel_21.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_21.gridwidth = 2;
			gbc_lblNewLabel_21.gridx = 0;
			gbc_lblNewLabel_21.gridy = 0;
			panel_6.add(lblNewLabel_21, gbc_lblNewLabel_21);
			
			final JComboBox cb_tectype1 = new JComboBox();
			cb_tectype1.addItem("按教工号查询");
			cb_tectype1.addItem("按教师姓名查询");
			GridBagConstraints gbc_cb_tectype1 = new GridBagConstraints();
			gbc_cb_tectype1.anchor = GridBagConstraints.NORTHEAST;
			gbc_cb_tectype1.insets = new Insets(0, 0, 5, 5);
			gbc_cb_tectype1.gridwidth = 3;
			gbc_cb_tectype1.gridx = 1;
			gbc_cb_tectype1.gridy = 0;
			panel_6.add(cb_tectype1, gbc_cb_tectype1);
			
			JLabel lblNewLabel_22 = new JLabel("按教工号查询：");
			GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
			gbc_lblNewLabel_22.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_22.gridx = 4;
			gbc_lblNewLabel_22.gridy = 0;
			panel_6.add(lblNewLabel_22, gbc_lblNewLabel_22);
			
			tf_tecnum1 = new JTextField();
			GridBagConstraints gbc_tf_tecnum1 = new GridBagConstraints();
			gbc_tf_tecnum1.anchor = GridBagConstraints.NORTHEAST;
			gbc_tf_tecnum1.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecnum1.gridx = 4;
			gbc_tf_tecnum1.gridy = 0;
			panel_6.add(tf_tecnum1, gbc_tf_tecnum1);
			tf_tecnum1.setColumns(10);
			
			JLabel lblNewLabel_23 = new JLabel("按姓名查询：");
			GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
			gbc_lblNewLabel_23.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_23.gridx = 5;
			gbc_lblNewLabel_23.gridy = 0;
			panel_6.add(lblNewLabel_23, gbc_lblNewLabel_23);
			
			tf_tecname1 = new JTextField();
			GridBagConstraints gbc_tf_tecname1 = new GridBagConstraints();
			gbc_tf_tecname1.anchor = GridBagConstraints.NORTH;
			gbc_tf_tecname1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tecname1.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecname1.gridx = 6;
			gbc_tf_tecname1.gridy = 0;
			panel_6.add(tf_tecname1, gbc_tf_tecname1);
			tf_tecname1.setColumns(10);
			
			JLabel lblNewLabel_24 = new JLabel("姓名：");
			GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
			gbc_lblNewLabel_24.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_24.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_24.gridx = 0;
			gbc_lblNewLabel_24.gridy = 1;
			panel_6.add(lblNewLabel_24, gbc_lblNewLabel_24);
			
			tf_tecname2 = new JTextField();
			tf_tecname2.setEditable(false);
			GridBagConstraints gbc_tf_tecname2 = new GridBagConstraints();
			gbc_tf_tecname2.anchor = GridBagConstraints.SOUTH;
			gbc_tf_tecname2.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tecname2.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecname2.gridwidth = 2;
			gbc_tf_tecname2.gridx = 1;
			gbc_tf_tecname2.gridy = 1;
			panel_6.add(tf_tecname2, gbc_tf_tecname2);
			tf_tecname2.setColumns(10);
			
			JScrollPane scrollPane_6 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_6 = new GridBagConstraints();
			gbc_scrollPane_6.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_6.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane_6.gridheight = 7;
			gbc_scrollPane_6.gridwidth = 4;
			gbc_scrollPane_6.gridx = 3;
			gbc_scrollPane_6.gridy = 1;
			panel_6.add(scrollPane_6, gbc_scrollPane_6);
			
			table_3 = new JTable();
			
			scrollPane_6.setViewportView(table_3);
			
			JLabel lblNewLabel_25 = new JLabel("教工号：");
			GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
			gbc_lblNewLabel_25.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_25.gridx = 0;
			gbc_lblNewLabel_25.gridy = 2;
			panel_6.add(lblNewLabel_25, gbc_lblNewLabel_25);
			
			tf_tecnum2 = new JTextField();
			GridBagConstraints gbc_tf_tecnum2 = new GridBagConstraints();
			gbc_tf_tecnum2.anchor = GridBagConstraints.NORTH;
			gbc_tf_tecnum2.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tecnum2.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecnum2.gridwidth = 2;
			gbc_tf_tecnum2.gridx = 1;
			gbc_tf_tecnum2.gridy = 2;
			panel_6.add(tf_tecnum2, gbc_tf_tecnum2);
			tf_tecnum2.setColumns(10);
			
			
			JLabel lblNewLabel_26 = new JLabel("性别：");
			GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
			gbc_lblNewLabel_26.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_26.gridx = 0;
			gbc_lblNewLabel_26.gridy = 3;
			panel_6.add(lblNewLabel_26, gbc_lblNewLabel_26);
			final JRadioButton rdb_tecsex_m = new JRadioButton("男",true);
			group2.add(rdb_tecsex_m);
			GridBagConstraints gbc_rdb_tecsex_m = new GridBagConstraints();
			gbc_rdb_tecsex_m.anchor = GridBagConstraints.NORTH;
			gbc_rdb_tecsex_m.fill = GridBagConstraints.HORIZONTAL;
			gbc_rdb_tecsex_m.insets = new Insets(0, 0, 5, 5);
			gbc_rdb_tecsex_m.gridx = 1;
			gbc_rdb_tecsex_m.gridy = 3;
			panel_6.add(rdb_tecsex_m, gbc_rdb_tecsex_m);
			
			final JRadioButton rdb_tecsex_f = new JRadioButton("女",false);
			group2.add(rdb_tecsex_f);
			GridBagConstraints gbc_rdb_tecsex_f = new GridBagConstraints();
			gbc_rdb_tecsex_f.anchor = GridBagConstraints.NORTH;
			gbc_rdb_tecsex_f.fill = GridBagConstraints.HORIZONTAL;
			gbc_rdb_tecsex_f.insets = new Insets(0, 0, 5, 5);
			gbc_rdb_tecsex_f.gridx = 2;
			gbc_rdb_tecsex_f.gridy = 3;
			panel_6.add(rdb_tecsex_f, gbc_rdb_tecsex_f);
			
			JLabel lblNewLabel_27 = new JLabel("出生日期：");
			GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
			gbc_lblNewLabel_27.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_27.gridx = 0;
			gbc_lblNewLabel_27.gridy = 4;
			panel_6.add(lblNewLabel_27, gbc_lblNewLabel_27);
			
			tf_tecbirth = new JTextField();
			GridBagConstraints gbc_tf_tecbirth = new GridBagConstraints();
			gbc_tf_tecbirth.anchor = GridBagConstraints.NORTH;
			gbc_tf_tecbirth.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tecbirth.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tecbirth.gridwidth = 2;
			gbc_tf_tecbirth.gridx = 1;
			gbc_tf_tecbirth.gridy = 4;
			panel_6.add(tf_tecbirth, gbc_tf_tecbirth);
			tf_tecbirth.setColumns(10);
			
			JLabel lblNewLabel_28 = new JLabel("联系电话：");
			GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
			gbc_lblNewLabel_28.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_28.gridx = 0;
			gbc_lblNewLabel_28.gridy = 5;
			panel_6.add(lblNewLabel_28, gbc_lblNewLabel_28);
			
			tf_tectel = new JTextField();
			GridBagConstraints gbc_tf_tectel = new GridBagConstraints();
			gbc_tf_tectel.anchor = GridBagConstraints.NORTH;
			gbc_tf_tectel.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_tectel.insets = new Insets(0, 0, 5, 5);
			gbc_tf_tectel.gridwidth = 2;
			gbc_tf_tectel.gridx = 1;
			gbc_tf_tectel.gridy = 5;
			panel_6.add(tf_tectel, gbc_tf_tectel);
			tf_tectel.setColumns(10);
			
			JLabel lblNewLabel_29 = new JLabel("邮箱地址：");
			GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
			gbc_lblNewLabel_29.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_29.gridx = 0;
			gbc_lblNewLabel_29.gridy = 6;
			panel_6.add(lblNewLabel_29, gbc_lblNewLabel_29);
			
			JScrollPane scrollPane_10 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_10 = new GridBagConstraints();
			gbc_scrollPane_10.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_10.gridwidth = 2;
			gbc_scrollPane_10.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane_10.gridx = 1;
			gbc_scrollPane_10.gridy = 6;
			panel_6.add(scrollPane_10, gbc_scrollPane_10);
			
			tf_tecemail = new JTextField();
			scrollPane_10.setViewportView(tf_tecemail);
			tf_tecemail.setColumns(10);
			
			JLabel lblNewLabel_30 = new JLabel("简要介绍：");
			GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
			gbc_lblNewLabel_30.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel_30.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_30.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_30.gridx = 0;
			gbc_lblNewLabel_30.gridy = 7;
			panel_6.add(lblNewLabel_30, gbc_lblNewLabel_30);
			
			JScrollPane scrollPane_9 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_9 = new GridBagConstraints();
			gbc_scrollPane_9.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_9.gridwidth = 2;
			gbc_scrollPane_9.insets = new Insets(0, 0, 5, 5);
			gbc_scrollPane_9.gridx = 1;
			gbc_scrollPane_9.gridy = 7;
			panel_6.add(scrollPane_9, gbc_scrollPane_9);
			
			final JTextArea ta_tecdetail = new JTextArea();
			scrollPane_9.setViewportView(ta_tecdetail);
			
			JButton btn_tecselect2 = new JButton("查询");
		
			GridBagConstraints gbc_btn_tecselect2 = new GridBagConstraints();
			gbc_btn_tecselect2.anchor = GridBagConstraints.NORTHWEST;
			gbc_btn_tecselect2.insets = new Insets(0, 0, 5, 5);
			gbc_btn_tecselect2.gridwidth = 2;
			gbc_btn_tecselect2.gridx = 1;
			gbc_btn_tecselect2.gridy = 8;
			panel_6.add(btn_tecselect2, gbc_btn_tecselect2);
			
			JButton btn_tecmodify = new JButton("修改");
		
			GridBagConstraints gbc_btn_tecmodify = new GridBagConstraints();
			gbc_btn_tecmodify.anchor = GridBagConstraints.NORTH;
			gbc_btn_tecmodify.insets = new Insets(0, 0, 5, 5);
			gbc_btn_tecmodify.gridx = 4;
			gbc_btn_tecmodify.gridy = 8;
			panel_6.add(btn_tecmodify, gbc_btn_tecmodify);
			
			JButton btn_tecshanchu = new JButton("删除");
			
			GridBagConstraints gbc_btn_tecshanchu = new GridBagConstraints();
			gbc_btn_tecshanchu.insets = new Insets(0, 0, 5, 5);
			gbc_btn_tecshanchu.anchor = GridBagConstraints.NORTH;
			gbc_btn_tecshanchu.gridwidth = 2;
			gbc_btn_tecshanchu.gridx = 5;
			gbc_btn_tecshanchu.gridy = 8;
			panel_6.add(btn_tecshanchu, gbc_btn_tecshanchu);
			
			JLabel label_1 = new JLabel("");
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 0);
			gbc_label_1.gridx = 7;
			gbc_label_1.gridy = 9;
			panel_6.add(label_1, gbc_label_1);
			
			final JLabel tecStatementLabel = new JLabel("");
			tecStatementLabel.setForeground(Color.CYAN);
			GridBagConstraints gbc_tecStatementLabel = new GridBagConstraints();
			gbc_tecStatementLabel.fill = GridBagConstraints.VERTICAL;
			gbc_tecStatementLabel.gridwidth = 2;
			gbc_tecStatementLabel.insets = new Insets(0, 0, 0, 5);
			gbc_tecStatementLabel.gridx = 3;
			gbc_tecStatementLabel.gridy = 11;
			panel_6.add(tecStatementLabel, gbc_tecStatementLabel);
			
			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("管理课程", null, panel_2, null);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0};
			gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			
			JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.LEFT);
			GridBagConstraints gbc_tabbedPane_4 = new GridBagConstraints();
			gbc_tabbedPane_4.fill = GridBagConstraints.BOTH;
			gbc_tabbedPane_4.gridx = 0;
			gbc_tabbedPane_4.gridy = 0;
			panel_2.add(tabbedPane_4, gbc_tabbedPane_4);
			
			JPanel panel_7 = new JPanel();
			tabbedPane_4.addTab("●查询课程信息", null, panel_7, null);
			panel_7.setLayout(null);
			
			JLabel lblNewLabel_31 = new JLabel("查询全部课程");
			lblNewLabel_31.setBounds(10, 10, 88, 15);
			panel_7.add(lblNewLabel_31);
			
			JButton btn_courseselect = new JButton("查询");
		
			btn_courseselect.setBounds(580, 6, 93, 23);
			panel_7.add(btn_courseselect);
			
			JScrollPane scrollPane_8 = new JScrollPane();
			scrollPane_8.setBounds(47, 52, 616, 479);
			panel_7.add(scrollPane_8);
			
			table_5 = new JTable();
			scrollPane_8.setViewportView(table_5);
			
			JPanel panel_8 = new JPanel();
			tabbedPane_4.addTab("●更新课程信息", null, panel_8, null);
			panel_8.setBorder(tBorder2);
			GridBagLayout gbl_panel_8 = new GridBagLayout();
			gbl_panel_8.columnWidths = new int[]{67, 20, 10, 55, 34, 100, 99, 9, 49, 41, 137, 0};
			gbl_panel_8.rowHeights = new int[]{35, 21, 34, 21, 35, 21, 21, 30, 181, 23, 0};
			gbl_panel_8.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_8.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			panel_8.setLayout(gbl_panel_8);
			
			final JLabel statementLable = new JLabel("");
			statementLable.setForeground(Color.GREEN);
			GridBagConstraints gbc_statementLable = new GridBagConstraints();
			gbc_statementLable.gridwidth = 2;
			gbc_statementLable.insets = new Insets(0, 0, 5, 5);
			gbc_statementLable.gridx = 5;
			gbc_statementLable.gridy = 0;
			panel_8.add(statementLable, gbc_statementLable);
			
			JLabel lblNewLabel_32 = new JLabel("选择查询方式：");
			GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
			gbc_lblNewLabel_32.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_32.gridwidth = 2;
			gbc_lblNewLabel_32.gridx = 0;
			gbc_lblNewLabel_32.gridy = 1;
			panel_8.add(lblNewLabel_32, gbc_lblNewLabel_32);
			
			final JComboBox cb_coustype = new JComboBox();
			cb_coustype.addItem("按课程号查询");
			cb_coustype.addItem("按课程名称查询");
			GridBagConstraints gbc_cb_coustype = new GridBagConstraints();
			gbc_cb_coustype.anchor = GridBagConstraints.NORTH;
			gbc_cb_coustype.fill = GridBagConstraints.HORIZONTAL;
			gbc_cb_coustype.insets = new Insets(0, 0, 5, 5);
			gbc_cb_coustype.gridwidth = 3;
			gbc_cb_coustype.gridx = 2;
			gbc_cb_coustype.gridy = 1;
			panel_8.add(cb_coustype, gbc_cb_coustype);
			
			JLabel lblNewLabel_33 = new JLabel("按课程号查询：");
			GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
			gbc_lblNewLabel_33.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_33.gridx = 5;
			gbc_lblNewLabel_33.gridy = 1;
			panel_8.add(lblNewLabel_33, gbc_lblNewLabel_33);
			
			tf_cousnum = new JTextField();
			GridBagConstraints gbc_tf_cousnum = new GridBagConstraints();
			gbc_tf_cousnum.anchor = GridBagConstraints.NORTH;
			gbc_tf_cousnum.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_cousnum.insets = new Insets(0, 0, 5, 5);
			gbc_tf_cousnum.gridx = 6;
			gbc_tf_cousnum.gridy = 1;
			panel_8.add(tf_cousnum, gbc_tf_cousnum);
			tf_cousnum.setColumns(10);
			
			JLabel lblNewLabel_34 = new JLabel("按课程名查询：");
			GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
			gbc_lblNewLabel_34.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_34.gridwidth = 3;
			gbc_lblNewLabel_34.gridx = 7;
			gbc_lblNewLabel_34.gridy = 1;
			panel_8.add(lblNewLabel_34, gbc_lblNewLabel_34);
			
			tf_cousname = new JTextField();
			GridBagConstraints gbc_tf_cousname = new GridBagConstraints();
			gbc_tf_cousname.anchor = GridBagConstraints.NORTH;
			gbc_tf_cousname.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_cousname.insets = new Insets(0, 0, 5, 0);
			gbc_tf_cousname.gridx = 10;
			gbc_tf_cousname.gridy = 1;
			panel_8.add(tf_cousname, gbc_tf_cousname);
			tf_cousname.setColumns(10);
			
			JLabel lblNewLabel_35 = new JLabel("课程名称：\r\n");
			GridBagConstraints gbc_lblNewLabel_35 = new GridBagConstraints();
			gbc_lblNewLabel_35.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel_35.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_35.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_35.gridx = 0;
			gbc_lblNewLabel_35.gridy = 2;
			panel_8.add(lblNewLabel_35, gbc_lblNewLabel_35);
			
			tf_cousname1 = new JTextField();
			GridBagConstraints gbc_tf_cousname1 = new GridBagConstraints();
			gbc_tf_cousname1.anchor = GridBagConstraints.SOUTH;
			gbc_tf_cousname1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_cousname1.insets = new Insets(0, 0, 5, 5);
			gbc_tf_cousname1.gridwidth = 4;
			gbc_tf_cousname1.gridx = 1;
			gbc_tf_cousname1.gridy = 2;
			panel_8.add(tf_cousname1, gbc_tf_cousname1);
			tf_cousname1.setColumns(10);
			
			JScrollPane scrollPane_7 = new JScrollPane();
			GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
			gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
			gbc_scrollPane_7.insets = new Insets(0, 0, 5, 0);
			gbc_scrollPane_7.gridheight = 7;
			gbc_scrollPane_7.gridwidth = 6;
			gbc_scrollPane_7.gridx = 5;
			gbc_scrollPane_7.gridy = 2;
			panel_8.add(scrollPane_7, gbc_scrollPane_7);
			
			table_4 = new JTable();
			
			scrollPane_7.setViewportView(table_4);
			
			JLabel lblNewLabel_36 = new JLabel("课程号：");
			GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
			gbc_lblNewLabel_36.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel_36.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_36.gridx = 0;
			gbc_lblNewLabel_36.gridy = 3;
			panel_8.add(lblNewLabel_36, gbc_lblNewLabel_36);
			
			tf_cousnum1 = new JTextField();
			GridBagConstraints gbc_tf_cousnum1 = new GridBagConstraints();
			gbc_tf_cousnum1.anchor = GridBagConstraints.NORTH;
			gbc_tf_cousnum1.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_cousnum1.insets = new Insets(0, 0, 5, 5);
			gbc_tf_cousnum1.gridwidth = 4;
			gbc_tf_cousnum1.gridx = 1;
			gbc_tf_cousnum1.gridy = 3;
			panel_8.add(tf_cousnum1, gbc_tf_cousnum1);
			tf_cousnum1.setColumns(10);
			
			JLabel label_2 = new JLabel("任课老师：");
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.anchor = GridBagConstraints.EAST;
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 0;
			gbc_label_2.gridy = 4;
			panel_8.add(label_2, gbc_label_2);
			
			cous_tec = new JTextField();
			GridBagConstraints gbc_cous_tec = new GridBagConstraints();
			gbc_cous_tec.gridwidth = 4;
			gbc_cous_tec.insets = new Insets(0, 0, 5, 5);
			gbc_cous_tec.fill = GridBagConstraints.HORIZONTAL;
			gbc_cous_tec.gridx = 1;
			gbc_cous_tec.gridy = 4;
			panel_8.add(cous_tec, gbc_cous_tec);
			cous_tec.setColumns(10);
			
			JLabel lblNewLabel_37 = new JLabel("所属学分：");
			GridBagConstraints gbc_lblNewLabel_37 = new GridBagConstraints();
			gbc_lblNewLabel_37.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel_37.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_37.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_37.gridx = 0;
			gbc_lblNewLabel_37.gridy = 5;
			panel_8.add(lblNewLabel_37, gbc_lblNewLabel_37);
			
			tf_couscredit = new JTextField();
			GridBagConstraints gbc_tf_couscredit = new GridBagConstraints();
			gbc_tf_couscredit.anchor = GridBagConstraints.NORTH;
			gbc_tf_couscredit.fill = GridBagConstraints.HORIZONTAL;
			gbc_tf_couscredit.insets = new Insets(0, 0, 5, 5);
			gbc_tf_couscredit.gridwidth = 4;
			gbc_tf_couscredit.gridx = 1;
			gbc_tf_couscredit.gridy = 5;
			panel_8.add(tf_couscredit, gbc_tf_couscredit);
			tf_couscredit.setColumns(10);
			
			JLabel lblNewLabel_38 = new JLabel("课程属性：");
			GridBagConstraints gbc_lblNewLabel_38 = new GridBagConstraints();
			gbc_lblNewLabel_38.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel_38.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_38.gridx = 0;
			gbc_lblNewLabel_38.gridy = 6;
			panel_8.add(lblNewLabel_38, gbc_lblNewLabel_38);
			
			final JComboBox cb_cousproperty = new JComboBox();
			cb_cousproperty.setModel(new DefaultComboBoxModel(new String[] {"选修", "必修"}));
			GridBagConstraints gbc_cb_cousproperty = new GridBagConstraints();
			gbc_cb_cousproperty.anchor = GridBagConstraints.NORTH;
			gbc_cb_cousproperty.fill = GridBagConstraints.HORIZONTAL;
			gbc_cb_cousproperty.insets = new Insets(0, 0, 5, 5);
			gbc_cb_cousproperty.gridwidth = 4;
			gbc_cb_cousproperty.gridx = 1;
			gbc_cb_cousproperty.gridy = 6;
			panel_8.add(cb_cousproperty, gbc_cb_cousproperty);
			
			JLabel lblNewLabel_39 = new JLabel("最大课容量：");
			GridBagConstraints gbc_lblNewLabel_39 = new GridBagConstraints();
			gbc_lblNewLabel_39.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblNewLabel_39.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_39.gridwidth = 2;
			gbc_lblNewLabel_39.gridx = 0;
			gbc_lblNewLabel_39.gridy = 8;
			panel_8.add(lblNewLabel_39, gbc_lblNewLabel_39);
			
			final JSpinner spinner_maxnum = new JSpinner();
			spinner_maxnum.setModel(new SpinnerNumberModel(50, 5, 120, 1));
			GridBagConstraints gbc_spinner_maxnum = new GridBagConstraints();
			gbc_spinner_maxnum.anchor = GridBagConstraints.NORTH;
			gbc_spinner_maxnum.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner_maxnum.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_maxnum.gridwidth = 3;
			gbc_spinner_maxnum.gridx = 2;
			gbc_spinner_maxnum.gridy = 8;
			panel_8.add(spinner_maxnum, gbc_spinner_maxnum);
			
			JButton btn_cousselect = new JButton("查询");
		
	
			GridBagConstraints gbc_btn_cousselect = new GridBagConstraints();
			gbc_btn_cousselect.anchor = GridBagConstraints.NORTH;
			gbc_btn_cousselect.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_cousselect.insets = new Insets(0, 0, 0, 5);
			gbc_btn_cousselect.gridwidth = 3;
			gbc_btn_cousselect.gridx = 0;
			gbc_btn_cousselect.gridy = 9;
			panel_8.add(btn_cousselect, gbc_btn_cousselect);
			
			 temp_cousNameLabel = new JLabel("");
			temp_cousNameLabel.setForeground(Color.WHITE);
			GridBagConstraints gbc_temp_cousNameLabel = new GridBagConstraints();
			gbc_temp_cousNameLabel.insets = new Insets(0, 0, 0, 5);
			gbc_temp_cousNameLabel.gridx = 3;
			gbc_temp_cousNameLabel.gridy = 9;
			panel_8.add(temp_cousNameLabel, gbc_temp_cousNameLabel);
			
			JButton btn_cousmodify = new JButton("修改");
			
			GridBagConstraints gbc_btn_cousmodify = new GridBagConstraints();
			gbc_btn_cousmodify.anchor = GridBagConstraints.NORTHWEST;
			gbc_btn_cousmodify.insets = new Insets(0, 0, 0, 5);
			gbc_btn_cousmodify.gridwidth = 2;
			gbc_btn_cousmodify.gridx = 4;
			gbc_btn_cousmodify.gridy = 9;
			panel_8.add(btn_cousmodify, gbc_btn_cousmodify);
			
			JButton btn_cousshanchu = new JButton("删除");
			
			GridBagConstraints gbc_btn_cousshanchu = new GridBagConstraints();
			gbc_btn_cousshanchu.anchor = GridBagConstraints.NORTH;
			gbc_btn_cousshanchu.fill = GridBagConstraints.HORIZONTAL;
			gbc_btn_cousshanchu.insets = new Insets(0, 0, 0, 5);
			gbc_btn_cousshanchu.gridwidth = 2;
			gbc_btn_cousshanchu.gridx = 6;
			gbc_btn_cousshanchu.gridy = 9;
			panel_8.add(btn_cousshanchu, gbc_btn_cousshanchu);
			
			final JButton btn_cousAdd = new JButton("增加");
		
			GridBagConstraints gbc_btn_cousAdd = new GridBagConstraints();
			gbc_btn_cousAdd.anchor = GridBagConstraints.NORTHWEST;
			gbc_btn_cousAdd.gridwidth = 2;
			gbc_btn_cousAdd.gridx = 9;
			gbc_btn_cousAdd.gridy = 9;
			panel_8.add(btn_cousAdd, gbc_btn_cousAdd);
			// 管理员查询 学生xinxi 
			btn_stuselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				 if (cb_stutype.getSelectedItem().equals("按学号查询")&&(!tf_stunum.getText().equals(""))) {
					Long stunumLong=Long.parseLong(tf_stunum.getText());
					table.removeAll();
					StuInformation information=new  StuInformation();
					ArrayList<stuTable> arrayList=information.SimplestuInfolist(stunumLong);
					model=new  TableModel(arrayList, 5);
					table.setModel(model);
					table.revalidate();
				}
				 if (cb_stutype.getSelectedItem().equals("按姓名查询")&&(!tf_stuname.getText().equals(""))) {
						String stunameString=tf_stuname.getText();
						table.removeAll();
						StuInformation information=new  StuInformation();
						ArrayList<stuTable> arrayList1=information.SimplestuInfolist(stunameString);
						model=new  TableModel(arrayList1, 5);
						table.setModel(model);
						table.revalidate();
					}
				}
			});
			// 查询全部学生 
			btn_stuallselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					table.removeAll();
					StuInformation information=new  StuInformation();
					ArrayList<stuTable> arrayList1=information.allstuInfolist();
					model=new  TableModel(arrayList1, 5);
					table.setModel(model);
					table.revalidate();
				}
			});
			//			学生信息更改 查询  
							btn_stuselect2.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									 if (cb_stuselecttype.getSelectedItem().equals("按学号查询")&&(!tf_stunum1.getText().equals("")))
									 {
										 Long stunumLong=Long.parseLong(tf_stunum1.getText());
										 table_1.removeAll();
											StuInformation information=new  StuInformation();
											ArrayList<stuTable> arrayList=information.SimplestuInfolist(stunumLong);
											model=new  TableModel(arrayList, 5);
											table_1.setModel(model);
											table_1.revalidate();
									 }
									 if (cb_stuselecttype.getSelectedItem().equals("按姓名查询")&&(!tf_stuname1.getText().equals(""))) {
											String stunameString=tf_stuname1.getText();
											table_1.removeAll();
											StuInformation information=new  StuInformation();
											ArrayList<stuTable> arrayList1=information.SimplestuInfolist(stunameString);
											model=new  TableModel(arrayList1, 5);
											table_1.setModel(model);
											table_1.revalidate();
										}
								}
							});
							//为 属性框 赋值
							table_1.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
//							
									if (e.getSource()==table_1) {
										int CurrselectRow=table_1.getSelectedRow();
										String string1 []=new String[8];
											for (int i=0;i<8;i++) {
												string1[i]=table_1.getValueAt(CurrselectRow, i).toString();
											}
											tf_stuname2.setText(string1[0]);
											tf_stunum2.setText(string1[1]);
											if (string1[2].equals("男")) {
												rdb_sex_m.setSelected(true);
											}
											if (string1[2].equals("女")) {
												rdb_sex_f.setSelected(true);
											}
											tf_stubirth.setText(string1[3]);
											tf_stutel.setText(string1[4]);
											tf_stuemail.setText(string1[5]);
										ta_studetail.setText(string1[6]);
										textArea.setText(string1[7]);
										//tf_stuname2.setText(table_1.getValueAt(cu, column));
										
									}
								}
							});
							//学生信息 更改
							btn_stumodify.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								
								stuTable stuTable=new  stuTable();
								stuTable.setStu_name(tf_stuname2.getText());
								stuTable.setStu_num(Long.parseLong(tf_stunum2.getText()));
								if (rdb_sex_m.isSelected()) {
									stuTable.setStu_sex("男");
								}
								if (rdb_sex_f.isSelected()) {
									stuTable.setStu_sex("女");
								}
								stuTable.setStu_birth(tf_stubirth.getText());
								stuTable.setStu_tel(Long.parseLong(tf_stutel.getText()));
								stuTable.setStu_email(tf_stuemail.getText());
								stuTable.setStu_info(ta_studetail.getText());
								stuTable.setStu_addr(textArea.getText());
								if (StuInfoModify.InfoModifyMore(stuTable)) {
									stuStatementLabel.setText("修改成功！");
								}
								else {
									stuStatementLabel.setText("修改失败");
								}
									
								}
							});
							//管理员删除学生 
							btn_stushanchu.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
								 stuTable stuTable=new  stuTable();
								 stuTable.setStu_name(tf_stuname2.getText());
								 if (StuInfoModify.InfoDel(stuTable)) {
										stuStatementLabel.setText("删除成功！");
									}
									else {
										stuStatementLabel.setText("删除失败");
									}
								 
								}
							});
					
			// 教师 查询
			btn_tecselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if (cb_tectype.getSelectedItem().equals("按教工号查询")&&(!tf_tecnum.getText().equals("")))
					 {
						 Long tecnumLong=Long.parseLong(tf_tecnum.getText());
						 table_2.removeAll();
							TecInformation information=new  TecInformation();
							ArrayList<tecTable> arrayList=information.tecInfo(tecnumLong);
							model=new  TableModel(arrayList, 4);
							table_2.setModel(model);
							table_2.revalidate();
					 }
					 if (cb_tectype.getSelectedItem().equals("按姓名查询")&&(!tf_tecname.getText().equals(""))) {
							String tecnameString=tf_tecname.getText();
							table_2.removeAll();
							TecInformation information=new  TecInformation();
							ArrayList<tecTable> arrayList1=information.tecInfo(tecnameString);
							model=new  TableModel(arrayList1, 4);
							table_2.setModel(model);
							table_2.revalidate();
						}	
				}
			});
			// 全部查询
			btn_tecallselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					table_2.removeAll();
					TecInformation information=new  TecInformation();
					ArrayList<tecTable> arrayList1=information.alltecinfoList();
					model=new  TableModel(arrayList1, 4);
					table_2.setModel(model);
					table_2.revalidate();
				
				}
			});
			//教师查询jia 操作 
			btn_tecselect2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if (cb_tectype1.getSelectedItem().equals("按教工号查询")&&(!tf_tecnum1.getText().equals("")))
					 {
						 Long tecnumLong=Long.parseLong(tf_tecnum1.getText());
						 table_3.removeAll();
							TecInformation information=new  TecInformation();
							ArrayList<tecTable> arrayList=information.tecInfo(tecnumLong);
							model=new  TableModel(arrayList, 4);
							table_3.setModel(model);
							table_3.revalidate();
					 }
					 if (cb_tectype1.getSelectedItem().equals("按教师姓名查询")&&(!tf_tecname1.getText().equals(""))) {
							String tecnameString=tf_tecname1.getText();
							table_3.removeAll();
							TecInformation information=new  TecInformation();
							ArrayList<tecTable> arrayList1=information.tecInfo(tecnameString);
							model=new  TableModel(arrayList1, 4);
							table_3.setModel(model);
							table_3.revalidate();
						}	
				}
			});
			// 为教师 属性框赋值 
			table_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
							if (e.getSource()==table_3) {
								int CurrentSelectRows=table_3.getSelectedRow();
								String[] string2=new String[7];
								for(int i=0;i<7;i++)
									string2[i]=table_3.getValueAt(CurrentSelectRows, i).toString();
								tf_tecname2.setText(string2[1]);
								tf_tecnum2.setText(string2[0]);
								if (string2[2].equals("男")) {
									rdb_tecsex_m.setSelected(true);
								}
								if (string2[2].equals("女")) {
									rdb_tecsex_f.setSelected(true);
								}
								tf_tecbirth.setText(string2[3]);
								tf_tectel.setText(string2[4]);
								tf_tecemail.setText(string2[5]);
								ta_tecdetail.setText(string2[6]);
								
								
							}
				}
			});
			//教师 修改  
			btn_tecmodify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						tecTable tecTable=new  tecTable();
						tecTable.setTec_name(tf_tecname2.getText());
						tecTable.setTec_num(Long.parseLong(tf_tecnum2.getText()));
						if (rdb_tecsex_m.isSelected()) {
							tecTable.setTec_sex("男");
						}
						if (rdb_tecsex_f.isSelected()) {
							tecTable.setTec_sex("女");
						}
						tecTable.setTec_birth(tf_tecbirth.getText());
						tecTable.setTec_tel(Long.parseLong(tf_tectel.getText()));
						tecTable.setTec_email(tf_tecemail.getText());
						tecTable.setTec_info(ta_tecdetail.getText());
						if (TecInfoModify.InfoModify(tecTable)) {
							tecStatementLabel.setText("信息更新成功");
						}
						else {
							tecStatementLabel.setText("信息更新失败");
						}
				
				}
			});
			//教师删除 
			btn_tecshanchu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					tecTable tecTable=new  tecTable();
					tecTable.setTec_name(tf_tecname1.getText());
					if (TecInfoModify.InfoDel(tecTable)) {
						tecStatementLabel.setText("删除成功！");
					}
					else {
						tecStatementLabel.setText("删除失败！");
					}
				}
			});
			// 课程  操作
			btn_cousselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					table_4.removeAll();
					CousInformation information=new  CousInformation();
					if (cb_coustype.getSelectedItem().equals("按课程号查询")&&(!tf_cousnum.getText().equals("")))
					{		int cousnum=Integer.parseInt(tf_cousnum.getText());
						ArrayList<cousTable> arrayList=information.OrderBynumCousInfo(cousnum);
						model=new  TableModel(arrayList, 1);
						table_4.setModel(model);
						table_4.revalidate();
					}
					if (cb_coustype.getSelectedItem().equals("按课程名称查询")&&(!tf_cousname.getText().equals(""))) {
						String cousnameString=tf_cousname.getText();
						ArrayList<cousTable> arrayList=information.OrderBynumCousInfo(cousnameString);
						model=new  TableModel(arrayList, 1);
						table_4.setModel(model);
						table_4.revalidate();
					}
				}
			});
			btn_courseselect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					table_5.removeAll();
					CousInformation information=new  CousInformation();
					ArrayList<cousTable> arrayList=information.AllCousInfo();
					model=new  TableModel(arrayList, 1);
					table_5.setModel(model);
					table_5.revalidate();
				}
			});
			// 课程属性框显示 
			table_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
						if (e.getSource()==table_4) {
							int CurrentSelectRows =table_4.getSelectedRow();
							String []string3=new String[6];
							for(int i=0;i<6;i++)
								string3[i]=table_4.getValueAt(CurrentSelectRows, i).toString();
							tf_cousnum1.setText(string3[0]);
							tf_cousname1.setText(string3[1]);
							tf_couscredit.setText(string3[2]);
							cb_cousproperty.setSelectedItem(string3[3]);
							spinner_maxnum.setValue(Integer.parseInt(string3[4]));
							cous_tec.setText(string3[5]);
							temp_cousNameLabel.setText(string3[1]);
						}
				}
			});
			//课程修改 
			btn_cousmodify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						cousTable cousTable=new cousTable();
					cousTable.setCous_num(Integer.parseInt(tf_cousnum1.getText()));
					cousTable.setCous_name(temp_cousNameLabel.getText());
					cousTable.setCous_credit(Float.parseFloat(tf_couscredit.getText()));
					cousTable.setCous_property(cb_cousproperty.getSelectedItem().toString());
					cousTable.setCous_maxnum(Integer.parseInt(spinner_maxnum.getValue().toString()));
					cousTable.setCous_tec(cous_tec.getText());
					if (CousInfoModify.InfoModify(cousTable,tf_cousname1)) {
						statementLable.setText(" 修改信息成功！");
					}
					else statementLable.setText(" 修改信息失败！");
					{
						table_5.removeAll();
						CousInformation information=new  CousInformation();
						ArrayList<cousTable> arrayList=information.AllCousInfo(); //刷新  
						model=new  TableModel(arrayList, 1);
						table_5.setModel(model);
						table_5.revalidate();
					}
				}
			});
			//kecheng课程 删除 
			btn_cousshanchu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				if (CousInfoModify.DelCous(tf_cousname1))
				{
					statementLable.setText(" 删除信息成功！");
				}
				else {
					statementLable.setText(" 删除信息失败！！");
				}
				}
			});
			
			//课程增加
			btn_cousAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(btn_cousAdd.getText().equals("增加"))
					{	tf_cousnum1.setText(null);
					tf_cousname1.setText(null);
					tf_couscredit.setText(null);
					cous_tec.setText(null);
					btn_cousAdd.setText("开始增加");
					}
					if (btn_cousAdd.getText().equals("开始增加")) {
						
//						tf_cousnum1.setText(string3[0]);
//						tf_cousname1.setText(string3[1]);
//						tf_couscredit.setText(string3[2]);
//						cb_cousproperty.setSelectedItem(string3[3]);
//						spinner_maxnum.setValue(Integer.parseInt(string3[4]));
					int cousnum;
					try {
						cousnum = Integer.parseInt(tf_cousnum1.getText());
						cousTable cousTable =new  cousTable(cousnum, tf_cousname1.getText(),Float.parseFloat(tf_couscredit.getText()), cb_cousproperty.getSelectedItem().toString(), Integer.parseInt(spinner_maxnum.getValue().toString()),cous_tec.getText());

						if (CousInfoModify.AddCous(cousTable)) {
							statementLable.setText("增加成功！");
						}
						else {
							statementLable.setText("失败，请检查 课程号或课程名是否已经存在！");
						}
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						statementLable.setText("失败，请检查 课程号或课程名！");
					}
						
						
					}
					
					
					
				
				}
			});
		
	}
}
