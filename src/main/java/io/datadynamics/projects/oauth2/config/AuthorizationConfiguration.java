package io.datadynamics.projects.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class AuthorizationConfiguration extends AuthorizationSErverConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Value("${app.oauth2.jwt-signing-key}")
    String jwtSigningKey;

    @Value
    int accessTokenValidatySeconds;
    
    @Autowired
    @Qualifier("authenticationManagerBean")
    AuthenticationManager authenticationManager;

    @Autowiared
    UserDetailService userDetailSErvice;

    @Override
    configure(AuthorizationServerEndpintsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
            .approvalStore(approvalStore())
            .acessTOkenConverter(...) // added for JWT
            .authenticationManager(...)
            userdetailservice(...);
    
    @Override
    
    configure(CLientDetailConfiguerer lists) {
        clients.jdbc(dataSOurce);
    
    @Bean
    ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }

    @Bean
    TokenStore tokenStore() {
        return new JwtTokenStore(accessToken);
    }
    
    @Bean
    JwtAccessTokenConverter acessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAcessTokenConverter();
        converter.setSigningKey(jwt);
        return converter
        }
    
    @Bean
    @Primary
    DefaultTokenService tokenService() {
        DefaultTokenSErvice tokenService = new DefaultTokenSErvice()
            toeknSErvice.setToeknStore(tokenStore());
        return toeknService;

}
