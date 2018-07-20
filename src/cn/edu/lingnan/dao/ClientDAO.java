package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.util.DataAccess;

public class ClientDAO {
	
	//查-------查客户表全部客户的姓名
	public Vector<ClientDTO> findAllClientInfo() {
		Vector<ClientDTO> v = new Vector<ClientDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from client";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	ClientDTO s = new ClientDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setCname(rs.getString("cname"));
		    	s.setTel(rs.getString("tel"));
		    	s.setPassword(rs.getString("password"));
		    	s.setSuperpassword(rs.getString("superpassword"));
		    	s.setStatus(rs.getInt("status"));
		    	v.add(s);
		    	}
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //注意返回
	}
	//查-----根据id查找客户信息
	public Vector<ClientDTO> findClientInfoById(String cid) {
		Vector<ClientDTO> v = new Vector<ClientDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from client where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	ClientDTO s = new ClientDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setCname(rs.getString("cname"));		    	
		    	s.setTel(rs.getString("tel"));
		    	s.setSuperpassword(rs.getString("superpassword"));
		    	s.setStatus(rs.getInt("status"));
		    	v.add(s);
		    	}
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //注意返回
	}
	//判断用户登录时是否正确
	public int findClientBynameAndPassword(String cname,String password){
		int superValue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
            prep = conn.prepareStatement
            		("select * from client where cname = ? and password = ?");
            //插入
            prep.setString(1,cname);
			prep.setString(2,password);
			rs = prep.executeQuery();
			if (rs.first()){
				superValue=Integer.parseInt(rs.getString("superpassword"));
			    System.out.println("---1---"+superValue);
			}
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return superValue;
    }
	//根据姓名查ID
	public String findClientByCname(String cname){
		String cid = null;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
            prep = conn.prepareStatement
            		("select * from client where cname = ?");
            prep.setString(1,cname);
			rs = prep.executeQuery();
			if (rs.first()){
				cid=rs.getString("cid");
			    System.out.println("---cid---"+cid);
			}
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return cid;
    }
	//判断软删除用户是否能登录
	public int findClientByStatus(String cname){
		int superValue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		int status = 0;
		try {
			conn = DataAccess.getConnection();
            prep = conn.prepareStatement
            		("select status from client where cname = ?");
            prep.setString(1,cname);
			rs = prep.executeQuery();
			if (rs.first()){
				status=Integer.parseInt(rs.getString("status"));
			    System.out.println("---status---"+status);
			}
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return status;
    }
	
	//增-----增加客户信息
	public boolean insertIntoClient(String cid,String cname,String tel,String password,String superpassword,int status){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
				conn = DataAccess.getConnection();
			    prep = conn.prepareStatement("insert into client values(?,?,?,?,?,?)");//创建SQL语句且执行
				prep.setString(1, cid);
				prep.setString(2, cname);
				prep.setString(3, tel);
				prep.setString(4, password);
				prep.setString(5, superpassword);
				prep.setInt(6, status);
			    prep.executeUpdate();
			    flag = true;
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, null); //关闭数据库连接
		}
		return flag;
	}
	//增-register
	public boolean inserttoClient(ClientDTO cdto){
		boolean flag = false;
		String cid = cdto.getCid();
		String cname = cdto.getCname();
		String tel = cdto.getTel();
		String password = cdto.getPassword();
		int superpassword = Integer.parseInt(cdto.getSuperpassword());
		int status = cdto.getStatus();
		String sql = "insert into client values"
				+"('"+cid+"','"+cname+"','"+tel+"','"+password+"','"+superpassword+"','"+status+"')";
		Connection conn = null;
		Statement stat = null;
		try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
			 	stat.executeUpdate(sql);
			    flag = true;
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //关闭数据库连接
		}
		return flag;
	}

	//删--------根据id删除客户信息（软删除）
	public boolean deleteClientById(String cid){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql2 = null;
		String sql3 = null;
		try {
		    conn = DataAccess.getConnection(); //创建SQL语句且执行
		    stat = conn.createStatement();
		    stat1 = conn.createStatement();
		    sql2 = "select * from ticketpurchase where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql2);
		    String tid = null;
		    HashSet<String> hs = new HashSet<String>(); //哈希表
		    while(rs.next()){
		    	tid = rs.getString(2);
		    	sql3 = "select count(*) as num from ticketpurchase where tid = '"+tid+"'";
		    	rs1 = stat1.executeQuery(sql3);
		    	rs1.next();
		    	if(rs1.getInt("num")==1){ //若机票购买表中同种机票的tid只有一个
		    		hs.add(tid);
//		    		stat.executeUpdate("delete from ticketpurchase where tid = '"+tid+"'");
//		    		stat.executeUpdate("delete from ticket where tid = '"+tid+"'");
		    	}
		    	rs.next();
		    	rs1.close();
		    }
		    
		    conn.setAutoCommit(false); 
//			stat.executeUpdate("delete from ticketpurchase where cid = '"+id+"'"); //1.删机票购买表信息
//		    stat.executeUpdate("delete from client where cid = '"+id+"'");  //2.删客户信息
		    stat.executeUpdate("update ticketpurchase set status = '1' where cid = '"+cid+"'");
		    stat.executeUpdate("update client set status = '1' where cid = '"+cid+"'");
		    Iterator<String> it = hs.iterator();
		    while(it.hasNext()){
//		    	stat.executeUpdate("delete from ticket where tid = '"+it.next()+"'"); //删没人乘坐的飞机的机票信息
		    	stat.executeUpdate("update ticket set status = '1' where tid = '"+it.next()+"'");   
		    }
		    conn.commit();  //提交
		    conn.setAutoCommit(true);
		    
		    flag = true;
		}
		catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs); //关闭数据库连接
		}
		return flag;
	}
	//改----根据id更改电话
	public boolean updateClientTelById(String id,String tel){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
		    conn = DataAccess.getConnection();    //创建SQL语句且执行
		    stat = conn.createStatement();
			String sql = "update client set tel = '"+tel+"' where cid='"+id+"'";
		    stat.executeUpdate(sql);
		    flag = true;
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //关闭数据库连接
		}
		return flag;
	}
	//修改
	public boolean updateClientInfo(ClientDTO cdto){
		boolean flag = false;
		String cid = cdto.getCid();
		String cname = cdto.getCname();
		String tel = cdto.getTel();
		String password = cdto.getPassword();
		int superpassword = Integer.parseInt(cdto.getSuperpassword());
		int status = cdto.getStatus();
		String sql = "update client set cname='"+cname+"',"+ "tel='"+tel+"',"+ "password='"+password+"',"
				+ "superpassword='"+superpassword+"',status='"+status+"' where cid='"+cid+"'";
		Connection conn = null;
		Statement stat = null;
		try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
			 	stat.executeUpdate(sql);
			    flag = true;
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //关闭数据库连接
		}
		return flag;
	}
	
}
