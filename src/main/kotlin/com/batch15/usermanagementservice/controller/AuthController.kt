package com.batch15.usermanagementservice.controller

import com.batch15.usermanagementservice.domain.dto.req.ReqLoginDTO
import com.batch15.usermanagementservice.domain.dto.req.ReqRegisterDTO
import com.batch15.usermanagementservice.domain.dto.res.ResLoginDTO
import com.batch15.usermanagementservice.domain.dto.res.ResRegisterDTO
import com.batch15.usermanagementservice.domain.dto.res.WebResponse
import com.batch15.usermanagementservice.service.AuthService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    fun registerUser(
        @RequestBody @Valid reqRegisterDTO: ReqRegisterDTO
    ): ResponseEntity<WebResponse<ResRegisterDTO>> {
        return ResponseEntity.ok(
            WebResponse(
                data = authService.registerUser(reqRegisterDTO),
                message = "User registered successfully"
            )
        )
    }

    @PostMapping("/login")
    fun loginUser(
        @RequestBody @Valid reqLoginDTO: ReqLoginDTO
    ): ResponseEntity<WebResponse<ResLoginDTO>> {
        return ResponseEntity.ok(
            WebResponse(
                data = authService.login(reqLoginDTO),
                message = "User logged in successfully"
            )
        )
    }
}