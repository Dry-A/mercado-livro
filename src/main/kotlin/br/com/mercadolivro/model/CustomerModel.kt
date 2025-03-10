package br.com.mercadolivro.model

import jakarta.persistence.*

@Entity
@Table(name = "customers")
data class CustomerModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String ,
    var email: String
)
