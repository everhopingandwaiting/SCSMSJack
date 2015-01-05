package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextField;

import scsms.jc.entity.cousTable;
import scsms.jc.entity.tecTable;
import scsms.jc.util.DBcon;

public class CousInfoModify {

	public CousInfoModify() {
		// TODO Auto-generated constructor stub
	}
	public static boolean ModiftscGrade(Float float1,String string2,String string3,String string4) {
		Connection connection=DBcon.getCon();
		PreparedStatement preparedStatement=null;
		boolean flag=false;
		
		String addString="update   sctable set grade=?  where stu_name=? and tec_name=? and cous_name=?";
		try {
			preparedStatement=connection.prepareStatement(addString);
			preparedStatement.setFloat(1,float1);
			preparedStatement.setString(2, string2);
			preparedStatement.setString(3,string3);
			preparedStatement.setString(4, string4);
			
		
		
			int count=preparedStatement.executeUpdate();
			if (count==1) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			flag=false;
		}
		finally{DBcon.CloseCon(connection, preparedStatement);}
		return flag;
	}
 	
	 public static boolean InfoModify(cousTable cousTable ,JTextField cousnametextField) {
		   Connection connection=DBcon.getCon();
		   boolean flag=false;
		     String sql_update="update coustable set  cous_num=?,cous_name=?,cous_credit=?,cous_property=? ,cous_maxnum=? where cous_name=?";
		   
		     PreparedStatement preparedStatement=null;
		     
		      try {
				preparedStatement=connection.prepareStatement(sql_update);
				  preparedStatement.setLong(1,cousTable.getCous_num());
				  preparedStatement.setString(2,cousnametextField.getText().toString());
				  
				  preparedStatement.setFloat(3,cousTable.getCous_credit());
				  preparedStatement.setString(4, cousTable.getCous_property().toString());
				  preparedStatement.setInt(5, cousTable.getCous_maxnum());
				  preparedStatement.setString(6, cousTable.getCous_name());
			int count=preparedStatement.executeUpdate();
				  if(count==1) flag= true;
				  else flag=false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();	
				flag= false;
			}
		      finally{
		    	   DBcon.CloseCon(connection, preparedStatement);
		      }
		    return flag;
	}
	 	public static boolean DelCous(JTextField textField) {
	 			Connection connection=DBcon.getCon();
	 			
	 			boolean flag=false;
	 			String delString="delete from coustable where cous_name=?";
	 			PreparedStatement preparedStatement=null;
	 			try {
					preparedStatement=connection.prepareStatement(delString);
					preparedStatement.setString(1, textField.getText());
					int count=preparedStatement.executeUpdate();
					if (count==1&&(selectededCousDel(textField)==1)) {
						flag=true;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag=false;
				}
	 			finally{DBcon.CloseCon(connection, preparedStatement);}
	 		
	 		return flag;
		}
	 	//同步删除 选课
	 	 public static int selectededCousDel(JTextField textField) {
	 		
	 		   Connection connection=DBcon.getCon();
	 		  int count=0;
	 		   String delsString="delete from sctable where cous_name=?";
	 		   PreparedStatement preparedStatement=null;
	 		   
	 		   try {
	 			preparedStatement=connection.prepareStatement(delsString);
	 			preparedStatement.setString(1, textField.getText());
	 		 count=preparedStatement.executeUpdate();
	 			
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			//e.printStackTrace();
	 		}
	 		   finally{DBcon.CloseCon(connection, preparedStatement);}
	 		   return count;
	 	}
	 	   	
	 	public static boolean AddCous(cousTable cousTable) {
			Connection connection=DBcon.getCon();
			PreparedStatement preparedStatement=null;
			boolean flag=false;
			
			String addString="insert into coustable values(?,?,?,?,?,?)";
			try {
				preparedStatement=connection.prepareStatement(addString);
				preparedStatement.setInt(1, cousTable.getCous_num());
				preparedStatement.setString(2, cousTable.getCous_name());
				preparedStatement.setFloat(3, cousTable.getCous_credit());
				preparedStatement.setString(4, cousTable.getCous_property());
				preparedStatement.setInt(5, cousTable.getCous_maxnum());
				preparedStatement.setString(6, cousTable.getCous_tec());
				int count=preparedStatement.executeUpdate();
				if (count==1) {
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag=false;
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return flag;
		}
	 	//add sctable
	 	public static boolean Addsc(String string,String string2,String string3) {
			Connection connection=DBcon.getCon();
			PreparedStatement preparedStatement=null;
			boolean flag=false;
			
			String addString="insert into sctable(stu_name,tec_name,cous_name) values(?,?,?)";
			try {
				preparedStatement=connection.prepareStatement(addString);
				preparedStatement.setString(1,string);
				preparedStatement.setString(2, string2);
				preparedStatement.setString(3,string3);
				
			
			
				int count=preparedStatement.executeUpdate();
				if (count==1&&(coussumReduce(addString, string2, string3)==1)) {
					flag=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				flag=false;
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return flag;
		}
	 	
	 	//
	 	//实现 客容量 同步 
	 	public static int coussumReduce(String string,String string2,String string3) {
			Connection connection=DBcon.getCon();
			PreparedStatement preparedStatement=null;
			int count=0;
			
			String addString="update set  coustable cous_maxsum-1  where stu_name=? and tec_name=? and cous_name=?";
			try {
				preparedStatement=connection.prepareStatement(addString);
				preparedStatement.setString(1,string);
				preparedStatement.setString(2, string2);
				preparedStatement.setString(3,string3);
				
			
			
				 count=preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return count;
		}
	 	//
	 	public static boolean Delsc(String string,String string2,String string3) {
			Connection connection=DBcon.getCon();
			PreparedStatement preparedStatement=null;
			boolean flag=false;
			
			String addString="delete from sctable where stu_name=? and tec_name=? and cous_name=?";
			try {
				preparedStatement=connection.prepareStatement(addString);
				preparedStatement.setString(1,string);
				preparedStatement.setString(2, string2);
				preparedStatement.setString(3,string3);
				
			
			
				int count=preparedStatement.executeUpdate();
				if (count==1&&(coussumDecre(addString, string2, string3)==1)) {
					flag=true;
				}
				else {
					flag=false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag=false;
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return flag;
		}
	 //  课程同步 增加
	 	public static int coussumDecre(String string,String string2,String string3) {
			Connection connection=DBcon.getCon();
			PreparedStatement preparedStatement=null;
			int count=0;
			
			String addString="update set  coustable cous_maxsum+1  where stu_name=? and tec_name=? and cous_name=?";
			try {
				preparedStatement=connection.prepareStatement(addString);
				preparedStatement.setString(1,string);
				preparedStatement.setString(2, string2);
				preparedStatement.setString(3,string3);
				
			
			
				 count=preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return count;
		}
//	 	public static boolean StuSelectCous(cousTable cousTable) {
//			Connection connection=DBcon.getCon();
//			PreparedStatement preparedStatement=null;
//			boolean flag=false;
//			
//			String addString="insert into sctable values(?,?,?,?)";
//			try {
//				preparedStatement=connection.prepareStatement(addString);
//				preparedStatement.setInt(1, cousTable.getCous_num());
//				preparedStatement.setString(2, cousTable.getCous_name());
//				preparedStatement.setFloat(3, cousTable.getCous_credit());
//				preparedStatement.setString(4, cousTable.getCous_property());
//			
//				int count=preparedStatement.executeUpdate();
//				if (count==1) {
//					flag=true;
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				//e.printStackTrace();
//				flag=false;
//			}
//			finally{DBcon.CloseCon(connection, preparedStatement);}
//			return flag;
//		}
}
