package br.com.mercadolivro.model

import br.com.mercadolivro.enums.BookStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity(name = "books")
data class BookModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var name: String,
    var price: BigDecimal,
    @Enumerated(EnumType.STRING)
    var status: BookStatus?,
    @ManyToOne
    @JoinColumn(name = "customer_id")
    var customer: CustomerModel?
)
