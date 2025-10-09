package com.batch15.usermanagementservice.service

import com.batch15.usermanagementservice.domain.dto.req.ReqLoginDTO
import com.batch15.usermanagementservice.domain.dto.req.ReqRegisterDTO
import com.batch15.usermanagementservice.domain.dto.res.ResLoginDTO
import com.batch15.usermanagementservice.domain.dto.res.ResRegisterDTO

interface AuthService {
    fun registerUser(reqRegisterDTO: ReqRegisterDTO) : ResRegisterDTO
    fun login(reqLoginDTO: ReqLoginDTO): ResLoginDTO
}