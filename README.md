<h1 align="center">RSVP Bot (For Telegram)</h1>
<br />

### Overview
RSVP bot allows groups to organise meetings/events from within telegram.

Features include:
- Create named events
- Add/remove attendees
- List current atendees

### Usage
- Create an event: `/create [event name]`
- Add attendee: `/rsvp [attendee name]`
- Remove attendee: `/unrsvp [attendee name]`
- List attendees: `/list [event name]`
- Help: `/help`

### Requirements
RSVP bot is written in [Kotlin](https://kotlinlang.org/), with build managed by [Gradle](https://gradle.org/)

**Java**
- check current version `java -version`
- install (with homebrew) `brew update && brew cask install java`
- install (manual) [https://www.java.com/en/download/help/download_options.xml](https://www.java.com/en/download/help/download_options.xml)

**Gradle**
- check current version `gradle -v`
- install with homebrew `brew update && brew install gradle`
- install with scoop `scoop install gradle`

### Installation
- `git clone https://github.com/JulijanasJezov/telegram-rsvp-bot.git`
- `cd ./telegram-rsvp-bot`
- `gradle build`