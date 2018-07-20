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
	//��-------
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
						stat.executeUpdate("update  ticket set allowance = allowance-1 where tid = '"+tid+"'");//�����һ�Ż�Ʊ����Ʊ�������ͻ��1
						flag = "true";
				 	}
				 	else
				 		{
				 		  flag = "flase"; 
				 		}
				}
				
		}
		catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, prep, rs); //�ر����ݿ�����
		}
		return flag;
	}
	//��------�����Ʊ
	public boolean insertIntoTicketpurchase(String cid,String tid,String purchaseDate,int status){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    prep = conn.prepareStatement("insert into ticketpurchase values(?,?,?,?)");//����SQL�����ִ��
			prep.setString(1, cid);
			prep.setString(2, tid);
			prep.setString(3, purchaseDate);
			prep.setInt(4, status);		
			stat = conn.createStatement();		
			rs = stat.executeQuery("select allowance from ticket where tid = '"+tid+"'");//��ѯ��Ʊ������
			rs.next(); 
			if(rs.getInt("allowance")>0){ 
				prep.executeUpdate();
				stat.executeUpdate("update  ticket set allowance = allowance-1 where tid = '"+tid+"'");//�����һ�Ż�Ʊ����Ʊ�������ͻ��1
			    flag = true;
			}
			else
				flag = false;
		    
		}
		catch (SQLException e) {
			System.out.println("SQL������д���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs); //�ر����ݿ�����
		}
		return flag;
	}
	
	//ɾ--------����cid��tidɾ����Ʊ�������Ϣ����ɾ����
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
		    conn = DataAccess.getConnection(); //����SQL�����ִ��
		    stat = conn.createStatement();
		    stat1 = conn.createStatement();
		    sql2 = "select * from ticketpurchase where tid = '"+tid+"'"; //��Ի�Ʊ��ע����tid,����cid
		    rs = stat.executeQuery(sql2);
		    HashSet<String> hs = new HashSet<String>(); //��ϣ��
		    while(rs.next()){
		    	tid = rs.getString(2);
		    	status = rs.getInt(4);
		    	sql3 = "select count(*) as num from ticketpurchase where tid = '"+tid+"' and status=0";//ע��Ҫ��status=0������£����ü�¼δ����ɾ�������
		    	rs1 = stat1.executeQuery(sql3);
		    	rs1.next();
		    	if(rs1.getInt("num")==1){ //����Ʊ�������ͬ�ֻ�Ʊ��tidֻ��һ��
		    		hs.add(tid);
		    	}   	
		//    	System.out.println("----"+rs1.getInt("num"));
		    	rs1.close();
		    }
		    
	    	conn.setAutoCommit(false); 
	  //  	System.out.println("--11111--"+cid+tid); //���Դ�������Ĳ���ֵ��û�иı�
		    stat.executeUpdate("update ticketpurchase set status = 1 where cid = '"+cid+"' and tid = '"+tid+"'");		     
			stat.executeUpdate("update  ticket set allowance = allowance+1 where tid = '"+tid+"'");//ɾ��һ���ѹ���Ļ�Ʊ����Ʊ�������ͻ��1		
		    Iterator<String> it = hs.iterator();
		    while(it.hasNext()){
		    	stat.executeUpdate("update ticket set status = 1 where tid = '"+it.next()+"'");  //ɾû�˳����ķɻ��Ļ�Ʊ��Ϣ 
		    }
		    conn.commit();  //�ύ
		    conn.setAutoCommit(true);
	        flag = true;
		}
		catch (SQLException e) {
			try {
				conn.rollback();  //�ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs); //�ر����ݿ�����
		}
		return flag;
	}
	//��-----���ݿͻ�id�ͻ�Ʊid���ҹ�����Ϣ
	public Vector<TicketpurchaseDTO> findTicketpurchaseInfoById(String cid,String tid) {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//��������
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();		   
		    stat = conn.createStatement(); //����SQL�����ִ��
		    String sql = "select * from ticketpurchase where cid = '"+cid+"' and tid = '"+tid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//��������
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setTid(rs.getString("tid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
		    	s.setStatus(rs.getInt("status"));
		    	v.add(s);
		    	}
		}
		catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //ע�ⷵ��
	}
	//�����û�ID���Ʊ��Ϣ
	public Vector<TicketpurchaseDTO> findTicketpurchaseInfoByCid(String cid) {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//��������
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();		   
		    stat = conn.createStatement(); //����SQL�����ִ��
		    String sql = "select * from ticketpurchase where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//��������
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setCid(rs.getString("cid"));
		    	s.setTid(rs.getString("tid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
		    	s.setStatus(rs.getInt("status"));
		    	v.add(s);
		    	}
		}
		catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //ע�ⷵ��
	}
	
	//�������л�Ʊ������Ϣ
	public Vector<TicketpurchaseDTO> findAllTicketpurchasetInfo() {
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();//��������
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //����SQL�����ִ��
		    stat = conn.createStatement();
		    String sql = "select * from ticketpurchase";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//��������
		    	TicketpurchaseDTO s = new TicketpurchaseDTO();
		    	s.setTid(rs.getString("tid"));
		    	s.setCid(rs.getString("cid"));
		    	s.setPurchaseDate(rs.getString("purchaseDate"));
		    	s.setStatus(rs.getInt("status"));
		    	v.add(s);
		    	}
		}
		catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //ע�ⷵ��
	}
	//��
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //�ر����ݿ�����
		}
		return flag;
	}
}
