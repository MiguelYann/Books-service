package fr.myt.learn.kotlin.ocr.asssmentlearnapi.exceptions

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class HandlerResponseError {

    @ExceptionHandler
    fun courseNotFoundHandlerException(e: CourseNotFoundException) = ResponseEntity.notFound()
}