<h1 align="center">RSVP Bot (For Telegram)</h1>
<br />

### Overview
RSVP bot allows groups to organise meetings/events from within telegram.

Features include:
- Create named events
- Add/remove attendees
- List current atendees

### Installation
RSVP bot is written in [Kotlin](https://kotlinlang.org/), with build managed by [Gradle](https://gradle.org/)

Requirements:
- **Java**
-- check current version `java -version`
-- install (with homebrew) `brew update && brew cask install java`
-- install (manual) [https://www.java.com/en/download/help/download_options.xml](https://www.java.com/en/download/help/download_options.xml)
- **Gradle**
-- check current version `gradle -v`
-- install with homebrew `brew update && brew install gradle`
-- install with scoop `scoop install gradle`

Steps:
- `git clone https://github.com/JulijanasJezov/telegram-rsvp-bot.git`
- `cd ./telegram-rsvp-bot`
- `gradle build`