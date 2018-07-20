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

public class FindAllTicketpurchase extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TicketpurchaseDAO tpdao = new TicketpurchaseDAO();
		Vector<TicketpurchaseDTO> v = new Vector<TicketpurchaseDTO>();
		v = tpdao.findAllTicketpurchasetInfo(); //���Ž����δ���ǰ��ȥ
		HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("allTicketpurchase", v); //�������ŵ����ǰ��Ϳ�������
	    resp.sendRedirect("jsp/showAllTicketpurchase.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ�� 
	}
}
