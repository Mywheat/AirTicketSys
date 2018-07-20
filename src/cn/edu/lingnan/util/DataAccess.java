package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * 实现注册JDBC驱动程序、建立数据库连接以及关闭数据库连接
 */
public class DataAccess {
	
//	private static String driver ="com.mysql.jdbc.Driver";
//	private static String url ="jdbc:mysql://localhost:3306/plane";
//	private static String username ="root";
//	private static String password ="123456";
//	private static Connection conn = null;
//	public static Connection getConnection() {
//		try {
//			//注册驱动程序
//			Class.forName(driver);
//			//建立数据库连接
//		    conn = DriverManager.getConnection(url, username, password);
//		}catch (ClassNotFoundException e) {
//		    System.out.println("数据库jar包加载失败......");
//			e.printStackTrace();
//		}catch (SQLException e) {
//			System.out.println("数据库获取连接失败......");//即上面三个参数有错
//			e.printStackTrace();
//		}
//		System.out.println("数据库连接获取成功......");                      版本一
//  ----------------------------------------------------------------------------
//                                                                     版本二	                                                     
	private static String driver = null;
	private static String url = null;
	private static String user =null;
	private static String password =null;
	private static String xmlPath = "database.conf.xml";
	private static String xsdPath = "database.conf.xsd";
	private static Connection conn = null;
	private static HashMap<String,String> hm = new HashMap<String,String>();
	
	static{
		if(XmlValidator.validator(xmlPath, xsdPath)){//如果配置文件是对的
			hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		}
	}
	
	public static Connection getConnection() {
		try {
			//注册驱动程序
			Class.forName(driver);
			//建立数据库连接
		    conn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
		    System.out.println("数据库jar包加载失败......");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("数据库获取连接失败......");//即上面三个参数有错
			e.printStackTrace();
		}
		System.out.println("数据库连接获取成功......");
		return conn;  //注意返回
	}
	//关闭数据库连接
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
		try {
			if(rs != null){ //注意一下rs与conn的次序,先开后关
		        rs.close();
		        rs = null;
			}	
			if(stat != null){
		        stat.close();
		        stat = null;
			}
			if(prep != null){
		        prep.close();
		        prep = null;
			}
			if(conn != null){
		        conn.close();
		        conn = null;
			}
		} catch (SQLException e) {
			System.out.println("关闭数据库连接,语句及结果集时出现错误！");
			e.printStackTrace();
		}
		
	}

}
