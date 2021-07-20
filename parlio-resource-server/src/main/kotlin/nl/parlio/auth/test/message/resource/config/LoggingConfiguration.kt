package nl.parlio.auth.test.message.resource.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
class LoggingConfiguration {

    @Bean
    fun requestLogFilter(): CommonsRequestLoggingFilter {
        val filter = CommonsRequestLoggingFilter()
        filter.apply {
            setIncludePayload(true)
            setIncludeHeaders(true)
            setIncludeQueryString(true)
        }
        return filter
    }

}
