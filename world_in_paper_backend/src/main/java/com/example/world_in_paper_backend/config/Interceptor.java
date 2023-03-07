package com.example.world_in_paper_backend.config;

import com.example.world_in_paper_backend.interceptor.ArtAuthInterceptor;
import com.example.world_in_paper_backend.interceptor.LoginAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Interceptor implements WebMvcConfigurer {

    @Bean
    LoginAuthInterceptor loginAuthInterceptor() {
        return new LoginAuthInterceptor();
    }
    @Bean
    ArtAuthInterceptor artAuthInterceptor(){
        return new ArtAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加一个拦截器，排除登录url
        registry.addInterceptor(loginAuthInterceptor())
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/user/sendMail")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
        registry.addInterceptor(artAuthInterceptor())
                .addPathPatterns("/column/addColumn")
                .addPathPatterns("/paper/uploadPaperwork");
    }
}