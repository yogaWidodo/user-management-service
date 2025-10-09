package com.batch15.usermanagementservice.exception

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleArgumentNotValid(e: MethodArgumentNotValidException): ResponseEntity<WebResponse<Any?>> {
        e.printStackTrace()
        val errorMessages = mutableListOf<String?>()
        e.bindingResult.fieldErrors.forEach {
            errorMessages.add(it.defaultMessage)
        }
        return ResponseEntity(
            WebResponse(
                message = "Invalid request",
                status = "F",
                error = errorMessages
            ),
            HttpStatus.BAD_REQUEST
        )
    }


    @ExceptionHandler(CustomException::class)
    fun handleCustomException(e: CustomException): ResponseEntity<WebResponse<Any?>> {
        e.printStackTrace()
        return ResponseEntity(
            WebResponse(
                message = e.message ?: "Internal Server Error",
                status = "F",
            ),
            HttpStatus.valueOf(e.code)
        )
    }


    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<WebResponse<Any?>> {
        e.printStackTrace()
        return ResponseEntity(
            WebResponse(
                data = null,
                message = e.message ?: "Internal Server Error",
                status = "F"
            ),
            HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}