package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import model.Product;

public class ListProductDAO {
	Connection connection=null;
	PreparedStatement ps=null;
	ResultSet rs= null;
	
	public Product getProduct(String id) {
		 String query = "select * from products\n"
	                + "where product_id = ?";
	        try {
	            connection = new DBContext().getConnection();//mo ket noi voi sql
	            ps = connection.prepareStatement(query);
	            ps.setString(1, id);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                return new Product(rs.getInt(1), 
							rs.getString(2), 
							rs.getString(3), 
							rs.getFloat(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7));
	               
	            }
	            System.out.println("thanh công lấy ra id= "+rs.getString(2));
	           
	        } catch (Exception e) {
	        }
	        return null;
	}
	public List<Product> getAllProducts(){
		List<Product> list=new ArrayList<>();
		String query="select * from products";
		try {
			connection=new DBContext().getConnection();
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7)));
				
			}
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
		}
		
		return list;
	}
	public List<Product> searchByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String query = "select * from products\n"
                + "where product_name like ?";
        try {
            connection = new DBContext().getConnection();//mo ket noi voi sql
            ps = connection.prepareStatement(query);
            ps.setString(1,"%"+ txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getFloat(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
//	public static void main(String[] args) {
//		ListProductDAO dao=new ListProductDAO();
//		List<Product> list=dao.getAllProducts();
//		for(Product p:list) {
//			System.out.println(p.toString());
//		}
//	}
}
