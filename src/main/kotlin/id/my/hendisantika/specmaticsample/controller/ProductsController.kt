package id.my.hendisantika.specmaticsample.controller

import id.my.hendisantika.specmaticsample.exception.ValidationException
import id.my.hendisantika.specmaticsample.model.Product
import id.my.hendisantika.specmaticsample.model.User
import id.my.hendisantika.specmaticsample.service.ProductService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
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
 * Time: 06.07
 * To change this template use File | Settings | File Templates.
 */
@RestController
class ProductsController {
    @Autowired
    lateinit var productService: ProductService

    @PostMapping("/products/{id}")
    @Validated
    fun update(
        @PathVariable("id") id: Int,
        @Valid @RequestBody product: Product,
        @AuthenticationPrincipal user: User
    ): ResponseEntity<String> {
        productService.addProduct(product.also {
            if (product.type !in typesOfProducts)
                throw ValidationException("type must be one of ${typesOfProducts.joinToString(", ")}")
        })
        productService.updateProduct(product)
        return ResponseEntity(HttpStatus.OK)
    }
}