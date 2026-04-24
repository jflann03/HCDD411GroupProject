package psu.edu.groupproject.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class GroupProjectSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/", "/css/**", "/images/**").permitAll()
                        .requestMatchers("/showLoginPage", "/access-denied").permitAll()
                        .requestMatchers(
                                "/signup/showSignupForm",
                                "/signup/processSignupForm",
                                "/signup/signupConfirmation"
                        ).permitAll()

                        .requestMatchers(
                                "/signup/pending",
                                "/signup/approve",
                                "/signup/deny"
                        ).hasAnyRole("MANAGER", "ADMIN")

                        .requestMatchers(
                                "/signup/manage",
                                "/signup/delete"
                        ).hasRole("ADMIN")

                        .requestMatchers("/employees/list").hasAnyRole("SUPERVISOR", "MANAGER", "ADMIN")
                        .requestMatchers("/employees/showFormForAdd").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/employees/showFormForUpdate").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/employees/save").hasAnyRole("MANAGER", "ADMIN")
                        .requestMatchers("/employees/delete").hasRole("ADMIN")

                        .anyRequest().authenticated()
        );

        http.formLogin(form ->
                form
                        .loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .defaultSuccessUrl("/employees/list", true)
                        .permitAll()
        );

        http.logout(logout ->
                logout
                        .logoutSuccessUrl("/")
                        .permitAll()
        );

        http.exceptionHandling(configurer ->
                configurer
                        .accessDeniedPage("/access-denied")
        );

        return http.build();
    }
}