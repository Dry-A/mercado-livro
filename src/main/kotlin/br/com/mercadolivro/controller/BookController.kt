package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.extension.toBookModel
import br.com.mercadolivro.model.BookModel
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

    @GetMapping
    fun getAll(@RequestParam name: String?): List<BookModel> {
        return bookService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Int): BookModel {
        return bookService.getBookById(id)
    }

    @GetMapping("/name/{name}")
    fun getBookByName(@PathVariable name: String): List<BookModel> {
        return bookService.getBookByName(name)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getCustomerById(request.customerId)
        bookService.create(request.toBookModel(customer))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
       bookService.update(book.toBookModel(id, customerService))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        bookService.delete(id)
    }
}