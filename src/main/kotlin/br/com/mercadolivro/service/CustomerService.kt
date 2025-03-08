package br.com.mercadolivro.service

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.request.PostCustomerRequest
import br.com.mercadolivro.request.PutCustomerRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Service
class CustomerService {

    val customerList = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerList.filter { it.name.contains(name, true) }
        }
        return customerList
    }

    fun getCustomerById(id: String): CustomerModel {
        return customerList.filter { it.id == id }.first()
    }

    fun getCustomerByNome(name: String): List<CustomerModel> {
        return customerList.filter { it.name.contains(name, true) }
    }

    fun getCustomerByEmail(email: String): List<CustomerModel> {
        return customerList.filter { it.email.contains(email, true) }
    }

    fun createCustomer(customer: PostCustomerRequest) {
        val id = if (customerList.isEmpty()) {
            "1"
        } else {
            customerList.last().id.toInt() + 1
        }.toString()
        customerList.add(CustomerModel(id, customer.name, customer.email))
    }

    fun update(id: String, customer: PutCustomerRequest) {
        customerList.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customerList.removeIf { it.id == id }
    }
}