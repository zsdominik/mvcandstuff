package com.zsirosd.mvcandstuff.config;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  public void onStartup(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

    context.scan("com.zsirosd.mvcandstuff");

    servletContext.addListener(new ContextLoaderListener(context));

    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }

  @Override
  protected String[] getServletMappings() {
    return new String[0];
  }

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[0];
  }

  @Override
  protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
    final DispatcherServlet dispatcherServlet = (DispatcherServlet) super.createDispatcherServlet(servletAppContext);
    dispatcherServlet.setThrowExceptionIfNoHandlerFound(true); // why is this not working?
    return dispatcherServlet;
  }
}
