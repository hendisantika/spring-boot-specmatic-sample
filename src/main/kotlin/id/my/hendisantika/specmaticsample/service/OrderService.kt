package id.my.hendisantika.specmaticsample.service

import id.my.hendisantika.specmaticsample.model.DB
import id.my.hendisantika.specmaticsample.model.Id
import id.my.hendisantika.specmaticsample.model.Order
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.59
 * To change this template use File | Settings | File Templates.
 */
@Service
class OrderService {
    fun createOrder(order: Order): Id {
        DB.reserveProductInventory(order.productid, order.count)
        DB.addOrder(order)
        return Id(order.id)
    }

    fun getOrder(id: Int): Order {
        return DB.getOrder(id)
    }

    fun deleteOrder(id: Int) {
        DB.deleteOrder(id)
    }
}