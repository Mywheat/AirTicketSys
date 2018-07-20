package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.TicketDTO;

public class DeleteCheckTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		TicketDAO tdao = new TicketDAO();
		for(String a : arr){
			String[] b = a.split(",");
			System.out.println("DeleteCheckTicketServlet从面获取数据为:"+a);
			for(String c : b){
				tdao.deleteTicketById(c);
			}
		}	
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allticket", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("jsp/showAllTicket.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
