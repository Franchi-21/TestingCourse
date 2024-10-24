package com.plcoding.testingcourse.part4.presentation

import com.plcoding.testingcourse.UiText

data class GoodProfileState(
    val profileId: Long = 0,
    val username: String = "",
    val bio: String = "",
    val isLoading: Boolean = false,
    val infoMessage: UiText? = null
)