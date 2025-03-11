package br.com.mercadolivro.repository

import br.com.mercadolivro.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookModel, Int> {
    fun findByNameContaining(name: String): List<BookModel>

}