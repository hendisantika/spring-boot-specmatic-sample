package id.my.hendisantika.specmaticsample.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.48
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@Order(1)
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        val filter = APIKeyAuthFilter(API_TOKEN, DB)
        filter.setAuthenticationManager(AuthManager())
        http.csrf().disable().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .addFilter(filter)
            .authorizeRequests()
            .anyRequest()
            .authenticated()
        return http.build()
    }

    companion object {
        const val API_TOKEN = "authenticate"
    }
}