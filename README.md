# Hilt-Example-Clean-Architecture
Writing Hilt Example App using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), in 100% Kotlin, using Android Jetpack Components:

Requirements
----
- Use the JSON Placeholder API documented here:
https://jsonplaceholder.typicode.com/posts

### Prerequisites - Unit Tests

#### Spek

This allows us to easily define specifications in a clear, understandable, human-readable way. This framework allows you to describe tests and expected behaviors in a more readable way.

To run tests in Android Studio you need to install Spek Framework plugin (search for Spek Framework).

The UI test run normally, either on a device or an emulator, without any special plugin or dependency.

### How it's built

* Technologies used
    * [Kotlin](https://kotlinlang.org/)
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
    * [Livedata](https://developer.android.com/topic/libraries/architecture/livedata)
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
    * [Retrofit](https://square.github.io/retrofit/)
    * [Paging 3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview)
    * [Jetpack](https://developer.android.com/jetpack)
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
    * [Timber](https://github.com/JakeWharton/timber)
* Architecture
    * MVVM - Model View View Model

* Tests
    * [JUnit5](https://junit.org/junit5/)
    * [Spek](https://www.spekframework.org/)
    * [MockK](https://github.com/mockk/mockk)
    * [Turbine](https://github.com/cashapp/turbine)

* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)

* CI/CD
    * Github Actions

### Screenshots

I added some screenshots as shown:

Main | 
--- |
<img src="https://i.imgur.com/wbPmKfq.png" width="280"/> |
