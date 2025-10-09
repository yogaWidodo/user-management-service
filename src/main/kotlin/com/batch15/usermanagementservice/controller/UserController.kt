package com.batch15.usermanagementservice.controller

import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUser
import com.batch15.usermanagementservice.domain.dto.res.resUser.ResUserByID
import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<WebResponse<List<ResUser>>> {
        val users = userService.findAllUser()
        return ResponseEntity.ok(
            WebResponse(
                data = users,
                message = "Get all users successfully"
            )
        )
    }

    @GetMapping("/{id}")
    fun getUserById(
        @PathVariable id: Int
    ): ResponseEntity<WebResponse<ResUserByID?>> {
        val user = userService.findUserById(id)
        return ResponseEntity.ok(
            WebResponse(
                data = user,
                message = "Search user by id $id successfully"
            )
        )
    }

    @DeleteMapping("/{id}/soft-delete")
    fun softDeleteUser(
        @PathVariable id: Int
    ): ResponseEntity<WebResponse<String>> {
        val response = userService.softDeleteUser(id)
        return ResponseEntity.ok(WebResponse(
            data = response.data,
            message = response.message
        ))
    }

}