package com.ssaw.ssawzuul.error.attributes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import java.util.Map;

/**
 * 自定义异常信息
 * @author HuSen.
 * @date 2018/11/17 15:26.
 */
@Slf4j
@Component
public class SsawErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.remove("exception");
        return errorAttributes;
    }
}
