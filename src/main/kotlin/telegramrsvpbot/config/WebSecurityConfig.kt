package telegramrsvpbot.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.TelegramBotsApi
import telegramrsvpbot.RsvpBot
import telegramrsvpbot.services.AttendeesService
import telegramrsvpbot.services.RsvpService
import javax.annotation.PostConstruct

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Value("\${bot.token}")
    lateinit var botToken: String

    @Autowired
    lateinit var rsvpService: RsvpService

    @Autowired
    lateinit var attendeeService: AttendeesService

    @PostConstruct
    fun init() {
        ApiContextInitializer.init()
        TelegramBotsApi().registerBot(RsvpBot(rsvpService, attendeeService, botToken))
    }

    override fun configure(http: HttpSecurity) {

        http.csrf().disable()
                .headers().frameOptions().disable()
    }

    @Bean
    fun mapper(): ObjectMapper = ObjectMapper().registerKotlinModule()
}

