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
		System.out.println("�ɹ�����UpdateUserByself");
		String cid = req.getParameter("cid");
		String cname = req.getParameter("cname");
		String tel = req.getParameter("tel");
		String password = req.getParameter("password");
		String superuser = req.getParameter("superuser");
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("���޸�ҳ���ȡ������Ϊ��"+cid+"   "+cname+"   "+tel+"    "+password+"   "+superuser+"   "+status);
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
		v = cdao.findAllClientInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("oneuser", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("clientInfo.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
