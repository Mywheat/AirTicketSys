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
		// 判断用户登录权限是什么，如果是超级用户（1）,那么可以去找到admin目录下的页面，否则去权限错误页面
		HttpServletRequest  request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1; //（1）转换参数
		HttpSession s = request.getSession();    //（2）通过session获得想要的值
	    Integer superValue = (Integer)s.getAttribute("superValue");//是ojbect，要强制类型转换
	    System.out.println("--3--"+superValue);//检验我在过滤器是否读到superValue值
	    if(superValue != null){
		    if(superValue==0){  //（3）根据值判断该去向什么地方
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
