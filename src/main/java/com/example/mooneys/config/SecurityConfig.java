package com.example.mooneys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                // 認可設定
                .authorizeHttpRequests(authz -> authz
                        // すべてのリクエストに認証を要求
                        .anyRequest().authenticated())
                // ログインフォームの設定
                .formLogin(form -> form
                        // ログイン成功時のリダイレクト先を/dashboardに設定
                        .defaultSuccessUrl("/dashboard", true)
                        // ログインページへのすべてのアクセスを許可
                        .permitAll())
                .build();

    }
}
