package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketpurchaseDAO;
import cn.edu.lingnan.dto.TicketpurchaseDTO;

public class InsertTicketpurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("00000000000000");
		String cid = req.getParameter("cid");
		String tid = req.getParameter("tid");
		String purchaseDate = req.getParameter("purchaseDate");
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("���޸�ҳ���ȡ������Ϊ��"+cid+"   "+tid+"   "+purchaseDate+"   "+status);
	    TicketpurchaseDTO tdto = new TicketpurchaseDTO();
	    TicketpurchaseDAO tdao = new TicketpurchaseDAO();
	    tdto.setCid(cid);
	    tdto.setTid(tid);
	    tdto.setPurchaseDate(purchaseDate);
	    tdto.setStatus(status);
	    String flag = tdao.insertTicketpurchase(tdto);
	    System.out.println(flag);
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allTicketpurchase", v); //�������ŵ����ǰ��Ϳ�������
	    s.setAttribute("allowance", flag);
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
