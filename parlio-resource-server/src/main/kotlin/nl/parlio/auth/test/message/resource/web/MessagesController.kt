package nl.parlio.auth.test.message.resource.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MessagesController {

    @GetMapping("/messages")
    fun messages(): List<String> {
        return listOf("Message 1", "Message 2", "Message 3", "Message 4")
    }

}
