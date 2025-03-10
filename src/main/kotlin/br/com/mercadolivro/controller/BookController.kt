package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.extension.toBookModel
import br.com.mercadolivro.service.BookService
import br.com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService

) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {

        val customer = customerService.getCustomerById(request.customerId)
        bookService.create(request.toBookModel(customer))

    }
}