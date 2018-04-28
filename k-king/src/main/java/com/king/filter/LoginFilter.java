package com.king.filter;

import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author King
 * @date 2017/11/27
 */
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;

        if(request.getRequestURI().indexOf("user/login") != -1){
            filterChain.doFilter(request,response);
            return;
        }

        String username = (String) request.getSession().getAttribute("LoginName");
        if(StringUtils.isEmpty(username)){
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            //response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
