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
		System.out.println("�ɹ�����DeleteClientServlet");
		String[] arr = req.getParameterValues("arr");		  
		System.out.println("��jspҳ������ɾ����cidΪ��"+arr);
		ClientDAO cdao = new ClientDAO();
	    for(String b : arr){
	    	String[] c = b.split("/");
	    	for(String d : c){
				cdao.deleteClientById(d);
			}
	    }
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("alluser", v); //�������ŵ����ǰ��Ϳ�������
		resp.sendRedirect("jsp/showAllUser.jsp");
		
	}
}
