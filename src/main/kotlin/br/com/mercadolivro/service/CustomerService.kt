package br.com.mercadolivro.service

import br.com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service


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

    fun create(customer: CustomerModel) {
        val id = if (customerList.isEmpty()) {
            "1"
        } else {
            customerList.last().id!!.toInt() + 1
        }.toString()
        customer.id = id
        customerList.add(customer)
    }

    fun update(customer: CustomerModel) {
        customerList.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customerList.removeIf { it.id == id }
    }
}