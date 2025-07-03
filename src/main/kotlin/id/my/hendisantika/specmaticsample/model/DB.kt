package id.my.hendisantika.specmaticsample.model

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
}