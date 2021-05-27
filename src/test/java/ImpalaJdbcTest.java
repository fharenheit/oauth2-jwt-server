import com.cloudera.impala.jdbc.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.util.Properties;

public class ImpalaJdbcTest {

    public static void main(String[] args) {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(Driver.class);
        ds.setUrl("jdbc:impala://localhost:21050;AuthMech=11");
        Properties props = new Properties();
        props.setProperty("Auth_Client_ID", "dataflex");
        props.setProperty("httpPath", "http://localhost:8888/oauth/token");
        props.setProperty("AuthorizationUrl", "http://localhost:8888/oauth/token");
        props.setProperty("transportMode", "http");
        props.setProperty("Auth_AccessToken", "http");
        props.setProperty("Auth_Flow", "0");

        ds.setConnectionProperties(props);

        JdbcTemplate template =new JdbcTemplate(ds);

        String query = template.queryForObject("SELECT 1", String.class);

    }
}
