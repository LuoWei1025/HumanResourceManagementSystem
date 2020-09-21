package com.swjtu.hrms.security;

import com.swjtu.hrms.service.StaffService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Configuration
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    StaffService staffService;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(staffService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/abscence_manage.html").hasRole("admin")
                .antMatchers("/attendance_data_import.html").hasRole("admin")
                .antMatchers("/leave_manage.html").hasRole("admin")
                .antMatchers("/overtime_manage.html").hasRole("admin")
                .antMatchers("/posi_transfor_manage.html").hasRole("admin")
                .antMatchers("/rehire_manage.html").hasRole("admin")
                .antMatchers("/salary_calculate.html").hasRole("admin")
                .antMatchers("/retire_manage.html").hasRole("admin")
                .antMatchers("/register_manage.html").hasRole("admin")
                .antMatchers("/temp_leave_manage.html").hasRole("admin")
                .antMatchers("/dep_info_manage.html").hasRole("dep")
                .antMatchers("/dep_position_manage.html").hasRole("dep")
                .antMatchers("/dep_train_manage.html").hasRole("dep")
                .anyRequest().authenticated()//表示剩余的其他接口，登录之后就能访问
                .and()
                .formLogin()
                .loginPage("/logins")
                .loginProcessingUrl("/loginform")//登录接口
                .permitAll()//和表单登录相关的接口统统都直接通过
                .and()
                .exceptionHandling()
                .accessDeniedPage("/denied")//拒绝访问页面
                .and()
                .logout()   //退出登录相关配置
                .logoutUrl("/logout")   //自定义退出登录页面
                .logoutSuccessUrl("/logins") //退出成功后跳转的页面
                .deleteCookies("JSESSIONID") //退出时要删除的Cookies的名字
                .and()
                .csrf()
                .disable()
                .sessionManagement()
                .maximumSessions(1)
                .expiredUrl("/welcome_page.html");
        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 忽略URL
        web.ignoring().antMatchers("/admin/**","/assets/**","/common/**","/images/**");
    }
}
