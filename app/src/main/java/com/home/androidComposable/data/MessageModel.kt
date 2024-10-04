package com.home.androidComposable.data

data class MessageModel(
    val author: String,
    val body: String
)

fun fakeData() = arrayListOf(
    MessageModel(author = "Name 1", body = "Hey, take a look at Jetpack Compose, it's great!"),
    MessageModel(author = "Name 2", body = "Reduces power usage by a significant amount, depending on the device’s screen technology."),
    MessageModel(author = "Name 3", body = "Hey, take a look at Jetpack Compose, it's great!"),
    MessageModel(author = "Name 4", body = "Hey, take a look at Jetpack Compose, it's great!"),
)
