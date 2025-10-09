package com.batch15.usermanagementservice.controller

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.service.DummyJsonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("dummy-json")
class DummyJsonController(
    private val dummyJsonService: DummyJsonService
) {

    @GetMapping("/products")
    fun getProducts(): ResponseEntity<WebResponse<Any>> {
        return ResponseEntity(
            WebResponse(
                data = dummyJsonService.getProducts(),
                message = "Get products successfully"
            ), HttpStatus.OK
        )
    }
}