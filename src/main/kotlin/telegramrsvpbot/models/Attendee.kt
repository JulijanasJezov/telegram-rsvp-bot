package telegramrsvpbot.models

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
data class Attendee(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int? = null,

        @NotNull
        var name: String,

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "rsvpList", nullable = false)
        val rsvpList: RsvpList? = null
)