package com.plcoding.testingcourse.part6

import com.google.firebase.auth.FirebaseAuth
import io.mockk.MockK
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var client: EmailClient
    private lateinit var orderService: OrderService

    @BeforeEach
    fun setUp() {
        firebaseAuth = mockk()
        client = mockk(relaxed = true)
        orderService = OrderService(firebaseAuth, client)
    }

    @Test
    fun `When user is not anonymous, send the correct email`() {
        val email = "fd687585@gmail.com"
        val product = "Macbook Pro M4"
        every { firebaseAuth.currentUser?.isAnonymous } returns false

        orderService.placeOrder(email, product)

        verify {
            client.send(
                match {
                    it.recipient == email && it.content == "Thank you for your order of $product."
                }
            )
        }
    }
}