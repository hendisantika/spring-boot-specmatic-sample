package id.my.hendisantika.specmaticsample.controller

import id.my.hendisantika.specmaticsample.exception.NotFoundException
import id.my.hendisantika.specmaticsample.exception.ValidationException
import id.my.hendisantika.specmaticsample.model.Id
import id.my.hendisantika.specmaticsample.model.Product
import id.my.hendisantika.specmaticsample.model.User
import id.my.hendisantika.specmaticsample.service.ProductService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

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
private val typesOfProducts = listOf("gadget", "book", "food", "other")

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

    @GetMapping("/products/{id}")
    fun get(@PathVariable("id") id: Int): Product {
        try {
            return productService.getProduct(id)
        } catch (e: NoSuchElementException) {
            throw NotFoundException(e.message!!)
        }
    }

    @PostMapping("/products")
    fun create(@Valid @RequestBody newProduct: Product, @AuthenticationPrincipal user: User): ResponseEntity<Id> {
        val productId = productService.addProduct(newProduct.also {
            if (newProduct.type !in typesOfProducts)
                throw ValidationException("type must be one of ${typesOfProducts.joinToString(", ")}")
        })
        return ResponseEntity(productId, HttpStatus.OK)
    }

    @DeleteMapping("/products/{id}")
    fun delete(@PathVariable("id") id: Int, @AuthenticationPrincipal user: User): ResponseEntity<String> {
        productService.deleteProduct(id)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/products")
    fun search(
        @RequestParam(name = "name", required = false) name: String?,
        @RequestParam(name = "type", required = false) type: String?,
        @RequestParam(name = "status", required = false) status: String?
    ): ResponseEntity<List<Product>> {
        // An exception thrown by some internal bug...
        if (name == "unknown")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        val products = productService.findProducts(name, type, status)
        return ResponseEntity(products, HttpStatus.OK)
    }

    @PutMapping("/products/{id}/image", consumes = ["multipart/form-data"])
    fun uploadImage(
        @PathVariable("id") id: Int,
        @RequestPart("image") image: MultipartFile
    ): ResponseEntity<Map<String, Any>> {
        productService.addImage(id, image.originalFilename, image.bytes)
        val response = mapOf("message" to "Product image updated successfully", "productId" to id)
        return ResponseEntity(response, HttpStatus.OK)
    }
}