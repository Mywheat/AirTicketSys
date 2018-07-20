package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
    String ecoding = null;
	@Override
	public void destroy() {
		this.ecoding = null;		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("字符编码转换过滤成功...");
		arg0.setCharacterEncoding(this.ecoding);
		arg1.setCharacterEncoding(this.ecoding);
		arg2.doFilter(arg0, arg1);		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.ecoding = arg0.getInitParameter("ecoding");		
	}

}
