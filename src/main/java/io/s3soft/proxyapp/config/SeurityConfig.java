package io.s3soft.proxyapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.s3soft.proxyapp.service.impl.MyUserDetailsService;
@EnableWebSecurity
public class SeurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired MyUserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*		http.authorizeRequests()     // Acceptable requests                                                       
//		.antMatchers("/resources/**","/","/api/users/**").permitAll()  
		.anyRequest().permitAll();*/


		http.csrf().disable().httpBasic().disable()
		.authorizeRequests()
		//	.antMatchers("/login.html","/login-error.html","/logout.html","/","/js/**","/css/**","/index.html","/api/users","/images/**").permitAll()
		.antMatchers("/","/js/**","/images/**","/css/**","/index.html","/login.html","/login-error.html","/logout.html").permitAll()
		.antMatchers(HttpMethod.GET,"/api/users").hasAnyRole("USER")
		.antMatchers(HttpMethod.POST,"/api/users").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login")
		.loginPage("/login.html")
		.defaultSuccessUrl("/index.html")
		.failureUrl("/login-error.html")
		.and()
		.logout().logoutUrl("/logout")
		.logoutSuccessUrl("/logout.html");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider());
	}

	private DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider=new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
