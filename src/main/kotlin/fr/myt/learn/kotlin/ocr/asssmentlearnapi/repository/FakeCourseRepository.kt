package fr.myt.learn.kotlin.ocr.asssmentlearnapi.repository

import fr.myt.learn.kotlin.ocr.asssmentlearnapi.exceptions.CourseNotFoundException
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.model.Course
import org.springframework.stereotype.Repository

@Repository
class FakeCourseRepository : CourseRepository {
    override fun getAllCourses() = listOf(
        Course(title = "Learn Kotlin", price = 15, author = "Unknow", courseId = "1"),
        Course(title = "Learn Java", author = "Unknown", courseId = "2")
    )

    override fun findCourseById(courseId: String): Course =
        getAllCourses().find { it.courseId == courseId } ?: notFoundCourse()

    private fun notFoundCourse(): Nothing = throw CourseNotFoundException("The book found not exist")

}