package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class FindClientTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����FindClientTicketServlet");
		String cid= (String)req.getSession().getAttribute("cid");
		System.out.println("cid="+cid);
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findTicketpurchaseInfoByCid(cid);//���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
		s.setAttribute("clientTicket", v);
		resp.sendRedirect("clientTicket.jsp");
	}
}
