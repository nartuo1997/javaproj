package com.project.application.configuration;

import com.project.application.security.JwtRequestFilter;
import com.project.application.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myuserDetailsService;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myuserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/authenticate","/user/register").permitAll()
//               // .antMatchers("/register").permitAll()
//                .antMatchers("/usr/**").hasAuthority("USER")
//                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .antMatchers("/anonymous*").anonymous()
//                .anyRequest().fullyAuthenticated()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http

                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/authenticate","/user/usr/register").permitAll()
                .antMatchers("/user/usr**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/user/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/project/add").permitAll()
                .antMatchers("/project/update").permitAll()
                .antMatchers("/project/delete/**").permitAll()
//                .antMatchers("/resource/delete").permitAll()
                .antMatchers("/anonymous*").anonymous()
                .anyRequest().fullyAuthenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.csrf().disable();

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);


    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationProvider authoProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.
//    }
}
