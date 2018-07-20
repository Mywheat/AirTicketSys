package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;

public class SearchTicketServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("来到SearchTicketServlet");
		String destination = req.getParameter("destination");
		//获得用户权限
		HttpSession s = req.getSession();    //（2）通过session获得想要的值
	    Integer superValue = (Integer)s.getAttribute("superValue");//是ojbect，要强制类型转换
	//  System.out.println(superValue);	    	    
	//	System.out.println(destination);
		
	    TicketDAO tdao = new TicketDAO();
	    Vector<TicketDTO> v = new Vector<TicketDTO>();
	    v = tdao.findTicketInfoByDestination(destination);
	 //   HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("search", v); //东西都放到这里，前面就可以用了
	    if(superValue == 1){
	    	resp.sendRedirect("admin/jsp/searchTicketByAdmin.jsp");
	    }
	    else{	    	
	    	resp.sendRedirect("searchTicket.jsp");//查找完了之后，把页面切过去，去jsp页面
	    }
	    	
	}
}
