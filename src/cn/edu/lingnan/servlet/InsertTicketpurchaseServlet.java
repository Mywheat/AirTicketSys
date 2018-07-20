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

public class InsertTicketpurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("00000000000000");
		String cid = req.getParameter("cid");
		String tid = req.getParameter("tid");
		String purchaseDate = req.getParameter("purchaseDate");
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("从修改页面获取的数据为："+cid+"   "+tid+"   "+purchaseDate+"   "+status);
	    TicketpurchaseDTO tdto = new TicketpurchaseDTO();
	    TicketpurchaseDAO tdao = new TicketpurchaseDAO();
	    tdto.setCid(cid);
	    tdto.setTid(tid);
	    tdto.setPurchaseDate(purchaseDate);
	    tdto.setStatus(status);
	    String flag = tdao.insertTicketpurchase(tdto);
	    System.out.println(flag);
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("allTicketpurchase", v); //东西都放到这里，前面就可以用了
	    s.setAttribute("allowance", flag);
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
