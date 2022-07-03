package fr.myt.learn.kotlin.ocr.asssmentlearnapi.service

import fr.myt.learn.kotlin.ocr.asssmentlearnapi.model.Course
import fr.myt.learn.kotlin.ocr.asssmentlearnapi.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {

    fun findAllCourses(): List<Course> = courseRepository.getAllCourses()
    fun findCourseById(courseId: String): Course = courseRepository.findCourseById(courseId)

}