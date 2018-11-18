package com.ssaw.ssawzuul.processor;

import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author HuSen.
 * @date 2018/11/17 15:05.
 */
public class SsawFilterProcessor extends FilterProcessor {
    @Override
    public Object processZuulFilter(ZuulFilter filter) throws ZuulException {
        try {
            return super.processZuulFilter(filter);
        } catch (ZuulException e) {
            RequestContext context = RequestContext.getCurrentContext();
            context.set("failed.filter", filter);
            throw e;
        }
    }
}
