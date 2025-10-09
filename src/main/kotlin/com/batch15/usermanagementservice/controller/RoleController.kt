package com.batch15.usermanagementservice.controller

import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.domain.dto.res.resRole.ResRole
import com.batch15.usermanagementservice.service.RoleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/roles")
class RoleController(private val roleService: RoleService) {

    @GetMapping
    fun getAllRoles(): ResponseEntity<WebResponse<List<ResRole>>> {
        val roles = roleService.getAllRoles()
        return ResponseEntity.ok(
            WebResponse(data = roles)
        )
    }
}