package psu.edu.groupproject.security;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// takes the users from the database and has them as credentials
@Configuration
public class GroupProjectSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManger(DataSource datsSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    

}
