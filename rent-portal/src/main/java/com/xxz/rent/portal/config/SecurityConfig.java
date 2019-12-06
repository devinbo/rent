package com.xxz.rent.portal.config;

import com.xxz.rent.portal.component.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * SpringSecurity的配置
 * Created by macro on 2018/8/3.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.xml",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .antMatchers(
                        "/sso/*",//登录注册
                        "/sso/*/*",//登录注册
                        "/payback/*", //支付回调
                        "/home/**",//首页接口
                        "/bbs/**", //发现
                        "/oto/category/list", //分类
                        "/oto/product/list", //oto查询产品
                        "/pms/category/*", //分类
                        "/common/search/*", //搜索
                        "/sys/*" //版本更新
                )
                .permitAll()
//                .antMatchers("/member/**","/returnApply/**")// 测试时开启
//                .permitAll()
                .anyRequest()// 除上面外的所有请求全部需要鉴权认证
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new GoAccessDeniedHandler())
                .authenticationEntryPoint(new GoAuthenticationEntryPoint())
                .and()
                .formLogin()
                .successHandler(new GoAuthenticationSuccessHandler())
                .failureHandler(new GoAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutSuccessHandler(new GoLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
//                .and()
//                .requiresChannel()
//                .antMatchers("/sso/*")
//                .requiresSecure()
//                .anyRequest()
//                .requiresInsecure()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1800)
//                .key("token_key")
                .and()
                .csrf()
                .disable();//开启basic认证登录后可以调用需要认证的接口
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(smsMemberService());
    }


    @Bean
    public SmsMemberService smsMemberService() {
        return new SmsMemberService();
    }

//    @Bean
//    public SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig() {
//        return new SmsCodeAuthenticationSecurityConfig();
//    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

//    @Bean
//    public AuthenticationFailureHandler authenticationFailureHandler() {
//        return new GoAuthenticationFailureHandler();
//    }

}
