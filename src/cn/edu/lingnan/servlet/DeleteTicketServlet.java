package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.TicketDTO;

public class DeleteTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String[] arr = req.getParameterValues("arr");		  
		System.out.println("��showAllTicket.jspҳ������ɾ����cidΪ��"+arr);
		TicketDAO tdao = new TicketDAO();;
    	for(String d : arr){
    		boolean flag =  tdao.deleteTicketById(d);
		}
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //���Ž����δ���ǰ��ȥ
		System.out.println("ɾ���ɹ�");
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ�ֶ���
	    s.setAttribute("allticket", v); //�������ŵ����ǰ��Ϳ�������
		resp.sendRedirect("jsp/showAllTicket.jsp");
	}
}
