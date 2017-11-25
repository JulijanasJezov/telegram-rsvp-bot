package telegramrsvpbot

import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.exceptions.TelegramApiException
import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Message
import telegramrsvpbot.models.RsvpList
import telegramrsvpbot.services.AttendeesService
import telegramrsvpbot.services.RsvpService

class RsvpBot(private val rsvpService: RsvpService, private val attendeesService: AttendeesService, private val botToken: String) : TelegramLongPollingBot() {

    companion object {
        val CREATE_LIST = "/create"
        val ADD_ATTENDEE = "/rsvp"
        val REMOVE_ATTENDEE = "/unrsvp"
        val RSVP_LIST = "/list"
        val HELP = "/help"
    }

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            try {
                handleMessage(update.message)
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }

    override fun getBotUsername(): String? = "rsvp_list_bot"

    override fun getBotToken(): String? = botToken

    private fun handleMessage(message: Message) {
        val text: String = message.text
        val words: List<String> = text.split(delimiters = " ")

        if (words.isEmpty()) return

        val keyword: String = words[0]

        if (keyword == HELP) sendMessage(message, "Available commands: \n$CREATE_LIST list_name\n" +
                "$ADD_ATTENDEE list_name\n" +
                "$REMOVE_ATTENDEE list_name\n" +
                "$RSVP_LIST list_name")

        if (words.size == 2) {
            when (keyword) {
                CREATE_LIST -> {
                    rsvpService.createRsvpList(RsvpList(name = words[1]))
                    sendMessage(message, "Created RSVP list: #${words[1]}")
                }
                ADD_ATTENDEE -> {
                    val name = message.from.userName ?: "${message.from.firstName}_${message.from.lastName}"
                    sendMessage(message, attendeesService.addAttendee(words[1], name))
                }
                RSVP_LIST -> {
                    var names = ""
                    rsvpService.getRsvpList(words[1])?.forEach { names = names.plus("\n@$it") }
                    if (names.isNotEmpty()) sendMessage(message, "Attending: $names")
                }
                REMOVE_ATTENDEE -> {
                    val name = message.from.userName ?: "${message.from.firstName}_${message.from.lastName}"
                    sendMessage(message, attendeesService.removeAttendee(words[1], name))
                }
            }
        }
    }

    private fun sendMessage(message: Message, text: String) {
        val sendMessage = SendMessage()
                .setChatId(message.chatId)
                .setText(text)
        execute(sendMessage)
    }
}