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
		System.out.println("�ɹ�����FindAllUser");
		String id= (String)req.getSession().getAttribute("cid");
		System.out.println("id="+id);	
		ClientDAO cdao = new ClientDAO();
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("alluser", v); //�������ŵ����ǰ��Ϳ�������
	    s.setAttribute("exceptid", id);
	    s.setAttribute("exceptid", id);
	    resp.sendRedirect("jsp/showAllUser.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
