/**
 * FileName: Interceptor
 * Author:   韩旭杰
 * Date:     2018/11/14 9:08
 * Description: 配置拦截器
 */
package com.example.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 说明：〈配置拦截器〉
 *
 * @author 韩旭杰
 * @create 2018/11/14
 * @since 1.0.0
 */
public class Interceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println(3);
    }
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub
        System.out.println(2);
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
        System.err.println("1");
        return true;
    }
}

