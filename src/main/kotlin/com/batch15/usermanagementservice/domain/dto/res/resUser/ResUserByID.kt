package com.batch15.usermanagementservice.domain.dto.res.resUser

import java.sql.Timestamp

data class ResUserByID(
    val id: Int,
    val userName: String,
    val fullName: String,
    val roleName: String? = null,
    val createdAt: Timestamp,
    val createdBy: String,
    val updateAt: String,
)
