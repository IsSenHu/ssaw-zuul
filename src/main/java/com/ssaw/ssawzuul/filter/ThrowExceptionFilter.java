package com.ssaw.ssawzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 该filter会抛出异常
 * @author HuSen.
 * @date 2018/11/17 14:17.
 */
@Slf4j
@Component
public class ThrowExceptionFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        log.info("This is a filter, it will throw a RuntimeException");
        RequestContext context = RequestContext.getCurrentContext();
        try {
            doSomething();
        }catch (Exception e) {
            // 在这里上下中文中设置error.status_code后 SendErrorFilter就会对异常处理，并返回给客户端
            context.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            context.set("error.exception", e);
            context.set("error.message", "Throw a RuntimeException!");
        }
        return null;
    }

    private void doSomething() {
        throw new RuntimeException();
    }
}
