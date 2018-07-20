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

public class FindTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("成功来到FindTicket");
		TicketDAO tdao = new TicketDAO();
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //接着解决如何传到前面去
		
		for(TicketDTO ct : v){
		    System.out.println("id:"+ct.getTid());
	    }
		
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allticket", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("showAllTicket.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
