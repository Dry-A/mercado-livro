package br.com.mercadolivro.controller

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.request.PostCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customerList = mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomer(): List<CustomerModel> {
        return customerList
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        val id = if (customerList.isEmpty()) {
            "1"
        } else {
            customerList.last().id.toInt() +1
        }.toString()

        customerList.add(CustomerModel(id, customer.name, customer.email))
    }
}


