package id.my.hendisantika.specmaticsample.model

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.54
 * To change this template use File | Settings | File Templates.
 */
class Order(
    @field:Positive val productid: Int = 0,
    @field:Positive val count: Int = 0,
    @field:NotNull var status: OrderStatus = OrderStatus.pending,
    val id: Int = idGenerator.getAndIncrement()
) {
    companion object {
        val idGenerator: AtomicInteger = AtomicInteger(1)
    }
}

enum class OrderStatus {
    pending,
    fulfilled,
    cancelled
}