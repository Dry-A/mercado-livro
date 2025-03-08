package br.com.mercadolivro.controller

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.request.PostCustomerRequest
import br.com.mercadolivro.request.PutCustomerRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController {

    val customerList = mutableListOf<CustomerModel>()

    @GetMapping
    fun getCustomer(@RequestParam name: String?): List<CustomerModel> {
        name?.let {
            return customerList.filter { it.name.contains(name, true) }
        }
        return customerList
    }

    @GetMapping("/{id}")
    //estamos recebendo uma variável pela url
    fun getCustomerById(@PathVariable id: String): CustomerModel {
        return customerList.filter{it.id == id}.first()
    }

    @GetMapping("/name/{name}")
    //estamos recebendo uma variável pela url
    fun getCustomerByNome(@PathVariable name: String): List<CustomerModel> {
        return customerList.filter{it.name.contains(name, true)}
    }

    @GetMapping("/email/{email}")
    //estamos recebendo uma variável pela url
    fun getCustomerByEmail(@PathVariable email: String): List<CustomerModel> {
        return customerList.filter{it.email.contains(email, true)}
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

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customerList.filter{it.id == id}.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerList.removeIf { it.id == id }
    }
}


