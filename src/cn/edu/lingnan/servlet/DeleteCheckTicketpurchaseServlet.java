package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class DeleteCheckTicketpurchaseServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("77777777777");
		String[] arr = req.getParameterValues("arr");
		for(String d : arr){
    		System.out.println(d);
		}
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		for(String a : arr){
			String[] b = a.split(",");
			System.out.println("DeleteCheckServlet从面获取数据为:"+b);
			for(int i = 0;i<b.length;i=i+2){
	    		String cid = b[i];
	    		String tid = b[i+1];
	    		System.out.println(cid+tid);	
	    		tdao.deleteTicketpurchaseId(cid, tid);
			}						
		}
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allTicketpurchase", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//查找完了之后，把页面切过去，去jsp页面 
	}

}
