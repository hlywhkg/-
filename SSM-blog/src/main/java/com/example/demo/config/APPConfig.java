/**
 * @ClassName $申先生
 * @Description days
 * @date 2022/9/18 16:35
 * @Version 1.0
 */
package com.example.demo.config;

import com.example.demo.intercept.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class APPConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercept()).
                //所有路由都拦截
                addPathPatterns("/**").
                //不拦截这个后缀的所有文件
                excludePathPatterns("/**/*.css").
                excludePathPatterns("/**/*.js").
                excludePathPatterns("/**/*.png").
                excludePathPatterns("/**/*.jpg").
                //登录页和注册页也不用拦截
                excludePathPatterns("/**/login.html").
                excludePathPatterns("/**/register.html").
                excludePathPatterns("/**/login").
                excludePathPatterns("/**/register");
    }
}
