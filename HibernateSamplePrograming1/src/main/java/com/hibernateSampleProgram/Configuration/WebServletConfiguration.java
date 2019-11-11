package com.hibernateSampleProgram.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebServletConfiguration implements WebApplicationInitializer
{
	public void onStartup(ServletContext ctx) throws ServletException
	{
		AnnotationConfigWebApplicationContext Webctx = new AnnotationConfigWebApplicationContext();
		Webctx.register(AppConfig.class);
		Webctx.setServletContext(ctx);
		ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(Webctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
