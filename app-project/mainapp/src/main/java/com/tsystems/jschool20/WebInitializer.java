package com.tsystems.jschool20;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class WebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
//        servletContext.setInitParameter("spring.profiles.active", "production");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{WebApplicationConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {

        return new String[]{"/"};
    }
}
