/**
 * FileName: AppConfigurer
 * Author:   韩旭杰
 * Date:     2018/11/14 9:15
 * Description: 注册拦截器
 */
package com.example.springboot.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 说明：〈注册拦截器〉
 *
 * @author 韩旭杰
 * @create 2018/11/14
 * @since 1.0.0
 */
// @Configuration用于定义配置类，可替换xml配置文件，被注解的类内部包含有一个或多个被@Bean注解的方法，
// 这些方法将会被AnnotationConfigApplicationContext或AnnotationConfigWebApplicationContext类进行扫描，
// 并用于构建bean定义，初始化Spring容器。
@Configuration
public class AppConfigurer implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        return new Interceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(getLoginInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                // 不包含error路径
                .excludePathPatterns("/error")
                // 不包含static路径
                .excludePathPatterns("/static/*");
    }

    /**
     * 配置静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler 请求路径
        // addResourceLocations 在项目中的资源路径
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                //跨域允许时间
                .maxAge(3600);
    }
}
