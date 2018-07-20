package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.ClientDAO;
import cn.edu.lingnan.dao.TicketDAO;
import cn.edu.lingnan.dao.TicketpurchaseDAO;

public class ClientTicketpurchaseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("����ClientTicketpurchase");
		int i = 0;
		String[] str = new String[20];
		
		//���cid���̣���LoginServlet�л�ȡcid,��cid����showAllTicket.jspҳ�棬�ٴӴ�ҳ�洫�뵽����
		String cid =(String)req.getSession().getAttribute("cid");
	//	System.out.println(cid); 
		
		//��showAllTicket.jspҳ���ȡ����ʱ���tid
		String[] arr = req.getParameterValues("arr");
		
		TicketpurchaseDAO tdao = new TicketpurchaseDAO();
		int status = 0;
		for(String a : arr){                        //һ���û�����һ�������Ʊ
		//	System.out.println(a);
			String[] b = a.split(",");
			String purchaseDate = a.substring(a.indexOf("/")+1);
	//		System.out.println("time="+a.substring(a.indexOf("/")+1));//���ϵͳʱ�䣬��/��Ϊtid��ʱ��ķ����־
			for(String c : b){
				//System.out.println(c);
				if(c.indexOf("/") != -1){
					 c = c.substring(0, c.indexOf("/")); //���һ��tid��"/",ȥ�����tid
				}
				boolean flag = tdao.insertIntoTicketpurchase(cid, c, purchaseDate, status);
								
				System.out.println(c);
				
//				str[i] = c;				
//				System.out.println("str["+i+"]"+str[i]);
//				i++;
//				HttpSession s = req.getSession();
//				s.setAttribute("tid", str[i]);
			}
		}
		
		resp.sendRedirect(req.getContextPath()+"/showAllTicket.jsp"); 
	}
}
