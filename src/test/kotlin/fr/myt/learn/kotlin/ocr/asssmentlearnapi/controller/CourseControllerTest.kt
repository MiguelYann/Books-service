package fr.myt.learn.kotlin.ocr.asssmentlearnapi.controller

import com.ninjasquad.springmockk.MockkBean
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.model.Course
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.service.CourseService
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
internal class CourseControllerTest(@Autowired private val mock: MockMvc) {

    @MockkBean
    lateinit var courseService: CourseService

    @Test
    fun should_list_all_courses() {

        //GIVEN

        every { courseService.findAllCourses() } returns listOf(Course("1", "fake", ""))

        // WHEN - THEN

        mock.perform(get("/api/v1/courses"))
            .andDo(print())
            .andExpectAll(status().`is`(200), jsonPath("$.[0].title").value("fake"))
    }

    @Test
    fun should_find_course_by_id() {

        //GIVEN

        every { courseService.findCourseById("110") } returns Course(title = "Go", courseId = "110", author = "")

        // WHEN - THEN

        mock.perform(get("/api/v1/courses/110"))
            .andDo(print())
            .andExpectAll(status().`is`(200), jsonPath("$.title").value("Go"))
    }
}