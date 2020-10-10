package com.raghu.springsecurity.log;/*
@author raghu created on 10/9/2020 
inside the package -PACKAGE_NAME
*/


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class LoggingFilter implements Filter {

    private final Log log = LogFactory.getLog(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        Assert.isTrue(request instanceof HttpServletRequest, "assumes you have HTTP request");
        String val = ((HttpServletRequest) request)
                .getRequestURL().toString();
        log.info("new request to the url" + val);
        long startTime = System.currentTimeMillis();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        log.info("process time for URI" + val+ "in milli seconds"+(endTime - startTime));

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
