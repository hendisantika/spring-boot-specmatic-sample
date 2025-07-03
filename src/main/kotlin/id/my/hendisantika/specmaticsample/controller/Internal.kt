package id.my.hendisantika.specmaticsample.controller

import id.my.hendisantika.specmaticsample.service.MetricService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 06.03
 * To change this template use File | Settings | File Templates.
 */
@RestController
class Internal {
    @Autowired
    lateinit var metricService: MetricService

    @GetMapping("/internal/metrics")
    fun metrics(): Int {
        return metricService.activeUsers()
    }
}