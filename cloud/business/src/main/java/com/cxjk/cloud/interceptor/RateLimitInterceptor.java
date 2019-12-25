package com.cxjk.cloud.interceptor;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author
 * @package com.cxjk.cloud.interceptor
 * @description 限流Filteer
 * @create 2019-12-24 11:13
 **/
@WebFilter(filterName = "tokenFilter", urlPatterns = "/apis/*")
public class RateLimitInterceptor implements Filter {
    //每秒发几个的令牌数量
    public static final int REQUEST_COUNT = 10;
    /*** set the number of requests per second */
    private static final RateLimiter rateLimiter = RateLimiter.create(REQUEST_COUNT);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (!rateLimiter.tryAcquire()) {
            //如果限流成功就会返回403，请求超时
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            System.out.println(">>>>>>>>>> 亲！接口限流,请稍后重试！");
            return;
        }
        System.out.println(">>>>>>>> 恭喜通过的限流接口！");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
