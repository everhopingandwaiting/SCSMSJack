package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import scsms.jc.entity.tecTable;
import scsms.jc.util.ConvertStrToDate;
import scsms.jc.util.DBcon;

public class TecInfoModify {

	public TecInfoModify() {
		// TODO Auto-generated constructor stub
	}
   public static boolean InfoModify(tecTable tecTable) {
	   Connection connection=DBcon.getCon();
	   boolean flag=false;
	     String sql_update="update tectable set tec_num=?,tec_sex=?,tec_birth=?,tec_tel=?,tec_email=?,tec_info=? where tec_name=?";
	   
	     PreparedStatement preparedStatement=null;
	     
	      try {
			preparedStatement=connection.prepareStatement(sql_update);
			  preparedStatement.setLong(1, tecTable.getTec_num());
			  preparedStatement.setString(2, tecTable.getTec_sex().toString());
			  
			  preparedStatement.setDate(3, java.sql.Date.valueOf(tecTable.getTec_birth().toString()));
			  preparedStatement.setLong(4, tecTable.getTec_tel());
			  preparedStatement.setString(5, tecTable.getTec_email().toString());
			  preparedStatement.setString(6, tecTable.getTec_info().toString());
			  preparedStatement.setString(7, tecTable.getTec_name().toString());
			  int count=preparedStatement.executeUpdate();
			 if (count==1) {
				 flag= true;
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
   public static boolean InfoDel(tecTable tecTable) {
	
	   Connection connection=DBcon.getCon();
	   boolean flag=false;
	   String delsString="delete from tectable where tec_name=?";
	   PreparedStatement preparedStatement=null;
	   
	   try {
		preparedStatement=connection.prepareStatement(delsString);
		preparedStatement.setString(1, tecTable.getTec_name().toString());
		int count=preparedStatement.executeUpdate();
		if (count==1&&(selectededCousDel(tecTable)==1)&&(selectededScCousDel(tecTable)==1)) {
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	   finally{DBcon.CloseCon(connection, preparedStatement);}
	   return flag;
}
   // t同步删除 任课信息 
   public static int selectededCousDel(tecTable tecTable) {
		
	   Connection connection=DBcon.getCon();
	  int count=0;
	   String delsString="delete from coustable where tec_name=?";
	   PreparedStatement preparedStatement=null;
	   
	   try {
		preparedStatement=connection.prepareStatement(delsString);
		preparedStatement.setString(1, tecTable.getTec_name().toString());
	 count=preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	   finally{DBcon.CloseCon(connection, preparedStatement);}
	   return count;
}
   	//
   public static int selectededScCousDel(tecTable tecTable) {
		
	   Connection connection=DBcon.getCon();
	  int count=0;
	   String delsString="delete from sctable where tec_name=?";
	   PreparedStatement preparedStatement=null;
	   
	   try {
		preparedStatement=connection.prepareStatement(delsString);
		preparedStatement.setString(1, tecTable.getTec_name().toString());
	 count=preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	   finally{DBcon.CloseCon(connection, preparedStatement);}
	   return count;
}
   	
}
