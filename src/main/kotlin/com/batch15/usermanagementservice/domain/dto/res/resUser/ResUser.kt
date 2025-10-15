package com.batch15.usermanagementservice.domain.dto.res.resUser

import java.sql.Timestamp

data class ResUser(
    val id: Int,
    val userName : String,
    val fullName : String,
    val createdAt : Timestamp,
    val roleName : String,
)
