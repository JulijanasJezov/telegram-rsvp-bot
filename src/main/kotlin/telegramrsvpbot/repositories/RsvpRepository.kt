package telegramrsvpbot.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import telegramrsvpbot.models.RsvpList

@Repository
interface RsvpRepository: JpaRepository<RsvpList, Int> {
    fun findByName(name: String): RsvpList?
}