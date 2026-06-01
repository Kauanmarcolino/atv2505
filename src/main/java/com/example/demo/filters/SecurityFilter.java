package com.example.demo.filters;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

/**
 * Configuração de segurança da aplicação.
 *
 * Esta classe define as regras de autenticação e autorização
 * para os endpoints expostos pela API.
 *
 * Configurações atuais:
 * - CSRF desabilitado.
 * - Sessões stateless (sem armazenamento de sessão no servidor).
 * - Endpoints GET /produtos liberados para acesso público.
 * - Endpoints POST /produtos liberados para acesso público.
 */
@Configuration
@EnableWebSecurity
public class SecurityFilter {

/**
 * Configura a cadeia de filtros de segurança da aplicação.
 * @param http Objeto utilizado para configurar as regras de segurança.
 * @return SecurityFilterChain configurado.
 */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http

                // Desabilita a proteção CSRF.
                // Geralmente utilizada em APIs REST que não usam sessão.
                .csrf(csrf -> csrf.disable())

                // Define que a aplicação não manterá sessões de usuário.
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Permite acesso público à listagem de produtos.
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.GET, "/produtos")
                                .permitAll())

                // Permite acesso público ao cadastro de produtos.
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers(HttpMethod.POST, "/produtos")
                                .permitAll())

                .build();
    }
}