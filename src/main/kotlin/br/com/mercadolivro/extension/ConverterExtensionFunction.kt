package br.com.mercadolivro.extension

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutBookRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.service.CustomerService

fun PostCustomerRequest.toCostumerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email
    )
}
fun PutCustomerRequest.toCostumerModel(id: Int): CustomerModel {
    return CustomerModel(
        id = id,
        name = this.name,
        email = this.email
    )
}
fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(id: Int, customerService: CustomerService): BookModel {
    val customer = customerService.getCustomerById(this.customerId)
    return BookModel(
        id = id,
        name = this.name,
        price = this.price,
        status = BookStatus.valueOf(this.status),
        customer = customer
    )
}
