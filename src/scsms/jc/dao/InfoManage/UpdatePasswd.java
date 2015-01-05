package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPasswordField;

import scsms.jc.util.DBcon;

public class UpdatePasswd {

	public UpdatePasswd() {
		// TODO Auto-generated constructor stub
	}

	 @SuppressWarnings("deprecation")
	public static boolean  updatePasswd(String name,JPasswordField  jField,JPasswordField jField2,JPasswordField jField3,final JLabel jLabel) {
		  
		  boolean flag=false;
		  if (jField.getText().toString().equals(jField2.getText().toString())) {
			  jLabel.setText("与原密码相同，不提供更改！！");
			  return false;}
		  if (!jField2.getText().toString().equals(jField3.getText().toString())) {
			   jLabel.setText("两次密码输入不一致！！");
			   return false;
			 
		}
		  Connection connection=DBcon.getCon();
		 String sql_update = "update userstable set users_passwd=? where users_name=?";
		   PreparedStatement preparedStatement=null;
		    try {
				preparedStatement=connection.prepareStatement(sql_update);
				preparedStatement.setString(1, jField3.getText().toString()); 
			
				preparedStatement.setString(2, name);	
				int count=preparedStatement.executeUpdate();
				if (count==1) {
						flag= true;
						jLabel.setText("修改成功！");
				}
			
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
}
