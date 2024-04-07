package com.github.ad.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// 所有的请求响应和请求的对象，都转json
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.clear();
        //实现将java对象转json对象 在http header 头就是一个Content-Type: application/json
        converters.add(new MappingJackson2CborHttpMessageConverter());
    }
}
