package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.TicketDTO;

public class FindTicket extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("�ɹ�����FindTicket");
		TicketDAO tdao = new TicketDAO();
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //���Ž����δ���ǰ��ȥ
		
		for(TicketDTO ct : v){
		    System.out.println("id:"+ct.getTid());
	    }
		
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allticket", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("showAllTicket.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
