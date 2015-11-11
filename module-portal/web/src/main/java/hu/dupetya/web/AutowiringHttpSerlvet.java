package hu.dupetya.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public abstract class AutowiringHttpSerlvet extends HttpServlet {

	private static final long serialVersionUID = -4862074590400316571L;

	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		wac.getAutowireCapableBeanFactory().autowireBean(this);
	}

	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}
