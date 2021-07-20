package nl.parlio.auth.test.message.resource.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class MessageServerSecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeRequests {
                authorize("messages/**", hasAuthority("SCOPE_message.read"))
            }
            oauth2ResourceServer {
                jwt {
                }
            }
        }
        return http.build()
    }

}