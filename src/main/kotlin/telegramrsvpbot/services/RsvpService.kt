package telegramrsvpbot.services

import org.springframework.stereotype.Service
import telegramrsvpbot.models.RsvpList
import telegramrsvpbot.repositories.RsvpRepository

@Service
class RsvpService(private val rsvpRepository: RsvpRepository) {

    fun createRsvpList(rsvpList: RsvpList): RsvpList = rsvpRepository.save(rsvpList)

    fun getRsvpLists(): List<RsvpList> = rsvpRepository.findAll()

    fun getRsvpList(list: String): List<String>? = rsvpRepository.findByName(list).attendees?.map { it.name }
}