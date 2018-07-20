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
		//1.��ҳ���ȡ������Ҫ������,5��
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
		System.out.println("��ע��ҳ���ȡ����Ϊ:"+cid+"  "+cname+"  "+tel+"  "+password+"  "+superuser+"  "+status);
		//2.�������ݣ����ú�̨��ҵ���߼�ȥ����DAO����ķ�����
	    ClientDAO cd = new ClientDAO();
	    ClientDTO cdto = new ClientDTO();
	    cdto.setCid(cid);
	    cdto.setCname(cname);
	    cdto.setTel(tel);
	    cdto.setPassword(password);
	    cdto.setSuperpassword(superuser);
	    cdto.setStatus(status);
		boolean flag =cd.inserttoClient(cdto);  
		//3.���ݽ��ȥ����Ӧ��ҳ��
		if(flag)
		    resp.sendRedirect(req.getContextPath()+"/index.html"); 
	    else
		    resp.sendRedirect(req.getContextPath()+"/error.html"); 
	}
}
