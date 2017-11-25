package telegramrsvpbot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication



@SpringBootApplication
class TelegramRsvpBotApplication

fun main(args: Array<String>) {
    SpringApplication.run(TelegramRsvpBotApplication::class.java, *args)
}
