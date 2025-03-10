package br.com.mercadolivro.extension

import br.com.mercadolivro.controller.request.PostBookRequest
import br.com.mercadolivro.controller.request.PostCustomerRequest
import br.com.mercadolivro.controller.request.PutCustomerRequest
import br.com.mercadolivro.enums.BookStatus
import br.com.mercadolivro.model.BookModel
import br.com.mercadolivro.model.CustomerModel

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
