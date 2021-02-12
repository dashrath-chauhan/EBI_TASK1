package org.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("test").password("test").roles("USER")
			.and()
			.withUser("admin").password("admin").roles("ADMIN","USER");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
        	.and()
            .authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/persons/*").hasRole("USER")
//            .antMatchers(HttpMethod.GET, "/person/*").hasRole("USER")
//            .antMatchers(HttpMethod.POST, "/persons").hasRole("ADMIN")
//            .antMatchers(HttpMethod.PUT, "/persons").hasRole("ADMIN")
//            .antMatchers(HttpMethod.DELETE, "/persons/*").hasRole("ADMIN")
            .antMatchers(HttpMethod.GET, "/persons").permitAll()
            .antMatchers(HttpMethod.GET, "/person/**").permitAll()
            .antMatchers(HttpMethod.POST, "/persons").permitAll()
            .antMatchers(HttpMethod.PUT, "/persons").permitAll()
            .antMatchers(HttpMethod.DELETE, "/persons/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .formLogin().disable()
            .headers().frameOptions().disable();
    }

}
