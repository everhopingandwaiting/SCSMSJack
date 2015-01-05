package scsms.jc.dao.InfoManage;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import scsms.jc.entity.stuTable;
import scsms.jc.util.DBcon;

public class StuInformation {

//	private int hasNUM;
	public StuInformation() {
		// TODO Auto-generated constructor stub
	}
	 
//    public ResultSet  stuINfo(stuTable stuTable) {
//		
//      Connection connection=DBcon.getCon();
//       String sqlString="select * from stutable where stu_name=?";
//    	 
//       PreparedStatement preparedStatement=null;
//       ResultSet resultSet=null;
//          try {
//			preparedStatement=connection.prepareStatement(sqlString);
//			  preparedStatement.setString(1, stuTable.getStu_name());
//			   resultSet=preparedStatement.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//           finally{
//        	    DBcon.CloseCon(connection, preparedStatement, resultSet);
//           }
//    	 return resultSet;
//	}
	public stuTable SimplestuInfolists(String name){
    	Connection connection=DBcon.getCon();
    	String selectString="select * from stutable where stu_name like '"+name+"'";
    	
    	PreparedStatement preparedStatement=null;
    	ResultSet resultSet=null;
    // ArrayList<stuTable> stuTableList=new ArrayList<stuTable>();
    	stuTable stuTable=new stuTable();
    	try {
			preparedStatement=connection.prepareStatement(selectString);
		//	preparedStatement.setString(1,name);
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while (resultSet.next())
			{
				
				
				stuTable.setStu_name(resultSet.getString(1));
				stuTable.setStu_num(resultSet.getLong(2));
				stuTable.setStu_sex(resultSet.getString(3));
				stuTable.setStu_birth(resultSet.getDate(4).toString());
				stuTable.setStu_tel(resultSet.getLong(5));
				stuTable.setStu_email(resultSet.getString(6));
				stuTable.setStu_info(resultSet.getString(7));
				stuTable.setStu_addr(resultSet.getString(8));
				//stuTableList.add(stuTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{

    		DBcon.CloseCon(connection, preparedStatement, resultSet);
    	}
		
    return stuTable;
   
    }
	public ArrayList<stuTable> SimplestuInfolist(String name){
    	Connection connection=DBcon.getCon();
    	String selectString="select * from stutable where stu_name like '%"+name+"%'";
    	
    	PreparedStatement preparedStatement=null;
    	ResultSet resultSet=null;
     ArrayList<stuTable> stuTableList=new ArrayList<stuTable>();
    	try {
			preparedStatement=connection.prepareStatement(selectString);
		//	preparedStatement.setString(1,name);
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while (resultSet.next())
			{
				stuTable stuTable=new stuTable();
				
				stuTable.setStu_name(resultSet.getString(1));
				stuTable.setStu_num(resultSet.getLong(2));
				stuTable.setStu_sex(resultSet.getString(3));
				stuTable.setStu_birth(resultSet.getDate(4).toString());
				stuTable.setStu_tel(resultSet.getLong(5));
				stuTable.setStu_email(resultSet.getString(6));
				stuTable.setStu_info(resultSet.getString(7));
				stuTable.setStu_addr(resultSet.getString(8));
				stuTableList.add(stuTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{

    		DBcon.CloseCon(connection, preparedStatement, resultSet);
    	}
		
    return stuTableList;
   
    }
	public ArrayList<stuTable> SimplestuInfolist(Long stunum){
    	Connection connection=DBcon.getCon();
    	String selectString="select * from stutable where  stu_num like '%"+stunum+"%'";
    
    	PreparedStatement preparedStatement=null;
    	ResultSet resultSet=null;
    	ArrayList<stuTable> stuTableList=new ArrayList<stuTable>();
    	try {
			preparedStatement=connection.prepareStatement(selectString);
		//	preparedStatement.setLong(1,stunum);
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while (resultSet.next())
			{
				stuTable stuTable=new stuTable();
				
				stuTable.setStu_name(resultSet.getString(1));
				stuTable.setStu_num(resultSet.getLong(2));
				stuTable.setStu_sex(resultSet.getString(3));
				stuTable.setStu_birth(resultSet.getDate(4).toString());
				stuTable.setStu_tel(resultSet.getLong(5));
				stuTable.setStu_email(resultSet.getString(6));
				stuTable.setStu_info(resultSet.getString(7));
				stuTable.setStu_addr(resultSet.getString(8));
				stuTableList.add(stuTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{

    		DBcon.CloseCon(connection, preparedStatement, resultSet);
    	}
		
    return stuTableList;
   
    }
    public ArrayList<stuTable> allstuInfolist(){
    	Connection connection=DBcon.getCon();
    	String selectString="select * from stutable";
    	PreparedStatement preparedStatement=null;
    	ResultSet resultSet=null;
    	ArrayList<stuTable> stuTableList=new ArrayList<stuTable>();
    	try {
			preparedStatement=connection.prepareStatement(selectString);
			resultSet=preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			while (resultSet.next())
			{

				stuTable stuTable=new stuTable();
				stuTable.setStu_name(resultSet.getString(1));
				stuTable.setStu_num(resultSet.getLong(2));
				stuTable.setStu_sex(resultSet.getString(3));
				stuTable.setStu_birth(resultSet.getDate(4).toString());
				stuTable.setStu_tel(resultSet.getLong(5));
				stuTable.setStu_email(resultSet.getString(6));
				stuTable.setStu_info(resultSet.getString(7));
				stuTable.setStu_addr(resultSet.getString(8));
				stuTableList.add(stuTable);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{

    		DBcon.CloseCon(connection, preparedStatement, resultSet);
    	}
		
    return stuTableList;
   
    }
    }