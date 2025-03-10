package br.com.mercadolivro.controller.request

data class PutCustomerRequest(
    //criamos essa classe pois se futuramente haver dados que não podem ser alterados, como o cpf, por exemplo
    var name: String,
    var email: String
)
