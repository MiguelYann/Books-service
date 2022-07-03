package fr.myt.learn.kotlin.ocr.asssmentlearnapi.service

import fr.myt.learn.kotlin.ocr.asssmentlearnapi.exceptions.CourseNotFoundException
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.model.Course
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.repository.CourseRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CourseServiceTest {
    private val courseRepository = mockk<CourseRepository>()
    private val courseService = CourseService(courseRepository)

    @Test
    fun should_list_all_courses() {

        //GIVEN

        every { courseRepository.getAllCourses() } returns listOf(Course(title = "Java VS Kotlin", author = "Me"))


        //WHEN

        val actual = courseService.findAllCourses()

        //THEN

        assertEquals(listOf(Course(title = "Java VS Kotlin", author = "Me")), actual)
    }

    @Test
    fun should_find_course_by_id() {

        //GIVEN

        every { courseRepository.findCourseById("1") } returns Course(
            title = "Java VS Kotlin",
            author = "Me",
            courseId = "1"
        )


        //WHEN

        val actual = courseService.findCourseById("1")

        //THEN

        assertEquals(Course(title = "Java VS Kotlin", author = "Me", courseId = "1"), actual)
    }

    @Test
    fun should_throws_when_repository_throws() {

        //GIVEN

        every { courseRepository.findCourseById("1") } throws CourseNotFoundException("default message error")


        //WHEN - THEN

        assertThrows<CourseNotFoundException> { courseService.findCourseById("1") }
    }
}