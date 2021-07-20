package nl.parlio.authorization.web

import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.servlet.config.annotation.*

@EnableWebMvc
@Configuration
class WebMvcConfiguration : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry
            .addViewController("/login").setViewName("login")
        registry
            .addViewController("/profile").setViewName("profile")
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE)
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/")
        registry
            .addResourceHandler("/favicon.ico")
            .addResourceLocations("classpath:/static/favicon.ico")
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
//        val localeInterceptor = LocaleChangeInterceptor()
//        localeInterceptor.paramName = "lang"
//        registry
//            .addInterceptor(localeInterceptor)
    }

}
