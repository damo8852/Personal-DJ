# Personal-DJ
Personal DJ is a web application that generates customized music queues by integrating with music services such as Spotify and Apple Music through their public APIs. The goal of the project is to provide users with a smarter and more customized listening experience that goes beyond standard playlist shuffling.

# Design Patterns
This section describes what is currently implemented in the project right now. This is a mid-project version, and we still plan to add more features and improvements in later milestones.

## 1. Factory Pattern
**Location:** `src/main/java/com/personaldj/engine/factory/RuleFactory.java`

`RuleFactory` creates `Rule` objects from a `RuleType`. This keeps rule-creation code in one place, so other parts of the app can just ask for a rule without building it manually.

## 2. Strategy Pattern
**Location:** `src/main/java/com/personaldj/engine/strategy/`

The `ScoringStrategy` interface defines one method: `score(Track candidate, DjSession session)`. Different strategy classes use different rules to score songs. The app can switch or combine strategies without changing the rest of the engine.

### Implemented Strategies

- **EnergyMatchStrategy**: maps session mood to a target energy value and scores tracks by closeness to that target using each track's `AudioFeatures.energy`.
- **MoodMatchStrategy**: maps session mood to a target valence value and scores tracks by closeness to that target using each track's `AudioFeatures.valence`.
- **GenreAffinityStrategy**: uses historical user feedback (`LIKE`, `SKIP`, `DISLIKE`) to score candidates based on prior positive vs. negative preference patterns.

## 3. Observer Pattern
**Location:** `src/main/java/com/personaldj/engine/observer/`

We use Spring events (`ApplicationEventPublisher` and `@EventListener`) for observer behavior. Services publish events like `SessionStartedEvent` and `FeedbackReceivedEvent`, and listener classes respond to them. This keeps features loosely connected and easier to extend.