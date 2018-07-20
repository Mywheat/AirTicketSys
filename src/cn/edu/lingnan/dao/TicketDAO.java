package cn.edu.lingnan.dao;

import java.sql.*;
import java.util.Vector;

import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.util.DataAccess;

public class TicketDAO {
	//查-------查客户表全部客户的姓名
	public Vector<TicketDTO> findAllTicketInfo() {
		Vector<TicketDTO> v = new Vector<TicketDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from ticket";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketDTO s = new TicketDTO();
		    	s.setTid(rs.getString("tid"));
		    	s.setFlightNumber(rs.getString("flightNumber"));
		    	s.setDestination(rs.getString("destination"));
		    	s.setOffDate(rs.getString("offDate"));
		    	s.setPrice(rs.getString("price"));
		    	s.setAllowance(rs.getInt("allowance"));
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
	//查-----根据id查找机票信息
	public Vector<TicketDTO> findTicketInfoById(String tid) {
		Vector<TicketDTO> v = new Vector<TicketDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from ticket where tid = '"+tid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketDTO tdto = new TicketDTO();
		    	tdto.setTid(rs.getString("tid"));
		    	tdto.setFlightNumber(rs.getString("fligtNumber"));
		    	tdto.setDestination(rs.getString("destination"));
		    	tdto.setOffDate(rs.getString("offDate"));
		    	tdto.setPrice(rs.getString("price"));
		    	tdto.setAllowance(rs.getInt("allowance"));
		    	tdto.setStatus(rs.getInt("status"));
		    	v.add(tdto);
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
	//查-----根据目的查找机票信息
	public Vector<TicketDTO> findTicketInfoByDestination(String destination) {
		Vector<TicketDTO> v = new Vector<TicketDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from ticket where destination = '"+destination+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketDTO tdto = new TicketDTO();
		    	tdto.setTid(rs.getString("tid"));
		    	tdto.setFlightNumber(rs.getString("flightNumber"));
		    	tdto.setDestination(rs.getString("destination"));
		    	tdto.setOffDate(rs.getString("offDate"));
		    	tdto.setPrice(rs.getString("price"));
		    	tdto.setAllowance(rs.getInt("allowance"));
		    	tdto.setStatus(rs.getInt("status"));
		    	v.add(tdto);
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
	//增------添加机票记录
	public boolean insertIntoTicket(String tid,String fightNumber,String destination,String offDate,String price,int allowance,int status){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    prep = conn.prepareStatement("insert into ticket values(?,?,?,?,?,?,?)");//创建SQL语句且执行
			prep.setString(1, tid);
			prep.setString(2, fightNumber);
			prep.setString(3, destination);
			prep.setString(4, offDate);
			prep.setString(5, price);
			prep.setInt(6, allowance);
			prep.setInt(7, status);
		    prep.executeUpdate();
		    flag = true;
		}
		catch (SQLException e) {
			System.out.println("SQL语句运行错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs); //关闭数据库连接
		}
		return flag;
	}
	//增
	public boolean insertTicket(TicketDTO tdto){
		boolean flag = false;
		String tid = tdto.getTid();
		String flightNumber = tdto.getFlightNumber();
		String destination = tdto.getDestination();
		String offDate = tdto.getOffDate();
		String price = tdto.getPrice();
		int allowance = tdto.getAllowance();
		int status = tdto.getStatus();
		String sql = "insert into ticket values"
				+"('"+tid+"','"+flightNumber+"','"+destination+"','"+offDate+"','"+price+"','"+allowance+"','"+status+"')";
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
	//删--------根据机票id删除机票信息（软删除）
	public boolean deleteTicketById(String tid){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
		    conn = DataAccess.getConnection(); //创建SQL语句且执行
		    stat = conn.createStatement();
		    conn.setAutoCommit(false); 
		    stat.executeUpdate("update ticketpurchase set status = '1' where tid = '"+tid+"'");
		    stat.executeUpdate("update ticket set status = '1' where tid = '"+tid+"'");
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
			DataAccess.closeconn(conn, stat, null, null); //关闭数据库连接
		}
		return flag;
	}

	//改----根据机票id更改起飞时间
	public boolean updateTicketById(String offDate,String tid){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
		    conn = DataAccess.getConnection();    //创建SQL语句且执行
		    prep = conn.prepareStatement("update ticket set offDate = ? where tid= ?");
		    prep.setString(1, offDate);
		    prep.setString(2, tid);
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
	//改
	public boolean updateTicketInfo(TicketDTO tdto){
		boolean flag = false;
		String tid = tdto.getTid();
		String flightNumber = tdto.getFlightNumber();
		String destination = tdto.getDestination();
		String offDate = tdto.getOffDate();
		String price = tdto.getPrice();
		int allowance = tdto.getAllowance();
		int status = tdto.getStatus();
		String sql = "update ticket set tid='"+tid+"',"+ "flightNumber='"+flightNumber+"',"+ "destination='"+destination+"',"
				+ "offDate='"+offDate+"',"+"price='"+price+"',"+"allowance='"+allowance+"',status='"+status+"' where tid='"+tid+"'";
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
