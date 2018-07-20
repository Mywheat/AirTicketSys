package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.TicketpurchaseDAO;

public class ClientTicketpurchaseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("来到ClientTicketpurchase");
		int i = 0;
		String[] str = new String[20];
		
		//获得cid过程：从LoginServlet中获取cid,把cid传到showAllTicket.jsp页面，再从此页面传入到这里
		String cid =(String)req.getSession().getAttribute("cid");
	//	System.out.println(cid); 
		
		//从showAllTicket.jsp页面获取购买时间和tid
		String[] arr = req.getParameterValues("arr");
		
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		int status = 0;
		for(String a : arr){                        //一个用户可以一次买多种票
		//	System.out.println(a);
			String[] b = a.split(",");
			String purchaseDate = a.substring(a.indexOf("/")+1);
	//		System.out.println("time="+a.substring(a.indexOf("/")+1));//获得系统时间，用/作为tid与时间的分离标志
			for(String c : b){
				//System.out.println(c);
				if(c.indexOf("/") != -1){
					 c = c.substring(0, c.indexOf("/")); //最后一个tid含"/",去除获得tid
				}
				boolean flag = tdao.insertIntoTicketpurchase(cid, c, purchaseDate, status);
								
				System.out.println(c);
				
//				str[i] = c;				
//				System.out.println("str["+i+"]"+str[i]);
//				i++;
//				HttpSession s = req.getSession();
//				s.setAttribute("tid", str[i]);
			}
		}
		
		resp.sendRedirect(req.getContextPath()+"/showAllTicket.jsp"); 
	}
}
