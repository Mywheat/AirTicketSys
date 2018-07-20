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

public class FindAllTicketpurchase extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tpdao.findAllTicketpurchasetInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allTicketpurchase", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//查找完了之后，把页面切过去，去jsp页面 
	}
}
