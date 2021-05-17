package io.datadynamics.projects.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class LdapConfiguration {

    @Value("${app.ldap.prefix.base}")
    String ldapBase;

    @Value("${app.ldap.bind-dn}")
    String userDn;

    @Value("${app.ldap.bind-password}")
    String password;

    @Value("${app.ldap.ldap-server-url}")
    String serverUrl;

    @Autowired
    Environment env;

    @Bean
    LdapContextSource ldapContextSource() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(serverUrl);
        contextSource.setBase(ldapBase);
        contextSource.setUserDn(userDn);
        contextSource.setPassword(password);
        return contextSource;
    }

    @Bean
    LdapTemplate ldapTemplate() {
        return new LdapTemplate(ldapContextSource());
    }
}
