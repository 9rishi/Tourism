package com.rishi.tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableAuthorizationServer
//@EnableResourceServer
@SpringBootApplication
@EnableDiscoveryClient  
public class TouristApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TouristApplication.class, args);
	}

//	@Bean
//	public WebSecurityConfigurerAdapter securityConfigurer() {
//
//		return new WebSecurityConfigurerAdapter() {
//			@Override
//			protected void configure(HttpSecurity http) throws Exception {
//
//				http.cors().and().csrf().disable().authorizeRequests()
//						.antMatchers("/api/v1/*").authenticated().and()
//						.httpBasic();
//				http.authorizeRequests().anyRequest().permitAll();
//			}
//		};
//	}
//
//	@Bean
//	public ResourceServerConfigurerAdapter resourceCongigurer() {
//		return new ResourceServerConfigurerAdapter() {
//
//			@Override
//			public void configure(HttpSecurity http) throws Exception {
//				http.cors().and().csrf().disable().authorizeRequests()
//						.antMatchers("/api/v1/*").authenticated().and()
//						.httpBasic();
//				http.authorizeRequests().anyRequest().permitAll();
//			}
//		};
//	}

}


//192.168.29.102:5432/postgres postgres-postgres
//localhost:5432/tourism postgres-rishi


