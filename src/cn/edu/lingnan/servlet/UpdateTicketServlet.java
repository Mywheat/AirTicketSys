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

public class UpdateTicketServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tid = req.getParameter("tid");
		String flightNumber = req.getParameter("flightNumber");
		String destination = req.getParameter("destination");
		String offDate = req.getParameter("offDate");
		String price = req.getParameter("price");
		String allowance0 = req.getParameter("allowance");
		int allowance = Integer.parseInt(allowance0);
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("���޸Ļ�Ʊҳ���ȡ������Ϊ��"+tid+"   "+flightNumber+"   "+destination+"    "+offDate+"   "+price+"   "+allowance+"   "+status);
	    TicketDTO tdto = new TicketDTO();
	    TicketDAO tdao = new TicketDAO();
	    tdto.setTid(tid);
	    tdto.setFlightNumber(flightNumber);
	    tdto.setDestination(destination);
	    tdto.setOffDate(offDate);
	    tdto.setPrice(price);
	    tdto.setAllowance(allowance);
	    tdto.setStatus(status);
	    boolean flag = tdao.updateTicketInfo(tdto);
		Vector<TicketDTO> v = new Vector<TicketDTO>();
		v = tdao.findAllTicketInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allticket", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/showAllTicket.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
