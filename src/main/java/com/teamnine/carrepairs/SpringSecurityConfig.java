package com.teamnine.carrepairs;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private AuthenticationProvider loginAuthenticationProvider;

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    //@Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
//                .and().formLogin().defaultSuccessUrl("/")
//                .loginPage("/login").and()
//                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/admin/**")
                .hasAuthority("ADMIN").anyRequest().fullyAuthenticated()
                .and()
                .csrf().disable()
                .formLogin().successHandler(successHandler)
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();
                //.and()
                //.exceptionHandling().accessDeniedPage("/login");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(loginAuthenticationProvider);
    }

}
