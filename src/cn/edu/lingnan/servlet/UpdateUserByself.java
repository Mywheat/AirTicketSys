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

public class UpdateUserByself extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("成功来到UpdateUserByself");
		String cid = req.getParameter("cid");
		String cname = req.getParameter("cname");
		String tel = req.getParameter("tel");
		String password = req.getParameter("password");
		String superuser = req.getParameter("superuser");
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("从修改页面获取的数据为："+cid+"   "+cname+"   "+tel+"    "+password+"   "+superuser+"   "+status);
	    ClientDTO cdto = new ClientDTO();
	    ClientDAO cdao = new ClientDAO();
	    cdto.setCid(cid);
	    cdto.setCname(cname);
	    cdto.setTel(tel);
	    cdto.setPassword(password);
	    cdto.setSuperpassword(superuser);
	    cdto.setStatus(status);
	    boolean flag = cdao.updateClientInfo(cdto);
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("oneuser", v); //东西都放到这里，前面就可以用了
	    resp.sendRedirect("clientInfo.jsp");//查找完了之后，把页面切过去，去jsp页面
	}
}
