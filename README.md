# NyTimesTest
A Nytimes news feed app illustrating current Android Architecture state using Android development best practises.

# Introduction
The application uses Clean Architecture based on MVVM and Repository patterns. Implemented Architecture principles follow [Google recommended Guide to app architecture](https://developer.android.com/jetpack/docs/guide).

![Image](https://i1.wp.com/www.simplifiedcoding.net/wp-content/uploads/2019/06/android-mvvm-architecture.png?resize=960%2C720&ssl=1)

I have used kotlin to write this entire application.

I have used multiple liberaries like ViewModel, LiveData, Lifecycles, Navigation, Room and Data Binding. See a complete list in "Libraries used" section.

The application does network HTTP requests via Retrofit, OkHttp and GSON. Loaded data is saved to SQL based database Room, which serves as single source of truth and support offline mode.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks. Combination of Coroutines and Kotlin build in functions (transformation, collections) are preferred over RxJava 2.

Work manager does synchronisation job being compatible with Doze Mode and using battery efficiently. Navigation component manages in-app navigation.

Dagger 2 is used for dependency injection.

Glide is used for image loading and Timber for logging.

A sample app consist of 1 screen: News Listing.

# Screenshot

![Image](https://uc797a832cf353de6ce1576d2bc8.previews.dropboxusercontent.com/p/thumb/AApZNM_6POwppx9-jRCztiPvEOpw14nlei5SzwAY8b6N54-jtwzGgFQL_BRXu53KbS4UwOhHrI70uJxAhJ77hiN1C1MgjsYcwbPaE49mt_yXxVlZ-9AcYF7mC1XWx_76-3FRyTj3viqLxiaCGwThTZB3FmaedKgKMUGU1mHfzOqqebH0AGYzpTuoMV-dwHlWLXGQ-_hFiSKaxQ8ez_TqvTK6MLB0iWFFVq5_Ht3w1n19216CdB8yfEzOSXSSgvp2B9gnxMosqCmkMBkbltgCjDTK-ogmJYsx-cugaHbWJc3mKIBJazN7diqL_BIMkOoOsMviaoKAcBeo9CgJQtoJ-xad/p.png)

# Libraries Used

* AppCompat - Degrade gracefully on older versions of Android.
* Android KTX - Write more concise, idiomatic Kotlin code.
* Test - An Android testing framework for unit and runtime UI tests.
* Architecture - A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence.
* Data Binding - Declaratively bind observable data to UI elements.
* Lifecycles - Create a UI that automatically responds to lifecycle events.
* LiveData - Build data objects that notify views when the underlying database changes.
* Room - SQLite database with in-app objects and compile-time checks.
* ViewModel - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
* WorkManager - Manage your Android background jobs.
* Fragment - A basic unit of composable UI.
* Layout - Lay out widgets using different algorithms.
* Material - Material Components.

#### Third party
* Kotlin Coroutines for managing background threads with simplified code and reducing needs for callbacks.
* Dagger 2 A fast dependency injector.
* Retrofit 2 A configurable REST client.
* OkHttp 3 A type-safe HTTP client.
* GSON A Json - Object converter using reflection.
* Glide Image loading.
* Timber A logger.


# IDE Setup
To open this project you need android studio with latest version. Here is the link to download [Link](https://developer.android.com/studio/).
Here are the steps to run this project.
* Install Android studio.
* Clone this project and setup it in your android studio.
* Connect your device to pc.
* Click on horrizontal green triangle to run this application.

