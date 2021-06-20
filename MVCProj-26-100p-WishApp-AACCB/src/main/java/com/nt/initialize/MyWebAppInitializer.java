package com.nt.initialize;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCConfig;

public class MyWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		//create Parent IOC container
		AnnotationConfigWebApplicationContext pCtx=new AnnotationConfigWebApplicationContext();
		pCtx.register(RootAppConfig.class);
		ContextLoaderListener listener = new ContextLoaderListener(pCtx);
		sc.addListener(listener);
		
		//create Child IOC container
		AnnotationConfigWebApplicationContext cCtx=new AnnotationConfigWebApplicationContext();
		cCtx.register(WebMVCConfig.class);
		DispatcherServlet servlet= new DispatcherServlet(cCtx);
		ServletRegistration.Dynamic dyna=sc.addServlet("ds", servlet);
		dyna.addMapping("/");
		dyna.setLoadOnStartup(2);
	}
/*public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		
		return new Class[] {WebMVCConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"/"};
	}
	*/
	
}
