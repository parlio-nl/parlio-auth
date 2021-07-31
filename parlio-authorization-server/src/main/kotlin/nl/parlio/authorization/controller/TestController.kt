package nl.parlio.authorization.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class TestController {


    @GetMapping("/abc")
    fun test(): String {
        val securityContext = SecurityContextHolder.getContext()
//        return ""
        val authentication = securityContext.authentication
        val principal = authentication.principal as OidcUser
        println(principal.claims)
        return authentication.toString()
    }

}