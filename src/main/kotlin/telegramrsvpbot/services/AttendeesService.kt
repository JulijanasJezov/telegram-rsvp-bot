package telegramrsvpbot.services

import org.springframework.stereotype.Service
import telegramrsvpbot.models.Attendee
import telegramrsvpbot.models.RsvpList
import telegramrsvpbot.repositories.AttendeeRepository
import telegramrsvpbot.repositories.RsvpRepository

@Service
class AttendeesService(private val attendeeRepository: AttendeeRepository, private val rsvpRepository: RsvpRepository) {

    fun addAttendee(rsvpListName: String, attendeeName: String): String {
        val rsvpList: RsvpList? = rsvpRepository.findByName(rsvpListName)

        if (rsvpList != null) {
            attendeeRepository.save(Attendee(null, attendeeName, rsvpList))
            return "Added @$attendeeName to #$rsvpListName"
        }

        return "RSVP List is not found"
    }

    fun removeAttendee(list: String, name: String): String {
        val rsvpList: RsvpList? = rsvpRepository.findByName(list)

        if (rsvpList != null) {
            attendeeRepository.delete(attendeeRepository.findByName(name))
            return "Removed $name"
        }

        return "RSVP List is not found"
    }
}