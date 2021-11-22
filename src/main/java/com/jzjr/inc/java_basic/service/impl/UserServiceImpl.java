package com.jzjr.inc.java_basic.service.impl;

import com.jzjr.inc.java_basic.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void doHttp(ServletRequest servletRequest, ServletResponse servletResponse) {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String method = request.getMethod();
        System.out.println("Method:\t"+method);
        String contextPath = request.getContextPath();
        System.out.println("contextPath:\t"+contextPath);
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr:\t"+remoteAddr);
        int serverPort = request.getServerPort();
        System.out.println("serverPort:\t"+serverPort);
        String characterEncoding = request.getCharacterEncoding();
        System.out.println("characterEncoding:\t"+characterEncoding);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI:\t"+requestURI);
        boolean secure = request.isSecure();
        System.out.println("secure:\t"+secure);
        String salt = request.getHeader("salt");
        System.out.println("salt:\t"+salt);

    }
}
