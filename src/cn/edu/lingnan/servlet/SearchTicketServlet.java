package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dto.ClientDTO;
import cn.edu.lingnan.dto.TicketDTO;

public class SearchTicketServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����SearchTicketServlet");
		String destination = req.getParameter("destination");
		//����û�Ȩ��
		HttpSession s = req.getSession();    //��2��ͨ��session�����Ҫ��ֵ
	    Integer superValue = (Integer)s.getAttribute("superValue");//��ojbect��Ҫǿ������ת��
	//  System.out.println(superValue);	    	    
	//	System.out.println(destination);
		
	    TicketDAO tdao = new TicketDAO();
	    Vector<TicketDTO> v = new Vector<TicketDTO>();
	    v = tdao.findTicketInfoByDestination(destination);
	 //   HttpSession s = req.getSession(); //��ǰ�˿������session,session�Ƕ�ÿ���û�����
	    s.setAttribute("search", v); //�������ŵ����ǰ��Ϳ�������
	    if(superValue == 1){
	    	resp.sendRedirect("admin/jsp/searchTicketByAdmin.jsp");
	    }
	    else{	    	
	    	resp.sendRedirect("searchTicket.jsp");//��������֮�󣬰�ҳ���й�ȥ��ȥjspҳ��
	    }
	    	
	}
}
