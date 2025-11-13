package org.springframework.samples.petclinic.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

        return http
                    .authorizeExchange(exchanges -> exchanges // 1. 使用 exchanges -> ... 的 Lambda 表达式
                             .pathMatchers("/login").permitAll()
                             .anyExchange().authenticated()
                         ) // 2. Lambda 表达式在这里结束
                    .csrf(ServerHttpSecurity.CsrfSpec::disable) // 3. csrf() 在 authorizeExchange() 之后调用
                     .build();
            }
}
