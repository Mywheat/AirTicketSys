package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class DeleteTicketpurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("成功来到DeleteTicketpurchaseServlet");
//		String[] arr = req.getParameterValues("arr");		  
//		System.out.println("从showAllTicket.jsp页面获得需删除的cid为："+arr);
//		
//		TicketpurchaseDAO tdao = new TicketpurchaseDAO();;
//    	for(String d : arr){
//    		System.out.println(d);
//    		boolean flag =  tdao.deleteTicketpurchaseId(d);
//		}
		String tid = req.getParameter("tid");
		String cid = req.getParameter("cid");
		System.out.println("从showAllTicketpurchase.jsp页面获得需删除的cid和tid为："+cid+"   "+tid);
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		boolean flag = tdao.deleteTicketpurchaseId(cid, tid); //注意：之后要重新调用findAllClientInfo
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //接着解决如何传到前面去
		System.out.println("删除成功");
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每种而言
	    s.setAttribute("allTicketpurchase", v); //东西都放到这里，前面就可以用了
		resp.sendRedirect("jsp/showAllTicketpurchase.jsp");
	}
}
