package telegramrsvpbot.controllers

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import telegramrsvpbot.models.Attendee
import telegramrsvpbot.models.RsvpList
import telegramrsvpbot.services.AttendeesService
import telegramrsvpbot.services.RsvpService

@RequestMapping("/rsvp")
@RestController
class RsvpController(private val rsvpService: RsvpService, private val attendeesService: AttendeesService) {

    @PostMapping
    fun postRsvpList(@RequestBody @Validated rsvpList: RsvpList) = ResponseEntity.ok(rsvpService.createRsvpList(rsvpList))

    @GetMapping
    fun getRsvpLists() = ResponseEntity.ok(rsvpService.getRsvpLists())

    @PostMapping("/{list}/attendees")
    fun postAttendee(@PathVariable("list") list: String,
                     @RequestBody @Validated attendee: Attendee) =
            ResponseEntity.ok(attendeesService.addAttendee(list, attendee.name))

    @DeleteMapping("/{list}/attendees/{name}")
    fun postAttendee(@PathVariable("list") list: String,
                     @PathVariable("name") name: String) =
            ResponseEntity.ok(attendeesService.removeAttendee(list, name))

    @GetMapping("/{list}")
    fun getRsvpList(@PathVariable("list") list: String) = ResponseEntity.ok(rsvpService.getRsvpList(list))
}