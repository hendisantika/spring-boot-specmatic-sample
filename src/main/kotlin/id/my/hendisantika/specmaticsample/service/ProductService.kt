package id.my.hendisantika.specmaticsample.service

import id.my.hendisantika.specmaticsample.exception.ValidationException
import id.my.hendisantika.specmaticsample.model.DB
import id.my.hendisantika.specmaticsample.model.Product
import org.springframework.stereotype.Service

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 06.02
 * To change this template use File | Settings | File Templates.
 */
@Service
class ProductService {
    fun getProduct(id: Int): Product {
        return DB.findProduct(id)
    }

    fun updateProduct(product: Product) {
        if (product.id == 0)
            throw ValidationException("Product id cannot be null")
        DB.updateProduct(product)
    }
}