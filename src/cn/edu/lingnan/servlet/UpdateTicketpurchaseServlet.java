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

public class UpdateTicketpurchaseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ggggggggggggggggggggg");
		String tid = req.getParameter("tid");
		String cid = req.getParameter("cid");
		String purchaseDate = req.getParameter("purchaseDate");
		String status0 = req.getParameter("status");
		int status = Integer.parseInt(status0);
		System.out.println("���޸Ļ�Ʊ����ҳ���ȡ������Ϊ��"+tid+"   "+cid+"   "+purchaseDate+"    "+status);
	    TicketpurchaseDTO tdto = new TicketpurchaseDTO();
	    TicketpurchaseDAO tdao = new TicketpurchaseDAO();
	    tdto.setTid(tid);
	    tdto.setCid(cid);;
	    tdto.setPurchaseDate(purchaseDate);;
	    tdto.setStatus(status);
	    boolean flag = tdao.updateTicketpurchasenInfo(tdto);
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tdao.findAllTicketpurchasetInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allTicketpurchase", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	}
}
