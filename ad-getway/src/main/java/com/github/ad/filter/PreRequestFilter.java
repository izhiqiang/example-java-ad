package com.github.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
//过滤器才会被发现
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //定义执行到顺序，数字越小，顺序越高，最先被执行
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true标识执行 false表示不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 记录当前请求时间
        RequestContext ctx  = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
