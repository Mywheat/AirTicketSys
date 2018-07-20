package cn.edu.lingnan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 * ʵ��ע��JDBC�������򡢽������ݿ������Լ��ر����ݿ�����
 */
public class DataAccess {
	
//	private static String driver ="com.mysql.jdbc.Driver";
//	private static String url ="jdbc:mysql://localhost:3306/plane";
//	private static String username ="root";
//	private static String password ="123456";
//	private static Connection conn = null;
//	public static Connection getConnection() {
//		try {
//			//ע����������
//			Class.forName(driver);
//			//�������ݿ�����
//		    conn = DriverManager.getConnection(url, username, password);
//		}catch (ClassNotFoundException e) {
//		    System.out.println("���ݿ�jar������ʧ��......");
//			e.printStackTrace();
//		}catch (SQLException e) {
//			System.out.println("���ݿ��ȡ����ʧ��......");//���������������д�
//			e.printStackTrace();
//		}
//		System.out.println("���ݿ����ӻ�ȡ�ɹ�......");                      �汾һ
//  ----------------------------------------------------------------------------
//                                                                     �汾��	                                                     
	private static String driver = null;
	private static String url = null;
	private static String user =null;
	private static String password =null;
	private static String xmlPath = "database.conf.xml";
	private static String xsdPath = "database.conf.xsd";
	private static Connection conn = null;
	private static HashMap<String,String> hm = new HashMap<String,String>();
	
	static{
		if(XmlValidator.validator(xmlPath, xsdPath)){//��������ļ��ǶԵ�
			hm = XmlParser.parser(xmlPath);
			driver = hm.get("driver");
			url = hm.get("url");
			user = hm.get("user");
			password = hm.get("password");
		}
	}
	
	public static Connection getConnection() {
		try {
			//ע����������
			Class.forName(driver);
			//�������ݿ�����
		    conn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
		    System.out.println("���ݿ�jar������ʧ��......");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("���ݿ��ȡ����ʧ��......");//���������������д�
			e.printStackTrace();
		}
		System.out.println("���ݿ����ӻ�ȡ�ɹ�......");
		return conn;  //ע�ⷵ��
	}
	//�ر����ݿ�����
	public static void closeconn(Connection conn,Statement stat,PreparedStatement prep,ResultSet rs){
		try {
			if(rs != null){ //ע��һ��rs��conn�Ĵ���,�ȿ����
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
			System.out.println("�ر����ݿ�����,��估�����ʱ���ִ���");
			e.printStackTrace();
		}
		
	}

}
