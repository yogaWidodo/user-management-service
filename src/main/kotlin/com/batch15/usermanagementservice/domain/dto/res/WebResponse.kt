package com.batch15.usermanagementservice.domain.dto.res

import java.util.UUID

data class WebResponse<T>(
    val reqId: UUID = UUID.randomUUID(),
    val status: String = "T",
    val message: String = "Success",
    val data: T? = null,
    val error: MutableList<String?> = mutableListOf()
)