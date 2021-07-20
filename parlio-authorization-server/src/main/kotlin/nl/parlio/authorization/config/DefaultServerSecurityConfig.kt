package nl.parlio.authorization.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class DefaultServerSecurityConfig(
    private val clientRegistrationRepository: ClientRegistrationRepository
) {

    @Bean
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeRequests {
                authorize("/login", permitAll)
                authorize("/static/parlio-logo.svg", permitAll)
                authorize("/favicon.ico", permitAll)
                authorize("/abc", authenticated)
                authorize("/profile", authenticated)
                authorize(anyRequest, authenticated)
            }
            formLogin {
                loginPage = "/login"
                defaultSuccessUrl("/profile", false)
            }
            oauth2Login {
                loginPage = "/login"
                clientRegistrationRepository = this@DefaultServerSecurityConfig.clientRegistrationRepository
            }
        }
        return http.build()
    }

    @Bean
    fun users(): UserDetailsService {
        val user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("p")
            .authorities(
                "ROLE_USER", "ROLE_POLITICIAN",
                "article:read", "article:write", "article:delete",
                "test1", "project:create", "project:star", "project:delete",
                "car:drive", "site:lock"
            )
            .build()
        return InMemoryUserDetailsManager(user)
    }

}