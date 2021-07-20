package nl.parlio.authorization

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParlioAuthorizationServerApplication

fun main(args: Array<String>) {
    runApplication<ParlioAuthorizationServerApplication>(*args)
}
