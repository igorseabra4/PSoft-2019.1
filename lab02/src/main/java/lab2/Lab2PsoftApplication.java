package lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import lab2.controller.TokenFilter;

@SpringBootApplication
@ComponentScan({"lab2.controller", "lab2.service", "lab2.dao", "lab2.exception", "lab2.model"})
public class Lab2PsoftApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Lab2PsoftApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filter = new FilterRegistrationBean<TokenFilter>();
		filter.setFilter(new TokenFilter());
		filter.addUrlPatterns(
				"/v1/products/private",
				"/v1/products/private/greeting",
				"/v1/products/private/*");
		return filter;
	}
}
