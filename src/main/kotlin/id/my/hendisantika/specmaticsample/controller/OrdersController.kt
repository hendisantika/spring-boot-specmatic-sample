package id.my.hendisantika.specmaticsample.controller

import id.my.hendisantika.specmaticsample.model.Id
import id.my.hendisantika.specmaticsample.model.Order
import id.my.hendisantika.specmaticsample.model.User
import id.my.hendisantika.specmaticsample.service.OrderService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/orders")
    fun create(@Valid @RequestBody order: Order, @AuthenticationPrincipal user: User): ResponseEntity<Id> {
        println(order.status.toString())
        val orderId = orderService.createOrder(order)
        return ResponseEntity(orderId, HttpStatus.OK)
    }

    @PostMapping("/orders/bulk")
    fun createBulk(
        @Valid @RequestBody orders: List<Order>
    ): ResponseEntity<List<Id>> {
        val orderIds = orders.map { orderService.createOrder(it) }
        return ResponseEntity(orderIds, HttpStatus.OK)
    }
}