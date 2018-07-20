package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.TicketDTO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class DeleteTicketpurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("�ɹ�����DeleteTicketpurchaseServlet");
//		String[] arr = req.getParameterValues("arr");		  
//		System.out.println("��showAllTicket.jspҳ������ɾ����cidΪ��"+arr);
//		
//		TicketpurchaseDAO tdao = new TicketpurchaseDAO();;
//    	for(String d : arr){
//    		System.out.println(d);
//    		boolean flag =  tdao.deleteTicketpurchaseId(d);
//		}
		String tid = req.getParameter("tid");
		String cid = req.getParameter("cid");
		System.out.println("��showAllTicketpurchase.jspҳ������ɾ����cid��tidΪ��"+cid+"   "+tid);
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		boolean flag = tdao.deleteTicketpurchaseId(cid, tid); //ע�⣺֮��Ҫ���µ���findAllClientInfo
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //���Ž����δ���ǰ��ȥ
		System.out.println("ɾ���ɹ�");
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ�ֶ���
	    s.setAttribute("allTicketpurchase", v); //�������ŵ����ǰ��Ϳ�������
		resp.sendRedirect("jsp/showAllTicketpurchase.jsp");
	}
}
