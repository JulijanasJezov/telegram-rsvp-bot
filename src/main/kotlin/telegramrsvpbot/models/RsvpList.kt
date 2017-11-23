package telegramrsvpbot.models

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class RsvpList(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,

        @Column(unique=true)
        @NotNull
        var name: String,

        @OneToMany(mappedBy = "rsvpList")
        val attendees: List<Attendee>? = null)