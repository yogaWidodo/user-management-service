package com.batch15.usermanagementservice.controller

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResGetUserByIdsDTO
import com.batch15.usermanagementservice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/data-source")
class DataSourceController(
    private val userService: UserService
) {

    @GetMapping("/users-by-ids")
    fun getUserByIds(
        @RequestParam(required = true) ids: List<Int>
    ): ResponseEntity<WebResponse<List<ResGetUserByIdsDTO>>> {
        return ResponseEntity.ok(
            WebResponse(
                data = userService.getUserByUniqueIds(ids)
            )
        )
    }
}