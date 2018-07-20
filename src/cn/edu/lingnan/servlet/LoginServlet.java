package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        //1.��ҳ���ȡ������Ҫ������
		String cname = null;
		String password = null;
		cname = req.getParameter("username");
		password = req.getParameter("password");
		System.out.println("�ӵ�½ҳ���ȡ����Ϊ:"+cname+"  "+password);		
		//2.�������ݣ����ú�̨��ҵ���߼�ȥ����DAO����ķ�����
	    ClientDAO cd = new ClientDAO();
	    int status = cd.findClientByStatus(cname);
	    
	    if(status == 1){
	    	System.out.println("eeeee");
	    	HttpSession s1 = req.getSession(); //�Ự
			s1.setAttribute("status", status);
			resp.sendRedirect(req.getContextPath()+"/noUser.html");
	    }
	    else{
			int superValue =cd.findClientBynameAndPassword(cname, password);
		    System.out.println("--2--��"+superValue);
			HttpSession s = req.getSession(); //�Ự
			s.setAttribute("superValue", superValue);					
			String cid = cd.findClientByCname(cname);
			System.out.println("��¼servlet��õ�cid:"+cid);
			s.setAttribute("cid", cid);
			s.setAttribute("cname", cname);
			System.out.println(cname);
			
			if(superValue != 0){//���ݽ��ȥ����Ӧ��ҳ��
				if(superValue == 1){
					resp.sendRedirect(req.getContextPath()+"/admin/index.jsp");
				}
				else{
			        resp.sendRedirect(req.getContextPath()+"/main.jsp"); 			       					
				}
			}
		    else{
			    resp.sendRedirect(req.getContextPath()+"/error.html"); 	
		    }
	    }
	}

}
