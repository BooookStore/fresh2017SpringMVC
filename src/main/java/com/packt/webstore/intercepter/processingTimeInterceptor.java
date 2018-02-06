package com.packt.webstore.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class processingTimeInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(processingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        long startTime = System.currentTimeMillis();
        httpServletRequest.setAttribute("startTime", startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String queryString = httpServletRequest.getQueryString() == null ? "" : "?" + httpServletRequest.getQueryString();
        String path = httpServletRequest.getRequestURL() + queryString;
        long startTime = (Long)httpServletRequest.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        LOGGER.info(String.format("%s millisecond taken to process the request %s.", (endTime - startTime), path));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
