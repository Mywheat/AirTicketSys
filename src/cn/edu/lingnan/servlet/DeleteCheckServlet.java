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

public class DeleteCheckServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		ClientDAO cdao = new ClientDAO();
		for(String a : arr){
			String[] b = a.split("/,");
			System.out.println("DeleteCheckServlet�����ȡ����Ϊ:"+a);
			System.out.println(b);			
			for(String c : b){
				String d = c.substring(0, 3);
				cdao.deleteClientById(d);
			}			
		}
		Vector<ClientDTO> v = new Vector<ClientDTO>();
		v = cdao.findAllClientInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("alluser", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/showAllUser.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
