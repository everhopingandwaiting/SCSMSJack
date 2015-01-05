package scsms.jc.dao.LoginAndReg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scsms.jc.entity.tecTable;
import scsms.jc.entity.usersTable;
import scsms.jc.util.ConvertStrToDate;
import scsms.jc.util.DBcon;

//private int tec_num;
//private String tec_name;
//private String tec_sex;
//private String tec_birth;
//private  int tec_tel;
//private String tec_email;
//private String tec_info;

public class TecRegister {
     private  int count;
     public  int  tecRegister(tecTable table,usersTable usersTable) {
	     Connection connection=DBcon.getCon();
	      String sqlString="insert into tectable values(?,?,?,?,?,?,?)";
	      PreparedStatement preparedStatement=null;
	      count=0;
	      try {
			preparedStatement=connection.prepareStatement(sqlString);
			  
			  preparedStatement.setLong(1, table.getTec_num());
			  preparedStatement.setString(2, table.getTec_name());
			  preparedStatement.setString(3, table.getTec_sex().toString());
			//  preparedStatement.setString(4, table.getTec_birth()); java.sql.Date.valueOf(dateStr)
			  try {
				preparedStatement.setDate(4, java.sql.Date.valueOf(table.getTec_birth().toString()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("cuo");
			}
			  preparedStatement.setLong(5, table.getTec_tel());
			  preparedStatement.setString(6, table.getTec_email());
			  preparedStatement.setString(7, table.getTec_info());
			  count=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 finally{
    		 DBcon.CloseCon(connection, preparedStatement);
    	 }
	      uTecReg(usersTable);
    	 return count;
	}
     public void uTecReg(usersTable uTable) {
		// count=0;
		 Connection connection=DBcon.getCon();
		 String sqString="insert into userstable(position,users_passwd,users_name) values(?,?,?)";
		 
		  PreparedStatement preparedStatement=null;
		      try {
				preparedStatement=connection.prepareStatement(sqString);
				   preparedStatement.setString(1, uTable.getPosition().toString());
				 //  preparedStatement.setInt(2, uTable.getUsers_id());
				   preparedStatement.setString(2, uTable.getUsers_passwd());
				   preparedStatement.setString(3, uTable.getUsers_name());
				   count=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      finally{
		    	  DBcon.CloseCon(connection, preparedStatement);
		      }
		// return count;
    	 
	}
     
}
