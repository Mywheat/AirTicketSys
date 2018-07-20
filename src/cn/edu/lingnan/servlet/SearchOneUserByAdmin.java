package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;

public class SearchOneUserByAdmin extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("来到AdminFindOneUser");
		String cid = req.getParameter("cid");
		System.out.println(cid);
		ClientDAO cdao = new ClientDAO();
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findClientInfoById(cid);
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("searchUser",v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("jsp/searchUser.jsp");//查找完了之后，把页面切过去，去jsp页面	
	}
}
