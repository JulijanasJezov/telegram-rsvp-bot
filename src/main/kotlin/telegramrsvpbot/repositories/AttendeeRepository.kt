package telegramrsvpbot.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import telegramrsvpbot.models.Attendee
import telegramrsvpbot.models.RsvpList

@Repository
interface AttendeeRepository : JpaRepository<Attendee, Int> {
    fun findByName(name: String): Attendee
}