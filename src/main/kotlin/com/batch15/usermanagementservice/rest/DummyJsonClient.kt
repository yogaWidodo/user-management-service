package com.batch15.usermanagementservice.rest

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "dummyjson",
    url = "https://dummyjson.com",
    path = "/products"
)
interface DummyJsonClient {

    @GetMapping
    fun getProducts(): Any
}