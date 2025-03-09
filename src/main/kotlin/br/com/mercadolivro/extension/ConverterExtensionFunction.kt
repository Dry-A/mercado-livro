package br.com.mercadolivro.extension

import br.com.mercadolivro.model.CustomerModel
import br.com.mercadolivro.request.PostCustomerRequest
import br.com.mercadolivro.request.PutCustomerRequest

fun PostCustomerRequest.toCostumerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email
    )
}

fun PutCustomerRequest.toCostumerModel(id: String): CustomerModel {
    return CustomerModel(
        id = id,
        name = this.name,
        email = this.email
    )
}
