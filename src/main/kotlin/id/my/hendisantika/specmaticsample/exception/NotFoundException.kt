package id.my.hendisantika.specmaticsample.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.50
 * To change this template use File | Settings | File Templates.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(private val validationErrorMessage: String = "") : RuntimeException(validationErrorMessage)