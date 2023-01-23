package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import model.Account;

public class AccountDAO {
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	public Account login(String user,String pass) {
		String query="select * from account\n"+
					"where user_mail =?\n"+
					"and password =?";
		try {
			  connection = new DBContext().getConnection();//mo ket noi voi sql
	            ps = connection.prepareStatement(query);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            rs = ps.executeQuery();
	            while (rs.next()) {
					return new Account(rs.getString(1), rs.getString(2), rs.getInt(3),
							rs.getString(4), rs.getString(5), rs.getString(6));
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
