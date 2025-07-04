package id.my.hendisantika.specmaticsample.handler

import id.my.hendisantika.specmaticsample.exception.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.52
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException::class)
    fun handleGenericException(ex: NotFoundException): ResponseEntity<ErrorResponse> {
        val notFound = HttpStatus.NOT_FOUND
        return ResponseEntity.status(notFound).body(
            errorResponse(
                notFound,
                ex,
                "Requested resource not found",
                "resource not found"
            )
        )
    }

    @ExceptionHandler(Exception::class)
    fun handleGenericException(ex: Exception): ResponseEntity<ErrorResponse> {
        val badRequest = HttpStatus.BAD_REQUEST
        return ResponseEntity.status(badRequest).body(
            errorResponse(
                badRequest,
                ex,
                "An error occurred while processing the request",
                "Unknown error"
            )
        )
    }

    private fun errorResponse(
        httpStatus: HttpStatus,
        ex: Exception,
        error: String,
        message: String
    ): ErrorResponse {
        return ErrorResponse(
            LocalDateTime.now(),
            httpStatus.value(),
            error,
            ex.message ?: message
        )
    }
}

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String
)