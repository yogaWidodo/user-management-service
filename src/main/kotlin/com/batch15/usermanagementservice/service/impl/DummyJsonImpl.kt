package com.batch15.usermanagementservice.service.impl

import com.batch15.usermanagementservice.rest.DummyJsonClient
import com.batch15.usermanagementservice.service.DummyJsonService
import org.springframework.stereotype.Service

@Service
class DummyJsonImpl(
    private val dummyJsonClient: DummyJsonClient
): DummyJsonService {
    override fun getProducts(): Any {
        return dummyJsonClient.getProducts()
    }

}