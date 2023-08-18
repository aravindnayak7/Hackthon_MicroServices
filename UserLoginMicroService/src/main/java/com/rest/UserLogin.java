package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import com.rest.JWTFilter.*;




@SpringBootApplication
@EnableFeignClients
public class UserLogin {

	public static void main(String[] args) {
		SpringApplication.run(UserLogin.class, args);
	}
	
//	@Bean
//
//    public FilterRegistrationBean jwtFilter()
//
//    {
//
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//
//        filterRegistrationBean.setFilter(new FilterJWT());
//
//        filterRegistrationBean.addUrlPatterns("/user/v1/*");
//
//        return filterRegistrationBean;
//
//    }

}
