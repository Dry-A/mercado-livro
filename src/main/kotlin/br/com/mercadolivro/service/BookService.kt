package br.com.mercadolivro.service

import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun getAll(name: String?): List<BookModel> {
        name?.let {
            return bookRepository.findByNameContaining(it)
        }
        return bookRepository.findAll().toList()
    }

    fun getBookById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow()
    }

    fun getBookByName(name: String): List<BookModel> {
        return bookRepository.findByNameContaining(name).toList()
    }

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun update(book: BookModel) {
        if (!bookRepository.existsById(book.id!!)) {
            throw Exception("Book not found 🙃")
        }
        bookRepository.save(book)
    }

    fun delete(id: Int) {
        if (!bookRepository.existsById(id)) {
            throw Exception("Book not found 🙃")
        }
        bookRepository.deleteById(id)
    }
}
