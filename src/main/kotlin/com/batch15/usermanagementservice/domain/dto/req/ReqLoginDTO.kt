package com.batch15.usermanagementservice.domain.dto.req

import jakarta.validation.constraints.NotBlank

data class ReqLoginDTO (
    @field:NotBlank(message = "Username is required")
    val username: String,
    @field:NotBlank(message = "Password is required")
    val password: String
)