package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import scsms.jc.entity.SCTable;
import scsms.jc.entity.cousTable;
import scsms.jc.entity.stuTable;
import scsms.jc.util.DBcon;

public class CousInformation {

	public CousInformation() {
		// TODO Auto-generated constructor stub
	}
	  public 	ArrayList<cousTable> AllCousInfo() {
			
  	    Connection connection=DBcon.getCon();
  	     String selectString=" select * from  coustable ";
  	      PreparedStatement preparedStatement=null;
  	       ResultSet resultSet=null;
  	        ArrayList<cousTable>  CousList= new ArrayList<cousTable>();
  	       try {
				preparedStatement=connection.prepareStatement(selectString);
				    resultSet=preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	       
  	         try {
				while (resultSet.next()) {
				
					 cousTable cousTable=new  cousTable();
					 cousTable.setCous_num(resultSet.getInt(1));
					 cousTable.setCous_name(resultSet.getString(2));
					 cousTable.setCous_credit(resultSet.getFloat(3));
					 cousTable.setCous_property(resultSet.getString(4));
					 cousTable.setCous_maxnum(resultSet.getInt(5));
					 cousTable.setCous_tec(resultSet.getString(6));
					 CousList.add(cousTable);
					 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	         finally{
  	        	 DBcon.CloseCon(connection, preparedStatement, resultSet);
  	         }
  	      return CousList;   
	}
	  public 	ArrayList<cousTable> OrderBynumCousInfo(int cousNum) {
			
	  	    Connection connection=DBcon.getCon();
	  	     String selectString=" select * from  coustable where cous_num like '"+cousNum+"' ";
	  	      PreparedStatement preparedStatement=null;
	  	       ResultSet resultSet=null;
	  	        ArrayList<cousTable>  CousList= new ArrayList<cousTable>();
	  	       try {
					preparedStatement=connection.prepareStatement(selectString);
					    resultSet=preparedStatement.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	       
	  	         try {
					while (resultSet.next()) {
					
						 cousTable cousTable=new  cousTable();
						 cousTable.setCous_num(resultSet.getInt(1));
						 cousTable.setCous_name(resultSet.getString(2));
						 cousTable.setCous_credit(resultSet.getFloat(3));
						 cousTable.setCous_property(resultSet.getString(4));
						 cousTable.setCous_maxnum(resultSet.getInt(5));
						 cousTable.setCous_tec(resultSet.getString(6));
						 CousList.add(cousTable);
						 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	         finally{
	  	        	 DBcon.CloseCon(connection, preparedStatement, resultSet);
	  	         }
	  	      return CousList;   
		}
	  public 	ArrayList<cousTable> OrderBynumCousInfo(String cousName) {
			
	  	    Connection connection=DBcon.getCon();
	  	     String selectString=" select * from  coustable where cous_num like '"+cousName+"' ";
	  	      PreparedStatement preparedStatement=null;
	  	       ResultSet resultSet=null;
	  	        ArrayList<cousTable>  CousList= new ArrayList<cousTable>();
	  	       try {
					preparedStatement=connection.prepareStatement(selectString);
					    resultSet=preparedStatement.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	       
	  	         try {
					while (resultSet.next()) {
					
						 cousTable cousTable=new  cousTable();
						 cousTable.setCous_num(resultSet.getInt(1));
						 cousTable.setCous_name(resultSet.getString(2));
						 cousTable.setCous_credit(resultSet.getFloat(3));
						 cousTable.setCous_property(resultSet.getString(4));
						 cousTable.setCous_maxnum(resultSet.getInt(5));
						 cousTable.setCous_tec(resultSet.getString(6));
						 CousList.add(cousTable);
						 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	         finally{
	  	        	 DBcon.CloseCon(connection, preparedStatement, resultSet);
	  	         }
	  	      return CousList;   
		}
	      public ArrayList<SCTable> stuSelectedCous(String stuName) {
			 ArrayList<SCTable> stuSelCousList=new ArrayList<SCTable>();
			 	Connection connection=DBcon.getCon();
			 	String selectString="select  stu_name,tec_name,cous_name from sctable where stu_name=?";
			 	PreparedStatement preparedStatement=null;
			 	ResultSet resultSet=null;
			 	 try {
					preparedStatement=connection.prepareStatement(selectString);
					 preparedStatement.setString(1,stuName);
					 resultSet=preparedStatement.executeQuery();
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	  try {
					while (resultSet.next()) {
						 SCTable scTable=new SCTable();
						 scTable.setStu_name(resultSet.getString(1));
				 scTable.setTec_name(resultSet.getString(2));
					// scTable.setGrade(resultSet.getFloat(3));
					 scTable.setCous_name(resultSet.getString(3));
						 stuSelCousList.add(scTable);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	   finally{ DBcon.CloseCon(connection, preparedStatement, resultSet);}
			 	return stuSelCousList;
		}
	      public static ArrayList<SCTable> tecSelectededCous(String tecName) {
				 ArrayList<SCTable> tecSelCousList=new ArrayList<SCTable>();
				 	Connection connection=DBcon.getCon();
				 	String selectString="select  stu_name,tec_name,cous_name,grade from sctable where tec_name=? ";
				 	PreparedStatement preparedStatement=null;
				 	ResultSet resultSet=null;
				 	 try {
						preparedStatement=connection.prepareStatement(selectString);
						 preparedStatement.setString(1,tecName);
						 resultSet=preparedStatement.executeQuery();
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	  try {
						while (resultSet.next()) {
							 SCTable scTable=new SCTable();
							 scTable.setStu_name(resultSet.getString(1));
							 scTable.setTec_name(resultSet.getString(2));
							
							 scTable.setCous_name(resultSet.getString(3));
							 scTable.setGrade(resultSet.getFloat(4));
							 tecSelCousList.add(scTable);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	   finally{ DBcon.CloseCon(connection, preparedStatement, resultSet);}
				 	return tecSelCousList;
			}
	      // 学生选择课程的对应老师
	      public ArrayList<SCTable> tecnameThatselectededBystu(String stuname) {
				 ArrayList<SCTable> tecSelededList=new ArrayList<SCTable>();
				 	Connection connection=DBcon.getCon();
				 	String selectString="select  tec_name from sctable where stu_name=?";
				 	PreparedStatement preparedStatement=null;
				 	ResultSet resultSet=null;
				 	 try {
						preparedStatement=connection.prepareStatement(selectString);
						 preparedStatement.setString(1,stuname);
						 resultSet=preparedStatement.executeQuery();
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	  try {
						while (resultSet.next()) {
							 SCTable scTable=new SCTable();
							
							 scTable.setTec_name(resultSet.getString(1));
							
							
							
							 tecSelededList.add(scTable);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	   finally{ DBcon.CloseCon(connection, preparedStatement, resultSet);}
				 	return tecSelededList;
			}
	      public ArrayList<SCTable> stuSelectCousGrade(String stuName) {
				 ArrayList<SCTable> stuSelCousGradeList=new ArrayList<SCTable>();
				 	Connection connection=DBcon.getCon();
				 	String selectString="select  stu_name,grade,cous_name from sctable where stu_name=?";
				 	PreparedStatement preparedStatement=null;
				 	ResultSet resultSet=null;
				 	 try {
						preparedStatement=connection.prepareStatement(selectString);
						 preparedStatement.setString(1,stuName);
						 resultSet=preparedStatement.executeQuery();
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	  try {
						while (resultSet.next()) {
							 SCTable scTable=new SCTable();
							 scTable.setStu_name(resultSet.getString(1));
							// scTable.setTec_name(resultSet.getString(2));
							 scTable.setGrade(resultSet.getFloat(2));
							 scTable.setCous_name(resultSet.getString(3));
							 stuSelCousGradeList.add(scTable);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	   finally{ DBcon.CloseCon(connection, preparedStatement, resultSet);}
				 	return stuSelCousGradeList;
			}
}
