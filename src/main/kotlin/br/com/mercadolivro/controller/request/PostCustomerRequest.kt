package br.com.mercadolivro.controller.request

import br.com.mercadolivro.model.CustomerModel

data class PostCustomerRequest(
    var name: String,
    var email: String
){
    fun toCostumerModel(): CustomerModel {
        return CustomerModel(
            name = this.name,
            email = this.email
        )
    }
}
