package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;
import cn.edu.lingnan.util.DataAccess;

public class TicketpurchaseDAO {
	//增-------
	public String insertTicketpurchase(TicketpurchaseDTO tdto){
		String flag = "true";
		String cid = tdto.getCid();
		String tid = tdto.getTid();
		String purchaseDate = tdto.getPurchaseDate();
		int status = tdto.getStatus();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		PreparedStatement prep = null;
		String sql = "insert into ticketpurchase values"
				+"('"+cid+"','"+tid+"','"+purchaseDate+"','"+status+"')";
		try {
				conn = DataAccess.getConnection();
				stat = conn.createStatement();
				rs = stat.executeQuery("select allowance from ticket where tid = '"+tid+"'");
          //      System.out.println("44444444444");
				while(rs.next()){ 
				 	if(rs.getInt("allowance")>0){ 
						stat.executeUpdate(sql);
						stat.executeUpdate("update  ticket set allowance = allowance-1 where tid = '"+tid+"'");//购买多一张机票，机票的余量就会减1
						flag = "true";
				 	}
				 	else
				 		{
				 		  flag = "flase"; 
				 		}
				}
				
		}
		catch (SQLException e) {
			System.out.println("运行SQL语句出现错误");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, prep, rs); //关闭数据库连接
		}
		return flag;
	}
	//增------购买机票
	public boolean insertIntoTicketpurchase(String cid,String tid,String purchaseDate,int status){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    prep = conn.prepareStatement("insert into ticketpurchase values(?,?,?,?)");//创建SQL语句且执行
			prep.setString(1, cid);
			prep.setString(2, tid);
			prep.setString(3, purchaseDate);
			prep.setInt(4, status);		
			stat = conn.createStatement();		
			rs = stat.executeQuery("select allowance from ticket where tid = '"+tid+"'");//查询机票的余量
			rs.next(); 
			if(rs.getInt("allowance")>0){ 
				prep.executeUpdate();
				stat.executeUpdate("update  ticket set allowance = allowance-1 where tid = '"+tid+"'");//购买多一张机票，机票的余量就会减1
			    flag = true;
			}
			else
				flag = false;
		    
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
	
	//删--------根据cid和tid删除机票购买的信息（软删除）
	public boolean deleteTicketpurchaseId(String cid,String tid){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql2 = null;
		String sql3 = null;
		int status;		
		try {
		    conn = DataAccess.getConnection(); //创建SQL语句且执行
		    stat = conn.createStatement();
		    stat1 = conn.createStatement();
		    sql2 = "select * from ticketpurchase where tid = '"+tid+"'"; //针对机票，注意是tid,不是cid
		    rs = stat.executeQuery(sql2);
		    HashSet<String> hs = new HashSet<String>(); //哈希表
		    while(rs.next()){
		    	tid = rs.getString(2);
		    	status = rs.getInt(4);
		    	sql3 = "select count(*) as num from ticketpurchase where tid = '"+tid+"' and status=0";//注意要在status=0的情况下，即该记录未被软删除的情况
		    	rs1 = stat1.executeQuery(sql3);
		    	rs1.next();
		    	if(rs1.getInt("num")==1){ //若机票购买表中同种机票的tid只有一个
		    		hs.add(tid);
		    	}   	
		//    	System.out.println("----"+rs1.getInt("num"));
		    	rs1.close();
		    }
		    
	    	conn.setAutoCommit(false); 
	  //  	System.out.println("--11111--"+cid+tid); //测试传到这里的参数值有没有改变
		    stat.executeUpdate("update ticketpurchase set status = 1 where cid = '"+cid+"' and tid = '"+tid+"'");		     
			stat.executeUpdate("update  ticket set allowance = allowance+1 where tid = '"+tid+"'");//删除一张已购买的机票，机票的余量就会加1		
		    Iterator<String> it = hs.iterator();
		    while(it.hasNext()){
		    	stat.executeUpdate("update ticket set status = 1 where tid = '"+it.next()+"'");  //删没人乘坐的飞机的机票信息 
		    }
		    conn.commit();  //提交
		    conn.setAutoCommit(true);
	        flag = true;
		}
		catch (SQLException e) {
			try {
				conn.rollback();  //回滚
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
	//查-----根据客户id和机票id查找购买信息
	public Vector<TicketpurchaseDTO> findTicketpurchaseInfoById(String cid,String tid) {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();		   
		    stat = conn.createStatement(); //创建SQL语句且执行
		    String sql = "select * from ticketpurchase where cid = '"+cid+"' and tid = '"+tid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setTid(rs.getString("tid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
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
	//根据用户ID查机票信息
	public Vector<TicketpurchaseDTO> findTicketpurchaseInfoByCid(String cid) {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();		   
		    stat = conn.createStatement(); //创建SQL语句且执行
		    String sql = "select * from ticketpurchase where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setTid(rs.getString("tid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
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
	
	//查找所有机票购买信息
	public Vector<TicketpurchaseDTO> findAllTicketpurchasetInfo() {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//泛型容器
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //创建SQL语句且执行
		    stat = conn.createStatement();
		    String sql = "select * from ticketpurchase";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//处理结果集
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setTid(rs.getString("tid"));
		    	s.setCid(rs.getString("cid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
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
	//改
	public boolean updateTicketpurchasenInfo(TicketpurchaseDTO tdto){
		boolean flag = false;
		String tid = tdto.getTid();
		String cid = tdto.getCid();
		String purchaseDate = tdto.getPurchaseDate();
		int status = tdto.getStatus();
		String sql = "update ticketpurchase set cid='"+cid+"',"+ "tid='"+tid+"',"+ ""+"purchaseDate='"+purchaseDate+"',status='"+status+"' where cid = '"+cid+"' and tid = '"+tid+"'";
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
