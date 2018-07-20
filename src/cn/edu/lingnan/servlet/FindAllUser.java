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

public class FindAllUser extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("成功来到FindAllUser");
		String id= (String)req.getSession().getAttribute("cid");
		System.out.println("id="+id);	
		ClientDAO cdao = new ClientDAO();
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("alluser", v); //东西都放到这里，前面就可以用了
	    s.setAttribute("exceptid", id);
	    s.setAttribute("exceptid", id);
	    resp.sendRedirect("jsp/showAllUser.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
