package scsms.jc.util;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import scsms.jc.entity.SCTable;
import scsms.jc.entity.countOfValueAtQues;
import scsms.jc.entity.cousTable;
import scsms.jc.entity.stuTable;
import scsms.jc.entity.tecTable;

public class TableModel  extends AbstractTableModel implements TableCellRenderer,ActionListener, TableCellEditor{

	 /**
	 * 
	 */
//	
//								_oo0oo_
//								088888880
//								88" . "88
//								(| -_- |)
//								 0\ = /0
//							  ___/'---'\___
//						    .' \\\\|     |// '.
//							/ \\\\|||  :  |||// \\
//							/_ ||||| -:- |||||- \\
//						  |   | \\\\\\  -  /// |   |
//						   | \_|  ''\---/''  |_/ |
//						  	\  .-\__  '-'  __/-.  /
//					      _	__'. .'  /--.--\  '. .'___
//						."" '<  '.___\_<|>_/___.' >'  "".
//						| | : '-  \'.;'\ _ /';.'/ - ' : | |
//						\  \ '_.   \_ __\ /__ _/   .-' /  /
//						====='-.____'.___ \_____/___.-'____.-'=====
//						'=---='
//
//
//						^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//								佛祖保佑    iii    永不死机
//	
//	
	
	private static final long serialVersionUID = 1L;
	private Object [][] dataObjects;
	 private String [] titleStrings;

