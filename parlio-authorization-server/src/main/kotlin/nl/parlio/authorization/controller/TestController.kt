package nl.parlio.authorization.controller

import org.springframework.security.core.context.SecurityContextHolder
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
        return authentication.toString()
    }

}