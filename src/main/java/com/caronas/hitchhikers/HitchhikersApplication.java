package com.caronas.hitchhikers;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HitchhikersApplication {

	public static void main(String[] args) {
		SpringApplication.run(HitchhikersApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean dbServletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/db/console/*");
		return registrationBean;
	}
}
