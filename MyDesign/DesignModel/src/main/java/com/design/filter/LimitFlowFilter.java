package com.design.filter;

import com.design.service.RedisService;
import com.design.utiles.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/5/1 23:22
 * @Description 服务限流
 */
@AllArgsConstructor
@Slf4j
public class LimitFlowFilter implements Filter {

    private RedisService redisService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpRequest.getRequestURI();
        System.out.println(requestURI);
        Object result = redisService.limit_listPush("limit_list");

        if(Integer.valueOf(result.toString())<=0){
            // 设置响应的状态码为需要返回的错误码
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
            httpResponse.setHeader("Access-Control-Max-Age", "3600");
            ObjectMapper mapper = new ObjectMapper();
            String json=mapper.writeValueAsString(R.fail("当前访问人数过多，请稍后再试"));
            // 将 JSON 对象设置为响应的主体
            httpResponse.setContentType("application/json; charset=UTF-8");
            httpResponse.getWriter().write(json);
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
            return ;
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }


}

