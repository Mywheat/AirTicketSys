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

public class DeleteCheckTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String[] arr = req.getParameterValues("arr");
		TicketDAO tdao = new TicketDAO();
		for(String a : arr){
			String[] b = a.split(",");
			System.out.println("DeleteCheckTicketServlet�����ȡ����Ϊ:"+a);
			for(String c : b){
				tdao.deleteTicketById(c);
			}
		}	
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allticket", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/showAllTicket.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
