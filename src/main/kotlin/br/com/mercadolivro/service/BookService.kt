package br.com.mercadolivro.service

import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }
}
