package com.booking.tickets.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Autowired
	public void configure_global(AuthenticationManagerBuilder authObj) throws Exception {


		authObj.inMemoryAuthentication().withUser("sunil").password("{noop}sunil")
		.roles("ADMIN");


		authObj.inMemoryAuthentication().withUser("sunilguest").password("{noop}sunilguest")
		.roles("USER");
	}

	/*
	 *
	 * Authorization Logic
	 * 1) ADMIN Role can Access All Tickets and Individual Ticket ==> Rule1
	 * 2) USER Role can access only Individual Ticket ==> Rule2
	 *
	 *
	 * */
	@Override
	public void configure(HttpSecurity authorizationObj) throws Exception {


		//Rule1
		//formLogin ==> It will redirect Login Page
		authorizationObj.csrf().disable() //This Line i will explain tomarrow
		.authorizeRequests().antMatchers("/api/v2/findAll/**").
		hasAnyRole("ADMIN").and().formLogin();


		//Rule2
		authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/api/v2/getTicket/**").
		hasAnyRole("ADMIN","USER").and().formLogin();

	}

}
