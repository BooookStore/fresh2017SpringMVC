package com.packt.webstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john").password("password").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("password").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        // ログインに使用するユーザ名、パスワードのパラメータ名を指定
//        httpSecurity.formLogin().loginPage("/login")
//                .usernameParameter("userId")
//                .passwordParameter("password");
//
//        // ログイン成功、失敗のURLを指定
//        httpSecurity.formLogin()
//                .defaultSuccessUrl("/market/products/add")
//                .failureForwardUrl("/login?error");
//
//        // ログアウト後のページを指定
//        httpSecurity.logout()
//                .logoutSuccessUrl("/login?logout");

        // ログイン管理をする対象のページを指定
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**/add").access("hasRole('ADMIN')")
                .antMatchers("/**/market").access("hasRole('USER')")
                .and()

                // ログインに使用するユーザ名、パスワードのパラメータ名を指定
                .formLogin().loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/login")

                // ログイン成功、失敗のURLを指定
                .defaultSuccessUrl("/market/products/add")
                .failureForwardUrl("/login?error")
                .and()

                .logout()
                .logoutSuccessUrl("/login?logout");

    }

}
