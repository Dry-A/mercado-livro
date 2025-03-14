package br.com.mercadolivro.controller

import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.extension.toCostumerModel
import br.com.mercadolivro.model.CustomerModel
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
    fun getCustomerById(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomerById(id)
    }

    @GetMapping("/name/{name}")
    fun getCustomerByName(@PathVariable name: String): List<CustomerModel> {
        return customerService.getCustomerByName(name)
    }

    @GetMapping("/email/{email}")
    fun getCustomerByEmail(@PathVariable email: String): List<CustomerModel> {
        return customerService.getCustomerByEmail(email)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.toCostumerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody customer: PutCustomerRequest) {
        customerService.update(customer.toCostumerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) {
        customerService.delete(id)
    }
}


