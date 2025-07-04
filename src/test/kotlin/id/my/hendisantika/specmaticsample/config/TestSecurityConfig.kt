package id.my.hendisantika.specmaticsample.config

import id.my.hendisantika.specmaticsample.config.SecurityConfig.Companion.API_TOKEN
import id.my.hendisantika.specmaticsample.filter.DummyAPIKeyAuthFilter
import id.my.hendisantika.specmaticsample.security.AuthManager
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
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
 * Date: 04/07/25
 * Time: 07.06
 * To change this template use File | Settings | File Templates.
 */
@TestConfiguration
@Order(1)
@EnableWebSecurity
class TestSecurityConfig {
    @Bean
    fun testFilterChain(http: HttpSecurity): SecurityFilterChain {
        val filter = DummyAPIKeyAuthFilter(API_TOKEN)
        filter.setAuthenticationManager(AuthManager())

        http
            .csrf { it.disable() }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
            .addFilter(filter)
            .authorizeHttpRequests { it.anyRequest().authenticated() }

        return http.build()
    }
}
