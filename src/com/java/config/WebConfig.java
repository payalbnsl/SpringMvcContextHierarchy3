package com.java.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

//Don't use @Configuration
//Equivalent of web.xml

public class WebConfig extends AbstractDispatcherServletInitializer{


	protected WebApplicationContext createRootApplicationContext() {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.register(new Class[] {RootConfig.class});
		//Servlet context already set
		//ctx.setServletContext(servletContext);
		/*Not needed to add contextListener here*/
	//	servletContext.addListener(new ContextLoaderListener(ctx));
		//each dispatcher servlet having own child context
	
		return ctx;
	}

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
		ctx.register(SpringConfig.class);
		
		return ctx;
		/*	By-default it is true here
		servletOne.setAsyncSupported(true);
		*/
	}

	/*Url mapping for child app context i.e. for Dispatcher servlet*/
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
