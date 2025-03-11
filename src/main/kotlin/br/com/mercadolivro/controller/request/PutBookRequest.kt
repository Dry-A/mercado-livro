package br.com.mercadolivro.controller.request

import java.math.BigDecimal

data class PutBookRequest(
    //criamos essa classe pois se futuramente haver dados que não podem ser alterados, como o cpf, por exemplo
    var name: String,
    var price: BigDecimal,
    var status: String,
    var customerId: Int
)
