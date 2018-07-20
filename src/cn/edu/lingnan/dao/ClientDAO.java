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
	
	//��-------��ͻ���ȫ���ͻ�������
	public Vector<ClientDTO> findAllClientInfo() {
		Vector<ClientDTO> v = new Vector<ClientDTO>();//��������
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //����SQL�����ִ��
		    stat = conn.createStatement();
		    String sql = "select * from client";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//��������
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //ע�ⷵ��
	}
	//��-----����id���ҿͻ���Ϣ
	public Vector<ClientDTO> findClientInfoById(String cid) {
		Vector<ClientDTO> v = new Vector<ClientDTO>();//��������
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
		    //����SQL�����ִ��
		    stat = conn.createStatement();
		    String sql = "select * from client where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql);
		    while(rs.next()){//��������
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, rs);
		}
		return v;  //ע�ⷵ��
	}
	//�ж��û���¼ʱ�Ƿ���ȷ
	public int findClientBynameAndPassword(String cname,String password){
		int superValue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
            prep = conn.prepareStatement
            		("select * from client where cname = ? and password = ?");
            //����
            prep.setString(1,cname);
			prep.setString(2,password);
			rs = prep.executeQuery();
			if (rs.first()){
				superValue=Integer.parseInt(rs.getString("superpassword"));
			    System.out.println("---1---"+superValue);
			}
		}
		catch (SQLException e) {
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return superValue;
    }
	//����������ID
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return cid;
    }
	//�ж���ɾ���û��Ƿ��ܵ�¼
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, rs);
		}
		return status;
    }
	
	//��-----���ӿͻ���Ϣ
	public boolean insertIntoClient(String cid,String cname,String tel,String password,String superpassword,int status){
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		try {
				conn = DataAccess.getConnection();
			    prep = conn.prepareStatement("insert into client values(?,?,?,?,?,?)");//����SQL�����ִ��
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, null, prep, null); //�ر����ݿ�����
		}
		return flag;
	}
	//��-register
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //�ر����ݿ�����
		}
		return flag;
	}

	//ɾ--------����idɾ���ͻ���Ϣ����ɾ����
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
		    conn = DataAccess.getConnection(); //����SQL�����ִ��
		    stat = conn.createStatement();
		    stat1 = conn.createStatement();
		    sql2 = "select * from ticketpurchase where cid = '"+cid+"'";
		    rs = stat.executeQuery(sql2);
		    String tid = null;
		    HashSet<String> hs = new HashSet<String>(); //��ϣ��
		    while(rs.next()){
		    	tid = rs.getString(2);
		    	sql3 = "select count(*) as num from ticketpurchase where tid = '"+tid+"'";
		    	rs1 = stat1.executeQuery(sql3);
		    	rs1.next();
		    	if(rs1.getInt("num")==1){ //����Ʊ�������ͬ�ֻ�Ʊ��tidֻ��һ��
		    		hs.add(tid);
//		    		stat.executeUpdate("delete from ticketpurchase where tid = '"+tid+"'");
//		    		stat.executeUpdate("delete from ticket where tid = '"+tid+"'");
		    	}
		    	rs.next();
		    	rs1.close();
		    }
		    
		    conn.setAutoCommit(false); 
//			stat.executeUpdate("delete from ticketpurchase where cid = '"+id+"'"); //1.ɾ��Ʊ�������Ϣ
//		    stat.executeUpdate("delete from client where cid = '"+id+"'");  //2.ɾ�ͻ���Ϣ
		    stat.executeUpdate("update ticketpurchase set status = '1' where cid = '"+cid+"'");
		    stat.executeUpdate("update client set status = '1' where cid = '"+cid+"'");
		    Iterator<String> it = hs.iterator();
		    while(it.hasNext()){
//		    	stat.executeUpdate("delete from ticket where tid = '"+it.next()+"'"); //ɾû�˳����ķɻ��Ļ�Ʊ��Ϣ
		    	stat.executeUpdate("update ticket set status = '1' where tid = '"+it.next()+"'");   
		    }
		    conn.commit();  //�ύ
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
			DataAccess.closeconn(conn, stat, null, rs); //�ر����ݿ�����
		}
		return flag;
	}
	//��----����id���ĵ绰
	public boolean updateClientTelById(String id,String tel){
		boolean flag = false;
		Connection conn = null;
		Statement stat = null;
		try {
		    conn = DataAccess.getConnection();    //����SQL�����ִ��
		    stat = conn.createStatement();
			String sql = "update client set tel = '"+tel+"' where cid='"+id+"'";
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
	//�޸�
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
			System.out.println("����SQL�����ִ���");
			e.printStackTrace();
		}
		finally{
			DataAccess.closeconn(conn, stat, null, null); //�ر����ݿ�����
		}
		return flag;
	}
	
}
