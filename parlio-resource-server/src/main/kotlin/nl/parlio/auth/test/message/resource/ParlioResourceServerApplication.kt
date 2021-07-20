package nl.parlio.auth.test.message.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParlioResourceServerApplication

fun main(args: Array<String>) {
    runApplication<ParlioResourceServerApplication>(*args)
}
