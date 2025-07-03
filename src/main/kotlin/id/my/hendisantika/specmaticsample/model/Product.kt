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
 * Time: 05.55
 * To change this template use File | Settings | File Templates.
 */
data class Product(
    @field:NotNull val name: String = "",
    @field:NotNull val type: String = "gadget",
    @field:NotNull @field:Positive val inventory: Int = 0,
    val id: Int = idGenerator.getAndIncrement()
) {
    companion object {
        val idGenerator: AtomicInteger = AtomicInteger(0)
    }
}
