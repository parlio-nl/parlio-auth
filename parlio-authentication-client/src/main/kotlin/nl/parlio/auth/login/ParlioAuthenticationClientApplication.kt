package nl.parlio.auth.login

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParlioAuthenticationClientApplication

fun main(args: Array<String>) {
    runApplication<ParlioAuthenticationClientApplication>(*args)
}
