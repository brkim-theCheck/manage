package com.thecheck.manage.config;

import com.thecheck.manage.component.AuthFailureHandler;
import com.thecheck.manage.component.AuthProvider;
import com.thecheck.manage.component.AuthSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthProvider authProvider;

    @Autowired
    private AuthFailureHandler authFailureHandler;

    @Autowired
    private AuthSuccessHandler authSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers("/resources/**",
                "/dist/**",
                "/css/**",
                "/font-awesome/**",
                "/fonts/**",
                "/img/**",
                "/js/**",
                "/manage/posts",
                "/manage/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info(">>>>>>>> Spring Security Configure <<<<<<<<");
        http
                //로그인 설정
                .authorizeRequests()
                    .antMatchers("/login").permitAll()
                    .antMatchers("/loginProc").permitAll()
                    .antMatchers("/manage/**").hasAnyRole("ADMIN", "USER")
                    .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                    .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/loginProc")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .failureHandler(authFailureHandler)
                    .successHandler(authSuccessHandler)
                    .successForwardUrl("/manage/")
                    .defaultSuccessUrl("/manage/")
                    //.failureForwardUrl("/")
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                .and()
                    .cors()
                .and()
                //로그인 프로세스가 진행될 provider
                    .authenticationProvider(authProvider)
                    .csrf().disable();

    }

    @Bean
    public CorsConfigurationSource  corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOrigin("http://127.0.0.1:3000");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setAllowCredentials(true);
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
