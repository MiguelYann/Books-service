package fr.myt.learn.kotlin.ocr.asssmentlearnapi.controller

import fr.myt.learn.kotlin.ocr.asssmentlearnapi.exceptions.CourseNotFoundException
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.service.CourseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class CourseController(private val courseService: CourseService) {

    @GetMapping("/courses")
    fun getAllCourses() = courseService.findAllCourses()

    @GetMapping("/courses/{courseId}")
    fun findCourseById(@PathVariable courseId: String) = try {
        courseService.findCourseById(courseId)
    } catch (exception: CourseNotFoundException) {
        throw exception
    }
}