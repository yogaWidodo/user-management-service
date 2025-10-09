package com.batch15.usermanagementservice.domain.dto.res

data class ResRegisterDTO(
    val username: String,
    val fullName: String,
    val roleIds: Int?
)
