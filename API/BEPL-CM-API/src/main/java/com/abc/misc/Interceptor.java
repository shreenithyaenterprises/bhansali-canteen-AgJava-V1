package com.abc.misc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.abc.bean.CustomResponse;
import com.abc.utility.Misc;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //log.info("Request intercepted: " + request.getHeader("Authorization"));
        System.out.println("Request intercepted: "+request.getRemoteHost());
        if (!Misc.validRequest()) 
        {
            CustomResponse customResponse = new CustomResponse();
            customResponse.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
            customResponse.setMessage("License Expired. Please contact administrator!");
            response.getWriter().write(new ObjectMapper().writeValueAsString("License Expired. Please contact administrator!"));
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
            System.out.println(customResponse.toString());
            return false;
        }
        return true;
           
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        response.getWriter().write("License Expired. Please contact administrator!");
//        response.setStatus(HttpStatus.PAYMENT_REQUIRED.value());
//      
//        return false;
    }

}
