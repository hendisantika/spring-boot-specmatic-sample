package id.my.hendisantika.specmaticsample.model

import id.my.hendisantika.specmaticsample.exception.UnrecognizedTypeException
import id.my.hendisantika.specmaticsample.exception.ValidationException

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

    fun findProduct(id: Int): Product = PRODUCTS.getValue(id)

    fun updateProduct(update: Product) {
        PRODUCTS[update.id] = run {
            PRODUCTS.getValue(update.id)
            Product(update.name, update.type, update.inventory)
        }
    }

    fun deleteProduct(id: Int) {
        PRODUCTS.remove(id)
    }

    fun findProducts(name: String?, type: String?, status: String?): List<Product> {
        if (type != null && type !in listOf("book", "food", "gadget", "other"))
            throw UnrecognizedTypeException(type)

        return PRODUCTS.filter { (id, product) ->
            product.name == name || product.type == type || inventoryStatus(id) == status
        }.values.toList()
    }

    private fun inventoryStatus(productid: Int): String {
        return when (PRODUCTS.getValue(productid).inventory) {
            0 -> "sold"
            else -> "available"
        }
    }

    fun addOrder(order: Order) {
        ORDERS[order.id] = order
    }

    fun getOrder(id: Int): Order = ORDERS.getValue(id)

    fun deleteOrder(id: Int) {
        ORDERS.remove(id)
    }

    fun findOrders(status: OrderStatus?, productId: Int?): List<Order> {
        return ORDERS.filter { (_, order) ->
            order.status == status || order.productid == productId
        }.values.toList()
    }

    fun updateOrder(updatedOrder: Order) {
        ORDERS[updatedOrder.id] = updatedOrder
    }

    fun reserveProductInventory(productId: Int, count: Int) {
        if (productId !in PRODUCTS)
            throw ValidationException("Product Id $productId does not exist")
        val updatedProduct = PRODUCTS.getValue(productId).let {
            it.copy(inventory = it.inventory - count)
        }

        PRODUCTS[productId] = updatedProduct
    }

    fun updateProductImage(id: Int, imageFileName: String) {
        PRODUCT_IMAGE[id] = imageFileName
    }
}