package scsms.jc.dao.InfoManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import scsms.jc.entity.countOfValueAtQues;
import scsms.jc.util.DBcon;

public class QuestionInfomation {

	public QuestionInfomation() {
		// TODO Auto-generated constructor stub
	}
		public static int InsertQuestion(int qnum,String qres,String qdetai,String tecname) {
			Connection connection=DBcon.getCon();
			int count=0;
			PreparedStatement preparedStatement=null;
			String insertsString="insert into questitable values(?,?,?,?)";
			
			try {
				preparedStatement=connection.prepareStatement(insertsString);
				preparedStatement.setInt(1, qnum);
				preparedStatement.setString(2, qres);
				preparedStatement.setString(3, qdetai);
				preparedStatement.setString(4, tecname);
				count=preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{DBcon.CloseCon(connection, preparedStatement);}
			return count;
		}
		public static ArrayList<countOfValueAtQues> tecGetValueOfQuestion(String tecname) {
			Connection connection=DBcon.getCon();
			ArrayList<countOfValueAtQues> arrayList=new  ArrayList<countOfValueAtQues>();
			PreparedStatement preparedStatement=null;
			ResultSet resultSet=null;
			String countsString=" select  que_detail,que_result,count(*) from questitable where tec_name=? group by que_detail,que_result";
			
			try {
				preparedStatement=connection.prepareStatement(countsString);
				preparedStatement.setString(1, tecname);
				resultSet=preparedStatement.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(resultSet.next())
				{
					countOfValueAtQues atQues=new  countOfValueAtQues();
					atQues.setQuestionLabel(resultSet.getString(1));
					atQues.setResult(resultSet.getString(2));
					atQues.setCount(resultSet.getInt(3));
				
					arrayList.add(atQues);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{DBcon.CloseCon(connection, preparedStatement, resultSet);}
			return arrayList;
		}
}
