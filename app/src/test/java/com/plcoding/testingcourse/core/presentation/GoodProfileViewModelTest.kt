package com.plcoding.testingcourse.core.presentation

import com.plcoding.testingcourse.part4.domain.AnalyticsLogger
import com.plcoding.testingcourse.part4.domain.LogParam
import com.plcoding.testingcourse.part4.presentation.GoodProfileViewModel
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class GoodProfileViewModelTest {

    private lateinit var viewModel: GoodProfileViewModel

    @BeforeEach
    fun setUp() {
        viewModel = GoodProfileViewModel(
            analytics = object : AnalyticsLogger {
                override fun logEvent(key: String, vararg params: LogParam<Any>) = Unit
            }
        )
    }
}