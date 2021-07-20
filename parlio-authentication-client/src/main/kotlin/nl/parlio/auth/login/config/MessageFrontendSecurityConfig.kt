package nl.parlio.auth.login.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class MessageFrontendSecurityConfig {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer {
        return WebSecurityCustomizer { web: WebSecurity -> web.ignoring().antMatchers("/webjars/**") }
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeRequests {
//                authorize(anyRequest, authenticated)
                authorize("/error", permitAll)
                authorize("/favicon.ico", permitAll)
                authorize("/webjars/**", permitAll)
            }
            oauth2Login {
                loginPage = "/oauth2/authorization/messaging-client-oidc"
            }
            oauth2Client {
            }
        }
        return http.build()
    }

}