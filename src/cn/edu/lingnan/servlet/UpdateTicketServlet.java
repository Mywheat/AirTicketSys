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

public class UpdateTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tid = req.getParameter("tid");
		String flightNumber = req.getParameter("flightNumber");
		String destination = req.getParameter("destination");
		String offDate = req.getParameter("offDate");
		String price = req.getParameter("price");
		String allowance0 = req.getParameter("allowance");
		int allowance = Integer.parseInt(allowance0);
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("从修改机票页面获取的数据为："+tid+"   "+flightNumber+"   "+destination+"    "+offDate+"   "+price+"   "+allowance+"   "+status);
	    TicketDTO tdto = new TicketDTO();
	    TicketDAO tdao = new TicketDAO();
	    tdto.setTid(tid);
	    tdto.setFlightNumber(flightNumber);
	    tdto.setDestination(destination);
	    tdto.setOffDate(offDate);
	    tdto.setPrice(price);
	    tdto.setAllowance(allowance);
	    tdto.setStatus(status);
	    boolean flag = tdao.updateTicketInfo(tdto);
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allticket", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("jsp/showAllTicket.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
