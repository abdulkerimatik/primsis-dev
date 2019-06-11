package com.primsis.smm.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.primsis.core.base.util.Privileges;
import com.primsis.core.repo.auth.jwt.JwtConfigurer;
import com.primsis.core.repo.auth.jwt.JwtTokenProvider;



@Configuration
public class SmmSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    JwtTokenProvider jwtTokenProvider;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority(Privileges.ACCESS)
                .antMatchers("/swagger-ui.html*").permitAll()
                .antMatchers("/smm/load").hasAuthority(Privileges.SMM_LOAD)
                .antMatchers("/smm/send").hasAuthority(Privileges.SMM_SEND)
                .antMatchers("/smm/get").hasAuthority(Privileges.SMM_VIEW)
                .antMatchers("/smm/statuscheck").hasAuthority(Privileges.SMM_STATUS_CHECK)
            .and()
           .apply(new JwtConfigurer(jwtTokenProvider));
        //@formatter:on
    }


}

