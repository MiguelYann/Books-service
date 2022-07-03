package fr.myt.learn.kotlin.ocr.asssmentlearnapi.model

data class Course(
    val courseId: String = "",
    val title: String,
    val author: String,
    val price: Int = 0,
    val isOlder: Boolean = false
)