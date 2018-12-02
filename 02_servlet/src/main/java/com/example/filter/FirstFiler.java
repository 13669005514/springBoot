package com.example.filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/1 14:58
 */
@WebFilter(filterName="filter",urlPatterns = {"/*"})
public class FirstFiler implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("进入过滤器中。。。。。");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("正在处理请求。。。。");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("请求处理已结束.......");
    }
}
