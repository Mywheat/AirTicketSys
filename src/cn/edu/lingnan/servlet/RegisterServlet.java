package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dto.ClientDTO;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1.从页面获取我们想要的数据,5个
		String cid = null;
		String cname = null;
		String tel = null;
		String password = null;
		String superpassword = null;
		String superuser = null;
		int status = 0;
		cid = req.getParameter("cid");
		cname = req.getParameter("username");
		tel = req.getParameter("tel");
		password = req.getParameter("password");
		superuser =req.getParameter("superuser");
		status = Integer.parseInt(req.getParameter("status"));
		System.out.println("从注册页面获取数据为:"+cid+"  "+cname+"  "+tel+"  "+password+"  "+superuser+"  "+status);
		//2.处理数据：调用后台的业务逻辑去处理（DAO里面的方法）
	    ClientDAO cd = new ClientDAO();
	    ClientDTO cdto = new ClientDTO();
	    cdto.setCid(cid);
	    cdto.setCname(cname);
	    cdto.setTel(tel);
	    cdto.setPassword(password);
	    cdto.setSuperpassword(superuser);
	    cdto.setStatus(status);
		boolean flag =cd.inserttoClient(cdto);  
		//3.根据结果去到相应的页面
		if(flag)
		    resp.sendRedirect(req.getContextPath()+"/index.html"); 
	    else
		    resp.sendRedirect(req.getContextPath()+"/error.html"); 
	}
}
