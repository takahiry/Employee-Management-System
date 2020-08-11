package com.takahiry.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //登陸成功之後，應該有用戶的session；
        Object loginUser = request.getSession().getAttribute("loginUser") ;

        if( loginUser == null) {//沒有登陸
            request.setAttribute("msg","沒有權限，請先登陸");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false ;
        }
        else {
            return true ;
        }
    }
}
