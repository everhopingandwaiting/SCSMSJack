package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import scsms.jc.entity.stuTable;
import scsms.jc.entity.tecTable;
import scsms.jc.util.DBcon;

public class TecInformation {

	public TecInformation() {
		// TODO Auto-generated constructor stub
	}
//	 public ResultSet  TecINfo(tecTable tecTable) {
//			
//	      Connection connection=DBcon.getCon();
//	       String sqlString="select * from tectable where tec_name=?";
//	    	
//	       PreparedStatement preparedStatement=null;
//	       ResultSet resultSet=null;
//	          try {
//				preparedStatement=connection.prepareStatement(sqlString);
//				  preparedStatement.setString(1, tecTable.getTec_name().toString());
//				   resultSet=preparedStatement.executeQuery();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	           finally{
//	        	    DBcon.CloseCon(connection, preparedStatement, resultSet);
//	           }
//	    	 return resultSet;
//		}
	public tecTable tecInfom(String name) {
		
		Connection connection=DBcon.getCon();
		tecTable tecTable=new  tecTable();
		String sqlString="select * from tectable where tec_name=?";
		PreparedStatement preparedStatement=null;
	       ResultSet resultSet=null;
	          try {
				preparedStatement=connection.prepareStatement(sqlString);
				  preparedStatement.setString(1, name);
				   resultSet=preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          try {
				while(resultSet.next())
				  {
				
				tecTable.setTec_num(resultSet.getLong(1));
				tecTable.setTec_name(resultSet.getString(2));
				tecTable.setTec_sex(resultSet.getString(3));
				tecTable.setTec_birth(resultSet.getDate(4).toString());
				tecTable.setTec_tel(resultSet.getLong(5));
				tecTable.setTec_email(resultSet.getString(6));
				tecTable.setTec_info(resultSet.getString(7));
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	          finally{DBcon.CloseCon(connection, preparedStatement, resultSet);}
	          return tecTable;
	}
	 public ArrayList<tecTable> tecInfo(String name){
		 Connection connection=DBcon.getCon();
		 String selString="select * from tectable where tec_name like '%"+name+"%' ";
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet =null;
		 ArrayList<tecTable> tectablesList=new ArrayList<tecTable>();
		 try {
			preparedStatement=connection.prepareStatement(selString);
			 resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(resultSet.next()){
				 tecTable  tecTable=new tecTable();
				 tecTable.setTec_num(resultSet.getLong(1));
				 tecTable.setTec_name(resultSet.getString(2));
				 tecTable.setTec_sex(resultSet.getString(3));
				 tecTable.setTec_birth(resultSet.getString(4).toString());
				 tecTable.setTec_tel(resultSet.getLong(5));
				 tecTable.setTec_email(resultSet.getString(6));
				 tecTable.setTec_info(resultSet.getString(7));
				 tectablesList.add(tecTable);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 DBcon.CloseCon(connection, preparedStatement, resultSet);
		 }
		 return tectablesList;
	 }
	 public ArrayList<tecTable> tecInfo(Long tecnum){
		 Connection connection=DBcon.getCon();
		 String selString="select * from tectable where tec_num like '%"+tecnum+"%' ";
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet =null;
		 ArrayList<tecTable> tectablesList=new ArrayList<tecTable>();
		 try {
			preparedStatement=connection.prepareStatement(selString);
			 resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(resultSet.next()){
				 tecTable  tecTable=new tecTable();
				 tecTable.setTec_num(resultSet.getLong(1));
				 tecTable.setTec_name(resultSet.getString(2));
				 tecTable.setTec_sex(resultSet.getString(3));
				 tecTable.setTec_birth(resultSet.getString(4).toString());
				 tecTable.setTec_tel(resultSet.getLong(5));
				 tecTable.setTec_email(resultSet.getString(6));
				 tecTable.setTec_info(resultSet.getString(7));
				 tectablesList.add(tecTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 DBcon.CloseCon(connection, preparedStatement, resultSet);
		 }
		 return tectablesList;
	 }
	 public ArrayList<tecTable> alltecinfoList(){
		 Connection connection=DBcon.getCon();
		 String selString="select * from tectable";
		 PreparedStatement preparedStatement=null;
		 ResultSet resultSet =null;
		 ArrayList<tecTable> tectablesList=new ArrayList<tecTable>();
		 try {
			preparedStatement=connection.prepareStatement(selString);
			 resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while(resultSet.next()){
				 tecTable  tecTable=new tecTable();
				 tecTable.setTec_num(resultSet.getLong(1));
				 tecTable.setTec_name(resultSet.getString(2));
				 tecTable.setTec_sex(resultSet.getString(3));
				 tecTable.setTec_birth(resultSet.getString(4).toString());
				 tecTable.setTec_tel(resultSet.getLong(5));
				 tecTable.setTec_email(resultSet.getString(6));
				 tecTable.setTec_info(resultSet.getString(7));
				 tectablesList.add(tecTable);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 DBcon.CloseCon(connection, preparedStatement, resultSet);
		 }
		 return tectablesList;
	 }
}
