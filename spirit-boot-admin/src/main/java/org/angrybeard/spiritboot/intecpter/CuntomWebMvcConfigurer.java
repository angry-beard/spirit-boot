package org.angrybeard.spiritboot.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by angry_beary on 2019/7/3.
 */
@Configuration
public class CuntomWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/vip/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
