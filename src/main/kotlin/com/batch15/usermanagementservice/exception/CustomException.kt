package com.batch15.usermanagementservice.exception

data class CustomException (
    override val message: String?,
    val code: Int,
    val data: Any? = null
): Exception()