package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ShoppingCartTest {
    private lateinit var cart: ShoppingCart

    @BeforeEach
    fun setUp() {
        cart = ShoppingCart()
    }

    @ParameterizedTest
    @ValueSource(
        ints = [1, 2, 3, 4, 5]
    )
    fun `Add multiple products, total cost is correct`(quantity: Int) {
        // GIVEN
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )

        // ACTION
        cart.addProduct(product, quantity)

        // ASSERTION
        assertThat(cart.getTotalCost()).isEqualTo(quantity * 5.0)
    }

    @Test
    fun `Add product with negative quantity, throws exception`() {
        val product = Product(
            id = 0,
            name = "Ice cream",
            price = 5.0
        )
        assertFailure {
            cart.addProduct(product, -5)
        }
    }

    @Test
    fun `isValidProduct returns invalid for non existing product`() {
        val product = Product(
            id = 6,
            name = "Ice cream",
            price = 5.0
        )
        cart.
    }
}