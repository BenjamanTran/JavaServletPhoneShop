package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	private static final String serverName="DESKTOP-FQC77OK";
	private static final String dbName="ShoppingDB";
	private static final String portNumber="1433";
	private static final String instance="";
	private static final String userID="sa";
	private static final String password="833142";
	
	
	public Connection getConnection() throws Exception{
		Connection connection=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("thành công driver");
			String url="jdbc:sqlserver://"+serverName+":1433;databaseName=" + dbName;
			if (instance==null ||instance.trim().isEmpty()) {
				url="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName+";encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
				System.out.println("1");
			}
			System.out.println("ktr thanh cong");
			connection=DriverManager.getConnection(url,userID,password);	
			System.out.println("thanh cong");
		} catch (Exception e) {
			System.out.println("that bai");
			e.printStackTrace();
			// TODO: handle exception
		}
		return connection;
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBContext().getConnection());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
