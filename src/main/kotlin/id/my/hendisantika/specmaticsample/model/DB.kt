package id.my.hendisantika.specmaticsample.model

import org.springframework.core.annotation.Order
import kotlin.collections.count

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 05.49
 * To change this template use File | Settings | File Templates.
 */
object DB {
    private var PRODUCTS: MutableMap<Int, Product> =
        mutableMapOf(
            10 to Product("XYZ Phone", "gadget", 10, 10),
            20 to Product("Gemini", "dog", 10, 20),
            30 to Product("Cleaner", "gadget", 10, 30)
        )

    private var PRODUCT_IMAGE: MutableMap<Int, String> =
        mutableMapOf(10 to "https://example.com/image.jpg", 20 to "https://example.com/image.jpg")
    private var ORDERS: MutableMap<Int, Order> =
        mutableMapOf(10 to Order(10, 2, OrderStatus.pending, 10), 20 to Order(10, 1, OrderStatus.pending, 20))
    private val USERS: Map<String, User> = mapOf("API-TOKEN-SPEC" to User("Hari"))

    fun userCount(): Int {
        return USERS.values.count()
    }

    fun resetDB() {
        PRODUCTS = mutableMapOf(
            10 to Product("XYZ Phone", "gadget", 10, 10),
            20 to Product("Gemini", "dog", 10, 20),
            30 to Product("Cleaner", "gadget", 10, 30)
        )
        ORDERS = mutableMapOf(10 to Order(10, 2, OrderStatus.pending, 10), 20 to Order(10, 1, OrderStatus.pending, 20))
    }

    fun addProduct(product: Product) {
        PRODUCTS[product.id] = product
    }
}