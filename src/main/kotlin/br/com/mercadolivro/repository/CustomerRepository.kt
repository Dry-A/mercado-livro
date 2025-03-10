package br.com.mercadolivro.repository

import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CustomerRepository: CrudRepository<CustomerModel, Int> {

    @Query("SELECT c FROM CustomerModel c WHERE c.name LIKE %:name%")
    fun findByNameContaining(@Param("name") name: String): List<CustomerModel>

    @Query("SELECT c FROM CustomerModel c WHERE c.email LIKE %:email%")
    fun findByEmailContaining(@Param("email") email: String): List<CustomerModel>

}