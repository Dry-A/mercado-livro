package br.com.mercadolivro.controller

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.request.PostCustomerRequest
import br.com.mercadolivro.request.PutCustomerRequest
import br.com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val customerService: CustomerService
) {
    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String): CustomerModel {
        return customerService.getCustomerById(id)
    }

    @GetMapping("/name/{name}")
    fun getCustomerByNome(@PathVariable name: String): List<CustomerModel> {
        return customerService.getCustomerByNome(name)
    }

    @GetMapping("/email/{email}")
    fun getCustomerByEmail(@PathVariable email: String): List<CustomerModel> {
        return customerService.getCustomerByEmail(email)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: PostCustomerRequest) {
        customerService.createCustomer(customer)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customerService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)
    }
}


