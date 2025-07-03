package id.my.hendisantika.specmaticsample.filter

import id.my.hendisantika.specmaticsample.model.DB
import id.my.hendisantika.specmaticsample.model.User
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.51
 * To change this template use File | Settings | File Templates.
 */
class APIKeyAuthFilter(private val principalRequestHeader: String, private val db: DB) :
    AbstractPreAuthenticatedProcessingFilter() {

    override fun getPreAuthenticatedPrincipal(request: HttpServletRequest): Any {
        return User("user")
    }

    override fun getPreAuthenticatedCredentials(request: HttpServletRequest?): Any {
        return User("user")
    }
}