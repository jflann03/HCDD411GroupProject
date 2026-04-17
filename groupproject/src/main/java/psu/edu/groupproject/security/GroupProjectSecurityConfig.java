package psu.edu.groupproject.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

// takes the users from the database and has them as credentials
@Configuration
public class GroupProjectSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManger(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    

}
