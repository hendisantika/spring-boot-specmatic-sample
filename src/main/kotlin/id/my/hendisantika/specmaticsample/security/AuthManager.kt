package id.my.hendisantika.specmaticsample.security

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.Authentication

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.57
 * To change this template use File | Settings | File Templates.
 */
class AuthManager : AuthenticationManager {
    override fun authenticate(authentication: Authentication?): Authentication {
        authentication!!.isAuthenticated = true
        return authentication
    }
}