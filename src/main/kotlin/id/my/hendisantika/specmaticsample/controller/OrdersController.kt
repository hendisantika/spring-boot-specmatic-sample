package id.my.hendisantika.specmaticsample.controller

import id.my.hendisantika.specmaticsample.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 06.05
 * To change this template use File | Settings | File Templates.
 */
@RestController
class OrdersController {
    @Autowired
    lateinit var orderService: OrderService
}