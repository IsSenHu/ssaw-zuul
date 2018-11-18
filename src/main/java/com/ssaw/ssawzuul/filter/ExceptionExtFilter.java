package com.ssaw.ssawzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.stereotype.Component;

/**
 * @author HuSen.
 * @date 2018/11/17 14:59.
 */
@Slf4j
@Component
public class ExceptionExtFilter extends SendErrorFilter {

    private static final String POST_FILTER_TYPE_NAME = "post";
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        // 大于SendErrorFilter的值
        return 30;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext context = RequestContext.getCurrentContext();
        ZuulFilter filter = (ZuulFilter) context.get("failed.filter");
        return null != filter && POST_FILTER_TYPE_NAME.equalsIgnoreCase(filter.filterType());
    }

    @Override
    public Object run() {
        return super.run();
    }
}
