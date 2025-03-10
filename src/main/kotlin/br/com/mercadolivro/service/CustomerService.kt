package br.com.mercadolivro.service

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.repository.CustomerRepository
import org.springframework.stereotype.Service


@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

     fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomerById(id: Int): CustomerModel {
        return customerRepository.findById(id).orElseThrow()
    }

    fun getCustomerByName(name: String): List<CustomerModel> {
        return customerRepository.findByNameContaining(name).toList()
    }

    fun getCustomerByEmail(email: String): List<CustomerModel> {
        return customerRepository.findByEmailContaining(email).toList()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
    }

    fun update(customer: CustomerModel) {
        if (!customerRepository.existsById(customer.id!!)) {
            throw Exception("Customer not found 🙃")
        }
        customerRepository.save(customer)
    }

    fun delete(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception("Customer not found 🙃")
        }
        customerRepository.deleteById(id)
    }

}