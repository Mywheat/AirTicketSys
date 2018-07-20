package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;

public class SearchOneUserByAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����AdminFindOneUser");
		String cid = req.getParameter("cid");
		System.out.println(cid);
		ClientDAO cdao = new ClientDAO();
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findClientInfoById(cid);
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("searchUser",v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/searchUser.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��	
	}
}
