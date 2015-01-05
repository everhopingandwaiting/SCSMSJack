package scsms.jc.dao.LoginAndReg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scsms.jc.entity.stuTable;
import scsms.jc.entity.usersTable;
import scsms.jc.util.DBcon;
  
//private String stu_name;
//private int stu_num;
// private String stu_sex;
// private String stu_birth;
// private int  stu_tel;
// private String stu_email;
// private String stu_info;
// private String stu_addr;
public class StuRegister {
	private  int count;
	  public  int stuRegister(stuTable stu) {
		  Connection connection=DBcon.getCon();
		  String sql="insert into stutable values(?,?,?,?,?,?,?,?)";
		  count=0;
		  PreparedStatement preparedStatement=null;
		   try {
			
			    preparedStatement=connection.prepareStatement(sql);
			    
			    preparedStatement.setString(1, stu.getStu_name());
			    preparedStatement.setLong(2, stu.getStu_num());
			    preparedStatement.setString(3, stu.getStu_sex());
			    preparedStatement.setString(4, stu.getStu_birth());
			    preparedStatement.setLong(5, stu.getStu_tel());
			    preparedStatement.setString(6, stu.getStu_email());
			    preparedStatement.setString(7, stu.getStu_info());
			    preparedStatement.setString(8, stu.getStu_addr());
			    
			    count=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		  finally{
			  DBcon.CloseCon(connection, preparedStatement);
		  }
		  
		    return count;
		   
		
	}
	   public int uStuReg(usersTable uTable) {
		   
		    Connection connection=DBcon.getCon();
		    String sqlString="insert into userstable(position,users_name,users_passwd) values(?,?,?)";
		    count=0;
		    PreparedStatement preparedStatement=null;
		    
		      try {
				preparedStatement=connection.prepareStatement(sqlString);
				  
				  preparedStatement.setString(1, uTable.getPosition());
				  preparedStatement.setString(2, uTable.getUsers_name());
				  preparedStatement.setString(3, uTable.getUsers_passwd());
				  count=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		      finally{
		    	  DBcon.CloseCon(connection, preparedStatement);
		      }
		    
		   return count;
	}
	   

}
