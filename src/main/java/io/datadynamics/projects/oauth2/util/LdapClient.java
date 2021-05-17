package io.datadynamics.projects.oauth2.util;

import io.datadynamics.projects.oauth2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.stereotype.Component;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Component
public class LdapClient {

    @Autowired
    LdapTemplate template;

    public List<User> findByUsername(String username) {
        LdapQuery query = query().base("OU=Users").attributes("cn", "sn")
                .where("objectClass").is("person")
                .and("cn").is(username);

        List<User> users = template.search(query, new AttributesMapper<User>() {
            @Override
            public User mapFromAttributes(Attributes attrs) throws NamingException {
                return User.builder().username((String) attrs.get("CN").get()).name("").password("").build();
            }
        });
        return users;
    }
}
