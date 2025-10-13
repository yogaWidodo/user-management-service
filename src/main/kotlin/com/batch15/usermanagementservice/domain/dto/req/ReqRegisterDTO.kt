package com.batch15.usermanagementservice.domain.dto.req

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size


data class ReqRegisterDTO(

    @field:NotBlank(message = "Username is required")
    @field:Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    val username: String,

    @field:NotBlank(message = "Password is required")
    val password: String,

    @field:NotBlank(message = "Fullname is required")
    val fullName: String,

    val roleId: Int
)
