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

public class DeleteClientServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("成功来到DeleteClientServlet");
		String[] arr = req.getParameterValues("arr");		  
		System.out.println("从jsp页面获得需删除的cid为："+arr);
		ClientDAO cdao = new ClientDAO();
	    for(String b : arr){
	    	String[] c = b.split("/");
	    	for(String d : c){
				cdao.deleteClientById(d);
			}
	    }
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //接着解决如何传到前面去
		HttpSession s = req.getSession(); //在前端可用这个session,session是对每个用户而言
	    s.setAttribute("alluser", v); //东西都放到这里，前面就可以用了
		resp.sendRedirect("jsp/showAllUser.jsp");
		
	}
}
