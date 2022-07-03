package fr.myt.learn.kotlin.ocr.asssmentlearnapi.repository

import fr.myt.learn.kotlin.ocr.asssmentlearnapi.model.Course

interface CourseRepository {
    fun getAllCourses(): List<Course>
    fun findCourseById(courseId: String): Course
}