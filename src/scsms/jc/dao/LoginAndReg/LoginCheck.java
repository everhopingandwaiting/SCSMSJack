package scsms.jc.dao.LoginAndReg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import scsms.jc.entity.usersTable;
import scsms.jc.util.DBcon;

public class LoginCheck {
	
    public static boolean check(usersTable users) {
    	boolean flag=false;
		 Connection connection=DBcon.getCon();
		 String sql="select * from userstable where position=? and users_name=? and users_passwd=?";
		 PreparedStatement preparedStatement=null;
		 
		 ResultSet resultSet=null;
		 
		  try {
			preparedStatement=connection.prepareStatement(sql);
			  preparedStatement.setString(1, users.getPosition());
			  preparedStatement.setString(2, users.getUsers_name());
			  preparedStatement.setString(3, users.getUsers_passwd());
			  
			  resultSet=preparedStatement.executeQuery();
			    if (resultSet.next()) {
					flag=true;
				}
			    else{ flag=false;}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    finally{
		    	DBcon.CloseCon(connection, preparedStatement, resultSet);
		    }
	
    	return flag;
	}
}
