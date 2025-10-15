package com.batch15.usermanagementservice.service.impl

import com.batch15.usermanagementservice.domain.dto.req.ReqLoginDTO
import com.batch15.usermanagementservice.domain.dto.req.ReqRegisterDTO
import com.batch15.usermanagementservice.domain.dto.res.ResLoginDTO
import com.batch15.usermanagementservice.domain.dto.res.ResRegisterDTO
import com.batch15.usermanagementservice.domain.entity.MasterUserEntity
import com.batch15.usermanagementservice.repository.MasterRoleRepository
import com.batch15.usermanagementservice.repository.MasterUserRepository
import com.batch15.usermanagementservice.service.AuthService
import com.batch15.usermanagementservice.utils.JwtUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    val masterUserRepository: MasterUserRepository,
    val masterRoleRepository: MasterRoleRepository,
    val passwordEncoder: BCryptPasswordEncoder,
    val jwtUtil: JwtUtil
) : AuthService {
    override fun registerUser(reqRegisterDTO: ReqRegisterDTO): ResRegisterDTO {
        val roleId = masterRoleRepository.findById(reqRegisterDTO.roleId).orElseThrow {
            Exception("Role not found with id ${reqRegisterDTO.roleId}")
        }
        val registeredUser = masterUserRepository.findByUsername(reqRegisterDTO.username)
        if (registeredUser != null) {
            throw Exception("Username ${reqRegisterDTO.username} is already taken")
        }
        val user = MasterUserEntity(
            username = reqRegisterDTO.username,
            password = passwordEncoder.encode(reqRegisterDTO.password),
            fullName = reqRegisterDTO.fullName,
            role = roleId
        )
        masterUserRepository.save(user)
        return ResRegisterDTO(
            username = user.username,
            fullName = user.fullName,
            roleName = user.role.name
        )
    }

    override fun login(reqLoginDTO: ReqLoginDTO): ResLoginDTO {
        val user = masterUserRepository.findByUsername(reqLoginDTO.username)
            if (user == null) {
                throw Exception("Username or password is incorrect")
            }
            if (!passwordEncoder.matches(reqLoginDTO.password, user.password)) {
                throw Exception("Invalid username or password")
            }
            return ResLoginDTO(
                token = jwtUtil.generateToken(user.id, user.role.name)
            )
        }
    }