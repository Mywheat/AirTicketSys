package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// �ж��û���¼Ȩ����ʲô������ǳ����û���1��,��ô����ȥ�ҵ�adminĿ¼�µ�ҳ�棬����ȥȨ�޴���ҳ��
		HttpServletRequest  request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1; //��1��ת������
		HttpSession s = request.getSession();    //��2��ͨ��session�����Ҫ��ֵ
	    Integer superValue = (Integer)s.getAttribute("superValue");//��ojbect��Ҫǿ������ת��
	    System.out.println("--3--"+superValue);//�������ڹ������Ƿ����superValueֵ
	    if(superValue != null){
		    if(superValue==0){  //��3������ֵ�жϸ�ȥ��ʲô�ط�
		        System.out.println("---4---");
		    	response.sendRedirect(request.getContextPath()+"/index.html");
		    }
		    else
		    	if(superValue==1)
		    		arg2.doFilter(arg0, arg1);
		    	else
		    		response.sendRedirect(request.getContextPath()+"/authority.html");
	    }else
	        response.sendRedirect(request.getContextPath()+"/index.html");
	    
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
