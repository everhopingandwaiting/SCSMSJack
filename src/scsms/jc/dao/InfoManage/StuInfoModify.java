package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scsms.jc.entity.stuTable;
import scsms.jc.entity.tecTable;
import scsms.jc.util.DBcon;

public class StuInfoModify {

	public StuInfoModify() {
		// TODO Auto-generated constructor stub
	}
	 public static boolean InfoModify(stuTable stuTable) {
		   Connection connection=DBcon.getCon();
		   boolean flag=false;
		     String sql_update="update stutable set  stu_tel=?,stu_addr=?,stu_email=?,stu_info=? where stu_name=?";
		   
		     PreparedStatement preparedStatement=null;
		     
		      try {
				preparedStatement=connection.prepareStatement(sql_update);
				  preparedStatement.setLong(1,stuTable.getStu_tel());
				  preparedStatement.setString(2, stuTable.getStu_addr().toString());
				  
				  preparedStatement.setString(3,stuTable.getStu_email().toString());
				  preparedStatement.setString(4, stuTable.getStu_info().toString());
				  preparedStatement.setString(5, stuTable.getStu_name().toString());
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
	 public static boolean InfoModifyMore(stuTable stuTable) {
		   Connection connection=DBcon.getCon();
		   boolean flag=false;
		     String sql_update="update stutable set  stu_tel=?,stu_addr=?,stu_email=?,stu_info=?,stu_num=?,stu_sex=? ,stu_addr=? where stu_name=?";
		   
		     PreparedStatement preparedStatement=null;
		     
		      try {
				preparedStatement=connection.prepareStatement(sql_update);
				  preparedStatement.setLong(1,stuTable.getStu_tel());
				  preparedStatement.setString(2, stuTable.getStu_addr().toString());
				  
				  preparedStatement.setString(3,stuTable.getStu_email().toString());
				  preparedStatement.setString(4, stuTable.getStu_info().toString());
				  preparedStatement.setLong(5, stuTable.getStu_num());
				  preparedStatement.setString(6, stuTable.getStu_sex());
				  preparedStatement.setString(7, stuTable.getStu_addr());
				  preparedStatement.setString(8, stuTable.getStu_name().toString());
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
	 public static boolean InfoDel(stuTable stuTable) {
		Connection connection=DBcon.getCon();
		boolean flag=false;
		String delsString="delete from stutable where stu_name=?";
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(delsString);
			preparedStatement.setString(1, stuTable.getStu_name());
			int count=preparedStatement.executeUpdate();
			if (count==1&&(selectedCousDel(stuTable)==1)) {
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			flag=false;
		}
		finally{DBcon.CloseCon(connection, preparedStatement);
		}
		return flag;
		
	}
	 // 同步删除  选课信息 
	 public static int selectedCousDel(stuTable stuTable) {
			Connection connection=DBcon.getCon();
			int count=0;
			String delsString="delete from sctable where stu_name=?";
			PreparedStatement preparedStatement=null;
			
			try {
				preparedStatement=connection.prepareStatement(delsString);
				preparedStatement.setString(1, stuTable.getStu_name());
			 count=preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				
			}
			finally{DBcon.CloseCon(connection, preparedStatement);
			}
			return count;
			
		}
}