	 @SuppressWarnings("unchecked")
	public TableModel(ArrayList<?> arrayList,int m) {
		// TODO Auto-generated constructor stub
		 if (m==1) {
			ArrayList<cousTable> cousTableslList =(ArrayList<cousTable>)  arrayList;
			 int length=cousTableslList.size();
			  dataObjects=new  Object[length][6];
			   titleStrings=new  String[]{"课程号","课程名","学分","课程属性","课程容量" ,"任课老师"};
			    for(int i=0;i<length;i++)
			    {
			    	dataObjects[i][0]=cousTableslList.get(i).getCous_num();
			    	dataObjects[i][1]=cousTableslList.get(i).getCous_name();
			    	dataObjects[i][2]=cousTableslList.get(i).getCous_credit();
			    	dataObjects[i][3]=cousTableslList.get(i).getCous_property();
			    	dataObjects[i][4]=cousTableslList.get(i).getCous_maxnum();
			    	dataObjects[i][5]=cousTableslList.get(i).getCous_tec();
			    }
		}
		 
		 if (m==2) {
//			stu_name,,tec_name  cous_name
			 ArrayList<SCTable> sctablesliList=(ArrayList<SCTable>) arrayList;
			 int length=sctablesliList.size();
			  dataObjects=new  Object[length][3];
			  titleStrings=new  String[]{"学生名","老师名","课程名" };
			    for(int i=0;i<length;i++)
			    {
			    	dataObjects[i][0]=sctablesliList.get(i).getStu_name();
			    	dataObjects[i][1]=sctablesliList.get(i).getTec_name();
			    	dataObjects[i][2]=sctablesliList.get(i).getCous_name();
			    }
			  
			    
		}
		
//		  stu_name,grade,cous_name  成绩 
		  if (m==3) {
			ArrayList<SCTable> sctableGradeList=(ArrayList<SCTable>) arrayList;
			int length=sctableGradeList.size();
			dataObjects=new Object[length][3];
			titleStrings=new String[]{"学生名","成绩","课程名"};
			 for(int index=0;index<length;index++)
			 {
				 	dataObjects[index][0]=sctableGradeList.get(index).getStu_name();
			    	dataObjects[index][1]=sctableGradeList.get(index).getGrade();
			    	dataObjects[index][2]=sctableGradeList.get(index).getCous_name();
			 }
		}
		  if (m==4) {
			ArrayList<tecTable> tecTables=(ArrayList<tecTable>) arrayList;
			int length=tecTables.size();
			dataObjects=new Object[length][7];
			titleStrings=new String[]{"教师号","教师名","性别","出生日期","联系电话","邮箱","简介"};
			for(int index=0;index<length;index++)
			{
				 dataObjects[index][0]=tecTables.get(index).getTec_num();
				 dataObjects[index][1]=tecTables.get(index).getTec_name();
				 dataObjects[index][2]=tecTables.get(index).getTec_sex();
				 dataObjects[index][3]=tecTables.get(index).getTec_birth();
				 dataObjects[index][4]=tecTables.get(index).getTec_tel();
				 dataObjects[index][5]=tecTables.get(index).getTec_email();
				 dataObjects[index][6]=tecTables.get(index).getTec_info();
				 
			}
		}
		  if (m==5) {
				ArrayList<stuTable> tecTables=(ArrayList<stuTable>) arrayList;
				int length=tecTables.size();
				dataObjects=new Object[length][8];
				titleStrings=new String[]{"学生名","学生号","性别","出生日期","联系电话","邮箱","简介","地址"};
				for(int index=0;index<length;index++)
				{
					 dataObjects[index][0]=tecTables.get(index).getStu_name();
					 dataObjects[index][1]=tecTables.get(index).getStu_num();
					 dataObjects[index][2]=tecTables.get(index).getStu_sex();
					 dataObjects[index][3]=tecTables.get(index).getStu_birth();
					 dataObjects[index][4]=tecTables.get(index).getStu_tel();
					 dataObjects[index][5]=tecTables.get(index).getStu_email();
					 dataObjects[index][6]=tecTables.get(index).getStu_info();
					 dataObjects[index][7]=tecTables.get(index).getStu_addr();
					 
				}
			}
		  if (m==6) {
//				stu_name,,tec_name  cous_name
				 ArrayList<SCTable> sctablesliList=(ArrayList<SCTable>) arrayList;
				
						  
				 int length=sctablesliList.size();
				  dataObjects=new  Object[length][4];
				  titleStrings=new  String[]{"学生名","老师名","成绩","课程名" };
				    for(int i=0;i<length;i++)
				    {
				    	dataObjects[i][0]=sctablesliList.get(i).getStu_name();
				    	dataObjects[i][1]=sctablesliList.get(i).getTec_name();
				    	dataObjects[i][2]=sctablesliList.get(i).getGrade();
				    	dataObjects[i][3]=sctablesliList.get(i).getCous_name();
				    	//dataObjects[i][4]=new JButton("确定");
				    }
				  
				    
			}
		  if (m==7) {
			ArrayList<countOfValueAtQues> atQues=(ArrayList<countOfValueAtQues>) arrayList;
			int length=atQues.size();
			dataObjects=new Object[length][3];
			titleStrings=new String[]{"问题描述","结果","计数"};
			for(int index=0;index<length;index++)
			{
				 dataObjects[index][0]=atQues.get(index).getQuestionLabel();
				 dataObjects[index][1]=atQues.get(index).getResult();
				 dataObjects[index][2]=atQues.get(index).getCount();
				 
				 
			}
		}
		  
	}


	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataObjects.length;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return dataObjects[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return dataObjects[rowIndex][columnIndex];
	}

	public String [] getTitleStrings() {
		return titleStrings;
	}

	public void setTitleStrings(String [] titleStrings) {
		this.titleStrings = titleStrings;
	}
	public String getColumnName(int column)
	{
		return titleStrings[column];
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		if(column==2)
		
			return true;
		else	return false;
	}


	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean stopCellEditing() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void cancelCellEditing() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removeCellEditorListener(CellEditorListener l) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean isCellEditable(EventObject anEvent) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
//@Override
//public int getRowCount() {
//	// TODO Auto-generated method stub
//	return data.length;
//}
//
//@Override
//public int getColumnCount() {
//	// TODO Auto-generated method stub
//	return data[0].length;
//}
//
//@Override
//public Object getValueAt(int rowIndex, int columnIndex) {
//	// TODO Auto-generated method stub
//	return data[rowIndex][columnIndex];
//}
//
//@Override
//public String getColumnName(int column) {
//	// TODO Auto-generated method stub
//	//		return super.getColumnName(column);
//	return title[column];
//}
 		