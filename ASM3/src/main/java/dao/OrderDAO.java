package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import context.DBContext;
import model.Account;
import model.Order;
import model.Product;

public class OrderDAO {
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	public int getLastOrderID() {
			String queryString="select count(order_id)\n"
					+ "from Orders";
			int count=0;
			try {
				 connection = new DBContext().getConnection();//mo ket noi voi sql
				 ps=connection.prepareStatement(queryString);
				 rs=ps.executeQuery();
				 while (rs.next()) {
					count=rs.getInt(1);
					}
				 return count;
				  
				
			} catch (Exception e) {
				// TODO: handle exception
				return count;
			}
		
	}
	public Account getAccount(String name) {
		String queString="select * \n"
				+ "from Account\n"
				+ "where user_mail=?";
		
		try {
			
			connection=new DBContext().getConnection();
			ps=connection.prepareStatement(queString);
			ps.setString(1, name);
			rs=ps.executeQuery();
			Account account=null;
			 while (rs.next()) {
					 account=new Account(rs.getString(1),rs.getString(2),rs.getInt(3), 
							rs.getString(4), rs.getString(5), rs.getString(6));
					}
			 System.out.println(account.getName());
			 return account;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
				
		
	}
	
	public void insertOrderDetail(Order order) {
		String queString="set IDENTITY_INSERT Orders On\r\n"
				+ "insert into Orders(user_mail,order_id,order_status,order_date,order_discount_code,order_address) values(?,?,?,?,?,?);\r\n"
				+ "set IDENTITY_INSERT Orders Off";
		try {
			connection=new DBContext().getConnection();
			ps=connection.prepareStatement(queString);
			ps.setString(1,order.getUserEmail() );
			ps.setInt(2, order.getOrderId());
			ps.setInt(3, order.getStatus());
			ps.setDate(4, order.getOrderDate());
			ps.setString(5, order.getDiscount());
			ps.setString(6,order.getAddres() );
			ps.executeUpdate();
			System.out.println("thanh cong insert");
		} catch (Exception e) {
			// TODO: handle exceptions
			System.out.println("that bai insert");
		}
				
	}
	public void insertCartDetail(Order order) {
	
		try {
			
			for(int i=0;i<order.getLp().size();i++) {
				String queryString="insert into Orders_detail values(?,?,?,?)";
				connection=new DBContext().getConnection();
				ps=connection.prepareStatement(queryString);
				
				ps.setInt(1, order.getLp().get(i).getOrderId());
				ps.setInt(2, order.getLp().get(i).getProductId());
				ps.setInt(3, order.getLp().get(i).getAmountProduct());
				
				ps.setInt(4,order.getLp().get(i).getPrice());
				ps.executeUpdate();
				System.out.println("thanh congo insert product order");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("that bai insert product order");
		}
	}
//	public static void main(String[] args) {
//		OrderDAO orderDAO=new OrderDAO();
//		System.out.println(orderDAO.getAccount("duongdt@fpt.com.vn"));
//	}
}
