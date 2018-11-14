package com.brain.earthcitizenclub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.brain.earthcitizenclub.service.UserAuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAuthenticationService userAuthenticationService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userAuthenticationService).passwordEncoder(new Md5PasswordEncoder());
	}

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
	        .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
	        .and()
                .userDetailsService(this.userAuthenticationService)
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
            .and()
                .authorizeRequests()
//        		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        		.antMatchers("/user/**").access("hasRole('ROLE_USER')")
    		.and()
    			.headers().frameOptions().disable()
    		.and()
                .csrf().disable();
            
    }
}
