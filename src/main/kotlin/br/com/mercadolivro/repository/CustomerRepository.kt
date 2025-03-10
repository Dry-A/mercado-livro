package br.com.mercadolivro.repository

import br.com.mercadolivro.model.CustomerModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface CustomerRepository : CrudRepository<CustomerModel, Int> {

    fun findByNameContaining(name: String): List<CustomerModel>

    fun findByEmailContaining(email: String): List<CustomerModel>

}