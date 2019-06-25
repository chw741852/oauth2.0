package com.hong.oauth2.config;

import com.hong.oauth2.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Created by caihongwei on 2019/6/20 14:37.
 */
@Configuration
public class AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {
    private AuthenticationManager authenticationManager;
    private UserService userService;

    public AuthorizationServerConfigurer(AuthenticationConfiguration authenticationConfiguration, UserService userService) throws Exception {
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();
        this.userService = userService;
    }

    @Bean
    public JwtTokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("123");
        return converter;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .secret("{noop}secret")
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()").allowFormAuthenticationForClients();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(jwtTokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .userDetailsService(userService)
                .authenticationManager(authenticationManager);
    }
}
