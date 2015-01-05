package scsms.jc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBcon {
    public static Connection getCon() {
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://127.0.0.1:3306/scsms?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String passwd="root";
		 Connection connection= null;
		try {
			
			  Class.forName(driver);
			   connection=DriverManager.getConnection(url,user,passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		  finally{
			   
			   
		  }
		  return connection;
		  
		 
		 
	}
     public static void CloseCon(Connection connection,PreparedStatement preparedStatement) {
		   try {
			if(preparedStatement!=null)
				   preparedStatement.close();
			   if(connection!=null)
				   connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     public static void  CloseCon(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
		   try {
			if(resultSet!=null)
				   {
				resultSet.close();
				   }
			
			   if (preparedStatement!=null) {
				preparedStatement.close();
			}
			   if (connection!=null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
