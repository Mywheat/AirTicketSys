package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.TicketDTO;

public class DeleteTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String[] arr = req.getParameterValues("arr");		  
		System.out.println("从showAllTicket.jsp页面获得需删除的cid为："+arr);
		TicketDAO tdao = new TicketDAO();;
    	for(String d : arr){
    		boolean flag =  tdao.deleteTicketById(d);
		}
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //接着解决如何传到前面去
		System.out.println("删除成功");
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每种而言
	    s.setAttribute("allticket", v); //东西都放到这里，前面就可以用了
		resp.sendRedirect("jsp/showAllTicket.jsp");
	}
}
