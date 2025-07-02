package id.my.hendisantika.specmaticsample.config

import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 02/07/25
 * Time: 07.49
 * To change this template use File | Settings | File Templates.
 */
@Configuration
class StringStringDeserializerConfig {
    @Bean
    fun strictStringDeserializerModule(): SimpleModule {
        val module = SimpleModule()
        module.addDeserializer(String::class.java, StrictStringDeserializer())
        return module
    }
}