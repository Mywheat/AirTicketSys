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
		System.out.println("来到FindClientTicketServlet");
		String cid= (String)req.getSession().getAttribute("cid");
		System.out.println("cid="+cid);
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findTicketpurchaseInfoByCid(cid);//接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
		s.setAttribute("clientTicket", v);
		resp.sendRedirect("clientTicket.jsp");
	}
}
